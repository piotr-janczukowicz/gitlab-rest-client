package io.github.piotr_janczukowicz.gitlab.api.resourceiterationevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabResourceIterationEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .id(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .user(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .createdAt(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .resourceType(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .resourceId(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIterationIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .iteration(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.iteration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabResourceIterationEventBuilder builder = GitLabResourceIterationEventBuilder.builder(
                        ResourceiterationeventsCatalogFixtures.resourceIterationEvent())
                .action(null);

        final GitLabResourceIterationEvent built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceIterationEvent value = ResourceiterationeventsCatalogFixtures.resourceIterationEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.resourceType()).isEqualTo("Issue");
            softly.assertThat(value.resourceId()).isEqualTo(1L);
            softly.assertThat(value.iteration()).isEqualTo(CommonCatalogFixtures.iteration());
            softly.assertThat(value.action()).isEqualTo("add");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceIterationEvent original = ResourceiterationeventsCatalogFixtures.resourceIterationEvent();

        final GitLabResourceIterationEvent rebuilt =
                GitLabResourceIterationEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceIterationEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "user", "createdAt", "resourceType", "resourceId", "iteration", "action");
    }
}
