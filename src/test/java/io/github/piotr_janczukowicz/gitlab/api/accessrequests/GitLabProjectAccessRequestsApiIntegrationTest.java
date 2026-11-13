package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMember;
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
class GitLabProjectAccessRequestsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/access_requests",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabAccessRequester.class, "access-requester.json") + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/access_requests?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabAccessRequester.class, "access-requester.json") + "]"));

        final List<GitLabAccessRequester> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client))
                    .list("group/sub/project")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        AccessrequestsCatalogFixtures.accessRequester(),
                        AccessrequestsCatalogFixtures.accessRequester());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/access_requests", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/projects/group%2Fsub%2Fproject/access_requests",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabAccessRequester.class, "access-requester.json")));

        final GitLabAccessRequester result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client)).create("group/sub/project");
        }

        assertThat(result).isEqualTo(AccessrequestsCatalogFixtures.accessRequester());
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_requests");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_requests", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessRequestsApi api = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create("group/sub/project"));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/projects/group%2Fsub%2Fproject/access_requests");
    }

    @Test
    void approve_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1/approve",
                GitLabApiStubSupport.okJson(FileUtils.readString(GitLabMember.class, "member.json")));

        final GitLabMember result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client))
                    .approve(
                            "group/sub/project",
                            1L,
                            AccessrequestsCatalogFixtures.projectAccessRequestsApprovePayload());
        }

        assertThat(result).isEqualTo(CommonCatalogFixtures.member());
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1/approve");
    }

    @Test
    void approve_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1/approve",
                GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessRequestsApi api = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.approve(
                    "group/sub/project", 1L, AccessrequestsCatalogFixtures.projectAccessRequestsApprovePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1/approve");
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabProjectAccessRequestsApi(GitLabCaller.of(client)).delete("group/sub/project", 1L);
        }

        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabProjectAccessRequestsApi api = new GitLabProjectAccessRequestsApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete("group/sub/project", 1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/projects/group%2Fsub%2Fproject/access_requests/1");
    }
}
