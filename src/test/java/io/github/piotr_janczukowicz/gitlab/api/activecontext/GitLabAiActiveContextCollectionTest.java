package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiActiveContextCollectionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .id(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .name(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .connectionId(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOptionsIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .options(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.options()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .createdAt(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .updatedAt(null);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiActiveContextCollection value = ActivecontextCatalogFixtures.aiActiveContextCollection();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("gitlab_active_context_code");
            softly.assertThat(value.connectionId()).isEqualTo(1L);
            softly.assertThat(value.options()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiActiveContextCollection original = ActivecontextCatalogFixtures.aiActiveContextCollection();

        final GitLabAiActiveContextCollection rebuilt =
                GitLabAiActiveContextCollectionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .createdAt(instant);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextCollectionBuilder builder = GitLabAiActiveContextCollectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextCollection())
                .updatedAt(instant);

        final GitLabAiActiveContextCollection built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiActiveContextCollection.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "connectionId", "options", "createdAt", "updatedAt");
    }
}
