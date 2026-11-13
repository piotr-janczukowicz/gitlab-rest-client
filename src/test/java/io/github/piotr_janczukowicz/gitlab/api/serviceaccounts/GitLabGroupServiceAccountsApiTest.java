package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessToken;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabPersonalAccessTokenWithToken;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabOffsetRequest;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupServiceAccountsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGroupServiceAccountsApi api() {
        return new GitLabGroupServiceAccountsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGroupServiceAccountsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list("group/sub/project");
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list(
                        "group/sub/project",
                        GitLabGroupServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                                .sort(GitLabGroupServiceAccountsListSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list("group/sub/project", GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list(
                        "group/sub/project",
                        GitLabGroupServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabGroupServiceAccountsListOrderBy.ID)
                                .sort(GitLabGroupServiceAccountsListSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result =
                api().create("group/sub/project", ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/service_accounts");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() ->
                api().create("group/sub/project", ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final Optional<GitLabServiceAccount> result = api().get("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabServiceAccount> result = api().get("group/sub/project", 1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result = api().update(
                        "group/sub/project", 1L, ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("PATCH /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().update(
                        "group/sub/project", 1L, ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete("group/sub/project", 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete("group/sub/project", 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(
                        "group/sub/project",
                        1L,
                        GitLabGroupServiceAccountsDeleteFilterBuilder.builder()
                                .hardDelete(true)
                                .build());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(request.uri()).hasParameter("hard_delete", "true");
    }

    @Test
    void listPersonalAccessTokens_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listPersonalAccessTokens("group/sub/project", 1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
        });
    }

    @Test
    void listPersonalAccessTokens_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listPersonalAccessTokens(
                        "group/sub/project",
                        1L,
                        GitLabGroupServiceAccountsListPersonalAccessTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabGroupServiceAccountsListPersonalAccessTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("revoked", "true");
        });
    }

    @Test
    void listPersonalAccessTokens_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page =
                api().listPersonalAccessTokens("group/sub/project", 1L, GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listPersonalAccessTokens_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listPersonalAccessTokens(
                        "group/sub/project",
                        1L,
                        GitLabGroupServiceAccountsListPersonalAccessTokensFilterBuilder.builder()
                                .revoked(true)
                                .state(GitLabGroupServiceAccountsListPersonalAccessTokensState.ALL)
                                .createdBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .createdAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedBefore(Instant.parse("2026-01-01T00:00:00Z"))
                                .lastUsedAfter(Instant.parse("2026-01-01T00:00:00Z"))
                                .expiresBefore(LocalDate.parse("2026-01-01"))
                                .expiresAfter(LocalDate.parse("2026-01-01"))
                                .search("search")
                                .sort("sort")
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("revoked", "true");
        });
    }

    @Test
    void createPersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result = api().createPersonalAccessToken(
                        "group/sub/project",
                        1L,
                        ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createPersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createPersonalAccessToken(
                        "group/sub/project",
                        1L,
                        ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePersonalAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deletePersonalAccessToken_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deletePersonalAccessToken("group/sub/project", 1L, 1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request))
                .isEqualTo("DELETE /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1");
    }

    @Test
    void deletePersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deletePersonalAccessToken("group/sub/project", 1L, 1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rotatePersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result = api().rotatePersonalAccessToken(
                        "group/sub/project",
                        1L,
                        1L,
                        ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo(
                            "POST /api/v4/groups/group%2Fsub%2Fproject/service_accounts/1/personal_access_tokens/1/rotate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"expires_at\":");
        });
    }

    @Test
    void rotatePersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().rotatePersonalAccessToken(
                        "group/sub/project",
                        1L,
                        1L,
                        ServiceaccountsCatalogFixtures.groupServiceAccountsRotatePersonalAccessTokenPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
