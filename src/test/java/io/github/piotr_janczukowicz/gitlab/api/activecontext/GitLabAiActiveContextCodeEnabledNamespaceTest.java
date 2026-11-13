package io.github.piotr_janczukowicz.gitlab.api.activecontext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiActiveContextCodeEnabledNamespaceTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .id(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .namespaceId(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConnectionIdIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .connectionId(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.connectionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .state(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .createdAt(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .updatedAt(null);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiActiveContextCodeEnabledNamespace value =
                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.connectionId()).isEqualTo(1L);
            softly.assertThat(value.state()).isEqualTo("pending");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiActiveContextCodeEnabledNamespace original =
                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace();

        final GitLabAiActiveContextCodeEnabledNamespace rebuilt =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .createdAt(instant);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabAiActiveContextCodeEnabledNamespaceBuilder builder =
                GitLabAiActiveContextCodeEnabledNamespaceBuilder.builder(
                                ActivecontextCatalogFixtures.aiActiveContextCodeEnabledNamespace())
                        .updatedAt(instant);

        final GitLabAiActiveContextCodeEnabledNamespace built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiActiveContextCodeEnabledNamespace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "namespaceId", "connectionId", "state", "createdAt", "updatedAt");
    }
}
