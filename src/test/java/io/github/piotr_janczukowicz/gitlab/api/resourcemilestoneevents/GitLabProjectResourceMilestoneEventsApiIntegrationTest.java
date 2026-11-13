package io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;

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
class GitLabProjectResourceMilestoneEventsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listIssuesResourceMilestoneEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final List<GitLabResourceMilestoneEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .listIssuesResourceMilestoneEvents("group/sub/project", "eventable_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent(),
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events", 2);
    }

    @Test
    void getIssuesResourceMilestoneEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events/event_id",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")));

        final Optional<GitLabResourceMilestoneEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .getIssuesResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");
        }

        assertThat(result).contains(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events/event_id");
    }

    @Test
    void getIssuesResourceMilestoneEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events/event_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .getIssuesResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/issues/eventable_id/resource_milestone_events/event_id");
    }

    @Test
    void listRequestsResourceMilestoneEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")
                                + "]"));

        final List<GitLabResourceMilestoneEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .listRequestsResourceMilestoneEvents("group/sub/project", "eventable_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent(),
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
        HTTP.verifyRequested(
                GET, "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events", 2);
    }

    @Test
    void getRequestsResourceMilestoneEvents_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events/event_id",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceMilestoneEvent.class, "resource-milestone-event.json")));

        final Optional<GitLabResourceMilestoneEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .getRequestsResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id");
        }

        assertThat(result).contains(ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent());
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events/event_id");
    }

    @Test
    void getRequestsResourceMilestoneEvents_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events/event_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabProjectResourceMilestoneEventsApi(GitLabCaller.of(client))
                    .getRequestsResourceMilestoneEvents("group/sub/project", "eventable_id", "event_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET,
                "/api/v4/projects/group%2Fsub%2Fproject/merge_requests/eventable_id/resource_milestone_events/event_id");
    }
}
