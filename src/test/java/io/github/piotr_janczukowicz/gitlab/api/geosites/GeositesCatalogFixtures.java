package io.github.piotr_janczukowicz.gitlab.api.geosites;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class GeositesCatalogFixtures {

    private GeositesCatalogFixtures() {}

    public static GitLabGeoSite geoSite() {
        return GitLabGeoSiteBuilder.builder()
                .id(1L)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .primary(true)
                .enabled(true)
                .current(true)
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .blobDownloadTimeout(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .syncObjectStorage(true)
                .webEditUrl("web_edit_url")
                .webGeoReplicationDetailsUrl("web_geo_replication_details_url")
                .links(GeositesCatalogFixtures.geoSiteLinks())
                .build();
    }

    public static GitLabGeoSiteLinks geoSiteLinks() {
        return GitLabGeoSiteLinksBuilder.builder()
                .self("self")
                .status("status")
                .repair("repair")
                .build();
    }

    public static GitLabGeoSiteStatus geoSiteStatus() {
        return GitLabGeoSiteStatusBuilder.builder()
                .container(GeositesCatalogFixtures.geoSiteStatusContainer())
                .abuse(GeositesCatalogFixtures.geoSiteStatusAbuse())
                .achievement(GeositesCatalogFixtures.geoSiteStatusAchievement())
                .alert(GeositesCatalogFixtures.geoSiteStatusAlert())
                .appearance(GeositesCatalogFixtures.geoSiteStatusAppearance())
                .bulk(GeositesCatalogFixtures.geoSiteStatusBulk())
                .ci(GeositesCatalogFixtures.geoSiteStatusCi())
                .dependency(GeositesCatalogFixtures.geoSiteStatusDependency())
                .design(GeositesCatalogFixtures.geoSiteStatusDesign())
                .group(GeositesCatalogFixtures.geoSiteStatusGroup())
                .importValue(GeositesCatalogFixtures.geoSiteStatusImport())
                .issuable(GeositesCatalogFixtures.geoSiteStatusIssuable())
                .job(GeositesCatalogFixtures.geoSiteStatusJob())
                .lfs(GeositesCatalogFixtures.geoSiteStatusLfs())
                .merge(GeositesCatalogFixtures.geoSiteStatusMerge())
                .organization(GeositesCatalogFixtures.geoSiteStatusOrganization())
                .packageValue(GeositesCatalogFixtures.geoSiteStatusPackage())
                .packages(GeositesCatalogFixtures.geoSiteStatusPackages())
                .pages(GeositesCatalogFixtures.geoSiteStatusPages())
                .personal(GeositesCatalogFixtures.geoSiteStatusPersonal())
                .pipeline(GeositesCatalogFixtures.geoSiteStatusPipeline())
                .project(GeositesCatalogFixtures.geoSiteStatusProject())
                .snippet(GeositesCatalogFixtures.geoSiteStatusSnippet())
                .supply(GeositesCatalogFixtures.geoSiteStatusSupply())
                .terraform(GeositesCatalogFixtures.geoSiteStatusTerraform())
                .uploads(GeositesCatalogFixtures.geoSiteStatusUploads())
                .user(GeositesCatalogFixtures.geoSiteStatusUser())
                .vulnerability(GeositesCatalogFixtures.geoSiteStatusVulnerability())
                .ai(GeositesCatalogFixtures.geoSiteStatusAi())
                .other(GeositesCatalogFixtures.geoSiteStatusOther())
                .build();
    }

    public static GitLabGeoSiteStatusAbuse geoSiteStatusAbuse() {
        return GitLabGeoSiteStatusAbuseBuilder.builder()
                .abuseReportUploadsCount("abuse_report_uploads_count")
                .abuseReportUploadsChecksumTotalCount("abuse_report_uploads_checksum_total_count")
                .abuseReportUploadsChecksummedCount("abuse_report_uploads_checksummed_count")
                .abuseReportUploadsChecksumFailedCount("abuse_report_uploads_checksum_failed_count")
                .abuseReportUploadsSyncedCount("abuse_report_uploads_synced_count")
                .abuseReportUploadsFailedCount("abuse_report_uploads_failed_count")
                .abuseReportUploadsRegistryCount("abuse_report_uploads_registry_count")
                .abuseReportUploadsVerificationTotalCount("abuse_report_uploads_verification_total_count")
                .abuseReportUploadsVerifiedCount("abuse_report_uploads_verified_count")
                .abuseReportUploadsVerificationFailedCount("abuse_report_uploads_verification_failed_count")
                .abuseReportUploadsOldestUnsyncedTime("abuse_report_uploads_oldest_unsynced_time")
                .abuseReportUploadsSyncedInPercentage("abuse_report_uploads_synced_in_percentage")
                .abuseReportUploadsVerifiedInPercentage("abuse_report_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusAchievement geoSiteStatusAchievement() {
        return GitLabGeoSiteStatusAchievementBuilder.builder()
                .achievementUploadsCount("achievement_uploads_count")
                .achievementUploadsChecksumTotalCount("achievement_uploads_checksum_total_count")
                .achievementUploadsChecksummedCount("achievement_uploads_checksummed_count")
                .achievementUploadsChecksumFailedCount("achievement_uploads_checksum_failed_count")
                .achievementUploadsSyncedCount("achievement_uploads_synced_count")
                .achievementUploadsFailedCount("achievement_uploads_failed_count")
                .achievementUploadsRegistryCount("achievement_uploads_registry_count")
                .achievementUploadsVerificationTotalCount("achievement_uploads_verification_total_count")
                .achievementUploadsVerifiedCount("achievement_uploads_verified_count")
                .achievementUploadsVerificationFailedCount("achievement_uploads_verification_failed_count")
                .achievementUploadsOldestUnsyncedTime("achievement_uploads_oldest_unsynced_time")
                .achievementUploadsSyncedInPercentage("achievement_uploads_synced_in_percentage")
                .achievementUploadsVerifiedInPercentage("achievement_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusAi geoSiteStatusAi() {
        return GitLabGeoSiteStatusAiBuilder.builder()
                .aiVectorizableFileUploadsCount(1)
                .aiVectorizableFileUploadsChecksumTotalCount(1)
                .aiVectorizableFileUploadsChecksummedCount(1)
                .aiVectorizableFileUploadsChecksumFailedCount(1)
                .aiVectorizableFileUploadsSyncedCount(1)
                .aiVectorizableFileUploadsFailedCount(1)
                .aiVectorizableFileUploadsRegistryCount(1)
                .aiVectorizableFileUploadsVerificationTotalCount(1)
                .aiVectorizableFileUploadsVerifiedCount(1)
                .aiVectorizableFileUploadsVerificationFailedCount(1)
                .aiVectorizableFileUploadsOldestUnsyncedTime(1)
                .aiVectorizableFileUploadsSyncedInPercentage("0.00%")
                .aiVectorizableFileUploadsVerifiedInPercentage("0.00%")
                .build();
    }

    public static GitLabGeoSiteStatusAlert geoSiteStatusAlert() {
        return GitLabGeoSiteStatusAlertBuilder.builder()
                .alertManagementMetricImageUploadsCount("alert_management_metric_image_uploads_count")
                .alertManagementMetricImageUploadsChecksumTotalCount(
                        "alert_management_metric_image_uploads_checksum_total_count")
                .alertManagementMetricImageUploadsChecksummedCount(
                        "alert_management_metric_image_uploads_checksummed_count")
                .alertManagementMetricImageUploadsChecksumFailedCount(
                        "alert_management_metric_image_uploads_checksum_failed_count")
                .alertManagementMetricImageUploadsSyncedCount("alert_management_metric_image_uploads_synced_count")
                .alertManagementMetricImageUploadsFailedCount("alert_management_metric_image_uploads_failed_count")
                .alertManagementMetricImageUploadsRegistryCount("alert_management_metric_image_uploads_registry_count")
                .alertManagementMetricImageUploadsVerificationTotalCount(
                        "alert_management_metric_image_uploads_verification_total_count")
                .alertManagementMetricImageUploadsVerifiedCount("alert_management_metric_image_uploads_verified_count")
                .alertManagementMetricImageUploadsVerificationFailedCount(
                        "alert_management_metric_image_uploads_verification_failed_count")
                .alertManagementMetricImageUploadsOldestUnsyncedTime(
                        "alert_management_metric_image_uploads_oldest_unsynced_time")
                .alertManagementMetricImageUploadsSyncedInPercentage(
                        "alert_management_metric_image_uploads_synced_in_percentage")
                .alertManagementMetricImageUploadsVerifiedInPercentage(
                        "alert_management_metric_image_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusAppearance geoSiteStatusAppearance() {
        return GitLabGeoSiteStatusAppearanceBuilder.builder()
                .appearanceUploadsCount("appearance_uploads_count")
                .appearanceUploadsChecksumTotalCount("appearance_uploads_checksum_total_count")
                .appearanceUploadsChecksummedCount("appearance_uploads_checksummed_count")
                .appearanceUploadsChecksumFailedCount("appearance_uploads_checksum_failed_count")
                .appearanceUploadsSyncedCount("appearance_uploads_synced_count")
                .appearanceUploadsFailedCount("appearance_uploads_failed_count")
                .appearanceUploadsRegistryCount("appearance_uploads_registry_count")
                .appearanceUploadsVerificationTotalCount("appearance_uploads_verification_total_count")
                .appearanceUploadsVerifiedCount("appearance_uploads_verified_count")
                .appearanceUploadsVerificationFailedCount("appearance_uploads_verification_failed_count")
                .appearanceUploadsOldestUnsyncedTime("appearance_uploads_oldest_unsynced_time")
                .appearanceUploadsSyncedInPercentage("appearance_uploads_synced_in_percentage")
                .appearanceUploadsVerifiedInPercentage("appearance_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusBulk geoSiteStatusBulk() {
        return GitLabGeoSiteStatusBulkBuilder.builder()
                .bulkImportExportUploadUploadsCount("bulk_import_export_upload_uploads_count")
                .bulkImportExportUploadUploadsChecksumTotalCount(
                        "bulk_import_export_upload_uploads_checksum_total_count")
                .bulkImportExportUploadUploadsChecksummedCount("bulk_import_export_upload_uploads_checksummed_count")
                .bulkImportExportUploadUploadsChecksumFailedCount(
                        "bulk_import_export_upload_uploads_checksum_failed_count")
                .bulkImportExportUploadUploadsSyncedCount("bulk_import_export_upload_uploads_synced_count")
                .bulkImportExportUploadUploadsFailedCount("bulk_import_export_upload_uploads_failed_count")
                .bulkImportExportUploadUploadsRegistryCount("bulk_import_export_upload_uploads_registry_count")
                .bulkImportExportUploadUploadsVerificationTotalCount(
                        "bulk_import_export_upload_uploads_verification_total_count")
                .bulkImportExportUploadUploadsVerifiedCount("bulk_import_export_upload_uploads_verified_count")
                .bulkImportExportUploadUploadsVerificationFailedCount(
                        "bulk_import_export_upload_uploads_verification_failed_count")
                .bulkImportExportUploadUploadsOldestUnsyncedTime(
                        "bulk_import_export_upload_uploads_oldest_unsynced_time")
                .bulkImportExportUploadUploadsSyncedInPercentage(
                        "bulk_import_export_upload_uploads_synced_in_percentage")
                .bulkImportExportUploadUploadsVerifiedInPercentage(
                        "bulk_import_export_upload_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusCi geoSiteStatusCi() {
        return GitLabGeoSiteStatusCiBuilder.builder()
                .ciSecureFilesCount("ci_secure_files_count")
                .ciSecureFilesChecksumTotalCount("ci_secure_files_checksum_total_count")
                .ciSecureFilesChecksummedCount("ci_secure_files_checksummed_count")
                .ciSecureFilesChecksumFailedCount("ci_secure_files_checksum_failed_count")
                .ciSecureFilesSyncedCount("ci_secure_files_synced_count")
                .ciSecureFilesFailedCount("ci_secure_files_failed_count")
                .ciSecureFilesRegistryCount("ci_secure_files_registry_count")
                .ciSecureFilesVerificationTotalCount("ci_secure_files_verification_total_count")
                .ciSecureFilesVerifiedCount("ci_secure_files_verified_count")
                .ciSecureFilesVerificationFailedCount("ci_secure_files_verification_failed_count")
                .ciSecureFilesOldestUnsyncedTime("ci_secure_files_oldest_unsynced_time")
                .ciSecureFilesSyncedInPercentage("ci_secure_files_synced_in_percentage")
                .ciSecureFilesVerifiedInPercentage("ci_secure_files_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusContainer geoSiteStatusContainer() {
        return GitLabGeoSiteStatusContainerBuilder.builder()
                .containerRepositoriesReplicationEnabled("container_repositories_replication_enabled")
                .containerRepositoriesCount("container_repositories_count")
                .containerRepositoriesChecksumTotalCount("container_repositories_checksum_total_count")
                .containerRepositoriesChecksummedCount("container_repositories_checksummed_count")
                .containerRepositoriesChecksumFailedCount("container_repositories_checksum_failed_count")
                .containerRepositoriesSyncedCount("container_repositories_synced_count")
                .containerRepositoriesFailedCount("container_repositories_failed_count")
                .containerRepositoriesRegistryCount("container_repositories_registry_count")
                .containerRepositoriesVerificationTotalCount("container_repositories_verification_total_count")
                .containerRepositoriesVerifiedCount("container_repositories_verified_count")
                .containerRepositoriesVerificationFailedCount("container_repositories_verification_failed_count")
                .containerRepositoriesOldestUnsyncedTime("container_repositories_oldest_unsynced_time")
                .containerRepositoriesSyncedInPercentage("container_repositories_synced_in_percentage")
                .containerRepositoriesVerifiedInPercentage("container_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusDependency geoSiteStatusDependency() {
        return GitLabGeoSiteStatusDependencyBuilder.builder()
                .dependencyListExportPartUploadsCount("dependency_list_export_part_uploads_count")
                .dependencyListExportPartUploadsChecksumTotalCount(
                        "dependency_list_export_part_uploads_checksum_total_count")
                .dependencyListExportPartUploadsChecksummedCount(
                        "dependency_list_export_part_uploads_checksummed_count")
                .dependencyListExportPartUploadsChecksumFailedCount(
                        "dependency_list_export_part_uploads_checksum_failed_count")
                .dependencyListExportPartUploadsSyncedCount("dependency_list_export_part_uploads_synced_count")
                .dependencyListExportPartUploadsFailedCount("dependency_list_export_part_uploads_failed_count")
                .dependencyListExportPartUploadsRegistryCount("dependency_list_export_part_uploads_registry_count")
                .dependencyListExportPartUploadsVerificationTotalCount(
                        "dependency_list_export_part_uploads_verification_total_count")
                .dependencyListExportPartUploadsVerifiedCount("dependency_list_export_part_uploads_verified_count")
                .dependencyListExportPartUploadsVerificationFailedCount(
                        "dependency_list_export_part_uploads_verification_failed_count")
                .dependencyListExportPartUploadsOldestUnsyncedTime(
                        "dependency_list_export_part_uploads_oldest_unsynced_time")
                .dependencyListExportUploadsCount("dependency_list_export_uploads_count")
                .dependencyListExportUploadsChecksumTotalCount("dependency_list_export_uploads_checksum_total_count")
                .dependencyListExportUploadsChecksummedCount("dependency_list_export_uploads_checksummed_count")
                .dependencyListExportUploadsChecksumFailedCount("dependency_list_export_uploads_checksum_failed_count")
                .dependencyListExportUploadsSyncedCount("dependency_list_export_uploads_synced_count")
                .dependencyListExportUploadsFailedCount("dependency_list_export_uploads_failed_count")
                .dependencyListExportUploadsRegistryCount("dependency_list_export_uploads_registry_count")
                .dependencyListExportUploadsVerificationTotalCount(
                        "dependency_list_export_uploads_verification_total_count")
                .dependencyListExportUploadsVerifiedCount("dependency_list_export_uploads_verified_count")
                .dependencyListExportUploadsVerificationFailedCount(
                        "dependency_list_export_uploads_verification_failed_count")
                .dependencyListExportUploadsOldestUnsyncedTime("dependency_list_export_uploads_oldest_unsynced_time")
                .dependencyProxyBlobsCount("dependency_proxy_blobs_count")
                .dependencyProxyBlobsChecksumTotalCount("dependency_proxy_blobs_checksum_total_count")
                .dependencyProxyBlobsChecksummedCount("dependency_proxy_blobs_checksummed_count")
                .dependencyProxyBlobsChecksumFailedCount("dependency_proxy_blobs_checksum_failed_count")
                .dependencyProxyBlobsSyncedCount("dependency_proxy_blobs_synced_count")
                .dependencyProxyBlobsFailedCount("dependency_proxy_blobs_failed_count")
                .dependencyProxyBlobsRegistryCount("dependency_proxy_blobs_registry_count")
                .dependencyProxyBlobsVerificationTotalCount("dependency_proxy_blobs_verification_total_count")
                .dependencyProxyBlobsVerifiedCount("dependency_proxy_blobs_verified_count")
                .dependencyProxyBlobsVerificationFailedCount("dependency_proxy_blobs_verification_failed_count")
                .dependencyProxyBlobsOldestUnsyncedTime("dependency_proxy_blobs_oldest_unsynced_time")
                .dependencyProxyManifestsCount("dependency_proxy_manifests_count")
                .dependencyProxyManifestsChecksumTotalCount("dependency_proxy_manifests_checksum_total_count")
                .dependencyProxyManifestsChecksummedCount("dependency_proxy_manifests_checksummed_count")
                .dependencyProxyManifestsChecksumFailedCount("dependency_proxy_manifests_checksum_failed_count")
                .dependencyProxyManifestsSyncedCount("dependency_proxy_manifests_synced_count")
                .dependencyProxyManifestsFailedCount("dependency_proxy_manifests_failed_count")
                .dependencyProxyManifestsRegistryCount("dependency_proxy_manifests_registry_count")
                .dependencyProxyManifestsVerificationTotalCount("dependency_proxy_manifests_verification_total_count")
                .dependencyProxyManifestsVerifiedCount("dependency_proxy_manifests_verified_count")
                .dependencyProxyManifestsVerificationFailedCount("dependency_proxy_manifests_verification_failed_count")
                .dependencyProxyManifestsOldestUnsyncedTime("dependency_proxy_manifests_oldest_unsynced_time")
                .dependencyListExportPartUploadsSyncedInPercentage(
                        "dependency_list_export_part_uploads_synced_in_percentage")
                .dependencyListExportPartUploadsVerifiedInPercentage(
                        "dependency_list_export_part_uploads_verified_in_percentage")
                .dependencyListExportUploadsSyncedInPercentage("dependency_list_export_uploads_synced_in_percentage")
                .dependencyListExportUploadsVerifiedInPercentage(
                        "dependency_list_export_uploads_verified_in_percentage")
                .dependencyProxyBlobsSyncedInPercentage("dependency_proxy_blobs_synced_in_percentage")
                .dependencyProxyBlobsVerifiedInPercentage("dependency_proxy_blobs_verified_in_percentage")
                .dependencyProxyManifestsSyncedInPercentage("dependency_proxy_manifests_synced_in_percentage")
                .dependencyProxyManifestsVerifiedInPercentage("dependency_proxy_manifests_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusDesign geoSiteStatusDesign() {
        return GitLabGeoSiteStatusDesignBuilder.builder()
                .designManagementActionUploadsCount("design_management_action_uploads_count")
                .designManagementActionUploadsChecksumTotalCount(
                        "design_management_action_uploads_checksum_total_count")
                .designManagementActionUploadsChecksummedCount("design_management_action_uploads_checksummed_count")
                .designManagementActionUploadsChecksumFailedCount(
                        "design_management_action_uploads_checksum_failed_count")
                .designManagementActionUploadsSyncedCount("design_management_action_uploads_synced_count")
                .designManagementActionUploadsFailedCount("design_management_action_uploads_failed_count")
                .designManagementActionUploadsRegistryCount("design_management_action_uploads_registry_count")
                .designManagementActionUploadsVerificationTotalCount(
                        "design_management_action_uploads_verification_total_count")
                .designManagementActionUploadsVerifiedCount("design_management_action_uploads_verified_count")
                .designManagementActionUploadsVerificationFailedCount(
                        "design_management_action_uploads_verification_failed_count")
                .designManagementActionUploadsOldestUnsyncedTime(
                        "design_management_action_uploads_oldest_unsynced_time")
                .designManagementRepositoriesCount("design_management_repositories_count")
                .designManagementRepositoriesChecksumTotalCount("design_management_repositories_checksum_total_count")
                .designManagementRepositoriesChecksummedCount("design_management_repositories_checksummed_count")
                .designManagementRepositoriesChecksumFailedCount("design_management_repositories_checksum_failed_count")
                .designManagementRepositoriesSyncedCount("design_management_repositories_synced_count")
                .designManagementRepositoriesFailedCount("design_management_repositories_failed_count")
                .designManagementRepositoriesRegistryCount("design_management_repositories_registry_count")
                .designManagementRepositoriesVerificationTotalCount(
                        "design_management_repositories_verification_total_count")
                .designManagementRepositoriesVerifiedCount("design_management_repositories_verified_count")
                .designManagementRepositoriesVerificationFailedCount(
                        "design_management_repositories_verification_failed_count")
                .designManagementRepositoriesOldestUnsyncedTime("design_management_repositories_oldest_unsynced_time")
                .designManagementActionUploadsSyncedInPercentage(
                        "design_management_action_uploads_synced_in_percentage")
                .designManagementActionUploadsVerifiedInPercentage(
                        "design_management_action_uploads_verified_in_percentage")
                .designManagementRepositoriesSyncedInPercentage("design_management_repositories_synced_in_percentage")
                .designManagementRepositoriesVerifiedInPercentage(
                        "design_management_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusGroup geoSiteStatusGroup() {
        return GitLabGeoSiteStatusGroupBuilder.builder()
                .groupUploadsCount("group_uploads_count")
                .groupUploadsChecksumTotalCount("group_uploads_checksum_total_count")
                .groupUploadsChecksummedCount("group_uploads_checksummed_count")
                .groupUploadsChecksumFailedCount("group_uploads_checksum_failed_count")
                .groupUploadsSyncedCount("group_uploads_synced_count")
                .groupUploadsFailedCount("group_uploads_failed_count")
                .groupUploadsRegistryCount("group_uploads_registry_count")
                .groupUploadsVerificationTotalCount("group_uploads_verification_total_count")
                .groupUploadsVerifiedCount("group_uploads_verified_count")
                .groupUploadsVerificationFailedCount("group_uploads_verification_failed_count")
                .groupUploadsOldestUnsyncedTime("group_uploads_oldest_unsynced_time")
                .groupWikiRepositoriesCount("group_wiki_repositories_count")
                .groupWikiRepositoriesChecksumTotalCount("group_wiki_repositories_checksum_total_count")
                .groupWikiRepositoriesChecksummedCount("group_wiki_repositories_checksummed_count")
                .groupWikiRepositoriesChecksumFailedCount("group_wiki_repositories_checksum_failed_count")
                .groupWikiRepositoriesSyncedCount("group_wiki_repositories_synced_count")
                .groupWikiRepositoriesFailedCount("group_wiki_repositories_failed_count")
                .groupWikiRepositoriesRegistryCount("group_wiki_repositories_registry_count")
                .groupWikiRepositoriesVerificationTotalCount("group_wiki_repositories_verification_total_count")
                .groupWikiRepositoriesVerifiedCount("group_wiki_repositories_verified_count")
                .groupWikiRepositoriesVerificationFailedCount("group_wiki_repositories_verification_failed_count")
                .groupWikiRepositoriesOldestUnsyncedTime("group_wiki_repositories_oldest_unsynced_time")
                .groupUploadsSyncedInPercentage("group_uploads_synced_in_percentage")
                .groupUploadsVerifiedInPercentage("group_uploads_verified_in_percentage")
                .groupWikiRepositoriesSyncedInPercentage("group_wiki_repositories_synced_in_percentage")
                .groupWikiRepositoriesVerifiedInPercentage("group_wiki_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusImport geoSiteStatusImport() {
        return GitLabGeoSiteStatusImportBuilder.builder()
                .importExportUploadUploadsCount("import_export_upload_uploads_count")
                .importExportUploadUploadsChecksumTotalCount("import_export_upload_uploads_checksum_total_count")
                .importExportUploadUploadsChecksummedCount("import_export_upload_uploads_checksummed_count")
                .importExportUploadUploadsChecksumFailedCount("import_export_upload_uploads_checksum_failed_count")
                .importExportUploadUploadsSyncedCount("import_export_upload_uploads_synced_count")
                .importExportUploadUploadsFailedCount("import_export_upload_uploads_failed_count")
                .importExportUploadUploadsRegistryCount("import_export_upload_uploads_registry_count")
                .importExportUploadUploadsVerificationTotalCount(
                        "import_export_upload_uploads_verification_total_count")
                .importExportUploadUploadsVerifiedCount("import_export_upload_uploads_verified_count")
                .importExportUploadUploadsVerificationFailedCount(
                        "import_export_upload_uploads_verification_failed_count")
                .importExportUploadUploadsOldestUnsyncedTime("import_export_upload_uploads_oldest_unsynced_time")
                .importExportUploadUploadsSyncedInPercentage("import_export_upload_uploads_synced_in_percentage")
                .importExportUploadUploadsVerifiedInPercentage("import_export_upload_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusIssuable geoSiteStatusIssuable() {
        return GitLabGeoSiteStatusIssuableBuilder.builder()
                .issuableMetricImageUploadsCount("issuable_metric_image_uploads_count")
                .issuableMetricImageUploadsChecksumTotalCount("issuable_metric_image_uploads_checksum_total_count")
                .issuableMetricImageUploadsChecksummedCount("issuable_metric_image_uploads_checksummed_count")
                .issuableMetricImageUploadsChecksumFailedCount("issuable_metric_image_uploads_checksum_failed_count")
                .issuableMetricImageUploadsSyncedCount("issuable_metric_image_uploads_synced_count")
                .issuableMetricImageUploadsFailedCount("issuable_metric_image_uploads_failed_count")
                .issuableMetricImageUploadsRegistryCount("issuable_metric_image_uploads_registry_count")
                .issuableMetricImageUploadsVerificationTotalCount(
                        "issuable_metric_image_uploads_verification_total_count")
                .issuableMetricImageUploadsVerifiedCount("issuable_metric_image_uploads_verified_count")
                .issuableMetricImageUploadsVerificationFailedCount(
                        "issuable_metric_image_uploads_verification_failed_count")
                .issuableMetricImageUploadsOldestUnsyncedTime("issuable_metric_image_uploads_oldest_unsynced_time")
                .issuableMetricImageUploadsSyncedInPercentage("issuable_metric_image_uploads_synced_in_percentage")
                .issuableMetricImageUploadsVerifiedInPercentage("issuable_metric_image_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusJob geoSiteStatusJob() {
        return GitLabGeoSiteStatusJobBuilder.builder()
                .jobArtifactsCount("job_artifacts_count")
                .jobArtifactsChecksumTotalCount("job_artifacts_checksum_total_count")
                .jobArtifactsChecksummedCount("job_artifacts_checksummed_count")
                .jobArtifactsChecksumFailedCount("job_artifacts_checksum_failed_count")
                .jobArtifactsSyncedCount("job_artifacts_synced_count")
                .jobArtifactsFailedCount("job_artifacts_failed_count")
                .jobArtifactsRegistryCount("job_artifacts_registry_count")
                .jobArtifactsVerificationTotalCount("job_artifacts_verification_total_count")
                .jobArtifactsVerifiedCount("job_artifacts_verified_count")
                .jobArtifactsVerificationFailedCount("job_artifacts_verification_failed_count")
                .jobArtifactsOldestUnsyncedTime("job_artifacts_oldest_unsynced_time")
                .jobArtifactsSyncedInPercentage("job_artifacts_synced_in_percentage")
                .jobArtifactsVerifiedInPercentage("job_artifacts_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusLfs geoSiteStatusLfs() {
        return GitLabGeoSiteStatusLfsBuilder.builder()
                .lfsObjectsCount("lfs_objects_count")
                .lfsObjectsChecksumTotalCount("lfs_objects_checksum_total_count")
                .lfsObjectsChecksummedCount("lfs_objects_checksummed_count")
                .lfsObjectsChecksumFailedCount("lfs_objects_checksum_failed_count")
                .lfsObjectsSyncedCount("lfs_objects_synced_count")
                .lfsObjectsFailedCount("lfs_objects_failed_count")
                .lfsObjectsRegistryCount("lfs_objects_registry_count")
                .lfsObjectsVerificationTotalCount("lfs_objects_verification_total_count")
                .lfsObjectsVerifiedCount("lfs_objects_verified_count")
                .lfsObjectsVerificationFailedCount("lfs_objects_verification_failed_count")
                .lfsObjectsOldestUnsyncedTime("lfs_objects_oldest_unsynced_time")
                .lfsObjectsSyncedInPercentage("lfs_objects_synced_in_percentage")
                .lfsObjectsVerifiedInPercentage("lfs_objects_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusLinks geoSiteStatusLinks() {
        return GitLabGeoSiteStatusLinksBuilder.builder()
                .self("self")
                .site("site")
                .build();
    }

    public static GitLabGeoSiteStatusMerge geoSiteStatusMerge() {
        return GitLabGeoSiteStatusMergeBuilder.builder()
                .mergeRequestDiffsCount("merge_request_diffs_count")
                .mergeRequestDiffsChecksumTotalCount("merge_request_diffs_checksum_total_count")
                .mergeRequestDiffsChecksummedCount("merge_request_diffs_checksummed_count")
                .mergeRequestDiffsChecksumFailedCount("merge_request_diffs_checksum_failed_count")
                .mergeRequestDiffsSyncedCount("merge_request_diffs_synced_count")
                .mergeRequestDiffsFailedCount("merge_request_diffs_failed_count")
                .mergeRequestDiffsRegistryCount("merge_request_diffs_registry_count")
                .mergeRequestDiffsVerificationTotalCount("merge_request_diffs_verification_total_count")
                .mergeRequestDiffsVerifiedCount("merge_request_diffs_verified_count")
                .mergeRequestDiffsVerificationFailedCount("merge_request_diffs_verification_failed_count")
                .mergeRequestDiffsOldestUnsyncedTime("merge_request_diffs_oldest_unsynced_time")
                .mergeRequestDiffsSyncedInPercentage("merge_request_diffs_synced_in_percentage")
                .mergeRequestDiffsVerifiedInPercentage("merge_request_diffs_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusOrganization geoSiteStatusOrganization() {
        return GitLabGeoSiteStatusOrganizationBuilder.builder()
                .organizationDetailUploadsCount("organization_detail_uploads_count")
                .organizationDetailUploadsChecksumTotalCount("organization_detail_uploads_checksum_total_count")
                .organizationDetailUploadsChecksummedCount("organization_detail_uploads_checksummed_count")
                .organizationDetailUploadsChecksumFailedCount("organization_detail_uploads_checksum_failed_count")
                .organizationDetailUploadsSyncedCount("organization_detail_uploads_synced_count")
                .organizationDetailUploadsFailedCount("organization_detail_uploads_failed_count")
                .organizationDetailUploadsRegistryCount("organization_detail_uploads_registry_count")
                .organizationDetailUploadsVerificationTotalCount("organization_detail_uploads_verification_total_count")
                .organizationDetailUploadsVerifiedCount("organization_detail_uploads_verified_count")
                .organizationDetailUploadsVerificationFailedCount(
                        "organization_detail_uploads_verification_failed_count")
                .organizationDetailUploadsOldestUnsyncedTime("organization_detail_uploads_oldest_unsynced_time")
                .organizationDetailUploadsSyncedInPercentage("organization_detail_uploads_synced_in_percentage")
                .organizationDetailUploadsVerifiedInPercentage("organization_detail_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusOther geoSiteStatusOther() {
        return GitLabGeoSiteStatusOtherBuilder.builder()
                .geoNodeId("geo_node_id")
                .projectsCount("projects_count")
                .gitFetchEventCountWeekly("git_fetch_event_count_weekly")
                .gitPushEventCountWeekly("git_push_event_count_weekly")
                .proxyRemoteRequestsEventCountWeekly("proxy_remote_requests_event_count_weekly")
                .proxyLocalRequestsEventCountWeekly("proxy_local_requests_event_count_weekly")
                .repositoriesCheckedInPercentage("repositories_checked_in_percentage")
                .repositoriesCount("repositories_count")
                .repositoriesCheckedCount("repositories_checked_count")
                .repositoriesCheckedFailedCount("repositories_checked_failed_count")
                .replicationSlotsUsedInPercentage("replication_slots_used_in_percentage")
                .replicationSlotsCount("replication_slots_count")
                .replicationSlotsUsedCount("replication_slots_used_count")
                .replicationSlotsMaxRetainedWalBytes("replication_slots_max_retained_wal_bytes")
                .healthy("healthy")
                .health("health")
                .healthStatus("health_status")
                .missingOauthApplication("missing_oauth_application")
                .dbReplicationLagSeconds("db_replication_lag_seconds")
                .lastEventId("last_event_id")
                .lastEventTimestamp("last_event_timestamp")
                .lastSuccessfulStatusCheckTimestamp("last_successful_status_check_timestamp")
                .cursorLastEventId("cursor_last_event_id")
                .cursorLastEventTimestamp("cursor_last_event_timestamp")
                .version("version")
                .revision("revision")
                .selectiveSyncType("selective_sync_type")
                .namespaces(CommonCatalogFixtures.namespaceBasic())
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .storageShards(CommonCatalogFixtures.storageShardEntity())
                .storageShardsMatch("storage_shards_match")
                .links(GeositesCatalogFixtures.geoSiteStatusLinks())
                .build();
    }

    public static GitLabGeoSiteStatusPackage geoSiteStatusPackage() {
        return GitLabGeoSiteStatusPackageBuilder.builder()
                .packageFilesCount("package_files_count")
                .packageFilesChecksumTotalCount("package_files_checksum_total_count")
                .packageFilesChecksummedCount("package_files_checksummed_count")
                .packageFilesChecksumFailedCount("package_files_checksum_failed_count")
                .packageFilesSyncedCount("package_files_synced_count")
                .packageFilesFailedCount("package_files_failed_count")
                .packageFilesRegistryCount("package_files_registry_count")
                .packageFilesVerificationTotalCount("package_files_verification_total_count")
                .packageFilesVerifiedCount("package_files_verified_count")
                .packageFilesVerificationFailedCount("package_files_verification_failed_count")
                .packageFilesOldestUnsyncedTime("package_files_oldest_unsynced_time")
                .packageFilesSyncedInPercentage("package_files_synced_in_percentage")
                .packageFilesVerifiedInPercentage("package_files_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusPackages geoSiteStatusPackages() {
        return GitLabGeoSiteStatusPackagesBuilder.builder()
                .packagesDebianProjectComponentFilesCount("packages_debian_project_component_files_count")
                .packagesDebianProjectComponentFilesChecksumTotalCount(
                        "packages_debian_project_component_files_checksum_total_count")
                .packagesDebianProjectComponentFilesChecksummedCount(
                        "packages_debian_project_component_files_checksummed_count")
                .packagesDebianProjectComponentFilesChecksumFailedCount(
                        "packages_debian_project_component_files_checksum_failed_count")
                .packagesDebianProjectComponentFilesSyncedCount("packages_debian_project_component_files_synced_count")
                .packagesDebianProjectComponentFilesFailedCount("packages_debian_project_component_files_failed_count")
                .packagesDebianProjectComponentFilesRegistryCount(
                        "packages_debian_project_component_files_registry_count")
                .packagesDebianProjectComponentFilesVerificationTotalCount(
                        "packages_debian_project_component_files_verification_total_count")
                .packagesDebianProjectComponentFilesVerifiedCount(
                        "packages_debian_project_component_files_verified_count")
                .packagesDebianProjectComponentFilesVerificationFailedCount(
                        "packages_debian_project_component_files_verification_failed_count")
                .packagesDebianProjectComponentFilesOldestUnsyncedTime(
                        "packages_debian_project_component_files_oldest_unsynced_time")
                .packagesHelmMetadataCachesCount("packages_helm_metadata_caches_count")
                .packagesHelmMetadataCachesChecksumTotalCount("packages_helm_metadata_caches_checksum_total_count")
                .packagesHelmMetadataCachesChecksummedCount("packages_helm_metadata_caches_checksummed_count")
                .packagesHelmMetadataCachesChecksumFailedCount("packages_helm_metadata_caches_checksum_failed_count")
                .packagesHelmMetadataCachesSyncedCount("packages_helm_metadata_caches_synced_count")
                .packagesHelmMetadataCachesFailedCount("packages_helm_metadata_caches_failed_count")
                .packagesHelmMetadataCachesRegistryCount("packages_helm_metadata_caches_registry_count")
                .packagesHelmMetadataCachesVerificationTotalCount(
                        "packages_helm_metadata_caches_verification_total_count")
                .packagesHelmMetadataCachesVerifiedCount("packages_helm_metadata_caches_verified_count")
                .packagesHelmMetadataCachesVerificationFailedCount(
                        "packages_helm_metadata_caches_verification_failed_count")
                .packagesHelmMetadataCachesOldestUnsyncedTime("packages_helm_metadata_caches_oldest_unsynced_time")
                .packagesNugetSymbolsCount("packages_nuget_symbols_count")
                .packagesNugetSymbolsChecksumTotalCount("packages_nuget_symbols_checksum_total_count")
                .packagesNugetSymbolsChecksummedCount("packages_nuget_symbols_checksummed_count")
                .packagesNugetSymbolsChecksumFailedCount("packages_nuget_symbols_checksum_failed_count")
                .packagesNugetSymbolsSyncedCount("packages_nuget_symbols_synced_count")
                .packagesNugetSymbolsFailedCount("packages_nuget_symbols_failed_count")
                .packagesNugetSymbolsRegistryCount("packages_nuget_symbols_registry_count")
                .packagesNugetSymbolsVerificationTotalCount("packages_nuget_symbols_verification_total_count")
                .packagesNugetSymbolsVerifiedCount("packages_nuget_symbols_verified_count")
                .packagesNugetSymbolsVerificationFailedCount("packages_nuget_symbols_verification_failed_count")
                .packagesNugetSymbolsOldestUnsyncedTime("packages_nuget_symbols_oldest_unsynced_time")
                .packagesDebianProjectComponentFilesSyncedInPercentage(
                        "packages_debian_project_component_files_synced_in_percentage")
                .packagesDebianProjectComponentFilesVerifiedInPercentage(
                        "packages_debian_project_component_files_verified_in_percentage")
                .packagesHelmMetadataCachesSyncedInPercentage("packages_helm_metadata_caches_synced_in_percentage")
                .packagesHelmMetadataCachesVerifiedInPercentage("packages_helm_metadata_caches_verified_in_percentage")
                .packagesNugetSymbolsSyncedInPercentage("packages_nuget_symbols_synced_in_percentage")
                .packagesNugetSymbolsVerifiedInPercentage("packages_nuget_symbols_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusPages geoSiteStatusPages() {
        return GitLabGeoSiteStatusPagesBuilder.builder()
                .pagesDeploymentsCount("pages_deployments_count")
                .pagesDeploymentsChecksumTotalCount("pages_deployments_checksum_total_count")
                .pagesDeploymentsChecksummedCount("pages_deployments_checksummed_count")
                .pagesDeploymentsChecksumFailedCount("pages_deployments_checksum_failed_count")
                .pagesDeploymentsSyncedCount("pages_deployments_synced_count")
                .pagesDeploymentsFailedCount("pages_deployments_failed_count")
                .pagesDeploymentsRegistryCount("pages_deployments_registry_count")
                .pagesDeploymentsVerificationTotalCount("pages_deployments_verification_total_count")
                .pagesDeploymentsVerifiedCount("pages_deployments_verified_count")
                .pagesDeploymentsVerificationFailedCount("pages_deployments_verification_failed_count")
                .pagesDeploymentsOldestUnsyncedTime("pages_deployments_oldest_unsynced_time")
                .pagesDeploymentsSyncedInPercentage("pages_deployments_synced_in_percentage")
                .pagesDeploymentsVerifiedInPercentage("pages_deployments_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusPersonal geoSiteStatusPersonal() {
        return GitLabGeoSiteStatusPersonalBuilder.builder()
                .personalSnippetUploadsCount("personal_snippet_uploads_count")
                .personalSnippetUploadsChecksumTotalCount("personal_snippet_uploads_checksum_total_count")
                .personalSnippetUploadsChecksummedCount("personal_snippet_uploads_checksummed_count")
                .personalSnippetUploadsChecksumFailedCount("personal_snippet_uploads_checksum_failed_count")
                .personalSnippetUploadsSyncedCount("personal_snippet_uploads_synced_count")
                .personalSnippetUploadsFailedCount("personal_snippet_uploads_failed_count")
                .personalSnippetUploadsRegistryCount("personal_snippet_uploads_registry_count")
                .personalSnippetUploadsVerificationTotalCount("personal_snippet_uploads_verification_total_count")
                .personalSnippetUploadsVerifiedCount("personal_snippet_uploads_verified_count")
                .personalSnippetUploadsVerificationFailedCount("personal_snippet_uploads_verification_failed_count")
                .personalSnippetUploadsOldestUnsyncedTime("personal_snippet_uploads_oldest_unsynced_time")
                .personalSnippetUploadsSyncedInPercentage("personal_snippet_uploads_synced_in_percentage")
                .personalSnippetUploadsVerifiedInPercentage("personal_snippet_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusPipeline geoSiteStatusPipeline() {
        return GitLabGeoSiteStatusPipelineBuilder.builder()
                .pipelineArtifactsCount("pipeline_artifacts_count")
                .pipelineArtifactsChecksumTotalCount("pipeline_artifacts_checksum_total_count")
                .pipelineArtifactsChecksummedCount("pipeline_artifacts_checksummed_count")
                .pipelineArtifactsChecksumFailedCount("pipeline_artifacts_checksum_failed_count")
                .pipelineArtifactsSyncedCount("pipeline_artifacts_synced_count")
                .pipelineArtifactsFailedCount("pipeline_artifacts_failed_count")
                .pipelineArtifactsRegistryCount("pipeline_artifacts_registry_count")
                .pipelineArtifactsVerificationTotalCount("pipeline_artifacts_verification_total_count")
                .pipelineArtifactsVerifiedCount("pipeline_artifacts_verified_count")
                .pipelineArtifactsVerificationFailedCount("pipeline_artifacts_verification_failed_count")
                .pipelineArtifactsOldestUnsyncedTime("pipeline_artifacts_oldest_unsynced_time")
                .pipelineArtifactsSyncedInPercentage("pipeline_artifacts_synced_in_percentage")
                .pipelineArtifactsVerifiedInPercentage("pipeline_artifacts_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusProject geoSiteStatusProject() {
        return GitLabGeoSiteStatusProjectBuilder.builder()
                .projectImportExportRelationExportUploadUploadsCount(
                        "project_import_export_relation_export_upload_uploads_count")
                .projectImportExportRelationExportUploadUploadsChecksumTotalCount(
                        "project_import_export_relation_export_upload_uploads_checksum_total_count")
                .projectImportExportRelationExportUploadUploadsChecksummedCount(
                        "project_import_export_relation_export_upload_uploads_checksummed_count")
                .projectImportExportRelationExportUploadUploadsChecksumFailedCount(
                        "project_import_export_relation_export_upload_uploads_checksum_failed_count")
                .projectImportExportRelationExportUploadUploadsSyncedCount(
                        "project_import_export_relation_export_upload_uploads_synced_count")
                .projectImportExportRelationExportUploadUploadsFailedCount(
                        "project_import_export_relation_export_upload_uploads_failed_count")
                .projectImportExportRelationExportUploadUploadsRegistryCount(
                        "project_import_export_relation_export_upload_uploads_registry_count")
                .projectImportExportRelationExportUploadUploadsVerificationTotalCount(
                        "project_import_export_relation_export_upload_uploads_verification_total_count")
                .projectImportExportRelationExportUploadUploadsVerifiedCount(
                        "project_import_export_relation_export_upload_uploads_verified_count")
                .projectImportExportRelationExportUploadUploadsVerificationFailedCount(
                        "project_import_export_relation_export_upload_uploads_verification_failed_count")
                .projectImportExportRelationExportUploadUploadsOldestUnsyncedTime(
                        "project_import_export_relation_export_upload_uploads_oldest_unsynced_time")
                .projectRepositoriesCount("project_repositories_count")
                .projectRepositoriesChecksumTotalCount("project_repositories_checksum_total_count")
                .projectRepositoriesChecksummedCount("project_repositories_checksummed_count")
                .projectRepositoriesChecksumFailedCount("project_repositories_checksum_failed_count")
                .projectRepositoriesSyncedCount("project_repositories_synced_count")
                .projectRepositoriesFailedCount("project_repositories_failed_count")
                .projectRepositoriesRegistryCount("project_repositories_registry_count")
                .projectRepositoriesVerificationTotalCount("project_repositories_verification_total_count")
                .projectRepositoriesVerifiedCount("project_repositories_verified_count")
                .projectRepositoriesVerificationFailedCount("project_repositories_verification_failed_count")
                .projectRepositoriesOldestUnsyncedTime("project_repositories_oldest_unsynced_time")
                .projectTopicUploadsCount("project_topic_uploads_count")
                .projectTopicUploadsChecksumTotalCount("project_topic_uploads_checksum_total_count")
                .projectTopicUploadsChecksummedCount("project_topic_uploads_checksummed_count")
                .projectTopicUploadsChecksumFailedCount("project_topic_uploads_checksum_failed_count")
                .projectTopicUploadsSyncedCount("project_topic_uploads_synced_count")
                .projectTopicUploadsFailedCount("project_topic_uploads_failed_count")
                .projectTopicUploadsRegistryCount("project_topic_uploads_registry_count")
                .projectTopicUploadsVerificationTotalCount("project_topic_uploads_verification_total_count")
                .projectTopicUploadsVerifiedCount("project_topic_uploads_verified_count")
                .projectTopicUploadsVerificationFailedCount("project_topic_uploads_verification_failed_count")
                .projectTopicUploadsOldestUnsyncedTime("project_topic_uploads_oldest_unsynced_time")
                .projectUploadsCount("project_uploads_count")
                .projectUploadsChecksumTotalCount("project_uploads_checksum_total_count")
                .projectUploadsChecksummedCount("project_uploads_checksummed_count")
                .projectUploadsChecksumFailedCount("project_uploads_checksum_failed_count")
                .projectUploadsSyncedCount("project_uploads_synced_count")
                .projectUploadsFailedCount("project_uploads_failed_count")
                .projectUploadsRegistryCount("project_uploads_registry_count")
                .projectUploadsVerificationTotalCount("project_uploads_verification_total_count")
                .projectUploadsVerifiedCount("project_uploads_verified_count")
                .projectUploadsVerificationFailedCount("project_uploads_verification_failed_count")
                .projectUploadsOldestUnsyncedTime("project_uploads_oldest_unsynced_time")
                .projectWikiRepositoriesCount("project_wiki_repositories_count")
                .projectWikiRepositoriesChecksumTotalCount("project_wiki_repositories_checksum_total_count")
                .projectWikiRepositoriesChecksummedCount("project_wiki_repositories_checksummed_count")
                .projectWikiRepositoriesChecksumFailedCount("project_wiki_repositories_checksum_failed_count")
                .projectWikiRepositoriesSyncedCount("project_wiki_repositories_synced_count")
                .projectWikiRepositoriesFailedCount("project_wiki_repositories_failed_count")
                .projectWikiRepositoriesRegistryCount("project_wiki_repositories_registry_count")
                .projectWikiRepositoriesVerificationTotalCount("project_wiki_repositories_verification_total_count")
                .projectWikiRepositoriesVerifiedCount("project_wiki_repositories_verified_count")
                .projectWikiRepositoriesVerificationFailedCount("project_wiki_repositories_verification_failed_count")
                .projectWikiRepositoriesOldestUnsyncedTime("project_wiki_repositories_oldest_unsynced_time")
                .projectImportExportRelationExportUploadUploadsSyncedInPercentage(
                        "project_import_export_relation_export_upload_uploads_synced_in_percentage")
                .projectImportExportRelationExportUploadUploadsVerifiedInPercentage(
                        "project_import_export_relation_export_upload_uploads_verified_in_percentage")
                .projectRepositoriesSyncedInPercentage("project_repositories_synced_in_percentage")
                .projectRepositoriesVerifiedInPercentage("project_repositories_verified_in_percentage")
                .projectTopicUploadsSyncedInPercentage("project_topic_uploads_synced_in_percentage")
                .projectTopicUploadsVerifiedInPercentage("project_topic_uploads_verified_in_percentage")
                .projectUploadsSyncedInPercentage("project_uploads_synced_in_percentage")
                .projectUploadsVerifiedInPercentage("project_uploads_verified_in_percentage")
                .projectWikiRepositoriesSyncedInPercentage("project_wiki_repositories_synced_in_percentage")
                .projectWikiRepositoriesVerifiedInPercentage("project_wiki_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusSnippet geoSiteStatusSnippet() {
        return GitLabGeoSiteStatusSnippetBuilder.builder()
                .snippetRepositoriesCount("snippet_repositories_count")
                .snippetRepositoriesChecksumTotalCount("snippet_repositories_checksum_total_count")
                .snippetRepositoriesChecksummedCount("snippet_repositories_checksummed_count")
                .snippetRepositoriesChecksumFailedCount("snippet_repositories_checksum_failed_count")
                .snippetRepositoriesSyncedCount("snippet_repositories_synced_count")
                .snippetRepositoriesFailedCount("snippet_repositories_failed_count")
                .snippetRepositoriesRegistryCount("snippet_repositories_registry_count")
                .snippetRepositoriesVerificationTotalCount("snippet_repositories_verification_total_count")
                .snippetRepositoriesVerifiedCount("snippet_repositories_verified_count")
                .snippetRepositoriesVerificationFailedCount("snippet_repositories_verification_failed_count")
                .snippetRepositoriesOldestUnsyncedTime("snippet_repositories_oldest_unsynced_time")
                .snippetRepositoriesSyncedInPercentage("snippet_repositories_synced_in_percentage")
                .snippetRepositoriesVerifiedInPercentage("snippet_repositories_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusSupply geoSiteStatusSupply() {
        return GitLabGeoSiteStatusSupplyBuilder.builder()
                .supplyChainAttestationsCount("supply_chain_attestations_count")
                .supplyChainAttestationsChecksumTotalCount("supply_chain_attestations_checksum_total_count")
                .supplyChainAttestationsChecksummedCount("supply_chain_attestations_checksummed_count")
                .supplyChainAttestationsChecksumFailedCount("supply_chain_attestations_checksum_failed_count")
                .supplyChainAttestationsSyncedCount("supply_chain_attestations_synced_count")
                .supplyChainAttestationsFailedCount("supply_chain_attestations_failed_count")
                .supplyChainAttestationsRegistryCount("supply_chain_attestations_registry_count")
                .supplyChainAttestationsVerificationTotalCount("supply_chain_attestations_verification_total_count")
                .supplyChainAttestationsVerifiedCount("supply_chain_attestations_verified_count")
                .supplyChainAttestationsVerificationFailedCount("supply_chain_attestations_verification_failed_count")
                .supplyChainAttestationsOldestUnsyncedTime("supply_chain_attestations_oldest_unsynced_time")
                .supplyChainAttestationsSyncedInPercentage("supply_chain_attestations_synced_in_percentage")
                .supplyChainAttestationsVerifiedInPercentage("supply_chain_attestations_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusTerraform geoSiteStatusTerraform() {
        return GitLabGeoSiteStatusTerraformBuilder.builder()
                .terraformStateVersionsCount("terraform_state_versions_count")
                .terraformStateVersionsChecksumTotalCount("terraform_state_versions_checksum_total_count")
                .terraformStateVersionsChecksummedCount("terraform_state_versions_checksummed_count")
                .terraformStateVersionsChecksumFailedCount("terraform_state_versions_checksum_failed_count")
                .terraformStateVersionsSyncedCount("terraform_state_versions_synced_count")
                .terraformStateVersionsFailedCount("terraform_state_versions_failed_count")
                .terraformStateVersionsRegistryCount("terraform_state_versions_registry_count")
                .terraformStateVersionsVerificationTotalCount("terraform_state_versions_verification_total_count")
                .terraformStateVersionsVerifiedCount("terraform_state_versions_verified_count")
                .terraformStateVersionsVerificationFailedCount("terraform_state_versions_verification_failed_count")
                .terraformStateVersionsOldestUnsyncedTime("terraform_state_versions_oldest_unsynced_time")
                .terraformStateVersionsSyncedInPercentage("terraform_state_versions_synced_in_percentage")
                .terraformStateVersionsVerifiedInPercentage("terraform_state_versions_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusUploads geoSiteStatusUploads() {
        return GitLabGeoSiteStatusUploadsBuilder.builder()
                .uploadsCount("uploads_count")
                .uploadsChecksumTotalCount("uploads_checksum_total_count")
                .uploadsChecksummedCount("uploads_checksummed_count")
                .uploadsChecksumFailedCount("uploads_checksum_failed_count")
                .uploadsSyncedCount("uploads_synced_count")
                .uploadsFailedCount("uploads_failed_count")
                .uploadsRegistryCount("uploads_registry_count")
                .uploadsVerificationTotalCount("uploads_verification_total_count")
                .uploadsVerifiedCount("uploads_verified_count")
                .uploadsVerificationFailedCount("uploads_verification_failed_count")
                .uploadsOldestUnsyncedTime("uploads_oldest_unsynced_time")
                .uploadsSyncedInPercentage("uploads_synced_in_percentage")
                .uploadsVerifiedInPercentage("uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusUser geoSiteStatusUser() {
        return GitLabGeoSiteStatusUserBuilder.builder()
                .userPermissionExportUploadUploadsCount("user_permission_export_upload_uploads_count")
                .userPermissionExportUploadUploadsChecksumTotalCount(
                        "user_permission_export_upload_uploads_checksum_total_count")
                .userPermissionExportUploadUploadsChecksummedCount(
                        "user_permission_export_upload_uploads_checksummed_count")
                .userPermissionExportUploadUploadsChecksumFailedCount(
                        "user_permission_export_upload_uploads_checksum_failed_count")
                .userPermissionExportUploadUploadsSyncedCount("user_permission_export_upload_uploads_synced_count")
                .userPermissionExportUploadUploadsFailedCount("user_permission_export_upload_uploads_failed_count")
                .userPermissionExportUploadUploadsRegistryCount("user_permission_export_upload_uploads_registry_count")
                .userPermissionExportUploadUploadsVerificationTotalCount(
                        "user_permission_export_upload_uploads_verification_total_count")
                .userPermissionExportUploadUploadsVerifiedCount("user_permission_export_upload_uploads_verified_count")
                .userPermissionExportUploadUploadsVerificationFailedCount(
                        "user_permission_export_upload_uploads_verification_failed_count")
                .userPermissionExportUploadUploadsOldestUnsyncedTime(
                        "user_permission_export_upload_uploads_oldest_unsynced_time")
                .userUploadsCount("user_uploads_count")
                .userUploadsChecksumTotalCount("user_uploads_checksum_total_count")
                .userUploadsChecksummedCount("user_uploads_checksummed_count")
                .userUploadsChecksumFailedCount("user_uploads_checksum_failed_count")
                .userUploadsSyncedCount("user_uploads_synced_count")
                .userUploadsFailedCount("user_uploads_failed_count")
                .userUploadsRegistryCount("user_uploads_registry_count")
                .userUploadsVerificationTotalCount("user_uploads_verification_total_count")
                .userUploadsVerifiedCount("user_uploads_verified_count")
                .userUploadsVerificationFailedCount("user_uploads_verification_failed_count")
                .userUploadsOldestUnsyncedTime("user_uploads_oldest_unsynced_time")
                .userPermissionExportUploadUploadsSyncedInPercentage(
                        "user_permission_export_upload_uploads_synced_in_percentage")
                .userPermissionExportUploadUploadsVerifiedInPercentage(
                        "user_permission_export_upload_uploads_verified_in_percentage")
                .userUploadsSyncedInPercentage("user_uploads_synced_in_percentage")
                .userUploadsVerifiedInPercentage("user_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSiteStatusVulnerability geoSiteStatusVulnerability() {
        return GitLabGeoSiteStatusVulnerabilityBuilder.builder()
                .vulnerabilityArchiveExportUploadsCount("vulnerability_archive_export_uploads_count")
                .vulnerabilityArchiveExportUploadsChecksumTotalCount(
                        "vulnerability_archive_export_uploads_checksum_total_count")
                .vulnerabilityArchiveExportUploadsChecksummedCount(
                        "vulnerability_archive_export_uploads_checksummed_count")
                .vulnerabilityArchiveExportUploadsChecksumFailedCount(
                        "vulnerability_archive_export_uploads_checksum_failed_count")
                .vulnerabilityArchiveExportUploadsSyncedCount("vulnerability_archive_export_uploads_synced_count")
                .vulnerabilityArchiveExportUploadsFailedCount("vulnerability_archive_export_uploads_failed_count")
                .vulnerabilityArchiveExportUploadsRegistryCount("vulnerability_archive_export_uploads_registry_count")
                .vulnerabilityArchiveExportUploadsVerificationTotalCount(
                        "vulnerability_archive_export_uploads_verification_total_count")
                .vulnerabilityArchiveExportUploadsVerifiedCount("vulnerability_archive_export_uploads_verified_count")
                .vulnerabilityArchiveExportUploadsVerificationFailedCount(
                        "vulnerability_archive_export_uploads_verification_failed_count")
                .vulnerabilityArchiveExportUploadsOldestUnsyncedTime(
                        "vulnerability_archive_export_uploads_oldest_unsynced_time")
                .vulnerabilityExportPartUploadsCount("vulnerability_export_part_uploads_count")
                .vulnerabilityExportPartUploadsChecksumTotalCount(
                        "vulnerability_export_part_uploads_checksum_total_count")
                .vulnerabilityExportPartUploadsChecksummedCount("vulnerability_export_part_uploads_checksummed_count")
                .vulnerabilityExportPartUploadsChecksumFailedCount(
                        "vulnerability_export_part_uploads_checksum_failed_count")
                .vulnerabilityExportPartUploadsSyncedCount("vulnerability_export_part_uploads_synced_count")
                .vulnerabilityExportPartUploadsFailedCount("vulnerability_export_part_uploads_failed_count")
                .vulnerabilityExportPartUploadsRegistryCount("vulnerability_export_part_uploads_registry_count")
                .vulnerabilityExportPartUploadsVerificationTotalCount(
                        "vulnerability_export_part_uploads_verification_total_count")
                .vulnerabilityExportPartUploadsVerifiedCount("vulnerability_export_part_uploads_verified_count")
                .vulnerabilityExportPartUploadsVerificationFailedCount(
                        "vulnerability_export_part_uploads_verification_failed_count")
                .vulnerabilityExportPartUploadsOldestUnsyncedTime(
                        "vulnerability_export_part_uploads_oldest_unsynced_time")
                .vulnerabilityExportUploadsCount("vulnerability_export_uploads_count")
                .vulnerabilityExportUploadsChecksumTotalCount("vulnerability_export_uploads_checksum_total_count")
                .vulnerabilityExportUploadsChecksummedCount("vulnerability_export_uploads_checksummed_count")
                .vulnerabilityExportUploadsChecksumFailedCount("vulnerability_export_uploads_checksum_failed_count")
                .vulnerabilityExportUploadsSyncedCount("vulnerability_export_uploads_synced_count")
                .vulnerabilityExportUploadsFailedCount("vulnerability_export_uploads_failed_count")
                .vulnerabilityExportUploadsRegistryCount("vulnerability_export_uploads_registry_count")
                .vulnerabilityExportUploadsVerificationTotalCount(
                        "vulnerability_export_uploads_verification_total_count")
                .vulnerabilityExportUploadsVerifiedCount("vulnerability_export_uploads_verified_count")
                .vulnerabilityExportUploadsVerificationFailedCount(
                        "vulnerability_export_uploads_verification_failed_count")
                .vulnerabilityExportUploadsOldestUnsyncedTime("vulnerability_export_uploads_oldest_unsynced_time")
                .vulnerabilityRemediationUploadsCount("vulnerability_remediation_uploads_count")
                .vulnerabilityRemediationUploadsChecksumTotalCount(
                        "vulnerability_remediation_uploads_checksum_total_count")
                .vulnerabilityRemediationUploadsChecksummedCount("vulnerability_remediation_uploads_checksummed_count")
                .vulnerabilityRemediationUploadsChecksumFailedCount(
                        "vulnerability_remediation_uploads_checksum_failed_count")
                .vulnerabilityRemediationUploadsSyncedCount("vulnerability_remediation_uploads_synced_count")
                .vulnerabilityRemediationUploadsFailedCount("vulnerability_remediation_uploads_failed_count")
                .vulnerabilityRemediationUploadsRegistryCount("vulnerability_remediation_uploads_registry_count")
                .vulnerabilityRemediationUploadsVerificationTotalCount(
                        "vulnerability_remediation_uploads_verification_total_count")
                .vulnerabilityRemediationUploadsVerifiedCount("vulnerability_remediation_uploads_verified_count")
                .vulnerabilityRemediationUploadsVerificationFailedCount(
                        "vulnerability_remediation_uploads_verification_failed_count")
                .vulnerabilityRemediationUploadsOldestUnsyncedTime(
                        "vulnerability_remediation_uploads_oldest_unsynced_time")
                .vulnerabilityArchiveExportUploadsSyncedInPercentage(
                        "vulnerability_archive_export_uploads_synced_in_percentage")
                .vulnerabilityArchiveExportUploadsVerifiedInPercentage(
                        "vulnerability_archive_export_uploads_verified_in_percentage")
                .vulnerabilityExportPartUploadsSyncedInPercentage(
                        "vulnerability_export_part_uploads_synced_in_percentage")
                .vulnerabilityExportPartUploadsVerifiedInPercentage(
                        "vulnerability_export_part_uploads_verified_in_percentage")
                .vulnerabilityExportUploadsSyncedInPercentage("vulnerability_export_uploads_synced_in_percentage")
                .vulnerabilityExportUploadsVerifiedInPercentage("vulnerability_export_uploads_verified_in_percentage")
                .vulnerabilityRemediationUploadsSyncedInPercentage(
                        "vulnerability_remediation_uploads_synced_in_percentage")
                .vulnerabilityRemediationUploadsVerifiedInPercentage(
                        "vulnerability_remediation_uploads_verified_in_percentage")
                .build();
    }

    public static GitLabGeoSitesCreatePayload geoSitesCreatePayload() {
        return GitLabGeoSitesCreatePayloadBuilder.builder()
                .primary(true)
                .enabled(true)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .syncObjectStorage(true)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .blobDownloadTimeout(1)
                .build();
    }

    public static GitLabGeoSitesUpdatePayload geoSitesUpdatePayload() {
        return GitLabGeoSitesUpdatePayloadBuilder.builder()
                .enabled(true)
                .name("name")
                .url("url")
                .internalUrl("internal_url")
                .filesMaxCapacity(1)
                .reposMaxCapacity(1)
                .verificationMaxCapacity(1)
                .containerRepositoriesMaxCapacity(1)
                .syncObjectStorage(true)
                .selectiveSyncType("selective_sync_type")
                .selectiveSyncShards(List.of("selective_sync_shards"))
                .selectiveSyncNamespaceIds(List.of(1L))
                .selectiveSyncOrganizationIds(List.of(1L))
                .minimumReverificationInterval(1)
                .checksumMismatchReportThreshold(1)
                .checksumMismatchSelfHealCooldownMinutes(1)
                .blobDownloadTimeout(1)
                .build();
    }
}
