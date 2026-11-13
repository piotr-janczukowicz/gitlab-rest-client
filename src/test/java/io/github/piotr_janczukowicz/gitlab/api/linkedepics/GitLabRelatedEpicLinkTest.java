package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRelatedEpicLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .id(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceEpicIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .sourceEpic(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.sourceEpic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetEpicIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .targetEpic(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.targetEpic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .linkType(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .createdAt(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabRelatedEpicLinkBuilder builder = GitLabRelatedEpicLinkBuilder.builder(
                        LinkedepicsCatalogFixtures.relatedEpicLink())
                .updatedAt(null);

        final GitLabRelatedEpicLink built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelatedEpicLink value = LinkedepicsCatalogFixtures.relatedEpicLink();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.sourceEpic()).isEqualTo(CommonCatalogFixtures.epic());
            softly.assertThat(value.targetEpic()).isEqualTo(CommonCatalogFixtures.epic());
            softly.assertThat(value.linkType()).isEqualTo("relates_to");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRelatedEpicLink original = LinkedepicsCatalogFixtures.relatedEpicLink();

        final GitLabRelatedEpicLink rebuilt =
                GitLabRelatedEpicLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelatedEpicLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "sourceEpic", "targetEpic", "linkType", "createdAt", "updatedAt");
    }
}
