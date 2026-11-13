package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import static io.github.piotr_janczukowicz.test.http.HttpResponses.response;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiTestClients;
import io.github.piotr_janczukowicz.http.HttpRequest;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.http.transport.HttpTransport;
import io.github.piotr_janczukowicz.test.http.HttpTransportMocks;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSoftwareCompositionAnalysisApiTest {

    private HttpTransport transport;

    @BeforeEach
    void setUpTransport() {
        transport = HttpTransportMocks.mock();
    }

    private GitLabSoftwareCompositionAnalysisApi api() {
        return new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport));
    }

    @Test
    void constructor_shouldRefuseNull_whenCallerIsNull() throws Exception {
        final Throwable thrown = catchThrowable(() -> new GitLabSoftwareCompositionAnalysisApi(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("caller");
    }

    @Test
    void authorize_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.authorize(
                1L, SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void authorize_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.authorize(
                1L, SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        when(transport.execute(any())).thenReturn(response(204, null));

        api().authorize(1L, SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload());

        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);
        assertSoftly(softly -> {
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/jobs/1/sbom_scans/authorize");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).contains("\"filesize\":");
        });
    }

    @Test
    void authorize_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().authorize(
                        1L, SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void create_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                1L, MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void create_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.create(
                1L, MultipartFormData.builder().text("field", "value").build()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSecurityVulnerabilityScanningSbomScan.class,
                                "security-vulnerability-scanning-sbom-scan.json")));

        final GitLabSecurityVulnerabilityScanningSbomScan result = api().create(
                        1L, MultipartFormData.builder().text("field", "value").build());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("POST /api/v4/jobs/1/sbom_scans");
        });
    }

    @Test
    void create_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().create(
                        1L, MultipartFormData.builder().text("field", "value").build()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }

    @Test
    void list_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L, 1));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void list_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.list(1L, 1));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        "["
                                + FileUtils.readString(
                                        GitLabSecurityVulnerabilityScanningSbomScan.class,
                                        "security-vulnerability-scanning-sbom-scan.json")
                                + "]"));

        final List<GitLabSecurityVulnerabilityScanningSbomScan> result = api().list(1L, 1);
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .containsExactly(
                            SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
            softly.assertThat(GitLabApiTestClients.line(request)).isEqualTo("GET /api/v4/jobs/1/sbom_scans/1");
        });
    }

    @Test
    void createBySbomDigest_shouldRefuse_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createBySbomDigest(
                1L,
                "sbom_digest",
                SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisCreateBySbomDigestPayload()));

        assertThat(thrown).isInstanceOf(GitLabTierException.class);
    }

    @Test
    void createBySbomDigest_shouldSendNoRequest_whenTheTierIsTooLow() throws Exception {
        final GitLabSoftwareCompositionAnalysisApi lowTier =
                new GitLabSoftwareCompositionAnalysisApi(GitLabApiTestClients.caller(transport, GitLabTier.FREE));

        final Throwable thrown = catchThrowable(() -> lowTier.createBySbomDigest(
                1L,
                "sbom_digest",
                SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisCreateBySbomDigestPayload()));

        GitLabApiTestClients.verifyNoRequest(transport);
        assertThat(thrown).isNotNull();
    }

    @Test
    void createBySbomDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        when(transport.execute(any()))
                .thenReturn(response(
                        200,
                        FileUtils.readString(
                                GitLabSecurityVulnerabilityScanningSbomScan.class,
                                "security-vulnerability-scanning-sbom-scan.json")));

        final GitLabSecurityVulnerabilityScanningSbomScan result = api().createBySbomDigest(
                        1L,
                        "sbom_digest",
                        SoftwarecompositionanalysisCatalogFixtures
                                .softwareCompositionAnalysisCreateBySbomDigestPayload());
        final HttpRequest request = GitLabApiTestClients.singleRequest(transport);

        assertSoftly(softly -> {
            softly.assertThat(result)
                    .isEqualTo(SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
            softly.assertThat(GitLabApiTestClients.line(request))
                    .isEqualTo("POST /api/v4/jobs/1/sbom_scans/sbom_digest");
            softly.assertThat(GitLabApiTestClients.bodyText(request)).isNotEmpty();
        });
    }

    @Test
    void createBySbomDigest_shouldThrowNotFound_whenResponseIsNotFound() throws Exception {
        when(transport.execute(any())).thenReturn(response(404, null));

        final Throwable thrown = catchThrowable(() -> api().createBySbomDigest(
                        1L,
                        "sbom_digest",
                        SoftwarecompositionanalysisCatalogFixtures
                                .softwareCompositionAnalysisCreateBySbomDigestPayload()));

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
    }
}
