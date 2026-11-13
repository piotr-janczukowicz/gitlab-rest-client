package io.github.piotr_janczukowicz.gitlab.api.geosites;

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
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGeoSitesApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabGeoSitesApi api() {
        return new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabGeoSitesApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGeoSite.class, "geo-site.json") + "]"));

        final GitLabPage<GitLabGeoSite> page = api().list();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GeositesCatalogFixtures.geoSite());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites");
        });
    }

    @Test
    void list_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, "[" + FileUtils.readString(GitLabGeoSite.class, "geo-site.json") + "]"));

        final GitLabPage<GitLabGeoSite> page = api().list(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GeositesCatalogFixtures.geoSite());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(GeositesCatalogFixtures.geoSitesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(GeositesCatalogFixtures.geoSitesCreatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final GitLabGeoSite result = api().create(GeositesCatalogFixtures.geoSitesCreatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSite());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/geo_sites");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"primary\":");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(GeositesCatalogFixtures.geoSitesCreatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void listStatus_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listStatus());

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void listStatus_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.listStatus());

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void listStatus_shouldReturnTheFirstPage_whenCalledWithTheDefaults() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json") + "]"));

        final GitLabPage<GitLabGeoSiteStatus> page = api().listStatus();
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GeositesCatalogFixtures.geoSiteStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites/status");
        });
    }

    @Test
    void listStatus_shouldReturnTheFirstPage_whenAPageRequestIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200, "[" + FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json") + "]"));

        final GitLabPage<GitLabGeoSiteStatus> page = api().listStatus(GitLabOffsetRequest.of(2));
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(page.items()).containsExactly(GeositesCatalogFixtures.geoSiteStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites/status");
            softly.assertThat(request.uri()).hasParameter("page", "2");
        });
    }

    @Test
    void get_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void get_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.get(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void get_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final Optional<GitLabGeoSite> result = api().get(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GeositesCatalogFixtures.geoSite());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites/1");
        });
    }

    @Test
    void get_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGeoSite> result = api().get(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void update_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void update_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown =
                catchThrowable(() -> lowTier.update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void update_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSite.class, "geo-site.json")));

        final GitLabGeoSite result = api().update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSite());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("PUT /api/v4/geo_sites/1");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"enabled\":");
        });
    }

    @Test
    void update_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown =
                catchThrowable(() -> api().update(1L, GeositesCatalogFixtures.geoSitesUpdatePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void delete_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void delete_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.delete(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void delete_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().delete(1L);

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertThat(GitLabApiTestClients.line(request)).isEqualTo("DELETE /api/v4/geo_sites/1");
    }

    @Test
    void delete_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().delete(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void getStatus_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getStatus(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void getStatus_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.getStatus(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void getStatus_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json")));

        final Optional<GitLabGeoSiteStatus> result = api().getStatus(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).contains(GeositesCatalogFixtures.geoSiteStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/geo_sites/1/status");
        });
    }

    @Test
    void getStatus_shouldReturnEmpty_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Optional<GitLabGeoSiteStatus> result = api().getStatus(1L);

        assertThat(result).isEmpty();
    }

    @Test
    void getStatus_shouldSendTheFilter_whenAFilterIsGiven() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json")));

        api().getStatus(
                        1L,
                        GitLabGeoSitesGetStatusFilterBuilder.builder()
                                .refresh(true)
                                .build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertThat(request.uri()).hasParameter("refresh", "true");
    }

    @Test
    void repair_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.repair(1L));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void repair_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabGeoSitesApi lowTier =
                new GitLabGeoSitesApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.repair(1L));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void repair_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(200, FileUtils.readString(GitLabGeoSiteStatus.class, "geo-site-status.json")));

        final GitLabGeoSiteStatus result = api().repair(1L);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result).isEqualTo(GeositesCatalogFixtures.geoSiteStatus());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/geo_sites/1/repair");
        });
    }

    @Test
    void repair_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().repair(1L));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
