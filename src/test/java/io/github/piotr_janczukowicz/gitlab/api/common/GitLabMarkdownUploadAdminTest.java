package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMarkdownUploadAdminTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMarkdownUploadAdminBuilder builder = GitLabMarkdownUploadAdminBuilder.builder(
                        CommonCatalogFixtures.markdownUploadAdmin())
                .id(null);

        final GitLabMarkdownUploadAdmin built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabMarkdownUploadAdminBuilder builder = GitLabMarkdownUploadAdminBuilder.builder(
                        CommonCatalogFixtures.markdownUploadAdmin())
                .size(null);

        final GitLabMarkdownUploadAdmin built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilenameIsNullable() {
        final GitLabMarkdownUploadAdminBuilder builder = GitLabMarkdownUploadAdminBuilder.builder(
                        CommonCatalogFixtures.markdownUploadAdmin())
                .filename(null);

        final GitLabMarkdownUploadAdmin built = builder.build();

        assertThat(built.filename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMarkdownUploadAdminBuilder builder = GitLabMarkdownUploadAdminBuilder.builder(
                        CommonCatalogFixtures.markdownUploadAdmin())
                .createdAt(null);

        final GitLabMarkdownUploadAdmin built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUploadedByIsNullable() {
        final GitLabMarkdownUploadAdminBuilder builder = GitLabMarkdownUploadAdminBuilder.builder(
                        CommonCatalogFixtures.markdownUploadAdmin())
                .uploadedBy(null);

        final GitLabMarkdownUploadAdmin built = builder.build();

        assertThat(built.uploadedBy()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMarkdownUploadAdmin value = CommonCatalogFixtures.markdownUploadAdmin();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.filename()).isEqualTo("image.png");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.uploadedBy()).isEqualTo(CommonCatalogFixtures.userSafe());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMarkdownUploadAdmin original = CommonCatalogFixtures.markdownUploadAdmin();

        final GitLabMarkdownUploadAdmin rebuilt =
                GitLabMarkdownUploadAdminBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMarkdownUploadAdmin.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "size", "filename", "createdAt", "uploadedBy");
    }
}
