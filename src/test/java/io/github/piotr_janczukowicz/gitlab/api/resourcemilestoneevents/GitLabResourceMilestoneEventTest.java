package io.github.piotr_janczukowicz.gitlab.api.resourcemilestoneevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabResourceMilestoneEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .id(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .user(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .createdAt(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceTypeIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .resourceType(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.resourceType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourceIdIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .resourceId(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.resourceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .milestone(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActionIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .action(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.action()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabResourceMilestoneEventBuilder builder = GitLabResourceMilestoneEventBuilder.builder(
                        ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent())
                .state(null);

        final GitLabResourceMilestoneEvent built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceMilestoneEvent value = ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.resourceType()).isEqualTo("Issue");
            softly.assertThat(value.resourceId()).isEqualTo(1L);
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.action()).isEqualTo("add");
            softly.assertThat(value.state()).isEqualTo("active");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceMilestoneEvent original = ResourcemilestoneeventsCatalogFixtures.resourceMilestoneEvent();

        final GitLabResourceMilestoneEvent rebuilt =
                GitLabResourceMilestoneEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceMilestoneEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "user", "createdAt", "resourceType", "resourceId", "milestone", "action", "state");
    }
}
