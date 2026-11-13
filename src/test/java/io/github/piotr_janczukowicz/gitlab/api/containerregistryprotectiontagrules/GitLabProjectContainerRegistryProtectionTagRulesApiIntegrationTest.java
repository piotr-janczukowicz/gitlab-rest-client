package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

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
class GitLabProjectContainerRegistryProtectionTagRulesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionTagRule.class,
                                "project-container-registry-protection-tag-rule.json")
                        + "]"));

        final List<GitLabProjectContainerRegistryProtectionTagRule> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client))
                    .list("group/sub/project");
        }

        assertThat(result)
                .containsExactly(
                        ContainerregistryprotectiontagrulesCatalogFixtures.projectContainerRegistryProtectionTagRule());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectContainerRegistryProtectionTagRule.class,
                        "project-container-registry-protection-tag-rule.json")));

        final GitLabProjectContainerRegistryProtectionTagRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload());
        }

        assertThat(result)
                .isEqualTo(
                        ContainerregistryprotectiontagrulesCatalogFixtures.projectContainerRegistryProtectionTagRule());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryProtectionTagRulesApi api =
                    new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabProjectContainerRegistryProtectionTagRule.class,
                        "project-container-registry-protection-tag-rule.json")));

        final GitLabProjectContainerRegistryProtectionTagRule result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            1L,
                            ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload());
        }

        assertThat(result)
                .isEqualTo(
                        ContainerregistryprotectiontagrulesCatalogFixtures.projectContainerRegistryProtectionTagRule());
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PATCH,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryProtectionTagRulesApi api =
                    new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    1L,
                    ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PATCH, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectContainerRegistryProtectionTagRulesApi api =
                    new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
    }
}
