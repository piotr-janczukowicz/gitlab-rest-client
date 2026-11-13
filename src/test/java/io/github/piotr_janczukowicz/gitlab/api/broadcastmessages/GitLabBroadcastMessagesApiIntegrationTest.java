package io.github.piotr_janczukowicz.gitlab.api.broadcastmessages;

import static io.github.piotr_janczukowicz.http.HttpMethod.DELETE;
import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static io.github.piotr_janczukowicz.http.HttpMethod.PUT;
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
class GitLabBroadcastMessagesApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void list_shouldReadTheNextPage_whenTheResponseNamesIt() throws Exception {
        final String base = HTTP.baseUri().toString().replaceAll("/$", "");
        HTTP.stub(
                GET,
                "/api/v4/broadcast_messages",
                GitLabApiStubSupport.okJson("["
                                + FileUtils.readString(
                                        GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")
                                + "]")
                        .header("Link", "<" + base + "/api/v4/broadcast_messages?page=2>; rel=\"next\""),
                GitLabApiStubSupport.okJson(
                        "[" + FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")
                                + "]"));

        final List<GitLabSystemBroadcastMessage> items;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            items = new GitLabBroadcastMessagesApi(GitLabCaller.of(client))
                    .list()
                    .all();
        }

        assertThat(items)
                .containsExactly(
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage(),
                        BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
        HTTP.verifyRequested(GET, "/api/v4/broadcast_messages", 2);
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/broadcast_messages",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final GitLabSystemBroadcastMessage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBroadcastMessagesApi(GitLabCaller.of(client))
                    .create(BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload());
        }

        assertThat(result).isEqualTo(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
        HTTP.verifyRequested(POST, "/api/v4/broadcast_messages");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/broadcast_messages", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBroadcastMessagesApi api = new GitLabBroadcastMessagesApi(GitLabCaller.of(client));
            thrown =
                    catchThrowable(() -> api.create(BroadcastmessagesCatalogFixtures.broadcastMessagesCreatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/broadcast_messages");
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/broadcast_messages/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final Optional<GitLabSystemBroadcastMessage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBroadcastMessagesApi(GitLabCaller.of(client)).get(1L);
        }

        assertThat(result).contains(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
        HTTP.verifyRequested(GET, "/api/v4/broadcast_messages/1");
    }

    @Test
    void get_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(GET, "/api/v4/broadcast_messages/1", GitLabApiStubSupport.notFound());

        final boolean empty;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            empty = new GitLabBroadcastMessagesApi(GitLabCaller.of(client))
                    .get(1L)
                    .isEmpty();
        }

        assertThat(empty).isTrue();
        HTTP.verifyRequested(GET, "/api/v4/broadcast_messages/1");
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                PUT,
                "/api/v4/broadcast_messages/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final GitLabSystemBroadcastMessage result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBroadcastMessagesApi(GitLabCaller.of(client))
                    .update(1L, BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload());
        }

        assertThat(result).isEqualTo(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
        HTTP.verifyRequested(PUT, "/api/v4/broadcast_messages/1");
    }

    @Test
    void update_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(PUT, "/api/v4/broadcast_messages/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBroadcastMessagesApi api = new GitLabBroadcastMessagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(
                    () -> api.update(1L, BroadcastmessagesCatalogFixtures.broadcastMessagesUpdatePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(PUT, "/api/v4/broadcast_messages/1");
    }

    @Test
    void delete_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                DELETE,
                "/api/v4/broadcast_messages/1",
                GitLabApiStubSupport.okJson(
                        FileUtils.readString(GitLabSystemBroadcastMessage.class, "system-broadcast-message.json")));

        final Optional<GitLabSystemBroadcastMessage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBroadcastMessagesApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).contains(BroadcastmessagesCatalogFixtures.systemBroadcastMessage());
        HTTP.verifyRequested(DELETE, "/api/v4/broadcast_messages/1");
    }

    @Test
    void delete_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(DELETE, "/api/v4/broadcast_messages/1", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabBroadcastMessagesApi api = new GitLabBroadcastMessagesApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.delete(1L));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(DELETE, "/api/v4/broadcast_messages/1");
    }

    @Test
    void delete_shouldReturnEmpty_whenResponseIsNoContent() throws Exception {
        HTTP.stub(DELETE, "/api/v4/broadcast_messages/1", GitLabApiStubSupport.noContent());

        final Optional<GitLabSystemBroadcastMessage> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabBroadcastMessagesApi(GitLabCaller.of(client)).delete(1L);
        }

        assertThat(result).isEmpty();
        HTTP.verifyRequested(DELETE, "/api/v4/broadcast_messages/1");
    }
}
