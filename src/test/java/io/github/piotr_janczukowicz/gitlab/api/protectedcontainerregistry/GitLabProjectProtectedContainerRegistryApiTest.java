package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProtectedContainerRegistryApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProtectedContainerRegistryApi api() {
        return new GitLabProjectProtectedContainerRegistryApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProtectedContainerRegistryApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listRegistryProtectionRepositoryRules_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabProjectContainerRegistryProtectionRule.class,
                                        "project-container-registry-protection-rule.json")
                                + "]"));

        final List<GitLabProjectContainerRegistryProtectionRule> result =
                api().listRegistryProtectionRepositoryRules("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(
                            ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules");
        });
    }

    @Test
    void createRegistryProtectionRepositoryRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionRule.class,
                                "project-container-registry-protection-rule.json")));

        final GitLabProjectContainerRegistryProtectionRule result = api().createRegistryProtectionRepositoryRule(
                        "group/sub/project",
                        ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"repository_path_pattern\":");
        });
    }

    @Test
    void createRegistryProtectionRepositoryRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createRegistryProtectionRepositoryRule(
                        "group/sub/project",
                        ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateRegistryProtectionRepositoryRule_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionRule.class,
                                "project-container-registry-protection-rule.json")));

        final GitLabProjectContainerRegistryProtectionRule result = api().updateRegistryProtectionRepositoryRule(
                        "group/sub/project",
                        1L,
                        ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"repository_path_pattern\":");
        });
    }

    @Test
    void updateRegistryProtectionRepositoryRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateRegistryProtectionRepositoryRule(
                        "group/sub/project",
                        1L,
                        ProtectedcontainerregistryCatalogFixtures.containerRegistryRuleUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteRegistryProtectionRepositoryRule_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteRegistryProtectionRepositoryRule("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/registry/protection/repository/rules/1");
    }

    @Test
    void deleteRegistryProtectionRepositoryRule_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().deleteRegistryProtectionRepositoryRule("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
