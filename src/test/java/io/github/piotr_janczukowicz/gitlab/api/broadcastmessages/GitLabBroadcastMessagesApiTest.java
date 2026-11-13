package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBroadcastMessagesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabBroadcastMessagesApi api() {
        return new GitLabBroadcastMessagesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabBroadcastMessagesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")
                                + "]"));

        final GitLabPage<GitLabSystemBroadcastMessage> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/broadcast_messages");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")
                                + "]"));

        final GitLabPage<GitLabSystemBroadcastMessage> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/broadcast_messages");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final GitLabSystemBroadcastMessage result =
                api().create(BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/broadcast_messages");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"message\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().create(BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final Optional<GitLabSystemBroadcastMessage> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/broadcast_messages/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabSystemBroadcastMessage> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final GitLabSystemBroadcastMessage result =
                api().update(1L, BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/broadcast_messages/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"message\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update(1L, BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final Optional<GitLabSystemBroadcastMessage> result = api().delete(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/broadcast_messages/1");
        });
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        final Optional<GitLabSystemBroadcastMessage> result = api().delete(1L);

        assertThat(result).isEmpty();
    }
}
