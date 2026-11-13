package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .id(null);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .version(null);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .createdAt(null);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .tags(null);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .pipeline(null);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageVersion value = CommonCatalogFixtures.packageVersion();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.tags()).isEqualTo(List.of(CommonCatalogFixtures.packageVersionTag()));
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.packagePipeline());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageVersion original = CommonCatalogFixtures.packageVersion();

        final GitLabPackageVersion rebuilt =
                GitLabPackageVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabPackageVersionBuilder builder = GitLabPackageVersionBuilder.builder(
                        CommonCatalogFixtures.packageVersion())
                .createdAt(instant);

        final GitLabPackageVersion built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "version", "createdAt", "tags", "pipeline");
    }
}
