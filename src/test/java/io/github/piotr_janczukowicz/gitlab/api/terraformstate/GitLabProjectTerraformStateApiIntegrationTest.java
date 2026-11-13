package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.PATCH;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.io.TempDir;

@IntegrationTest
class GitLabProjectTerraformStateApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void getStateVersion_shouldWriteTheBytes_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));

        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .getStateVersion("group/sub/project", "name", 1, out);
        }

        assertThat(out.toByteArray()).containsExactly(1, 2, 3);
    }

    @Test
    void getStateVersion_shouldWriteTheFile_whenTheTargetIsAPath(@TempDir final Path directory) throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1",
                io.github.piotr_janczukowicz.test.http.StubHttpServer.status(200)
                        .body(new byte[] {1, 2, 3}));
        final Path target = directory.resolve("download.bin");

        final Path written;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            written = new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .getStateVersion("group/sub/project", "name", 1, target);
        }

        assertThat(written).hasBinaryContent(new byte[] {1, 2, 3});
    }

    @Test
    void deleteStateVersion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .deleteStateVersion("group/sub/project", "name", 1);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1");
    }

    @Test
    void deleteStateVersion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteStateVersion("group/sub/project", "name", 1));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/versions/1");
    }

    @Test
    void listStateProtectionRules_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabTerraformStateProtectionRule.class, "terraform-state-protection-rule.json")
                        + "]"));

        final List<GitLabTerraformStateProtectionRule> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .listStateProtectionRules("group/sub/project");
        }

        assertThat(result).containsExactly(TerraformstateCatalogFixtures.terraformStateProtectionRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules");
    }

    @Test
    void createStateProtectionRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabTerraformStateProtectionRule.class, "terraform-state-protection-rule.json")));

        final GitLabTerraformStateProtectionRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .createStateProtectionRule(
                            "group/sub/project",
                            TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload());
        }

        assertThat(result).isEqualTo(TerraformstateCatalogFixtures.terraformStateProtectionRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules");
    }

    @Test
    void createStateProtectionRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStateProtectionRule(
                    "group/sub/project", TerraformstateCatalogFixtures.projectTerraformStateRuleCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules");
    }

    @Test
    void updateStateProtectionRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabTerraformStateProtectionRule.class, "terraform-state-protection-rule.json")));

        final GitLabTerraformStateProtectionRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .updateStateProtectionRule(
                            "group/sub/project",
                            1L,
                            TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload());
        }

        assertThat(result).isEqualTo(TerraformstateCatalogFixtures.terraformStateProtectionRule());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1");
    }

    @Test
    void updateStateProtectionRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateStateProtectionRule(
                    "group/sub/project", 1L, TerraformstateCatalogFixtures.projectTerraformStateRuleUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1");
    }

    @Test
    void deleteStateProtectionRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .deleteStateProtectionRule("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1");
    }

    @Test
    void deleteStateProtectionRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteStateProtectionRule("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state_protection_rules/1");
    }

    @Test
    void callState_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client)).callState("group/sub/project", "name");
        }

        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void callState_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callState("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void createState_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .createState(
                            "group/sub/project",
                            "name",
                            MultipartFormData.builder().text("field", "value").build());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void createState_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createState(
                    "group/sub/project",
                    "name",
                    MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void deleteState_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client)).deleteState("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void deleteState_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteState("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name");
    }

    @Test
    void authorizeState_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/authorize",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client)).authorizeState("group/sub/project", "name");
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/authorize");
    }

    @Test
    void authorizeState_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/authorize",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorizeState("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/authorize");
    }

    @Test
    void createStateLock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client))
                    .createStateLock(
                            "group/sub/project",
                            "name",
                            TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock");
    }

    @Test
    void createStateLock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStateLock(
                    "group/sub/project",
                    "name",
                    TerraformstateCatalogFixtures.projectTerraformStateCreateStateLockPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock");
    }

    @Test
    void deleteStateLock_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectTerraformStateApi(GitLabCaller.of(client)).deleteStateLock("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock");
    }

    @Test
    void deleteStateLock_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectTerraformStateApi api = new GitLabProjectTerraformStateApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteStateLock("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/terraform/state/name/lock");
    }
}
