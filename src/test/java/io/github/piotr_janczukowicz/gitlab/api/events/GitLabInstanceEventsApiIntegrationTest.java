package io.github.piotr_janczukowicz.gitlab.api.events;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabInstanceEventsApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void listEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/events",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]")
                        .header("Link", "<" + base + "/api/v4/events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final List<GitLabEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceEventsApi(GitLabCaller.of(client))
                    .listEvents()
                    .all();
        }

        assertThat(items).containsExactly(EventsCatalogFixtures.event(), EventsCatalogFixtures.event());
        HTTP.verifyRequested(GET, "/api/v4/events", 2);
    }

    @Test
    void listUsersEvents_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/users/group%2Fsub%2Fproject/events",
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]")
                        .header(
                                "Link",
                                "<" + base + "/api/v4/users/group%2Fsub%2Fproject/events?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson("[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final List<GitLabEvent> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabInstanceEventsApi(GitLabCaller.of(client))
                    .listUsersEvents("group/sub/project")
                    .all();
        }

        assertThat(items).containsExactly(EventsCatalogFixtures.event(), EventsCatalogFixtures.event());
        HTTP.verifyRequested(GET, "/api/v4/users/group%2Fsub%2Fproject/events", 2);
    }
}
