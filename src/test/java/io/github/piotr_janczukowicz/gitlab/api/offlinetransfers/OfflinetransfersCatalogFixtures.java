package io.github.piotr_janczukowicz.gitlab.api.offlinetransfers;

import java.time.Instant;
import java.util.List;

public final class OfflinetransfersCatalogFixtures {

    private OfflinetransfersCatalogFixtures() {}

    public static GitLabImportOfflineExport importOfflineExport() {
        return GitLabImportOfflineExportBuilder.builder()
                .id(1L)
                .status(GitLabImportOfflineExportStatus.CREATED)
                .sourceHostname("https://source.example.com/")
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .updatedAt(Instant.parse("2026-01-01T00:00:00Z"))
                .hasFailures(true)
                .bucket("gitlab-exports")
                .exportPrefix("2012-05-28_04-42-42_export_ab12cd34")
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsAwsS3Configuration
            offlineTransfersCreateExportsAwsS3Configuration() {
        return GitLabOfflineTransfersCreateExportsAwsS3ConfigurationBuilder.builder()
                .awsAccessKeyId("aws_access_key_id")
                .awsSecretAccessKey("aws_secret_access_key")
                .region("region")
                .pathStyle(true)
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsEntity offlineTransfersCreateExportsEntity() {
        return GitLabOfflineTransfersCreateExportsEntityBuilder.builder()
                .fullPath("'source/full/path' not 'https://example.com/source/full/path'")
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsGcsAdcConfiguration
            offlineTransfersCreateExportsGcsAdcConfiguration() {
        return GitLabOfflineTransfersCreateExportsGcsAdcConfigurationBuilder.builder()
                .googleProject("google_project")
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsGcsConfiguration offlineTransfersCreateExportsGcsConfiguration() {
        return GitLabOfflineTransfersCreateExportsGcsConfigurationBuilder.builder()
                .googleProject("google_project")
                .googleJsonKeyString("google_json_key_string")
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsGcsHmacConfiguration
            offlineTransfersCreateExportsGcsHmacConfiguration() {
        return GitLabOfflineTransfersCreateExportsGcsHmacConfigurationBuilder.builder()
                .googleStorageAccessKeyId("google_storage_access_key_id")
                .googleStorageSecretAccessKey("google_storage_secret_access_key")
                .region("region")
                .pathStyle(true)
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsPayload offlineTransfersCreateExportsPayload() {
        return GitLabOfflineTransfersCreateExportsPayloadBuilder.builder()
                .bucket("bucket")
                .awsS3Configuration(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsAwsS3Configuration())
                .s3CompatibleConfiguration(
                        OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsS3CompatibleConfiguration())
                .gcsConfiguration(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsConfiguration())
                .gcsHmacConfiguration(
                        OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsHmacConfiguration())
                .gcsAdcConfiguration(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsGcsAdcConfiguration())
                .entities(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateExportsEntity()))
                .build();
    }

    public static GitLabOfflineTransfersCreateExportsS3CompatibleConfiguration
            offlineTransfersCreateExportsS3CompatibleConfiguration() {
        return GitLabOfflineTransfersCreateExportsS3CompatibleConfigurationBuilder.builder()
                .awsAccessKeyId("aws_access_key_id")
                .awsSecretAccessKey("aws_secret_access_key")
                .region("region")
                .endpoint("endpoint")
                .pathStyle(true)
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsAwsS3Configuration
            offlineTransfersCreateImportsAwsS3Configuration() {
        return GitLabOfflineTransfersCreateImportsAwsS3ConfigurationBuilder.builder()
                .awsAccessKeyId("aws_access_key_id")
                .awsSecretAccessKey("aws_secret_access_key")
                .region("region")
                .pathStyle(true)
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsEntity offlineTransfersCreateImportsEntity() {
        return GitLabOfflineTransfersCreateImportsEntityBuilder.builder()
                .sourceType(GitLabOfflineTransfersCreateImportsEntitySourceType.GROUP_ENTITY)
                .sourceFullPath("source_full_path")
                .destinationNamespace("destination_namespace")
                .destinationSlug("destination_slug")
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsGcsAdcConfiguration
            offlineTransfersCreateImportsGcsAdcConfiguration() {
        return GitLabOfflineTransfersCreateImportsGcsAdcConfigurationBuilder.builder()
                .googleProject("google_project")
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsGcsConfiguration offlineTransfersCreateImportsGcsConfiguration() {
        return GitLabOfflineTransfersCreateImportsGcsConfigurationBuilder.builder()
                .googleProject("google_project")
                .googleJsonKeyString("google_json_key_string")
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsGcsHmacConfiguration
            offlineTransfersCreateImportsGcsHmacConfiguration() {
        return GitLabOfflineTransfersCreateImportsGcsHmacConfigurationBuilder.builder()
                .googleStorageAccessKeyId("google_storage_access_key_id")
                .googleStorageSecretAccessKey("google_storage_secret_access_key")
                .region("region")
                .pathStyle(true)
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsImportAll offlineTransfersCreateImportsImportAll() {
        return GitLabOfflineTransfersCreateImportsImportAllBuilder.builder()
                .destinationNamespace("destination-group/subgroup")
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsPayload offlineTransfersCreateImportsPayload() {
        return GitLabOfflineTransfersCreateImportsPayloadBuilder.builder()
                .bucket("bucket")
                .awsS3Configuration(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsAwsS3Configuration())
                .s3CompatibleConfiguration(
                        OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsS3CompatibleConfiguration())
                .gcsConfiguration(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsConfiguration())
                .gcsHmacConfiguration(
                        OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsHmacConfiguration())
                .gcsAdcConfiguration(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsGcsAdcConfiguration())
                .exportPrefix("export_prefix")
                .entities(List.of(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsEntity()))
                .importAll(OfflinetransfersCatalogFixtures.offlineTransfersCreateImportsImportAll())
                .build();
    }

    public static GitLabOfflineTransfersCreateImportsS3CompatibleConfiguration
            offlineTransfersCreateImportsS3CompatibleConfiguration() {
        return GitLabOfflineTransfersCreateImportsS3CompatibleConfigurationBuilder.builder()
                .awsAccessKeyId("aws_access_key_id")
                .awsSecretAccessKey("aws_secret_access_key")
                .region("region")
                .endpoint("endpoint")
                .pathStyle(true)
                .build();
    }
}
