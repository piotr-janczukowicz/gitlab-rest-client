package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;

/** The GitLab operations of software composition analysis. */
public final class GitLabSoftwareCompositionAnalysisApi extends GitLabResourceApi {
    private static final PathTemplate AUTHORIZE = PathTemplate.of("/jobs/{id}/sbom_scans/authorize");
    private static final PathTemplate CREATE = PathTemplate.of("/jobs/{id}/sbom_scans");
    private static final PathTemplate LIST = PathTemplate.of("/jobs/{id}/sbom_scans/{sbom_digest}");
    private static final JsonType<List<GitLabSecurityVulnerabilityScanningSbomScan>>
            SECURITY_VULNERABILITY_SCANNING_SBOM_SCAN_LIST_TYPE =
                    JsonTypes.listOf(GitLabSecurityVulnerabilityScanningSbomScan.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSoftwareCompositionAnalysisApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Authorize ({@code POST /jobs/{id}/sbom_scans/authorize}).
     *
     * @param id the id
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public void authorize(final long id, final GitLabSoftwareCompositionAnalysisAuthorizePayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4JobsIdSbomScansAuthorize");
        requireNonNull(payload, "payload");
        caller.send(caller.json(post(AUTHORIZE, id), payload));
    }

    /**
     * Create ({@code POST /jobs/{id}/sbom_scans}).
     *
     * @param id the id
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabSecurityVulnerabilityScanningSbomScan create(final long id, final MultipartFormData form)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4JobsIdSbomScans");
        requireNonNull(form, "form");
        return caller.fetch(
                caller.multipart(post(CREATE, id), form), GitLabSecurityVulnerabilityScanningSbomScan.class);
    }

    /**
     * List ({@code GET /jobs/{id}/sbom_scans/{sbom_digest}}).
     *
     * @param id the id
     * @param sbomDigest the sbom digest
     * @return the items
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public List<GitLabSecurityVulnerabilityScanningSbomScan> list(final long id, final int sbomDigest)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "getApiV4JobsIdSbomScansSbomScanId");
        return caller.fetch(get(LIST, id, sbomDigest), SECURITY_VULNERABILITY_SCANNING_SBOM_SCAN_LIST_TYPE);
    }

    /**
     * Create by sbom digest ({@code POST /jobs/{id}/sbom_scans/{sbom_digest}}).
     *
     * @param id the id
     * @param sbomDigest the sbom digest
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code sbomDigest} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than ultimate
     */
    @RequiresTier(GitLabTier.ULTIMATE)
    public GitLabSecurityVulnerabilityScanningSbomScan createBySbomDigest(
            final long id,
            final String sbomDigest,
            final GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.ULTIMATE, "postApiV4JobsIdSbomScansSbomDigest");
        requireNotBlank(sbomDigest, "sbomDigest");
        requireNonNull(payload, "payload");
        return caller.fetch(
                caller.json(post(LIST, id, sbomDigest), payload), GitLabSecurityVulnerabilityScanningSbomScan.class);
    }
}
