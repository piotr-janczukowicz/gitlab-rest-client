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
class GitLabProjectIssuesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .title(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .updatedAt(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateEventIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .stateEvent(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.stateEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .description(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdsIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .assigneeIds(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.assigneeIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIdIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .assigneeId(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.assigneeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .milestoneId(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.milestoneId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .milestone(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMilestoneIsTooLong() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .milestone("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMilestoneHasTheMaximumLength() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .milestone("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .labels(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddLabelsIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .addLabels(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.addLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveLabelsIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .removeLabels(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.removeLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .dueDate(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .startDate(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .confidential(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .discussionLocked(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueTypeIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .issueType(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.issueType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSeverityIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .severity(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.severity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .weight(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIdIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .epicId(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.epicId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIidIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .epicIid(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.epicIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .createdAt(null);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIssuesUpdatePayload value = IssuesCatalogFixtures.projectIssuesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.stateEvent()).isEqualTo(GitLabProjectIssuesUpdateStateEvent.REOPEN);
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
            softly.assertThat(value.issueType()).isEqualTo(GitLabProjectIssuesUpdateIssueType.ISSUE);
            softly.assertThat(value.severity()).isEqualTo(GitLabProjectIssuesUpdateSeverity.UNKNOWN);
            softly.assertThat(value.weight()).isEqualTo(1);
            softly.assertThat(value.epicId()).isEqualTo(1L);
            softly.assertThat(value.epicIid()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIssuesUpdatePayload original = IssuesCatalogFixtures.projectIssuesUpdatePayload();

        final GitLabProjectIssuesUpdatePayload rebuilt =
                GitLabProjectIssuesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenAssigneeIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabProjectIssuesUpdatePayload built = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .assigneeIds(source)
                .build();
        source.clear();

        assertThat(built.assigneeIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAssigneeIdsIsRead() {
        final GitLabProjectIssuesUpdatePayload built = IssuesCatalogFixtures.projectIssuesUpdatePayload();
        final List<Long> values = built.assigneeIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabProjectIssuesUpdatePayload built = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabProjectIssuesUpdatePayload built = IssuesCatalogFixtures.projectIssuesUpdatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAddLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("add_labels"));
        final GitLabProjectIssuesUpdatePayload built = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .addLabels(source)
                .build();
        source.clear();

        assertThat(built.addLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAddLabelsIsRead() {
        final GitLabProjectIssuesUpdatePayload built = IssuesCatalogFixtures.projectIssuesUpdatePayload();
        final List<String> values = built.addLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenRemoveLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("remove_labels"));
        final GitLabProjectIssuesUpdatePayload built = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .removeLabels(source)
                .build();
        source.clear();

        assertThat(built.removeLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRemoveLabelsIsRead() {
        final GitLabProjectIssuesUpdatePayload built = IssuesCatalogFixtures.projectIssuesUpdatePayload();
        final List<String> values = built.removeLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectIssuesUpdatePayloadBuilder builder = GitLabProjectIssuesUpdatePayloadBuilder.builder(
                        IssuesCatalogFixtures.projectIssuesUpdatePayload())
                .createdAt(instant);

        final GitLabProjectIssuesUpdatePayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIssuesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "updatedAt",
                        "stateEvent",
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
                        "epicIid",
                        "createdAt");
    }
}
