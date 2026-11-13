package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupGroupWebhooksApi api() {
        return new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupGroupWebhooksApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list("group/sub/project"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroupHook.class, "group-hook.json") + "]"));

        final GitLabPage<GitLabGroupHook> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupwebhooksCatalogFixtures.groupHook());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/hooks");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGroupHook.class, "group-hook.json") + "]"));

        final GitLabPage<GitLabGroupHook> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GroupwebhooksCatalogFixtures.groupHook());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/hooks");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.create("group/sub/project", GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() ->
                lowTier.create("group/sub/project", GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupHook.class, "group-hook.json")));

        final GitLabGroupHook result =
                api().create("group/sub/project", GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupwebhooksCatalogFixtures.groupHook());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/hooks");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create("group/sub/project", GroupwebhooksCatalogFixtures.groupGroupWebhooksCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupHook.class, "group-hook.json")));

        final Optional<GitLabGroupHook> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GroupwebhooksCatalogFixtures.groupHook());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/hooks/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGroupHook> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project", 1L, GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.update(
                "group/sub/project", 1L, GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGroupHook.class, "group-hook.json")));

        final GitLabGroupHook result =
                api().update("group/sub/project", 1L, GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GroupwebhooksCatalogFixtures.groupHook());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/hooks/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"url\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().update("group/sub/project", 1L, GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/hooks/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callEvents_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callEvents("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void callEvents_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.callEvents("group/sub/project", 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void callEvents_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callEvents("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/hooks/1/events");
    }

    @Test
    void callEvents_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().callEvents("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void callEvents_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().callEvents(
                        "group/sub/project",
                        1L,
                        GitLabGroupGroupWebhooksCallEventsFilterBuilder.builder()
                                .status(List.of(GitLabGroupGroupWebhooksCallEventsStatus.N_100))
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("status", "100");
    }

    @Test
    void updateUrlVariable_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateUrlVariable(
                "group/sub/project",
                1L,
                "key",
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateUrlVariable_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateUrlVariable(
                "group/sub/project",
                1L,
                "key",
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateUrlVariable(
                        "group/sub/project",
                        1L,
                        "key",
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/hooks/1/url_variables/key");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"value\":");
        });
    }

    @Test
    void updateUrlVariable_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateUrlVariable(
                        "group/sub/project",
                        1L,
                        "key",
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteUrlVariable_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteUrlVariable("group/sub/project", 1L, "key"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteUrlVariable_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteUrlVariable("group/sub/project", 1L, "key"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteUrlVariable_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteUrlVariable("group/sub/project", 1L, "key");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/hooks/1/url_variables/key");
    }

    @Test
    void deleteUrlVariable_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteUrlVariable("group/sub/project", 1L, "key"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void updateCustomHeader_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateCustomHeader(
                "group/sub/project",
                1L,
                "key",
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void updateCustomHeader_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.updateCustomHeader(
                "group/sub/project",
                1L,
                "key",
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void updateCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().updateCustomHeader(
                        "group/sub/project",
                        1L,
                        "key",
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PUT /api/v4/groups/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"value\":");
        });
    }

    @Test
    void updateCustomHeader_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().updateCustomHeader(
                        "group/sub/project",
                        1L,
                        "key",
                        GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteCustomHeader_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteCustomHeader("group/sub/project", 1L, "key"));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void deleteCustomHeader_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.deleteCustomHeader("group/sub/project", 1L, "key"));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void deleteCustomHeader_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteCustomHeader("group/sub/project", 1L, "key");

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/hooks/1/custom_headers/key");
    }

    @Test
    void deleteCustomHeader_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteCustomHeader("group/sub/project", 1L, "key"));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void createTest_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createTest(
                "group/sub/project", 1L, GitLabGroupGroupWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createTest_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createTest(
                "group/sub/project", 1L, GitLabGroupGroupWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createTest_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().createTest("group/sub/project", 1L, GitLabGroupGroupWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/hooks/1/test/confidential_issues_events");
    }

    @Test
    void createTest_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createTest(
                        "group/sub/project", 1L, GitLabGroupGroupWebhooksCreateTestTrigger.CONFIDENTIAL_ISSUES_EVENTS));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void resendEvent_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.resendEvent("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void resendEvent_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGroupGroupWebhooksApi lowTier =
                new GitLabGroupGroupWebhooksApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.resendEvent("group/sub/project", 1L, 1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void resendEvent_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().resendEvent("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/hooks/1/events/1/resend");
    }

    @Test
    void resendEvent_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().resendEvent("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
