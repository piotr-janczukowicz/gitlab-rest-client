package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

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
class GitLabGroupResourceLabelEventsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events",
                GitLabApiStubSupport.okJson(
                                "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json")
                                        + "]")
                        .header(
                                "Link",
                                "<" + base
                                        + "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json") + "]"));

        final List<GitLabResourceLabelEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabGroupResourceLabelEventsApi(GitLabCaller.of(client))
                    .list("group/sub/project", "eventable_id")
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent(),
                        ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
        HTTP.verifyRequested(GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events", 2);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events/event_id",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabResourceLabelEvent.class, "resource-label-event.json")));

        final Optional<GitLabResourceLabelEvent> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabGroupResourceLabelEventsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "eventable_id", "event_id");
        }

        assertThat(result).contains(ResourcelabeleventsCatalogFixtures.resourceLabelEvent());
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events/event_id");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events/event_id",
                GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabGroupResourceLabelEventsApi(GitLabCaller.of(client))
                    .get("group/sub/project", "eventable_id", "event_id")
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(
                GET, "/api/v4/groups/group%2Fsub%2Fproject/epics/eventable_id/resource_label_events/event_id");
    }
}
