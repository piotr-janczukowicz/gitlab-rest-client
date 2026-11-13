package io.github.piotr_janczukowicz.gitlab.api.geo;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public final class GeoCatalogFixtures {

    private GeoCatalogFixtures() {}

    public static GitLabGeoCreateFailuresFailure geoCreateFailuresFailure() {
        return GitLabGeoCreateFailuresFailureBuilder.builder()
                .errorType("checksum_mismatch")
                .replicableName("upload")
                .replicableId(1L)
                .verificationRetryCount(1)
                .context(Map.of("key", "value"))
                .build();
    }

    public static GitLabGeoCreateFailuresPayload geoCreateFailuresPayload() {
        return GitLabGeoCreateFailuresPayloadBuilder.builder()
                .geoNodeId(1L)
                .failures(List.of(GeoCatalogFixtures.geoCreateFailuresFailure()))
                .build();
    }

    public static GitLabGeoCreateStatusData geoCreateStatusData() {
        return GitLabGeoCreateStatusDataBuilder.builder()
                .geoNodeId(1L)
                .dbReplicationLagSeconds(1)
                .lastEventId(1L)
                .lastEventDate(Instant.parse("2026-01-01T00:00:00Z"))
                .cursorLastEventId(1L)
                .cursorLastEventDate(Instant.parse("2026-01-01T00:00:00Z"))
                .lastSuccessfulStatusCheckAt(Instant.parse("2026-01-01T00:00:00Z"))
                .statusMessage("status_message")
                .replicationSlotsCount(1)
                .replicationSlotsUsedCount(1)
                .replicationSlotsMaxRetainedWalBytes(1L)
                .version("version")
                .revision("revision")
                .status(GeoCatalogFixtures.geoCreateStatusDataStatus())
                .build();
    }

    public static GitLabGeoCreateStatusDataStatus geoCreateStatusDataStatus() {
        return GitLabGeoCreateStatusDataStatusBuilder.builder()
                .projectsCount(1)
                .containerRepositoriesReplicationEnabled(true)
                .lfsObjectsCount(1)
                .lfsObjectsChecksumTotalCount(1)
                .lfsObjectsChecksummedCount(1)
                .lfsObjectsChecksumFailedCount(1)
                .lfsObjectsSyncedCount(1)
                .lfsObjectsFailedCount(1)
                .lfsObjectsRegistryCount(1)
                .lfsObjectsVerificationTotalCount(1)
                .lfsObjectsVerifiedCount(1)
                .lfsObjectsVerificationFailedCount(1)
                .mergeRequestDiffsCount(1)
                .mergeRequestDiffsChecksumTotalCount(1)
                .mergeRequestDiffsChecksummedCount(1)
                .mergeRequestDiffsChecksumFailedCount(1)
                .mergeRequestDiffsSyncedCount(1)
                .mergeRequestDiffsFailedCount(1)
                .mergeRequestDiffsRegistryCount(1)
                .mergeRequestDiffsVerificationTotalCount(1)
                .mergeRequestDiffsVerifiedCount(1)
                .mergeRequestDiffsVerificationFailedCount(1)
                .packageFilesCount(1)
                .packageFilesChecksumTotalCount(1)
                .packageFilesChecksummedCount(1)
                .packageFilesChecksumFailedCount(1)
                .packageFilesSyncedCount(1)
                .packageFilesFailedCount(1)
                .packageFilesRegistryCount(1)
                .packageFilesVerificationTotalCount(1)
                .packageFilesVerifiedCount(1)
                .packageFilesVerificationFailedCount(1)
                .packagesNugetSymbolsCount(1)
                .packagesNugetSymbolsChecksumTotalCount(1)
                .packagesNugetSymbolsChecksummedCount(1)
                .packagesNugetSymbolsChecksumFailedCount(1)
                .packagesNugetSymbolsSyncedCount(1)
                .packagesNugetSymbolsFailedCount(1)
                .packagesNugetSymbolsRegistryCount(1)
                .packagesNugetSymbolsVerificationTotalCount(1)
                .packagesNugetSymbolsVerifiedCount(1)
                .packagesNugetSymbolsVerificationFailedCount(1)
                .terraformStateVersionsCount(1)
                .terraformStateVersionsChecksumTotalCount(1)
                .terraformStateVersionsChecksummedCount(1)
                .terraformStateVersionsChecksumFailedCount(1)
                .terraformStateVersionsSyncedCount(1)
                .terraformStateVersionsFailedCount(1)
                .terraformStateVersionsRegistryCount(1)
                .terraformStateVersionsVerificationTotalCount(1)
                .terraformStateVersionsVerifiedCount(1)
                .terraformStateVersionsVerificationFailedCount(1)
                .snippetRepositoriesCount(1)
                .snippetRepositoriesChecksumTotalCount(1)
                .snippetRepositoriesChecksummedCount(1)
                .snippetRepositoriesChecksumFailedCount(1)
                .snippetRepositoriesSyncedCount(1)
                .snippetRepositoriesFailedCount(1)
                .snippetRepositoriesRegistryCount(1)
                .snippetRepositoriesVerificationTotalCount(1)
                .snippetRepositoriesVerifiedCount(1)
                .snippetRepositoriesVerificationFailedCount(1)
                .groupWikiRepositoriesCount(1)
                .groupWikiRepositoriesChecksumTotalCount(1)
                .groupWikiRepositoriesChecksummedCount(1)
                .groupWikiRepositoriesChecksumFailedCount(1)
                .groupWikiRepositoriesSyncedCount(1)
                .groupWikiRepositoriesFailedCount(1)
                .groupWikiRepositoriesRegistryCount(1)
                .groupWikiRepositoriesVerificationTotalCount(1)
                .groupWikiRepositoriesVerifiedCount(1)
                .groupWikiRepositoriesVerificationFailedCount(1)
                .pipelineArtifactsCount(1)
                .pipelineArtifactsChecksumTotalCount(1)
                .pipelineArtifactsChecksummedCount(1)
                .pipelineArtifactsChecksumFailedCount(1)
                .pipelineArtifactsSyncedCount(1)
                .pipelineArtifactsFailedCount(1)
                .pipelineArtifactsRegistryCount(1)
                .pipelineArtifactsVerificationTotalCount(1)
                .pipelineArtifactsVerifiedCount(1)
                .pipelineArtifactsVerificationFailedCount(1)
                .pagesDeploymentsCount(1)
                .pagesDeploymentsChecksumTotalCount(1)
                .pagesDeploymentsChecksummedCount(1)
                .pagesDeploymentsChecksumFailedCount(1)
                .pagesDeploymentsSyncedCount(1)
                .pagesDeploymentsFailedCount(1)
                .pagesDeploymentsRegistryCount(1)
                .pagesDeploymentsVerificationTotalCount(1)
                .pagesDeploymentsVerifiedCount(1)
                .pagesDeploymentsVerificationFailedCount(1)
                .uploadsCount(1)
                .uploadsChecksumTotalCount(1)
                .uploadsChecksummedCount(1)
                .uploadsChecksumFailedCount(1)
                .uploadsSyncedCount(1)
                .uploadsFailedCount(1)
                .uploadsRegistryCount(1)
                .uploadsVerificationTotalCount(1)
                .uploadsVerifiedCount(1)
                .uploadsVerificationFailedCount(1)
                .jobArtifactsCount(1)
                .jobArtifactsChecksumTotalCount(1)
                .jobArtifactsChecksummedCount(1)
                .jobArtifactsChecksumFailedCount(1)
                .jobArtifactsSyncedCount(1)
                .jobArtifactsFailedCount(1)
                .jobArtifactsRegistryCount(1)
                .jobArtifactsVerificationTotalCount(1)
                .jobArtifactsVerifiedCount(1)
                .jobArtifactsVerificationFailedCount(1)
                .ciSecureFilesCount(1)
                .ciSecureFilesChecksumTotalCount(1)
                .ciSecureFilesChecksummedCount(1)
                .ciSecureFilesChecksumFailedCount(1)
                .ciSecureFilesSyncedCount(1)
                .ciSecureFilesFailedCount(1)
                .ciSecureFilesRegistryCount(1)
                .ciSecureFilesVerificationTotalCount(1)
                .ciSecureFilesVerifiedCount(1)
                .ciSecureFilesVerificationFailedCount(1)
                .containerRepositoriesCount(1)
                .containerRepositoriesChecksumTotalCount(1)
                .containerRepositoriesChecksummedCount(1)
                .containerRepositoriesChecksumFailedCount(1)
                .containerRepositoriesSyncedCount(1)
                .containerRepositoriesFailedCount(1)
                .containerRepositoriesRegistryCount(1)
                .containerRepositoriesVerificationTotalCount(1)
                .containerRepositoriesVerifiedCount(1)
                .containerRepositoriesVerificationFailedCount(1)
                .gitFetchEventCountWeekly(1)
                .gitPushEventCountWeekly(1)
                .proxyRemoteRequestsEventCountWeekly(1)
                .proxyLocalRequestsEventCountWeekly(1)
                .build();
    }

    public static GitLabGeoCreateStatusPayload geoCreateStatusPayload() {
        return GitLabGeoCreateStatusPayloadBuilder.builder()
                .data(GeoCatalogFixtures.geoCreateStatusData())
                .build();
    }

    public static GitLabGeoInfoRefsReceivePackData geoInfoRefsReceivePackData() {
        return GitLabGeoInfoRefsReceivePackDataBuilder.builder()
                .glId("gl_id")
                .primaryRepo("primary_repo")
                .build();
    }

    public static GitLabGeoInfoRefsReceivePackPayload geoInfoRefsReceivePackPayload() {
        return GitLabGeoInfoRefsReceivePackPayloadBuilder.builder()
                .secretToken("secret_token")
                .data(GeoCatalogFixtures.geoInfoRefsReceivePackData())
                .build();
    }

    public static GitLabGeoInfoRefsUploadPackData geoInfoRefsUploadPackData() {
        return GitLabGeoInfoRefsUploadPackDataBuilder.builder()
                .glId("gl_id")
                .primaryRepo("primary_repo")
                .build();
    }

    public static GitLabGeoInfoRefsUploadPackPayload geoInfoRefsUploadPackPayload() {
        return GitLabGeoInfoRefsUploadPackPayloadBuilder.builder()
                .secretToken("secret_token")
                .data(GeoCatalogFixtures.geoInfoRefsUploadPackData())
                .build();
    }

    public static GitLabGeoPipelineRefs geoPipelineRefs() {
        return GitLabGeoPipelineRefsBuilder.builder()
                .pipelineRefs(List.of("refs/pipelines/1"))
                .build();
    }

    public static GitLabGeoReceivePackData geoReceivePackData() {
        return GitLabGeoReceivePackDataBuilder.builder()
                .glId("gl_id")
                .primaryRepo("primary_repo")
                .build();
    }

    public static GitLabGeoReceivePackPayload geoReceivePackPayload() {
        return GitLabGeoReceivePackPayloadBuilder.builder()
                .secretToken("secret_token")
                .data(GeoCatalogFixtures.geoReceivePackData())
                .output("output")
                .build();
    }

    public static GitLabGeoUploadPackData geoUploadPackData() {
        return GitLabGeoUploadPackDataBuilder.builder()
                .glId("gl_id")
                .primaryRepo("primary_repo")
                .build();
    }

    public static GitLabGeoUploadPackPayload geoUploadPackPayload() {
        return GitLabGeoUploadPackPayloadBuilder.builder()
                .secretToken("secret_token")
                .data(GeoCatalogFixtures.geoUploadPackData())
                .output("output")
                .build();
    }
}
