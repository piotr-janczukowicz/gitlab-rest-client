package io.github.piotr_janczukowicz.gitlab.api.projectlevelsecurefiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiSecureFileTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .id(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .name(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .checksum(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.checksum()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumAlgorithmIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .checksumAlgorithm(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.checksumAlgorithm()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .createdAt(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .expiresAt(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMetadataIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .metadata(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.metadata()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileExtensionIsNullable() {
        final GitLabCiSecureFileBuilder builder = GitLabCiSecureFileBuilder.builder(
                        ProjectlevelsecurefilesCatalogFixtures.ciSecureFile())
                .fileExtension(null);

        final GitLabCiSecureFile built = builder.build();

        assertThat(built.fileExtension()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiSecureFile value = ProjectlevelsecurefilesCatalogFixtures.ciSecureFile();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("upload-keystore.jks");
            softly.assertThat(value.checksum())
                    .isEqualTo("16630b189ab34b2e3504f4758e1054d2e478deda510b2b08cc0ef38d12e80aac");
            softly.assertThat(value.checksumAlgorithm()).isEqualTo("sha256");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.metadata()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.fileExtension()).isEqualTo("jks");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiSecureFile original = ProjectlevelsecurefilesCatalogFixtures.ciSecureFile();

        final GitLabCiSecureFile rebuilt =
                GitLabCiSecureFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiSecureFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "checksum",
                        "checksumAlgorithm",
                        "createdAt",
                        "expiresAt",
                        "metadata",
                        "fileExtension");
    }
}
