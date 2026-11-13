package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

public final class SoftwarecompositionanalysisCatalogFixtures {

    private SoftwarecompositionanalysisCatalogFixtures() {}

    public static GitLabSecurityVulnerabilityScanningSbomScan securityVulnerabilityScanningSbomScan() {
        return GitLabSecurityVulnerabilityScanningSbomScanBuilder.builder()
                .id(1L)
                .downloadUrl("download_url")
                .throttled(true)
                .projectThrottlingResetsIn(1)
                .advisoryDbState("advisory_db_state")
                .build();
    }

    public static GitLabSoftwareCompositionAnalysisAuthorizePayload softwareCompositionAnalysisAuthorizePayload() {
        return GitLabSoftwareCompositionAnalysisAuthorizePayloadBuilder.builder()
                .filesize(1)
                .build();
    }

    public static GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload
            softwareCompositionAnalysisCreateBySbomDigestPayload() {
        return GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayloadBuilder.builder()
                .build();
    }
}
