package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).id(null);

        final GitLabEpic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemIdIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).workItemId(null);

        final GitLabEpic built = builder.build();

        assertThat(built.workItemId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).iid(null);

        final GitLabEpic built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).color(null);

        final GitLabEpic built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextColorIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).textColor(null);

        final GitLabEpic built = builder.build();

        assertThat(built.textColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).groupId(null);

        final GitLabEpic built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).parentId(null);

        final GitLabEpic built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIidIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).parentIid(null);

        final GitLabEpic built = builder.build();

        assertThat(built.parentIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).imported(null);

        final GitLabEpic built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).importedFrom(null);

        final GitLabEpic built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).title(null);

        final GitLabEpic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).description(null);

        final GitLabEpic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).confidential(null);

        final GitLabEpic built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).author(null);

        final GitLabEpic built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).startDate(null);

        final GitLabEpic built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsFixedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).startDateIsFixed(null);

        final GitLabEpic built = builder.build();

        assertThat(built.startDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFixedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).startDateFixed(null);

        final GitLabEpic built = builder.build();

        assertThat(built.startDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFromInheritedSourceIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).startDateFromInheritedSource(null);

        final GitLabEpic built = builder.build();

        assertThat(built.startDateFromInheritedSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFromMilestonesIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).startDateFromMilestones(null);

        final GitLabEpic built = builder.build();

        assertThat(built.startDateFromMilestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).endDate(null);

        final GitLabEpic built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).dueDate(null);

        final GitLabEpic built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsFixedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).dueDateIsFixed(null);

        final GitLabEpic built = builder.build();

        assertThat(built.dueDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFixedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).dueDateFixed(null);

        final GitLabEpic built = builder.build();

        assertThat(built.dueDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFromInheritedSourceIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).dueDateFromInheritedSource(null);

        final GitLabEpic built = builder.build();

        assertThat(built.dueDateFromInheritedSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFromMilestonesIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).dueDateFromMilestones(null);

        final GitLabEpic built = builder.build();

        assertThat(built.dueDateFromMilestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).state(null);

        final GitLabEpic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebEditUrlIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).webEditUrl(null);

        final GitLabEpic built = builder.build();

        assertThat(built.webEditUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).webUrl(null);

        final GitLabEpic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).references(null);

        final GitLabEpic built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).reference(null);

        final GitLabEpic built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).createdAt(null);

        final GitLabEpic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).updatedAt(null);

        final GitLabEpic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).closedAt(null);

        final GitLabEpic built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).labels(null);

        final GitLabEpic built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).upvotes(null);

        final GitLabEpic built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).downvotes(null);

        final GitLabEpic built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).subscribed(null);

        final GitLabEpic built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabEpicBuilder builder =
                GitLabEpicBuilder.builder(CommonCatalogFixtures.epic()).links(null);

        final GitLabEpic built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpic value = CommonCatalogFixtures.epic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.workItemId()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.color()).isEqualTo("#1068bf");
            softly.assertThat(value.textColor()).isEqualTo("#1068bf");
            softly.assertThat(value.groupId()).isEqualTo(1L);
            softly.assertThat(value.parentId()).isEqualTo(1L);
            softly.assertThat(value.parentIid()).isEqualTo(1L);
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("github");
            softly.assertThat(value.title()).isEqualTo("My Epic");
            softly.assertThat(value.description()).isEqualTo("Epic description");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.startDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.startDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.startDateFixed()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.startDateFromInheritedSource()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDateFromMilestones()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.dueDateFixed()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDateFromInheritedSource()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.dueDateFromMilestones()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.state()).isEqualTo("opened");
            softly.assertThat(value.webEditUrl()).isEqualTo("http://gitlab.example.com/groups/test/-/epics/4/edit");
            softly.assertThat(value.webUrl()).isEqualTo("http://gitlab.example.com/groups/test/-/epics/4");
            softly.assertThat(value.references()).isEqualTo(CommonCatalogFixtures.issuableReferences());
            softly.assertThat(value.reference()).isEqualTo("&1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.closedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.upvotes()).isEqualTo(1);
            softly.assertThat(value.downvotes()).isEqualTo(1);
            softly.assertThat(value.subscribed()).isEqualTo(true);
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.epicLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpic original = CommonCatalogFixtures.epic();

        final GitLabEpic rebuilt = GitLabEpicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "workItemId",
                        "iid",
                        "color",
                        "textColor",
                        "groupId",
                        "parentId",
                        "parentIid",
                        "imported",
                        "importedFrom",
                        "title",
                        "description",
                        "confidential",
                        "author",
                        "startDate",
                        "startDateIsFixed",
                        "startDateFixed",
                        "startDateFromInheritedSource",
                        "startDateFromMilestones",
                        "endDate",
                        "dueDate",
                        "dueDateIsFixed",
                        "dueDateFixed",
                        "dueDateFromInheritedSource",
                        "dueDateFromMilestones",
                        "state",
                        "webEditUrl",
                        "webUrl",
                        "references",
                        "reference",
                        "createdAt",
                        "updatedAt",
                        "closedAt",
                        "labels",
                        "upvotes",
                        "downvotes",
                        "subscribed",
                        "links");
    }
}
