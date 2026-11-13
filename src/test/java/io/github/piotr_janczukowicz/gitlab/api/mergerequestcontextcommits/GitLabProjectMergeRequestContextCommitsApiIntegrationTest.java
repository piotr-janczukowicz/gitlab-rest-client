package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
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
class GitLabProjectMergeRequestContextCommitsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabCommitWithLink.class, "commit-with-link.json") + "]"));

        final List<GitLabCommitWithLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestContextCommitsApi(GitLabCaller.of(client))
                    .list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(MergerequestcontextcommitsCatalogFixtures.commitWithLink());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits");
    }

    @Test
    void create_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabCommit.class, "commit.json") + "]"));

        final List<GitLabCommit> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectMergeRequestContextCommitsApi(GitLabCaller.of(client))
                    .create(
                            "group/sub/project",
                            1L,
                            MergerequestcontextcommitsCatalogFixtures.projectMergeRequestContextCommitsCreatePayload());
        }

        assertThat(result).containsExactly(CommonCatalogFixtures.commit());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits",
                GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectMergeRequestContextCommitsApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L, List.of("commits"));
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectMergeRequestContextCommitsApi api =
                    new GitLabProjectMergeRequestContextCommitsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, List.of("commits")));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/context_commits");
    }
}
