package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabProjectMergeTrainsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_trains",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_trains?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final List<GitLabMergeTrainsCar> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeTrainsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergetrainsCatalogFixtures.mergeTrainsCar(), MergetrainsCatalogFixtures.mergeTrainsCar());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_trains", 2);
    }

    @Test
    void listByTargetBranch_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final List<GitLabMergeTrainsCar> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectMergeTrainsApi(GitLabCaller.of(client))
                    .listByTargetBranch("group/sub/project", "target_branch")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        MergetrainsCatalogFixtures.mergeTrainsCar(), MergetrainsCatalogFixtures.mergeTrainsCar());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/target_branch", 2);
    }

    @Test
    void getMergeRequest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json")));

        final Optional<GitLabMergeTrainsCar> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeTrainsApi(GitLabCaller.of(client)).getMergeRequest("group/sub/project", 1L);
        }

        assertThat(result).contains(MergetrainsCatalogFixtures.mergeTrainsCar());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1");
    }

    @Test
    void getMergeRequest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectMergeTrainsApi(GitLabCaller.of(client))
                    .getMergeRequest("group/sub/project", 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1");
    }

    @Test
    void createMergeRequest_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabMergeTrainsCar.class, "merge-trains-car.json") + "]"));

        final List<GitLabMergeTrainsCar> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeTrainsApi(GitLabCaller.of(client))
                    .createMergeRequest(
                            "group/sub/project",
                            1L,
                            MergetrainsCatalogFixtures.projectMergeTrainsCreateMergeRequestPayload());
        }

        assertThat(result).containsExactly(MergetrainsCatalogFixtures.mergeTrainsCar());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_trains/merge_requests/1");
    }
}
