package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
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
class GitLabProjectResourceStateEventsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listIssuesResourceStateEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final List<GitLabResourceStateEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .listIssuesResourceStateEvents("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent(),
                        ResourcestateeventsCatalogFixtures.resourceStateEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events", 2);
    }

    @Test
    void getIssuesResourceStateEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")));

        final Optional<GitLabResourceStateEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .getIssuesResourceStateEvents("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(ResourcestateeventsCatalogFixtures.resourceStateEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events/1");
    }

    @Test
    void getIssuesResourceStateEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .getIssuesResourceStateEvents("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/1/resource_state_events/1");
    }

    @Test
    void listRequestsResourceStateEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json") + "]"));

        final List<GitLabResourceStateEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .listRequestsResourceStateEvents("group/sub/project", 1L)
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcestateeventsCatalogFixtures.resourceStateEvent(),
                        ResourcestateeventsCatalogFixtures.resourceStateEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events", 2);
    }

    @Test
    void getRequestsResourceStateEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceStateEvent.class, "resource-state-event.json")));

        final Optional<GitLabResourceStateEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .getRequestsResourceStateEvents("group/sub/project", 1L, 1L);
        }

        assertThat(result).contains(ResourcestateeventsCatalogFixtures.resourceStateEvent());
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events/1");
    }

    @Test
    void getRequestsResourceStateEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events/1",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceStateEventsApi(GitLabCaller.of(client))
                    .getRequestsResourceStateEvents("group/sub/project", 1L, 1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/1/resource_state_events/1");
    }
}
