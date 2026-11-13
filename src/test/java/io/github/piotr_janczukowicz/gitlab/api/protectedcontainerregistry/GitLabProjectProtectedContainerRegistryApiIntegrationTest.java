package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

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
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectProtectedContainerRegistryApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listRegistryProtectionRepositoryRules_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionRule.class,
                                "project-container-registry-protection-rule.json")
                        + "]"));

        final List<GitLabProjectContainerRegistryProtectionRule> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client))
                    .listRegistryProtectionRepositoryRules("group/sub/project");
        }

        assertThat(result)
                .containsExactly(ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules");
    }

    @Test
    void createRegistryProtectionRepositoryRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectContainerRegistryProtectionRule.class,
                        "project-container-registry-protection-rule.json")));

        final GitLabProjectContainerRegistryProtectionRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client))
                    .createRegistryProtectionRepositoryRule(
                            "group/sub/project",
                            ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload());
        }

        assertThat(result)
                .isEqualTo(ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules");
    }

    @Test
    void createRegistryProtectionRepositoryRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedContainerRegistryApi api =
                    new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createRegistryProtectionRepositoryRule(
                    "group/sub/project",
                    ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules");
    }

    @Test
    void updateRegistryProtectionRepositoryRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectContainerRegistryProtectionRule.class,
                        "project-container-registry-protection-rule.json")));

        final GitLabProjectContainerRegistryProtectionRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client))
                    .updateRegistryProtectionRepositoryRule(
                            "group/sub/project",
                            1L,
                            ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload());
        }

        assertThat(result)
                .isEqualTo(ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
    }

    @Test
    void updateRegistryProtectionRepositoryRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedContainerRegistryApi api =
                    new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateRegistryProtectionRepositoryRule(
                    "group/sub/project",
                    1L,
                    ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
    }

    @Test
    void deleteRegistryProtectionRepositoryRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client))
                    .deleteRegistryProtectionRepositoryRule("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
    }

    @Test
    void deleteRegistryProtectionRepositoryRule_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectProtectedContainerRegistryApi api =
                    new GitLabProjectProtectedContainerRegistryApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteRegistryProtectionRepositoryRule("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
    }
}
