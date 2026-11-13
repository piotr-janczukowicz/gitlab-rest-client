package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabInstanceIssuesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void callIssuesStatistics_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(GET, "/api/v4/issues_statistics", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabInstanceIssuesApi(GitLabCaller.of(client)).callIssuesStatistics();
        }

        HTTP.verifyRequested(GET, "/api/v4/issues_statistics");
    }

    @Test
    void callIssuesStatistics_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/issues_statistics", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabInstanceIssuesApi api = new GitLabInstanceIssuesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.callIssuesStatistics());
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(GET, "/api/v4/issues_statistics");
    }

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/issues",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]")
                        .header("Link", "<" + base + "/api/v4/issues?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabIssue.class, "issue.json") + "]"));

        final List<GitLabIssue> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceIssuesApi(GitLabCaller.of(client)).list().all();
        }

        assertThat(items).containsExactly(IssuesCatalogFixtures.issue(), IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(GET, "/api/v4/issues", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/issues/group%2Fsub%2Fproject",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssue.class, "issue.json")));

        final Optional<GitLabIssue> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabInstanceIssuesApi(GitLabCaller.of(client)).get("group/sub/project");
        }

        assertThat(result).contains(IssuesCatalogFixtures.issue());
        HTTP.verifyRequested(GET, "/api/v4/issues/group%2Fsub%2Fproject");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/issues/group%2Fsub%2Fproject", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabInstanceIssuesApi(GitLabCaller.of(client))
                    .get("group/sub/project")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/issues/group%2Fsub%2Fproject");
    }
}
