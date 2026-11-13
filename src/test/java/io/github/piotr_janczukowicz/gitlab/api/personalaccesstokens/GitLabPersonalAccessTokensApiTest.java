package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

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
class GitLabPersonalAccessTokensApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabPersonalAccessTokensApi api() {
        return new GitLabPersonalAccessTokensApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabPersonalAccessTokensApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void createUserPersonalAccessToken_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result = api().createUserPersonalAccessToken(
                        PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/user/personal_access_tokens");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void createUserPersonalAccessToken_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createUserPersonalAccessToken(
                        PersonalaccesstokensCatalogFixtures.personalAccessTokenCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rotateSelf_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result =
                api().rotateSelf(PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/personal_access_tokens/self/rotate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"expires_at\":");
        });
    }

    @Test
    void rotateSelf_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().rotateSelf(PersonalaccesstokensCatalogFixtures.personalAccessTokensRotateSelfPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getSelf_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")));

        final GitLabPersonalAccessToken result = api().getSelf();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens/self");
        });
    }

    @Test
    void getSelf_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().getSelf());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void deleteSelf_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().deleteSelf();

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/personal_access_tokens/self");
    }

    @Test
    void deleteSelf_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().deleteSelf());

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listSelfAssociations_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listSelfAssociations();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/personal_access_tokens/self/associations");
        });
    }

    @Test
    void listSelfAssociations_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listSelfAssociations(
                        GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                                .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/personal_access_tokens/self/associations");
            softly.assertThat(request.uri()).hasParameter("min_access_level", "10");
        });
    }

    @Test
    void listSelfAssociations_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listSelfAssociations(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/personal_access_tokens/self/associations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void listSelfAssociations_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().listSelfAssociations(
                        GitLabPersonalAccessTokensListSelfAssociationsFilterBuilder.builder()
                                .minAccessLevel(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.GUEST)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("GET /api/v4/personal_access_tokens/self/associations");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("min_access_level", "10");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().list(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
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
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("user_id", "1");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "[" + FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")
                                + "]"));

        final GitLabPage<GitLabPersonalAccessToken> page = api().list(
                        GitLabPersonalAccessTokensListFilterBuilder.builder()
                                .userId(1L)
                                .revoked(true)
                                .state(GitLabPersonalAccessTokensListState.ALL)
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
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("user_id", "1");
        });
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, FileUtils.readString(GitLabPersonalAccessToken.class, "personal-access-token.json")));

        final Optional<GitLabPersonalAccessToken> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(CommonCatalogFixtures.personalAccessToken());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/personal_access_tokens/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabPersonalAccessToken> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/personal_access_tokens/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void rotate_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabPersonalAccessTokenWithToken.class, "personal-access-token-with-token.json")));

        final GitLabPersonalAccessTokenWithToken result =
                api().rotate(1L, PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(CommonCatalogFixtures.personalAccessTokenWithToken());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/personal_access_tokens/1/rotate");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"expires_at\":");
        });
    }

    @Test
    void rotate_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().rotate(1L, PersonalaccesstokensCatalogFixtures.personalAccessTokensRotatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
