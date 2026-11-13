package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .id(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .iid(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .projectId(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .title(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .description(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .state(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .createdAt(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .updatedAt(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedByIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergedBy(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeUserIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergeUser(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergeUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAtIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergedAt(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedByIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .closedBy(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.closedBy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .closedAt(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleHtmlIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .titleHtml(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.titleHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .descriptionHtml(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .targetBranch(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .sourceBranch(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserNotesCountIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .userNotesCount(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.userNotesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .upvotes(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .downvotes(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .author(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneesIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .assignees(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.assignees()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .assignee(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReviewersIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .reviewers(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.reviewers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceProjectIdIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .sourceProjectId(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.sourceProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetProjectIdIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .targetProjectId(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.targetProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .labels(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDraftIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .draft(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.draft()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .imported(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .importedFrom(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkInProgressIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .workInProgress(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.workInProgress()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .milestone(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeWhenPipelineSucceedsIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergeWhenPipelineSucceeds(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergeWhenPipelineSucceeds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeStatusIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergeStatus(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDetailedMergeStatusIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .detailedMergeStatus(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.detailedMergeStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeAfterIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergeAfter(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergeAfter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .sha(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeCommitShaIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .mergeCommitSha(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.mergeCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashCommitShaIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .squashCommitSha(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.squashCommitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDiscussionLockedIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .discussionLocked(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.discussionLocked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShouldRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .shouldRemoveSourceBranch(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.shouldRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForceRemoveSourceBranchIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .forceRemoveSourceBranch(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.forceRemoveSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreparedAtIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .preparedAt(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.preparedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowCollaborationIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .allowCollaboration(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.allowCollaboration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowMaintainerToPushIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .allowMaintainerToPush(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.allowMaintainerToPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .reference(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .references(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .webUrl(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeStatsIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .timeStats(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.timeStats()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .squash(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.squash()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSquashOnMergeIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .squashOnMerge(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.squashOnMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTaskCompletionStatusIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .taskCompletionStatus(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.taskCompletionStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasConflictsIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .hasConflicts(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.hasConflicts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlockingDiscussionsResolvedIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .blockingDiscussionsResolved(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.blockingDiscussionsResolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalsBeforeMergeIsNullable() {
        final GitLabMergeRequestBasicBuilder builder = GitLabMergeRequestBasicBuilder.builder(
                        CommonCatalogFixtures.mergeRequestBasic())
                .approvalsBeforeMerge(null);

        final GitLabMergeRequestBasic built = builder.build();

        assertThat(built.approvalsBeforeMerge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestBasic value = CommonCatalogFixtures.mergeRequestBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("Impedit et ut et dolores vero provident ullam est");
            softly.assertThat(value.description()).isEqualTo("Repellendus impedit et vel velit dignissimos.");
            softly.assertThat(value.state()).isEqualTo("closed");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.mergeUser()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.mergedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.closedBy()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.closedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.titleHtml()).isEqualTo("title_html");
            softly.assertThat(value.descriptionHtml()).isEqualTo("description_html");
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.userNotesCount()).isEqualTo(1);
            softly.assertThat(value.upvotes()).isEqualTo(1);
            softly.assertThat(value.downvotes()).isEqualTo(1);
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.mergeRequestAuthor());
            softly.assertThat(value.assignees()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.assignee()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.reviewers()).isEqualTo(List.of(CommonCatalogFixtures.userBasic()));
            softly.assertThat(value.sourceProjectId()).isEqualTo(1L);
            softly.assertThat(value.targetProjectId()).isEqualTo(1L);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.draft()).isEqualTo(true);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("bitbucket");
            softly.assertThat(value.workInProgress()).isEqualTo(true);
            softly.assertThat(value.milestone()).isEqualTo(CommonCatalogFixtures.milestone());
            softly.assertThat(value.mergeWhenPipelineSucceeds()).isEqualTo(true);
            softly.assertThat(value.mergeStatus()).isEqualTo("unchecked");
            softly.assertThat(value.detailedMergeStatus()).isEqualTo("mergeable");
            softly.assertThat(value.mergeAfter()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.sha()).isEqualTo("1234abcd");
            softly.assertThat(value.mergeCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.squashCommitSha()).isEqualTo("1234abcd");
            softly.assertThat(value.discussionLocked()).isEqualTo(true);
            softly.assertThat(value.shouldRemoveSourceBranch()).isEqualTo(true);
            softly.assertThat(value.forceRemoveSourceBranch()).isEqualTo(true);
            softly.assertThat(value.preparedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.allowCollaboration()).isEqualTo(true);
            softly.assertThat(value.allowMaintainerToPush()).isEqualTo(true);
            softly.assertThat(value.reference()).isEqualTo("!1");
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/my-group/my-project/-/merge_requests/1");
            softly.assertThat(value.timeStats()).isEqualTo(CommonCatalogFixtures.issuableTimeStats());
            softly.assertThat(value.squash()).isEqualTo(true);
            softly.assertThat(value.squashOnMerge()).isEqualTo(true);
            softly.assertThat(value.taskCompletionStatus()).isEqualTo(CommonCatalogFixtures.taskCompletionStatus());
            softly.assertThat(value.hasConflicts()).isEqualTo(true);
            softly.assertThat(value.blockingDiscussionsResolved()).isEqualTo(true);
            softly.assertThat(value.approvalsBeforeMerge()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestBasic original = CommonCatalogFixtures.mergeRequestBasic();

        final GitLabMergeRequestBasic rebuilt =
                GitLabMergeRequestBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "title",
                        "description",
                        "state",
                        "createdAt",
                        "updatedAt",
                        "mergedBy",
                        "mergeUser",
                        "mergedAt",
                        "closedBy",
                        "closedAt",
                        "titleHtml",
                        "descriptionHtml",
                        "targetBranch",
                        "sourceBranch",
                        "userNotesCount",
                        "upvotes",
                        "downvotes",
                        "author",
                        "assignees",
                        "assignee",
                        "reviewers",
                        "sourceProjectId",
                        "targetProjectId",
                        "labels",
                        "draft",
                        "imported",
                        "importedFrom",
                        "workInProgress",
                        "milestone",
                        "mergeWhenPipelineSucceeds",
                        "mergeStatus",
                        "detailedMergeStatus",
                        "mergeAfter",
                        "sha",
                        "mergeCommitSha",
                        "squashCommitSha",
                        "discussionLocked",
                        "shouldRemoveSourceBranch",
                        "forceRemoveSourceBranch",
                        "preparedAt",
                        "allowCollaboration",
                        "allowMaintainerToPush",
                        "reference",
                        "references",
                        "webUrl",
                        "timeStats",
                        "squash",
                        "squashOnMerge",
                        "taskCompletionStatus",
                        "hasConflicts",
                        "blockingDiscussionsResolved",
                        "approvalsBeforeMerge");
    }
}
