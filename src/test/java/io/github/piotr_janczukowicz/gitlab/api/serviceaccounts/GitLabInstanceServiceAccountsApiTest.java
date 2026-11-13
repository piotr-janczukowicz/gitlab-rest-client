package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceServiceAccountsApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabInstanceServiceAccountsApi api() {
        return new GitLabInstanceServiceAccountsApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabInstanceServiceAccountsApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/service_accounts");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list(
                        GitLabInstanceServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                                .sort(GitLabInstanceServiceAccountsListSort.ASC)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/service_accounts");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/service_accounts");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAFilterAndAPageRequestAreGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabServiceAccount.class, "service-account.json") + "]"));

        final GitLabPage<GitLabServiceAccount> page = api().list(
                        GitLabInstanceServiceAccountsListFilterBuilder.builder()
                                .orderBy(GitLabInstanceServiceAccountsListOrderBy.ID)
                                .sort(GitLabInstanceServiceAccountsListSort.ASC)
                                .build(),
                        GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/service_accounts");
            softly.assertThat(request.uri()).hasParameter("page", "2");
            softly.assertThat(request.uri()).hasParameter("order_by", "id");
        });
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result =
                api().create(ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/service_accounts");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().create(ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabServiceAccount.class, "service-account.json")));

        final GitLabServiceAccount result =
                api().update(1L, ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(ServiceaccountsCatalogFixtures.serviceAccount());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PATCH /api/v4/service_accounts/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"name\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(
                () -> api().update(1L, ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
