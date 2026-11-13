package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingMaxTest {

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsContentIncludeSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxArtifactsContentIncludeSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxArtifactsContentIncludeSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxArtifactsSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxAttachmentSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxAttachmentSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxAttachmentSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxDecompressedArchiveSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxDecompressedArchiveSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxDecompressedArchiveSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxExportSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxExportSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxExportSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxGithubResponseSizeLimitIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxGithubResponseSizeLimit(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxGithubResponseSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxGithubResponseJsonValueCountIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxGithubResponseJsonValueCount(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxGithubResponseJsonValueCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpDecompressedSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpDecompressedSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpDecompressedSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseSizeLimitIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpResponseSizeLimit(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpResponseSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseJsonDepthIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpResponseJsonDepth(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpResponseJsonDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseJsonStructuralCharsIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpResponseJsonStructuralChars(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpResponseJsonStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseXmlStructuralCharsIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpResponseXmlStructuralChars(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpResponseXmlStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseCsvStructuralCharsIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxHttpResponseCsvStructuralChars(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxHttpResponseCsvStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxImportSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxImportSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxImportSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxImportRemoteFileSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxImportRemoteFileSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxImportRemoteFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxLoginAttemptsIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxLoginAttempts(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxLoginAttempts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPagesSizeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxPagesSize(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxPagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPagesCustomDomainsPerProjectIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxPagesCustomDomainsPerProject(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxPagesCustomDomainsPerProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxTerraformStateSizeBytesIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxTerraformStateSizeBytes(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxTerraformStateSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxYamlSizeBytesIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxYamlSizeBytes(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxYamlSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxYamlDepthIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxYamlDepth(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxYamlDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPersonalAccessTokenLifetimeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxPersonalAccessTokenLifetime(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxPersonalAccessTokenLifetime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSshKeyLifetimeIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxSshKeyLifetime(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxSshKeyLifetime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxNumberOfRepositoryDownloadsIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxNumberOfRepositoryDownloads(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxNumberOfRepositoryDownloads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxNumberOfRepositoryDownloadsWithinTimePeriodIsNullable() {
        final GitLabApplicationSettingMaxBuilder builder = GitLabApplicationSettingMaxBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingMax())
                .maxNumberOfRepositoryDownloadsWithinTimePeriod(null);

        final GitLabApplicationSettingMax built = builder.build();

        assertThat(built.maxNumberOfRepositoryDownloadsWithinTimePeriod()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingMax value = SettingsCatalogFixtures.applicationSettingMax();

        assertSoftly(softly -> {
            softly.assertThat(value.maxArtifactsContentIncludeSize()).isEqualTo("max_artifacts_content_include_size");
            softly.assertThat(value.maxArtifactsSize()).isEqualTo("max_artifacts_size");
            softly.assertThat(value.maxAttachmentSize()).isEqualTo("max_attachment_size");
            softly.assertThat(value.maxDecompressedArchiveSize()).isEqualTo("max_decompressed_archive_size");
            softly.assertThat(value.maxExportSize()).isEqualTo("max_export_size");
            softly.assertThat(value.maxGithubResponseSizeLimit()).isEqualTo("max_github_response_size_limit");
            softly.assertThat(value.maxGithubResponseJsonValueCount())
                    .isEqualTo("max_github_response_json_value_count");
            softly.assertThat(value.maxHttpDecompressedSize()).isEqualTo("max_http_decompressed_size");
            softly.assertThat(value.maxHttpResponseSizeLimit()).isEqualTo("max_http_response_size_limit");
            softly.assertThat(value.maxHttpResponseJsonDepth()).isEqualTo("max_http_response_json_depth");
            softly.assertThat(value.maxHttpResponseJsonStructuralChars())
                    .isEqualTo("max_http_response_json_structural_chars");
            softly.assertThat(value.maxHttpResponseXmlStructuralChars())
                    .isEqualTo("max_http_response_xml_structural_chars");
            softly.assertThat(value.maxHttpResponseCsvStructuralChars())
                    .isEqualTo("max_http_response_csv_structural_chars");
            softly.assertThat(value.maxImportSize()).isEqualTo("max_import_size");
            softly.assertThat(value.maxImportRemoteFileSize()).isEqualTo("max_import_remote_file_size");
            softly.assertThat(value.maxLoginAttempts()).isEqualTo("max_login_attempts");
            softly.assertThat(value.maxPagesSize()).isEqualTo("max_pages_size");
            softly.assertThat(value.maxPagesCustomDomainsPerProject())
                    .isEqualTo("max_pages_custom_domains_per_project");
            softly.assertThat(value.maxTerraformStateSizeBytes()).isEqualTo("max_terraform_state_size_bytes");
            softly.assertThat(value.maxYamlSizeBytes()).isEqualTo("max_yaml_size_bytes");
            softly.assertThat(value.maxYamlDepth()).isEqualTo("max_yaml_depth");
            softly.assertThat(value.maxPersonalAccessTokenLifetime()).isEqualTo("max_personal_access_token_lifetime");
            softly.assertThat(value.maxSshKeyLifetime()).isEqualTo("max_ssh_key_lifetime");
            softly.assertThat(value.maxNumberOfRepositoryDownloads()).isEqualTo("max_number_of_repository_downloads");
            softly.assertThat(value.maxNumberOfRepositoryDownloadsWithinTimePeriod())
                    .isEqualTo("max_number_of_repository_downloads_within_time_period");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingMax original = SettingsCatalogFixtures.applicationSettingMax();

        final GitLabApplicationSettingMax rebuilt =
                GitLabApplicationSettingMaxBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenMaxPersonalAccessTokenLifetimeIsACredential() {
        final GitLabApplicationSettingMax value = SettingsCatalogFixtures.applicationSettingMax();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingMax.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "maxArtifactsContentIncludeSize",
                        "maxArtifactsSize",
                        "maxAttachmentSize",
                        "maxDecompressedArchiveSize",
                        "maxExportSize",
                        "maxGithubResponseSizeLimit",
                        "maxGithubResponseJsonValueCount",
                        "maxHttpDecompressedSize",
                        "maxHttpResponseSizeLimit",
                        "maxHttpResponseJsonDepth",
                        "maxHttpResponseJsonStructuralChars",
                        "maxHttpResponseXmlStructuralChars",
                        "maxHttpResponseCsvStructuralChars",
                        "maxImportSize",
                        "maxImportRemoteFileSize",
                        "maxLoginAttempts",
                        "maxPagesSize",
                        "maxPagesCustomDomainsPerProject",
                        "maxTerraformStateSizeBytes",
                        "maxYamlSizeBytes",
                        "maxYamlDepth",
                        "maxPersonalAccessTokenLifetime",
                        "maxSshKeyLifetime",
                        "maxNumberOfRepositoryDownloads",
                        "maxNumberOfRepositoryDownloadsWithinTimePeriod");
    }
}
