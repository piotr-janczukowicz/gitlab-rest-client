package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespacesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabNamespacesApi api() {
        return new GitLabNamespacesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabNamespacesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNamespace.class, "namespace.json")));

        final Optional<GitLabNamespace> result = api().get("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/namespaces/group%2Fsub%2Fproject");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNamespace> result = api().get("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabNamespace.class, "namespace.json")));

        final GitLabNamespace result =
                api().update("group/sub/project", NamespacesCatalogFixtures.namespacesUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/namespaces/group%2Fsub%2Fproject");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"shared_runners_minutes_limit\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update("group/sub/project", NamespacesCatalogFixtures.namespacesUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getGitlabSubscription_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabGitlabSubscription.class, "gitlab-subscription.json")));

        final Optional<GitLabGitlabSubscription> result = api().getGitlabSubscription("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NamespacesCatalogFixtures.gitlabSubscription());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/namespaces/group%2Fsub%2Fproject/gitlab_subscription");
        });
    }

    @Test
    void getGitlabSubscription_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGitlabSubscription> result = api().getGitlabSubscription("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void createStorageLimitExclusion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabNamespaceStorageLimitExclusion.class, "namespace-storage-limit-exclusion.json")));

        final GitLabNamespaceStorageLimitExclusion result = api().createStorageLimitExclusion(
                        "group/sub/project", NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(NamespacesCatalogFixtures.namespaceStorageLimitExclusion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"reason\":");
        });
    }

    @Test
    void createStorageLimitExclusion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createStorageLimitExclusion(
                        "group/sub/project", NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteStorageLimitExclusion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteStorageLimitExclusion("group/sub/project");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
    }

    @Test
    void deleteStorageLimitExclusion_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteStorageLimitExclusion("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listStorageLimitExclusions_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabNamespaceStorageLimitExclusion.class,
                                        "namespace-storage-limit-exclusion.json")
                                + "]"));

        final GitLabPage<GitLabNamespaceStorageLimitExclusion> page = api().listStorageLimitExclusions();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespaceStorageLimitExclusion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/namespaces/storage/limit_exclusions");
        });
    }

    @Test
    void listStorageLimitExclusions_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabNamespaceStorageLimitExclusion.class,
                                        "namespace-storage-limit-exclusion.json")
                                + "]"));

        final GitLabPage<GitLabNamespaceStorageLimitExclusion> page =
                api().listStorageLimitExclusions(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespaceStorageLimitExclusion());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/namespaces/storage/limit_exclusions");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]"));

        final GitLabPage<GitLabNamespace> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/namespaces");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]"));

        final GitLabPage<GitLabNamespace> page = api().list(GitLabNamespacesListFilterBuilder.builder()
                .search("search")
                .ownedOnly(true)
                .topLevelOnly(true)
                .fullPathSearch(true)
                .requestedHostedPlan("requested_hosted_plan")
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/namespaces");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]"));

        final GitLabPage<GitLabNamespace> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/namespaces");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]"));

        final GitLabPage<GitLabNamespace> page = api().list(
                        GitLabNamespacesListFilterBuilder.builder()
                                .search("search")
                                .ownedOnly(true)
                                .topLevelOnly(true)
                                .fullPathSearch(true)
                                .requestedHostedPlan("requested_hosted_plan")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(NamespacesCatalogFixtures.namespace());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/namespaces");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("search", "search");
        });
    }

    @Test
    void getExists_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNamespaceExistence.class, "namespace-existence.json")));

        final Optional<GitLabNamespaceExistence> result = api().getExists("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(NamespacesCatalogFixtures.namespaceExistence());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/namespaces/group%2Fsub%2Fproject/exists");
        });
    }

    @Test
    void getExists_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabNamespaceExistence> result = api().getExists("group/sub/project");

        assertThat(result).isEmpty();
    }

    @Test
    void getExists_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabNamespaceExistence.class, "namespace-existence.json")));

        api().getExists(
                        "group/sub/project",
                        GitLabNamespacesGetExistsFilterBuilder.builder()
                                .parentId(1L)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("parent_id", "1");
    }
}
