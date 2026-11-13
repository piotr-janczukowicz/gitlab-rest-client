package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabGroupLabel;
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
class GitLabGroupGroupLabelsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void subscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/subscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .subscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/subscribe");
    }

    @Test
    void subscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/subscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.subscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/subscribe");
    }

    @Test
    void unsubscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .unsubscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe");
    }

    @Test
    void unsubscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unsubscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabGroupLabel.class, "group-label.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/groups/group%2Fsub%2Fproject/labels?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabGroupLabel.class, "group-label.json") + "]"));

        final List<GitLabGroupLabel> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(CommonCatalogFixtures.groupLabel(), CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/labels", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/groups/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .create("group/sub/project", GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .update("group/sub/project", GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final Optional<GitLabGroupLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client)).delete("group/sub/project", "name");
        }

        assertThat(result).contains(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.noContent());

        final Optional<GitLabGroupLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client)).delete("group/sub/project", "name");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final Optional<GitLabGroupLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client)).get("group/sub/project", "name");
        }

        assertThat(result).contains(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/groups/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void updateByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client))
                    .updateByName(
                            "group/sub/project",
                            "name",
                            GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void updateByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateByName(
                    "group/sub/project", "name", GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void deleteByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/groups/group%2Fsub%2Fproject/labels/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final Optional<GitLabGroupLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client)).deleteByName("group/sub/project", "name");
        }

        assertThat(result).contains(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void deleteByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabGroupGroupLabelsApi api = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteByName("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void deleteByName_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.noContent());

        final Optional<GitLabGroupLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupGroupLabelsApi(GitLabCaller.of(client)).deleteByName("group/sub/project", "name");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/groups/group%2Fsub%2Fproject/labels/name");
    }
}
