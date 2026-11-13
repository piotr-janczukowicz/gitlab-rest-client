package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
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
class GitLabProjectIssueLinksApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links",
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabRelatedIssue.class, "related-issue.json") + "]"));

        final List<GitLabRelatedIssue> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueLinksApi(GitLabCaller.of(client)).list("group/sub/project", 1L);
        }

        assertThat(result).containsExactly(IssuelinksCatalogFixtures.relatedIssue());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssueLink.class, "issue-link.json")));

        final GitLabIssueLink result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueLinksApi(GitLabCaller.of(client))
                    .create("group/sub/project", 1L, IssuelinksCatalogFixtures.projectIssueLinksCreatePayload());
        }

        assertThat(result).isEqualTo(IssuelinksCatalogFixtures.issueLink());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueLinksApi api = new GitLabProjectIssueLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() ->
                    api.create("group/sub/project", 1L, IssuelinksCatalogFixtures.projectIssueLinksCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssueLink.class, "issue-link.json")));

        final Optional<GitLabIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueLinksApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L, "issue_link_id");
        }

        assertThat(result).contains(IssuelinksCatalogFixtures.issueLink());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectIssueLinksApi(GitLabCaller.of(client))
                    .get("group/sub/project", 1L, "issue_link_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabIssueLink.class, "issue-link.json")));

        final Optional<GitLabIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueLinksApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L, "issue_link_id");
        }

        assertThat(result).contains(IssuelinksCatalogFixtures.issueLink());
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectIssueLinksApi api = new GitLabProjectIssueLinksApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L, "issue_link_id"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id",
                GitLabApiStubSupport.noContent());

        final Optional<GitLabIssueLink> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectIssueLinksApi(GitLabCaller.of(client))
                    .delete("group/sub/project", 1L, "issue_link_id");
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/links/issue_link_id");
    }
}
