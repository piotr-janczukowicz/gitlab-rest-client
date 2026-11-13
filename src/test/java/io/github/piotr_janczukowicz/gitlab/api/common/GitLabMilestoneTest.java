package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMilestoneTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .id(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .iid(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .projectId(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .groupId(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .title(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .description(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .state(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .createdAt(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .updatedAt(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .dueDate(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .startDate(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .expired(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .webUrl(null);

        final GitLabMilestone built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMilestone value = CommonCatalogFixtures.milestone();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.state()).isEqualTo("state");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
            softly.assertThat(value.expired()).isEqualTo(true);
            softly.assertThat(value.webUrl()).isEqualTo("web_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMilestone original = CommonCatalogFixtures.milestone();

        final GitLabMilestone rebuilt = GitLabMilestoneBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .createdAt(instant);

        final GitLabMilestone built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabMilestoneBuilder builder = GitLabMilestoneBuilder.builder(CommonCatalogFixtures.milestone())
                .updatedAt(instant);

        final GitLabMilestone built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMilestone.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "groupId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "dueDate",
                        "startDate",
                        "expired",
                        "webUrl");
    }
}
