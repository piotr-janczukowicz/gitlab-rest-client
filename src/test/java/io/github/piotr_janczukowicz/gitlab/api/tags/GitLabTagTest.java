package io.github.piotr_janczukowicz.gitlab.api.tags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTagTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).name(null);

        final GitLabTag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).message(null);

        final GitLabTag built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).target(null);

        final GitLabTag built = builder.build();

        assertThat(built.target()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).commit(null);

        final GitLabTag built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleaseIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).release(null);

        final GitLabTag built = builder.build();

        assertThat(built.release()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).protectedValue(null);

        final GitLabTag built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabTagBuilder builder =
                GitLabTagBuilder.builder(TagsCatalogFixtures.tag()).createdAt(null);

        final GitLabTag built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTag value = TagsCatalogFixtures.tag();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("v1.0.0");
            softly.assertThat(value.message()).isEqualTo("Release v1.0.0");
            softly.assertThat(value.target()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.release()).isEqualTo(TagsCatalogFixtures.tagRelease());
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTag original = TagsCatalogFixtures.tag();

        final GitLabTag rebuilt = GitLabTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("name", "message", "target", "commit", "release", "protectedValue", "createdAt");
    }
}
