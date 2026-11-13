package io.github.piotr_janczukowicz.gitlab.api.geo;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab geo create status data status of a GitLab resource.
 *
 * @param projectsCount the projects count
 * @param containerRepositoriesReplicationEnabled the container repositories replication enabled
 * @param lfsObjectsCount the lfs objects count
 * @param lfsObjectsChecksumTotalCount the lfs objects checksum total count
 * @param lfsObjectsChecksummedCount the lfs objects checksummed count
 * @param lfsObjectsChecksumFailedCount the lfs objects checksum failed count
 * @param lfsObjectsSyncedCount the lfs objects synced count
 * @param lfsObjectsFailedCount the lfs objects failed count
 * @param lfsObjectsRegistryCount the lfs objects registry count
 * @param lfsObjectsVerificationTotalCount the lfs objects verification total count
 * @param lfsObjectsVerifiedCount the lfs objects verified count
 * @param lfsObjectsVerificationFailedCount the lfs objects verification failed count
 * @param mergeRequestDiffsCount the merge request diffs count
 * @param mergeRequestDiffsChecksumTotalCount the merge request diffs checksum total count
 * @param mergeRequestDiffsChecksummedCount the merge request diffs checksummed count
 * @param mergeRequestDiffsChecksumFailedCount the merge request diffs checksum failed count
 * @param mergeRequestDiffsSyncedCount the merge request diffs synced count
 * @param mergeRequestDiffsFailedCount the merge request diffs failed count
 * @param mergeRequestDiffsRegistryCount the merge request diffs registry count
 * @param mergeRequestDiffsVerificationTotalCount the merge request diffs verification total count
 * @param mergeRequestDiffsVerifiedCount the merge request diffs verified count
 * @param mergeRequestDiffsVerificationFailedCount the merge request diffs verification failed count
 * @param packageFilesCount the package files count
 * @param packageFilesChecksumTotalCount the package files checksum total count
 * @param packageFilesChecksummedCount the package files checksummed count
 * @param packageFilesChecksumFailedCount the package files checksum failed count
 * @param packageFilesSyncedCount the package files synced count
 * @param packageFilesFailedCount the package files failed count
 * @param packageFilesRegistryCount the package files registry count
 * @param packageFilesVerificationTotalCount the package files verification total count
 * @param packageFilesVerifiedCount the package files verified count
 * @param packageFilesVerificationFailedCount the package files verification failed count
 * @param packagesNugetSymbolsCount the packages nuget symbols count
 * @param packagesNugetSymbolsChecksumTotalCount the packages nuget symbols checksum total count
 * @param packagesNugetSymbolsChecksummedCount the packages nuget symbols checksummed count
 * @param packagesNugetSymbolsChecksumFailedCount the packages nuget symbols checksum failed count
 * @param packagesNugetSymbolsSyncedCount the packages nuget symbols synced count
 * @param packagesNugetSymbolsFailedCount the packages nuget symbols failed count
 * @param packagesNugetSymbolsRegistryCount the packages nuget symbols registry count
 * @param packagesNugetSymbolsVerificationTotalCount the packages nuget symbols verification total count
 * @param packagesNugetSymbolsVerifiedCount the packages nuget symbols verified count
 * @param packagesNugetSymbolsVerificationFailedCount the packages nuget symbols verification failed count
 * @param terraformStateVersionsCount the terraform state versions count
 * @param terraformStateVersionsChecksumTotalCount the terraform state versions checksum total count
 * @param terraformStateVersionsChecksummedCount the terraform state versions checksummed count
 * @param terraformStateVersionsChecksumFailedCount the terraform state versions checksum failed count
 * @param terraformStateVersionsSyncedCount the terraform state versions synced count
 * @param terraformStateVersionsFailedCount the terraform state versions failed count
 * @param terraformStateVersionsRegistryCount the terraform state versions registry count
 * @param terraformStateVersionsVerificationTotalCount the terraform state versions verification total count
 * @param terraformStateVersionsVerifiedCount the terraform state versions verified count
 * @param terraformStateVersionsVerificationFailedCount the terraform state versions verification failed count
 * @param snippetRepositoriesCount the snippet repositories count
 * @param snippetRepositoriesChecksumTotalCount the snippet repositories checksum total count
 * @param snippetRepositoriesChecksummedCount the snippet repositories checksummed count
 * @param snippetRepositoriesChecksumFailedCount the snippet repositories checksum failed count
 * @param snippetRepositoriesSyncedCount the snippet repositories synced count
 * @param snippetRepositoriesFailedCount the snippet repositories failed count
 * @param snippetRepositoriesRegistryCount the snippet repositories registry count
 * @param snippetRepositoriesVerificationTotalCount the snippet repositories verification total count
 * @param snippetRepositoriesVerifiedCount the snippet repositories verified count
 * @param snippetRepositoriesVerificationFailedCount the snippet repositories verification failed count
 * @param groupWikiRepositoriesCount the group wiki repositories count
 * @param groupWikiRepositoriesChecksumTotalCount the group wiki repositories checksum total count
 * @param groupWikiRepositoriesChecksummedCount the group wiki repositories checksummed count
 * @param groupWikiRepositoriesChecksumFailedCount the group wiki repositories checksum failed count
 * @param groupWikiRepositoriesSyncedCount the group wiki repositories synced count
 * @param groupWikiRepositoriesFailedCount the group wiki repositories failed count
 * @param groupWikiRepositoriesRegistryCount the group wiki repositories registry count
 * @param groupWikiRepositoriesVerificationTotalCount the group wiki repositories verification total count
 * @param groupWikiRepositoriesVerifiedCount the group wiki repositories verified count
 * @param groupWikiRepositoriesVerificationFailedCount the group wiki repositories verification failed count
 * @param pipelineArtifactsCount the pipeline artifacts count
 * @param pipelineArtifactsChecksumTotalCount the pipeline artifacts checksum total count
 * @param pipelineArtifactsChecksummedCount the pipeline artifacts checksummed count
 * @param pipelineArtifactsChecksumFailedCount the pipeline artifacts checksum failed count
 * @param pipelineArtifactsSyncedCount the pipeline artifacts synced count
 * @param pipelineArtifactsFailedCount the pipeline artifacts failed count
 * @param pipelineArtifactsRegistryCount the pipeline artifacts registry count
 * @param pipelineArtifactsVerificationTotalCount the pipeline artifacts verification total count
 * @param pipelineArtifactsVerifiedCount the pipeline artifacts verified count
 * @param pipelineArtifactsVerificationFailedCount the pipeline artifacts verification failed count
 * @param pagesDeploymentsCount the pages deployments count
 * @param pagesDeploymentsChecksumTotalCount the pages deployments checksum total count
 * @param pagesDeploymentsChecksummedCount the pages deployments checksummed count
 * @param pagesDeploymentsChecksumFailedCount the pages deployments checksum failed count
 * @param pagesDeploymentsSyncedCount the pages deployments synced count
 * @param pagesDeploymentsFailedCount the pages deployments failed count
 * @param pagesDeploymentsRegistryCount the pages deployments registry count
 * @param pagesDeploymentsVerificationTotalCount the pages deployments verification total count
 * @param pagesDeploymentsVerifiedCount the pages deployments verified count
 * @param pagesDeploymentsVerificationFailedCount the pages deployments verification failed count
 * @param uploadsCount the uploads count
 * @param uploadsChecksumTotalCount the uploads checksum total count
 * @param uploadsChecksummedCount the uploads checksummed count
 * @param uploadsChecksumFailedCount the uploads checksum failed count
 * @param uploadsSyncedCount the uploads synced count
 * @param uploadsFailedCount the uploads failed count
 * @param uploadsRegistryCount the uploads registry count
 * @param uploadsVerificationTotalCount the uploads verification total count
 * @param uploadsVerifiedCount the uploads verified count
 * @param uploadsVerificationFailedCount the uploads verification failed count
 * @param jobArtifactsCount the job artifacts count
 * @param jobArtifactsChecksumTotalCount the job artifacts checksum total count
 * @param jobArtifactsChecksummedCount the job artifacts checksummed count
 * @param jobArtifactsChecksumFailedCount the job artifacts checksum failed count
 * @param jobArtifactsSyncedCount the job artifacts synced count
 * @param jobArtifactsFailedCount the job artifacts failed count
 * @param jobArtifactsRegistryCount the job artifacts registry count
 * @param jobArtifactsVerificationTotalCount the job artifacts verification total count
 * @param jobArtifactsVerifiedCount the job artifacts verified count
 * @param jobArtifactsVerificationFailedCount the job artifacts verification failed count
 * @param ciSecureFilesCount the ci secure files count
 * @param ciSecureFilesChecksumTotalCount the ci secure files checksum total count
 * @param ciSecureFilesChecksummedCount the ci secure files checksummed count
 * @param ciSecureFilesChecksumFailedCount the ci secure files checksum failed count
 * @param ciSecureFilesSyncedCount the ci secure files synced count
 * @param ciSecureFilesFailedCount the ci secure files failed count
 * @param ciSecureFilesRegistryCount the ci secure files registry count
 * @param ciSecureFilesVerificationTotalCount the ci secure files verification total count
 * @param ciSecureFilesVerifiedCount the ci secure files verified count
 * @param ciSecureFilesVerificationFailedCount the ci secure files verification failed count
 * @param containerRepositoriesCount the container repositories count
 * @param containerRepositoriesChecksumTotalCount the container repositories checksum total count
 * @param containerRepositoriesChecksummedCount the container repositories checksummed count
 * @param containerRepositoriesChecksumFailedCount the container repositories checksum failed count
 * @param containerRepositoriesSyncedCount the container repositories synced count
 * @param containerRepositoriesFailedCount the container repositories failed count
 * @param containerRepositoriesRegistryCount the container repositories registry count
 * @param containerRepositoriesVerificationTotalCount the container repositories verification total count
 * @param containerRepositoriesVerifiedCount the container repositories verified count
 * @param containerRepositoriesVerificationFailedCount the container repositories verification failed count
 * @param gitFetchEventCountWeekly the git fetch event count weekly
 * @param gitPushEventCountWeekly the git push event count weekly
 * @param proxyRemoteRequestsEventCountWeekly the proxy remote requests event count weekly
 * @param proxyLocalRequestsEventCountWeekly the proxy local requests event count weekly
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GeoStatus/requestBody/properties/data/properties/status")
public record GitLabGeoCreateStatusDataStatus(
        @Nullable Integer projectsCount,
        @Nullable Boolean containerRepositoriesReplicationEnabled,
        @Nullable Integer lfsObjectsCount,
        @Nullable Integer lfsObjectsChecksumTotalCount,
        @Nullable Integer lfsObjectsChecksummedCount,
        @Nullable Integer lfsObjectsChecksumFailedCount,
        @Nullable Integer lfsObjectsSyncedCount,
        @Nullable Integer lfsObjectsFailedCount,
        @Nullable Integer lfsObjectsRegistryCount,
        @Nullable Integer lfsObjectsVerificationTotalCount,
        @Nullable Integer lfsObjectsVerifiedCount,
        @Nullable Integer lfsObjectsVerificationFailedCount,
        @Nullable Integer mergeRequestDiffsCount,
        @Nullable Integer mergeRequestDiffsChecksumTotalCount,
        @Nullable Integer mergeRequestDiffsChecksummedCount,
        @Nullable Integer mergeRequestDiffsChecksumFailedCount,
        @Nullable Integer mergeRequestDiffsSyncedCount,
        @Nullable Integer mergeRequestDiffsFailedCount,
        @Nullable Integer mergeRequestDiffsRegistryCount,
        @Nullable Integer mergeRequestDiffsVerificationTotalCount,
        @Nullable Integer mergeRequestDiffsVerifiedCount,
        @Nullable Integer mergeRequestDiffsVerificationFailedCount,
        @Nullable Integer packageFilesCount,
        @Nullable Integer packageFilesChecksumTotalCount,
        @Nullable Integer packageFilesChecksummedCount,
        @Nullable Integer packageFilesChecksumFailedCount,
        @Nullable Integer packageFilesSyncedCount,
        @Nullable Integer packageFilesFailedCount,
        @Nullable Integer packageFilesRegistryCount,
        @Nullable Integer packageFilesVerificationTotalCount,
        @Nullable Integer packageFilesVerifiedCount,
        @Nullable Integer packageFilesVerificationFailedCount,
        @Nullable Integer packagesNugetSymbolsCount,
        @Nullable Integer packagesNugetSymbolsChecksumTotalCount,
        @Nullable Integer packagesNugetSymbolsChecksummedCount,
        @Nullable Integer packagesNugetSymbolsChecksumFailedCount,
        @Nullable Integer packagesNugetSymbolsSyncedCount,
        @Nullable Integer packagesNugetSymbolsFailedCount,
        @Nullable Integer packagesNugetSymbolsRegistryCount,
        @Nullable Integer packagesNugetSymbolsVerificationTotalCount,
        @Nullable Integer packagesNugetSymbolsVerifiedCount,
        @Nullable Integer packagesNugetSymbolsVerificationFailedCount,
        @Nullable Integer terraformStateVersionsCount,
        @Nullable Integer terraformStateVersionsChecksumTotalCount,
        @Nullable Integer terraformStateVersionsChecksummedCount,
        @Nullable Integer terraformStateVersionsChecksumFailedCount,
        @Nullable Integer terraformStateVersionsSyncedCount,
        @Nullable Integer terraformStateVersionsFailedCount,
        @Nullable Integer terraformStateVersionsRegistryCount,
        @Nullable Integer terraformStateVersionsVerificationTotalCount,
        @Nullable Integer terraformStateVersionsVerifiedCount,
        @Nullable Integer terraformStateVersionsVerificationFailedCount,
        @Nullable Integer snippetRepositoriesCount,
        @Nullable Integer snippetRepositoriesChecksumTotalCount,
        @Nullable Integer snippetRepositoriesChecksummedCount,
        @Nullable Integer snippetRepositoriesChecksumFailedCount,
        @Nullable Integer snippetRepositoriesSyncedCount,
        @Nullable Integer snippetRepositoriesFailedCount,
        @Nullable Integer snippetRepositoriesRegistryCount,
        @Nullable Integer snippetRepositoriesVerificationTotalCount,
        @Nullable Integer snippetRepositoriesVerifiedCount,
        @Nullable Integer snippetRepositoriesVerificationFailedCount,
        @Nullable Integer groupWikiRepositoriesCount,
        @Nullable Integer groupWikiRepositoriesChecksumTotalCount,
        @Nullable Integer groupWikiRepositoriesChecksummedCount,
        @Nullable Integer groupWikiRepositoriesChecksumFailedCount,
        @Nullable Integer groupWikiRepositoriesSyncedCount,
        @Nullable Integer groupWikiRepositoriesFailedCount,
        @Nullable Integer groupWikiRepositoriesRegistryCount,
        @Nullable Integer groupWikiRepositoriesVerificationTotalCount,
        @Nullable Integer groupWikiRepositoriesVerifiedCount,
        @Nullable Integer groupWikiRepositoriesVerificationFailedCount,
        @Nullable Integer pipelineArtifactsCount,
        @Nullable Integer pipelineArtifactsChecksumTotalCount,
        @Nullable Integer pipelineArtifactsChecksummedCount,
        @Nullable Integer pipelineArtifactsChecksumFailedCount,
        @Nullable Integer pipelineArtifactsSyncedCount,
        @Nullable Integer pipelineArtifactsFailedCount,
        @Nullable Integer pipelineArtifactsRegistryCount,
        @Nullable Integer pipelineArtifactsVerificationTotalCount,
        @Nullable Integer pipelineArtifactsVerifiedCount,
        @Nullable Integer pipelineArtifactsVerificationFailedCount,
        @Nullable Integer pagesDeploymentsCount,
        @Nullable Integer pagesDeploymentsChecksumTotalCount,
        @Nullable Integer pagesDeploymentsChecksummedCount,
        @Nullable Integer pagesDeploymentsChecksumFailedCount,
        @Nullable Integer pagesDeploymentsSyncedCount,
        @Nullable Integer pagesDeploymentsFailedCount,
        @Nullable Integer pagesDeploymentsRegistryCount,
        @Nullable Integer pagesDeploymentsVerificationTotalCount,
        @Nullable Integer pagesDeploymentsVerifiedCount,
        @Nullable Integer pagesDeploymentsVerificationFailedCount,
        @Nullable Integer uploadsCount,
        @Nullable Integer uploadsChecksumTotalCount,
        @Nullable Integer uploadsChecksummedCount,
        @Nullable Integer uploadsChecksumFailedCount,
        @Nullable Integer uploadsSyncedCount,
        @Nullable Integer uploadsFailedCount,
        @Nullable Integer uploadsRegistryCount,
        @Nullable Integer uploadsVerificationTotalCount,
        @Nullable Integer uploadsVerifiedCount,
        @Nullable Integer uploadsVerificationFailedCount,
        @Nullable Integer jobArtifactsCount,
        @Nullable Integer jobArtifactsChecksumTotalCount,
        @Nullable Integer jobArtifactsChecksummedCount,
        @Nullable Integer jobArtifactsChecksumFailedCount,
        @Nullable Integer jobArtifactsSyncedCount,
        @Nullable Integer jobArtifactsFailedCount,
        @Nullable Integer jobArtifactsRegistryCount,
        @Nullable Integer jobArtifactsVerificationTotalCount,
        @Nullable Integer jobArtifactsVerifiedCount,
        @Nullable Integer jobArtifactsVerificationFailedCount,
        @Nullable Integer ciSecureFilesCount,
        @Nullable Integer ciSecureFilesChecksumTotalCount,
        @Nullable Integer ciSecureFilesChecksummedCount,
        @Nullable Integer ciSecureFilesChecksumFailedCount,
        @Nullable Integer ciSecureFilesSyncedCount,
        @Nullable Integer ciSecureFilesFailedCount,
        @Nullable Integer ciSecureFilesRegistryCount,
        @Nullable Integer ciSecureFilesVerificationTotalCount,
        @Nullable Integer ciSecureFilesVerifiedCount,
        @Nullable Integer ciSecureFilesVerificationFailedCount,
        @Nullable Integer containerRepositoriesCount,
        @Nullable Integer containerRepositoriesChecksumTotalCount,
        @Nullable Integer containerRepositoriesChecksummedCount,
        @Nullable Integer containerRepositoriesChecksumFailedCount,
        @Nullable Integer containerRepositoriesSyncedCount,
        @Nullable Integer containerRepositoriesFailedCount,
        @Nullable Integer containerRepositoriesRegistryCount,
        @Nullable Integer containerRepositoriesVerificationTotalCount,
        @Nullable Integer containerRepositoriesVerifiedCount,
        @Nullable Integer containerRepositoriesVerificationFailedCount,
        @Nullable Integer gitFetchEventCountWeekly,
        @Nullable Integer gitPushEventCountWeekly,
        @Nullable Integer proxyRemoteRequestsEventCountWeekly,
        @Nullable Integer proxyLocalRequestsEventCountWeekly) {}
