package io.github.piotr_janczukowicz.gitlab.api.knowledgegraph;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsKnowledgeGraphEnabledNamespaceTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder builder =
                GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder.builder(
                                KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace())
                        .id(null);

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootNamespaceIdIsNullable() {
        final GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder builder =
                GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder.builder(
                                KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace())
                        .rootNamespaceId(null);

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace built = builder.build();

        assertThat(built.rootNamespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder builder =
                GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder.builder(
                                KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace())
                        .createdAt(null);

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsKnowledgeGraphEnabledNamespace value =
                KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.rootNamespaceId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsKnowledgeGraphEnabledNamespace original =
                KnowledgegraphCatalogFixtures.analyticsKnowledgeGraphEnabledNamespace();

        final GitLabAnalyticsKnowledgeGraphEnabledNamespace rebuilt =
                GitLabAnalyticsKnowledgeGraphEnabledNamespaceBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsKnowledgeGraphEnabledNamespace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "rootNamespaceId", "createdAt");
    }
}
