package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageVersionTagTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .id(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageIdIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .packageId(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.packageId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .name(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .createdAt(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .updatedAt(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabPackageVersionTagBuilder builder = GitLabPackageVersionTagBuilder.builder(
                        CommonCatalogFixtures.packageVersionTag())
                .projectId(null);

        final GitLabPackageVersionTag built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageVersionTag value = CommonCatalogFixtures.packageVersionTag();

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
        final GitLabPackageVersionTag original = CommonCatalogFixtures.packageVersionTag();

        final GitLabPackageVersionTag rebuilt =
                GitLabPackageVersionTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageVersionTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "packageId", "name", "createdAt", "updatedAt", "projectId");
    }
}
