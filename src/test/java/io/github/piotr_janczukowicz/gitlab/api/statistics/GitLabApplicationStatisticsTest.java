package io.github.piotr_janczukowicz.gitlab.api.statistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationStatisticsTest {

    @Test
    void constructor_shouldAcceptNull_whenForksIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .forks(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.forks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .issues(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.issues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .mergeRequests(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.mergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .notes(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSnippetsIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .snippets(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.snippets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshKeysIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .sshKeys(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.sshKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestonesIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .milestones(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.milestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsersIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .users(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.users()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .projects(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.projects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupsIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .groups(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.groups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveUsersIsNullable() {
        final GitLabApplicationStatisticsBuilder builder = GitLabApplicationStatisticsBuilder.builder(
                        StatisticsCatalogFixtures.applicationStatistics())
                .activeUsers(null);

        final GitLabApplicationStatistics built = builder.build();

        assertThat(built.activeUsers()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationStatistics value = StatisticsCatalogFixtures.applicationStatistics();

        assertSoftly(softly -> {
            softly.assertThat(value.forks()).isEqualTo(1);
            softly.assertThat(value.issues()).isEqualTo(1);
            softly.assertThat(value.mergeRequests()).isEqualTo(1);
            softly.assertThat(value.notes()).isEqualTo(1);
            softly.assertThat(value.snippets()).isEqualTo(1);
            softly.assertThat(value.sshKeys()).isEqualTo(1);
            softly.assertThat(value.milestones()).isEqualTo(1);
            softly.assertThat(value.users()).isEqualTo(1);
            softly.assertThat(value.projects()).isEqualTo(1);
            softly.assertThat(value.groups()).isEqualTo(1);
            softly.assertThat(value.activeUsers()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationStatistics original = StatisticsCatalogFixtures.applicationStatistics();

        final GitLabApplicationStatistics rebuilt =
                GitLabApplicationStatisticsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationStatistics.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "forks",
                        "issues",
                        "mergeRequests",
                        "notes",
                        "snippets",
                        "sshKeys",
                        "milestones",
                        "users",
                        "projects",
                        "groups",
                        "activeUsers");
    }
}
