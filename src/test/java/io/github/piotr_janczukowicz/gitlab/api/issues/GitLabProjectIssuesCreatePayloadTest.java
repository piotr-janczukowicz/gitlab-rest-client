package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIssuesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .title(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .createdAt(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestToResolveDiscussionsOfIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .mergeRequestToResolveDiscussionsOf(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.mergeRequestToResolveDiscussionsOf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionToResolveIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .discussionToResolve(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.discussionToResolve()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .iid(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .description(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdsIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .assigneeIds(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.assigneeIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .assigneeId(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .milestoneId(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .milestone(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMilestoneIsTooLong() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .milestone("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMilestoneHasTheMaximumLength() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .milestone("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .labels(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddLabelsIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .addLabels(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.addLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveLabelsIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .removeLabels(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.removeLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .dueDate(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .startDate(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .confidential(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .discussionLocked(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .issueType(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .severity(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.severity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .weight(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIdIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .epicId(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.epicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIidIsNullable() {
        final GitLabProjectIssuesCreatePayloadBuilder builder = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .epicIid(null);

        final GitLabProjectIssuesCreatePayload built = builder.build();

        assertThat(built.epicIid()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesCreatePayload value = IssuesCatalogFixtures.projectIssuesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeRequestToResolveDiscussionsOf()).isEqualTo(1);
            softly.assertThat(value.discussionToResolve()).isEqualTo("discussion_to_resolve");
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.assigneeIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.assigneeId()).isEqualTo(1L);
            softly.assertThat(value.milestoneId()).isEqualTo(1L);
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.addLabels()).isEqualTo(List.of("add_labels"));
            softly.assertThat(value.removeLabels()).isEqualTo(List.of("remove_labels"));
            softly.assertThat(value.dueDate()).isEqualTo("due_date");
            softly.assertThat(value.startDate()).isEqualTo("start_date");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.discussionLocked()).isEqualTo(true);
            softly.assertThat(value.issueType()).isEqualTo(GitLabProjectIssuesCreateIssueType.ISSUE);
            softly.assertThat(value.severity()).isEqualTo(GitLabProjectIssuesCreateSeverity.UNKNOWN);
            softly.assertThat(value.weight()).isEqualTo(1);
            softly.assertThat(value.epicId()).isEqualTo(1L);
            softly.assertThat(value.epicIid()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesCreatePayload original = IssuesCatalogFixtures.projectIssuesCreatePayload();

        final GitLabProjectIssuesCreatePayload rebuilt =
                GitLabProjectIssuesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectIssuesCreatePayload built = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .assigneeIds(source)
                .build();
        source.clear();

        assertThat(built.assigneeIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeIdsIsRead() {
        final GitLabProjectIssuesCreatePayload built = IssuesCatalogFixtures.projectIssuesCreatePayload();
        final List<Long> values = built.assigneeIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectIssuesCreatePayload built = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectIssuesCreatePayload built = IssuesCatalogFixtures.projectIssuesCreatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAddLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("add_labels"));
        final GitLabProjectIssuesCreatePayload built = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .addLabels(source)
                .build();
        source.clear();

        assertThat(built.addLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAddLabelsIsRead() {
        final GitLabProjectIssuesCreatePayload built = IssuesCatalogFixtures.projectIssuesCreatePayload();
        final List<String> values = built.addLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenRemoveLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("remove_labels"));
        final GitLabProjectIssuesCreatePayload built = GitLabProjectIssuesCreatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesCreatePayload())
                .removeLabels(source)
                .build();
        source.clear();

        assertThat(built.removeLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRemoveLabelsIsRead() {
        final GitLabProjectIssuesCreatePayload built = IssuesCatalogFixtures.projectIssuesCreatePayload();
        final List<String> values = built.removeLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "createdAt",
                        "mergeRequestToResolveDiscussionsOf",
                        "discussionToResolve",
                        "iid",
                        "description",
                        "assigneeIds",
                        "assigneeId",
                        "milestoneId",
                        "milestone",
                        "labels",
                        "addLabels",
                        "removeLabels",
                        "dueDate",
                        "startDate",
                        "confidential",
                        "discussionLocked",
                        "issueType",
                        "severity",
                        "weight",
                        "epicId",
                        "epicIid");
    }
}
