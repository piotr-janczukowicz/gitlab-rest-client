package io.github.piotr_janczukowicz.gitlab.api.projectcicdjobtokenscope;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicProjectDetails;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectCICDJobTokenScopeApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabProjectProjectCICDJobTokenScopeApi api() {
        return new GitLabProjectProjectCICDJobTokenScopeApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabProjectProjectCICDJobTokenScopeApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabProjectJobTokenScope.class, "project-job-token-scope.json")));

        final GitLabProjectJobTokenScope result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.projectJobTokenScope());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
        });
    }

    @Test
    void get_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().get("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().update(
                        "group/sub/project",
                        ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/projects/group%2Fsub%2Fproject/job_token_scope");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enabled\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project",
                        ProjectcicdjobtokenscopeCatalogFixtures.projectProjectCICDJobTokenScopeUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listAllowlist_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]"));

        final GitLabPage<GitLabBasicProjectDetails> page = api().listAllowlist("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/job_token_scope/allowlist");
        });
    }

    @Test
    void listAllowlist_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicProjectDetails.class, "basic-project-details.json")
                                + "]"));

        final GitLabPage<GitLabBasicProjectDetails> page =
                api().listAllowlist("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/job_token_scope/allowlist");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createAllowlist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(
                        response(200, FileUtils.readString(GitLabProjectScopeLink.class, "project-scope-link.json")));

        final GitLabProjectScopeLink result = api().createAllowlist(
                        1L,
                        ProjectcicdjobtokenscopeCatalogFixtures
                                .projectProjectCICDJobTokenScopeCreateAllowlistPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.projectScopeLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/1/job_token_scope/allowlist");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"target_project_id\":");
        });
    }

    @Test
    void createAllowlist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createAllowlist(
                        1L,
                        ProjectcicdjobtokenscopeCatalogFixtures
                                .projectProjectCICDJobTokenScopeCreateAllowlistPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listGroupsAllowlist_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicGroupDetails.class, "basic-group-details.json") + "]"));

        final GitLabPage<GitLabBasicGroupDetails> page = api().listGroupsAllowlist("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/job_token_scope/groups_allowlist");
        });
    }

    @Test
    void listGroupsAllowlist_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabBasicGroupDetails.class, "basic-group-details.json") + "]"));

        final GitLabPage<GitLabBasicGroupDetails> page =
                api().listGroupsAllowlist("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.basicGroupDetails());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/projects/group%2Fsub%2Fproject/job_token_scope/groups_allowlist");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void createGroupsAllowlist_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupScopeLink.class, "group-scope-link.json")));

        final GitLabGroupScopeLink result = api().createGroupsAllowlist(
                        1L,
                        ProjectcicdjobtokenscopeCatalogFixtures
                                .projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ProjectcicdjobtokenscopeCatalogFixtures.groupScopeLink());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/projects/1/job_token_scope/groups_allowlist");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"target_group_id\":");
        });
    }

    @Test
    void createGroupsAllowlist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createGroupsAllowlist(
                        1L,
                        ProjectcicdjobtokenscopeCatalogFixtures
                                .projectProjectCICDJobTokenScopeCreateGroupsAllowlistPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteGroupsAllowlist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteGroupsAllowlist(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/1/job_token_scope/groups_allowlist/1");
    }

    @Test
    void deleteGroupsAllowlist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteGroupsAllowlist(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteAllowlist_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteAllowlist(1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/projects/1/job_token_scope/allowlist/1");
    }

    @Test
    void deleteAllowlist_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteAllowlist(1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
