package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageTagTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .id(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageIdIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .packageId(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.packageId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .name(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .createdAt(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .updatedAt(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabPackageTagBuilder builder = GitLabPackageTagBuilder.builder(CommonCatalogFixtures.packageTag())
                .projectId(null);

        final GitLabPackageTag built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageTag value = CommonCatalogFixtures.packageTag();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.packageId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.projectId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageTag original = CommonCatalogFixtures.packageTag();

        final GitLabPackageTag rebuilt =
                GitLabPackageTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "packageId", "name", "createdAt", "updatedAt", "projectId");
    }
}
