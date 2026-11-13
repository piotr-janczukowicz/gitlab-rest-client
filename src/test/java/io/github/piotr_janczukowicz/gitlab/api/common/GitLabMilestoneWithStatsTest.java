package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMilestoneWithStatsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .id(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .iid(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .projectId(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .groupId(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .title(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .description(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .state(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .createdAt(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .updatedAt(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .dueDate(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .startDate(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiredIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .expired(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.expired()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .webUrl(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueStatsIsNullable() {
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .issueStats(null);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.issueStats()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMilestoneWithStats value = CommonCatalogFixtures.milestoneWithStats();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.groupId()).isEqualTo("group_id");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.state()).isEqualTo("state");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
            softly.assertThat(value.expired()).isEqualTo(true);
            softly.assertThat(value.webUrl()).isEqualTo("web_url");
            softly.assertThat(value.issueStats()).isEqualTo(CommonCatalogFixtures.milestoneWithStatsIssueStats());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMilestoneWithStats original = CommonCatalogFixtures.milestoneWithStats();

        final GitLabMilestoneWithStats rebuilt =
                GitLabMilestoneWithStatsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .createdAt(instant);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenUpdatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabMilestoneWithStatsBuilder builder = GitLabMilestoneWithStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStats())
                .updatedAt(instant);

        final GitLabMilestoneWithStats built = builder.build();

        assertThat(built.updatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMilestoneWithStats.class.getRecordComponents())
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
                        "webUrl",
                        "issueStats");
    }
}
