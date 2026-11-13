package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import static io.github.piotr_janczukowicz.http.HttpMethod.GET;
import static io.github.piotr_janczukowicz.http.HttpMethod.POST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabClient;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabNotFoundException;
import io.github.piotr_janczukowicz.gitlab.test.GitLabApiStubSupport;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.test.http.StubHttpServer;
import io.github.piotr_janczukowicz.testsupport.IntegrationTest;
import io.github.piotr_janczukowicz.util.FileUtils;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

@IntegrationTest
class GitLabSoftwareCompositionAnalysisApiIntegrationTest {

    @RegisterExtension
    static final StubHttpServer HTTP = new StubHttpServer();

    @Test
    void authorize_shouldSendTheRequest_whenResponseIsNoContent() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/sbom_scans/authorize", GitLabApiStubSupport.noContent());

        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client))
                    .authorize(
                            1L,
                            SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload());
        }

        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans/authorize");
    }

    @Test
    void authorize_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/sbom_scans/authorize", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSoftwareCompositionAnalysisApi api =
                    new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.authorize(
                    1L, SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans/authorize");
    }

    @Test
    void create_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/jobs/1/sbom_scans",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSecurityVulnerabilityScanningSbomScan.class,
                        "security-vulnerability-scanning-sbom-scan.json")));

        final GitLabSecurityVulnerabilityScanningSbomScan result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client))
                    .create(
                            1L,
                            MultipartFormData.builder().text("field", "value").build());
        }

        assertThat(result)
                .isEqualTo(SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans");
    }

    @Test
    void create_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/sbom_scans", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSoftwareCompositionAnalysisApi api =
                    new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.create(
                    1L, MultipartFormData.builder().text("field", "value").build()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans");
    }

    @Test
    void list_shouldReturnTheItems_whenResponseIsOk() throws Exception {
        HTTP.stub(
                GET,
                "/api/v4/jobs/1/sbom_scans/1",
                GitLabApiStubSupport.okJson("["
                        + FileUtils.readString(
                                GitLabSecurityVulnerabilityScanningSbomScan.class,
                                "security-vulnerability-scanning-sbom-scan.json")
                        + "]"));

        final List<GitLabSecurityVulnerabilityScanningSbomScan> result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client)).list(1L, 1);
        }

        assertThat(result)
                .containsExactly(SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
        HTTP.verifyRequested(GET, "/api/v4/jobs/1/sbom_scans/1");
    }

    @Test
    void createBySbomDigest_shouldReturnTheResource_whenResponseIsOk() throws Exception {
        HTTP.stub(
                POST,
                "/api/v4/jobs/1/sbom_scans/sbom_digest",
                GitLabApiStubSupport.okJson(FileUtils.readString(
                        GitLabSecurityVulnerabilityScanningSbomScan.class,
                        "security-vulnerability-scanning-sbom-scan.json")));

        final GitLabSecurityVulnerabilityScanningSbomScan result;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            result = new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client))
                    .createBySbomDigest(
                            1L,
                            "sbom_digest",
                            SoftwarecompositionanalysisCatalogFixtures
                                    .softwareCompositionAnalysisCreateBySbomDigestPayload());
        }

        assertThat(result)
                .isEqualTo(SoftwarecompositionanalysisCatalogFixtures.securityVulnerabilityScanningSbomScan());
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans/sbom_digest");
    }

    @Test
    void createBySbomDigest_shouldAnswerNotFound_whenResponseIsNotFound() throws Exception {
        HTTP.stub(POST, "/api/v4/jobs/1/sbom_scans/sbom_digest", GitLabApiStubSupport.notFound());

        final Throwable thrown;
        try (GitLabClient client = GitLabApiStubSupport.client(HTTP)) {
            final GitLabSoftwareCompositionAnalysisApi api =
                    new GitLabSoftwareCompositionAnalysisApi(GitLabCaller.of(client));
            thrown = catchThrowable(() -> api.createBySbomDigest(
                    1L,
                    "sbom_digest",
                    SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisCreateBySbomDigestPayload()));
        }

        assertThat(thrown).isInstanceOf(GitLabNotFoundException.class);
        HTTP.verifyRequested(POST, "/api/v4/jobs/1/sbom_scans/sbom_digest");
    }
}
