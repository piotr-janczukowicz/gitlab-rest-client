package io.github.piotr_janczukowicz.gitlab.api.featureflaguserlists;

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
class GitLabProjectFeatureFlagUserListsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(GitLabFeatureFlagUserList.class, "feature-flag-user-list.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(GitLabFeatureFlagUserList.class, "feature-flag-user-list.json") + "]"));

        final List<GitLabFeatureFlagUserList> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList(),
                        FeatureflaguserlistsCatalogFixtures.featureFlagUserList());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabFeatureFlagUserList.class, "feature-flag-user-list.json")));

        final GitLabFeatureFlagUserList result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload());
        }

        assertThat(result).isEqualTo(FeatureflaguserlistsCatalogFixtures.featureFlagUserList());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagUserListsApi api =
                    new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    "group/sub/project",
                    FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabFeatureFlagUserList.class, "feature-flag-user-list.json")));

        final Optional<GitLabFeatureFlagUserList> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client)).get("group/sub/project", "iid");
        }

        assertThat(result).contains(FeatureflaguserlistsCatalogFixtures.featureFlagUserList());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "iid")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabFeatureFlagUserList.class, "feature-flag-user-list.json")));

        final GitLabFeatureFlagUserList result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client))
                    .update(
                            "group/sub/project",
                            "iid",
                            FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload());
        }

        assertThat(result).isEqualTo(FeatureflaguserlistsCatalogFixtures.featureFlagUserList());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagUserListsApi api =
                    new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.update(
                    "group/sub/project",
                    "iid",
                    FeatureflaguserlistsCatalogFixtures.projectFeatureFlagUserListsUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client)).delete("group/sub/project", "iid");
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectFeatureFlagUserListsApi api =
                    new GitLabProjectFeatureFlagUserListsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", "iid"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/feature_flags_user_lists/iid");
    }
}
