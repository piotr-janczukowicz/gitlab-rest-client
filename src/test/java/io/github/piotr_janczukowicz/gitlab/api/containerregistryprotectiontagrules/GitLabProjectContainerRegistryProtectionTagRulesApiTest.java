package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

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
class GitLabProjectContainerRegistryProtectionTagRulesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectContainerRegistryProtectionTagRulesApi api() {
        return new GitLabProjectContainerRegistryProtectionTagRulesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectContainerRegistryProtectionTagRulesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabProjectContainerRegistryProtectionTagRule.class,
                                        "project-container-registry-protection-tag-rule.json")
                                + "]"));

        final List<GitLabProjectContainerRegistryProtectionTagRule> result = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(
                            ContainerregistryprotectiontagrulesCatalogFixtures
                                    .projectContainerRegistryProtectionTagRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionTagRule.class,
                                "project-container-registry-protection-tag-rule.json")));

        final GitLabProjectContainerRegistryProtectionTagRule result = api().create(
                        "group/sub/project",
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(
                            ContainerregistryprotectiontagrulesCatalogFixtures
                                    .projectContainerRegistryProtectionTagRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"tag_name_pattern\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        "group/sub/project",
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabProjectContainerRegistryProtectionTagRule.class,
                                "project-container-registry-protection-tag-rule.json")));

        final GitLabProjectContainerRegistryProtectionTagRule result = api().update(
                        "group/sub/project",
                        1L,
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(
                            ContainerregistryprotectiontagrulesCatalogFixtures
                                    .projectContainerRegistryProtectionTagRule());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"tag_name_pattern\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        1L,
                        ContainerregistryprotectiontagrulesCatalogFixtures.containerTagRuleUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/group%2Fsub%2Fproject/registry/protection/tag/rules/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
