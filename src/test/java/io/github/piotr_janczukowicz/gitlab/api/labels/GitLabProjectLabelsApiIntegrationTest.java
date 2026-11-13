package io.github.piotr_janczukowicz.gitlab.api.labels;

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
class GitLabProjectLabelsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void subscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/subscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final GitLabProjectLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .subscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/subscribe");
    }

    @Test
    void subscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/subscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.subscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/subscribe");
    }

    @Test
    void unsubscribe_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final GitLabProjectLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .unsubscribe("group/sub/project", "subscribable_id");
        }

        assertThat(result).isEqualTo(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe");
    }

    @Test
    void unsubscribe_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.unsubscribe("group/sub/project", "subscribable_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels/subscribable_id/unsubscribe");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabProjectLabel.class, "project-label.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/projects/group%2Fsub%2Fproject/labels?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabProjectLabel.class, "project-label.json") + "]"));

        final List<GitLabProjectLabel> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(LabelsCatalogFixtures.projectLabel(), LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/labels", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final GitLabProjectLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .create("group/sub/project", LabelsCatalogFixtures.projectLabelsCreatePayload());
        }

        assertThat(result).isEqualTo(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.create("group/sub/project", LabelsCatalogFixtures.projectLabelsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/labels",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final GitLabProjectLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .update("group/sub/project", LabelsCatalogFixtures.projectLabelsUpdatePayload());
        }

        assertThat(result).isEqualTo(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update("group/sub/project", LabelsCatalogFixtures.projectLabelsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectLabelsApi(GitLabCaller.of(client)).delete("group/sub/project");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final Optional<GitLabProjectLabel> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client)).get("group/sub/project", "name");
        }

        assertThat(result).contains(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/projects/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "name")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void updateByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/name",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabProjectLabel.class, "project-label.json")));

        final GitLabProjectLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .updateByName(
                            "group/sub/project", "name", LabelsCatalogFixtures.projectLabelsUpdateByNamePayload());
        }

        assertThat(result).isEqualTo(LabelsCatalogFixtures.projectLabel());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void updateByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.updateByName(
                    "group/sub/project", "name", LabelsCatalogFixtures.projectLabelsUpdateByNamePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void deleteByName_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectLabelsApi(GitLabCaller.of(client)).deleteByName("group/sub/project", "name");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void deleteByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels/name", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.deleteByName("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/labels/name");
    }

    @Test
    void promote_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/promote",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client))
                    .promote("group/sub/project", LabelsCatalogFixtures.projectLabelsPromotePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/promote");
    }

    @Test
    void promote_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/promote", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.promote("group/sub/project", LabelsCatalogFixtures.projectLabelsPromotePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/promote");
    }

    @Test
    void promoteByName_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/labels/name/promote",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabGroupLabel.class, "group-label.json")));

        final GitLabGroupLabel result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectLabelsApi(GitLabCaller.of(client)).promoteByName("group/sub/project", "name");
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.groupLabel());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name/promote");
    }

    @Test
    void promoteByName_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name/promote", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectLabelsApi api = new GitLabProjectLabelsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.promoteByName("group/sub/project", "name"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/labels/name/promote");
    }
}
