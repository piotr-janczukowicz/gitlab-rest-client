package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateMaxTest {

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxArtifactsSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxArtifactsSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxAttachmentSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxAttachmentSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxAttachmentSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxExportSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxExportSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxExportSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxGithubResponseSizeLimitIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxGithubResponseSizeLimit(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxGithubResponseSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxGithubResponseJsonValueCountIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxGithubResponseJsonValueCount(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxGithubResponseJsonValueCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxImportSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxImportSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxImportSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxImportRemoteFileSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxImportRemoteFileSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxImportRemoteFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxDecompressedArchiveSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxDecompressedArchiveSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxDecompressedArchiveSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPagesSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxPagesSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxPagesSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPagesCustomDomainsPerProjectIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxPagesCustomDomainsPerProject(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxPagesCustomDomainsPerProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxTerraformStateSizeBytesIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxTerraformStateSizeBytes(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxTerraformStateSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpDecompressedSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpDecompressedSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpDecompressedSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseCsvStructuralCharsIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpResponseCsvStructuralChars(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpResponseCsvStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseJsonDepthIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpResponseJsonDepth(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpResponseJsonDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseJsonStructuralCharsIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpResponseJsonStructuralChars(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpResponseJsonStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseSizeLimitIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpResponseSizeLimit(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpResponseSizeLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxHttpResponseXmlStructuralCharsIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxHttpResponseXmlStructuralChars(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxHttpResponseXmlStructuralChars()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxLoginAttemptsIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxLoginAttempts(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxLoginAttempts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxYamlDepthIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxYamlDepth(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxYamlDepth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxYamlSizeBytesIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxYamlSizeBytes(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxYamlSizeBytes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxNumberOfRepositoryDownloadsIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxNumberOfRepositoryDownloads(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxNumberOfRepositoryDownloads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxNumberOfRepositoryDownloadsWithinTimePeriodIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxNumberOfRepositoryDownloadsWithinTimePeriod(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxNumberOfRepositoryDownloadsWithinTimePeriod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxPersonalAccessTokenLifetimeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxPersonalAccessTokenLifetime(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxPersonalAccessTokenLifetime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxSshKeyLifetimeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxSshKeyLifetime(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxSshKeyLifetime()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxArtifactsContentIncludeSizeIsNullable() {
        final GitLabSettingsUpdateMaxBuilder builder = GitLabSettingsUpdateMaxBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateMax())
                .maxArtifactsContentIncludeSize(null);

        final GitLabSettingsUpdateMax built = builder.build();

        assertThat(built.maxArtifactsContentIncludeSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateMax value = SettingsCatalogFixtures.settingsUpdateMax();

        assertSoftly(softly -> {
            softly.assertThat(value.maxArtifactsSize()).isEqualTo(1L);
            softly.assertThat(value.maxAttachmentSize()).isEqualTo(1L);
            softly.assertThat(value.maxExportSize()).isEqualTo(1L);
            softly.assertThat(value.maxGithubResponseSizeLimit()).isEqualTo(1);
            softly.assertThat(value.maxGithubResponseJsonValueCount()).isEqualTo(1);
            softly.assertThat(value.maxImportSize()).isEqualTo(1L);
            softly.assertThat(value.maxImportRemoteFileSize()).isEqualTo(1L);
            softly.assertThat(value.maxDecompressedArchiveSize()).isEqualTo(1L);
            softly.assertThat(value.maxPagesSize()).isEqualTo(1L);
            softly.assertThat(value.maxPagesCustomDomainsPerProject()).isEqualTo(1);
            softly.assertThat(value.maxTerraformStateSizeBytes()).isEqualTo(1L);
            softly.assertThat(value.maxHttpDecompressedSize()).isEqualTo("max_http_decompressed_size");
            softly.assertThat(value.maxHttpResponseCsvStructuralChars())
                    .isEqualTo("max_http_response_csv_structural_chars");
            softly.assertThat(value.maxHttpResponseJsonDepth()).isEqualTo("max_http_response_json_depth");
            softly.assertThat(value.maxHttpResponseJsonStructuralChars())
                    .isEqualTo("max_http_response_json_structural_chars");
            softly.assertThat(value.maxHttpResponseSizeLimit()).isEqualTo("max_http_response_size_limit");
            softly.assertThat(value.maxHttpResponseXmlStructuralChars())
                    .isEqualTo("max_http_response_xml_structural_chars");
            softly.assertThat(value.maxLoginAttempts()).isEqualTo("max_login_attempts");
            softly.assertThat(value.maxYamlDepth()).isEqualTo("max_yaml_depth");
            softly.assertThat(value.maxYamlSizeBytes()).isEqualTo("max_yaml_size_bytes");
            softly.assertThat(value.maxNumberOfRepositoryDownloads()).isEqualTo(1);
            softly.assertThat(value.maxNumberOfRepositoryDownloadsWithinTimePeriod())
                    .isEqualTo(1);
            softly.assertThat(value.maxPersonalAccessTokenLifetime()).isEqualTo("max_personal_access_token_lifetime");
            softly.assertThat(value.maxSshKeyLifetime()).isEqualTo("max_ssh_key_lifetime");
            softly.assertThat(value.maxArtifactsContentIncludeSize()).isEqualTo("max_artifacts_content_include_size");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateMax original = SettingsCatalogFixtures.settingsUpdateMax();

        final GitLabSettingsUpdateMax rebuilt =
                GitLabSettingsUpdateMaxBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenMaxPersonalAccessTokenLifetimeIsACredential() {
        final GitLabSettingsUpdateMax value = SettingsCatalogFixtures.settingsUpdateMax();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateMax.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "maxArtifactsSize",
                        "maxAttachmentSize",
                        "maxExportSize",
                        "maxGithubResponseSizeLimit",
                        "maxGithubResponseJsonValueCount",
                        "maxImportSize",
                        "maxImportRemoteFileSize",
                        "maxDecompressedArchiveSize",
                        "maxPagesSize",
                        "maxPagesCustomDomainsPerProject",
                        "maxTerraformStateSizeBytes",
                        "maxHttpDecompressedSize",
                        "maxHttpResponseCsvStructuralChars",
                        "maxHttpResponseJsonDepth",
                        "maxHttpResponseJsonStructuralChars",
                        "maxHttpResponseSizeLimit",
                        "maxHttpResponseXmlStructuralChars",
                        "maxLoginAttempts",
                        "maxYamlDepth",
                        "maxYamlSizeBytes",
                        "maxNumberOfRepositoryDownloads",
                        "maxNumberOfRepositoryDownloadsWithinTimePeriod",
                        "maxPersonalAccessTokenLifetime",
                        "maxSshKeyLifetime",
                        "maxArtifactsContentIncludeSize");
    }
}
