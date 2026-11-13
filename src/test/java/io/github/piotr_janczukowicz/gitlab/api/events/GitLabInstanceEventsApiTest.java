package io.github.piotr_janczukowicz.gitlab.api.events;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceEventsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceEventsApi api() {
        return new GitLabInstanceEventsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceEventsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void listEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listEvents();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/events");
        });
    }

    @Test
    void listEvents_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listEvents(GitLabInstanceEventsListEventsFilterBuilder.builder()
                .scope("scope")
                .action("action")
                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                .before(LocalDate.parse("2026-01-01"))
                .after(LocalDate.parse("2026-01-01"))
                .sort(GitLabInstanceEventsListEventsSort.ASC)
                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/events");
            softly.assertThat(request.uri()).hasParameter("scope", "scope");
        });
    }

    @Test
    void listEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listEvents(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listEvents_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listEvents(
                        GitLabInstanceEventsListEventsFilterBuilder.builder()
                                .scope("scope")
                                .action("action")
                                .targetType(GitLabInstanceEventsListEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListEventsSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("scope", "scope");
        });
    }

    @Test
    void listUsersEvents_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listUsersEvents("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/group%2Fsub%2Fproject/events");
        });
    }

    @Test
    void listUsersEvents_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listUsersEvents(
                        "group/sub/project",
                        GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/group%2Fsub%2Fproject/events");
            softly.assertThat(request.uri()).hasParameter("action", "action");
        });
    }

    @Test
    void listUsersEvents_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listUsersEvents("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/group%2Fsub%2Fproject/events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listUsersEvents_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabEvent.class, "event.json") + "]"));

        final GitLabPage<GitLabEvent> page = api().listUsersEvents(
                        "group/sub/project",
                        GitLabInstanceEventsListUsersEventsFilterBuilder.builder()
                                .action("action")
                                .targetType(GitLabInstanceEventsListUsersEventsTargetType.ISSUE)
                                .before(LocalDate.parse("2026-01-01"))
                                .after(LocalDate.parse("2026-01-01"))
                                .sort(GitLabInstanceEventsListUsersEventsSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(EventsCatalogFixtures.event());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/users/group%2Fsub%2Fproject/events");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("action", "action");
        });
    }
}
