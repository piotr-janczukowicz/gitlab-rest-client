package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
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
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabNamespacesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNamespace.class, "namespace.json")));

        final Optional<GitLabNamespace> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabNamespacesApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(NamespacesCatalogFixtures.namespace());
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/namespaces/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/namespaces/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabNamespace.class, "namespace.json")));

        final GitLabNamespace result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .update("group/sub/project", NamespacesCatalogFixtures.namespacesUpdatePayload());
        }

        assertThat(result).isEqualTo(NamespacesCatalogFixtures.namespace());
        HTTP.verifyRequested(PUT, "/api/v4/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/namespaces/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabNamespacesApi api = new GitLabNamespacesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", NamespacesCatalogFixtures.namespacesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/namespaces/group%2Fsub%2Fproject");
    }

    @Test
    void getGitlabSubscription_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/namespaces/group%2Fsub%2Fproject/gitlab_subscription",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabGitlabSubscription.class, "gitlab-subscription.json")));

        final Optional<GitLabGitlabSubscription> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabNamespacesApi(GitLabCaller.of(client)).getGitlabSubscription("group/sub/project");
        }

        assertThat(result).contains(NamespacesCatalogFixtures.gitlabSubscription());
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/gitlab_subscription");
    }

    @Test
    void getGitlabSubscription_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/gitlab_subscription", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .getGitlabSubscription("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/gitlab_subscription");
    }

    @Test
    void createStorageLimitExclusion_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabNamespaceStorageLimitExclusion.class, "namespace-storage-limit-exclusion.json")));

        final GitLabNamespaceStorageLimitExclusion result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .createStorageLimitExclusion(
                            "group/sub/project",
                            NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload());
        }

        assertThat(result).isEqualTo(NamespacesCatalogFixtures.namespaceStorageLimitExclusion());
        HTTP.verifyRequested(POST, "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
    }

    @Test
    void createStorageLimitExclusion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabNamespacesApi api = new GitLabNamespacesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createStorageLimitExclusion(
                    "group/sub/project", NamespacesCatalogFixtures.namespacesCreateStorageLimitExclusionPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
    }

    @Test
    void deleteStorageLimitExclusion_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabNamespacesApi(GitLabCaller.of(client)).deleteStorageLimitExclusion("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
    }

    @Test
    void deleteStorageLimitExclusion_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabNamespacesApi api = new GitLabNamespacesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteStorageLimitExclusion("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/namespaces/group%2Fsub%2Fproject/storage/limit_exclusion");
    }

    @Test
    void listStorageLimitExclusions_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/namespaces/storage/limit_exclusions",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabNamespaceStorageLimitExclusion.class,
                                        "namespace-storage-limit-exclusion.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/namespaces/storage/limit_exclusions?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabNamespaceStorageLimitExclusion.class, "namespace-storage-limit-exclusion.json")
                        + "]"));

        final List<GitLabNamespaceStorageLimitExclusion> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .listStorageLimitExclusions()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion(),
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion());
        HTTP.verifyRequested(GET, "/api/v4/namespaces/storage/limit_exclusions", 2);
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/namespaces",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]")
                        .header("Link", "<" + base + "/api/v4/namespaces?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabNamespace.class, "namespace.json") + "]"));

        final List<GitLabNamespace> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabNamespacesApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(NamespacesCatalogFixtures.namespace(), NamespacesCatalogFixtures.namespace());
        HTTP.verifyRequested(GET, "/api/v4/namespaces", 2);
    }

    @Test
    void getExists_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/namespaces/group%2Fsub%2Fproject/exists",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabNamespaceExistence.class, "namespace-existence.json")));

        final Optional<GitLabNamespaceExistence> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabNamespacesApi(GitLabCaller.of(client)).getExists("group/sub/project");
        }

        assertThat(result).contains(NamespacesCatalogFixtures.namespaceExistence());
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/exists");
    }

    @Test
    void getExists_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/exists", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabNamespacesApi(GitLabCaller.of(client))
                    .getExists("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/namespaces/group%2Fsub%2Fproject/exists");
    }
}
