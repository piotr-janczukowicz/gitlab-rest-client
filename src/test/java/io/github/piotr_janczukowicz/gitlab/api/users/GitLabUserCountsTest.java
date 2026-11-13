package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserCountsTest {

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsIsNullable() {
        final GitLabUserCountsBuilder builder = GitLabUserCountsBuilder.builder(UsersCatalogFixtures.userCounts())
                .mergeRequests(null);

        final GitLabUserCounts built = builder.build();

        assertThat(built.mergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssignedIssuesIsNullable() {
        final GitLabUserCountsBuilder builder = GitLabUserCountsBuilder.builder(UsersCatalogFixtures.userCounts())
                .assignedIssues(null);

        final GitLabUserCounts built = builder.build();

        assertThat(built.assignedIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssignedMergeRequestsIsNullable() {
        final GitLabUserCountsBuilder builder = GitLabUserCountsBuilder.builder(UsersCatalogFixtures.userCounts())
                .assignedMergeRequests(null);

        final GitLabUserCounts built = builder.build();

        assertThat(built.assignedMergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewRequestedMergeRequestsIsNullable() {
        final GitLabUserCountsBuilder builder = GitLabUserCountsBuilder.builder(UsersCatalogFixtures.userCounts())
                .reviewRequestedMergeRequests(null);

        final GitLabUserCounts built = builder.build();

        assertThat(built.reviewRequestedMergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTodosIsNullable() {
        final GitLabUserCountsBuilder builder = GitLabUserCountsBuilder.builder(UsersCatalogFixtures.userCounts())
                .todos(null);

        final GitLabUserCounts built = builder.build();

        assertThat(built.todos()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserCounts value = UsersCatalogFixtures.userCounts();

        assertSoftly(softly -> {
            softly.assertThat(value.mergeRequests()).isEqualTo(1);
            softly.assertThat(value.assignedIssues()).isEqualTo(1);
            softly.assertThat(value.assignedMergeRequests()).isEqualTo(1);
            softly.assertThat(value.reviewRequestedMergeRequests()).isEqualTo(1);
            softly.assertThat(value.todos()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserCounts original = UsersCatalogFixtures.userCounts();

        final GitLabUserCounts rebuilt =
                GitLabUserCountsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserCounts.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "mergeRequests",
                        "assignedIssues",
                        "assignedMergeRequests",
                        "reviewRequestedMergeRequests",
                        "todos");
    }
}
