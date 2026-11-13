package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEnvironmentBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .id(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .name(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .slug(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .externalUrl(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .createdAt(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabEnvironmentBasicBuilder builder = GitLabEnvironmentBasicBuilder.builder(
                        CommonCatalogFixtures.environmentBasic())
                .updatedAt(null);

        final GitLabEnvironmentBasic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEnvironmentBasic value = CommonCatalogFixtures.environmentBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("deploy");
            softly.assertThat(value.slug()).isEqualTo("deploy");
            softly.assertThat(value.externalUrl()).isEqualTo("https://deploy.gitlab.example.com");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEnvironmentBasic original = CommonCatalogFixtures.environmentBasic();

        final GitLabEnvironmentBasic rebuilt =
                GitLabEnvironmentBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEnvironmentBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "slug", "externalUrl", "createdAt", "updatedAt");
    }
}
