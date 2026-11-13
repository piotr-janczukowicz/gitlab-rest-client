package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiActiveContextConnectionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .id(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .name(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAdapterClassIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .adapterClass(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.adapterClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPrefixIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .prefix(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.prefix()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .active(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .createdAt(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .updatedAt(null);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiActiveContextConnection value = ActivecontextCatalogFixtures.aiActiveContextConnection();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("elastic");
            softly.assertThat(value.adapterClass()).isEqualTo("ActiveContext::Databases::Elasticsearch::Adapter");
            softly.assertThat(value.prefix()).isEqualTo("gitlab");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiActiveContextConnection original = ActivecontextCatalogFixtures.aiActiveContextConnection();

        final GitLabAiActiveContextConnection rebuilt =
                GitLabAiActiveContextConnectionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .createdAt(instant);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextConnectionBuilder builder = GitLabAiActiveContextConnectionBuilder.builder(
                        ActivecontextCatalogFixtures.aiActiveContextConnection())
                .updatedAt(instant);

        final GitLabAiActiveContextConnection built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiActiveContextConnection.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "adapterClass", "prefix", "active", "createdAt", "updatedAt");
    }
}
