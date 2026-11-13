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
class GitLabRelatedEpicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .id(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkItemIdIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .workItemId(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.workItemId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .iid(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .color(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextColorIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .textColor(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.textColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIdIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .groupId(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.groupId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .parentId(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIidIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .parentIid(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.parentIid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .imported(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .importedFrom(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .title(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .description(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .confidential(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .author(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .startDate(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsFixedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .startDateIsFixed(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.startDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFixedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .startDateFixed(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.startDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFromInheritedSourceIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .startDateFromInheritedSource(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.startDateFromInheritedSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFromMilestonesIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .startDateFromMilestones(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.startDateFromMilestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .endDate(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .dueDate(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.dueDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsFixedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .dueDateIsFixed(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.dueDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFixedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .dueDateFixed(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.dueDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFromInheritedSourceIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .dueDateFromInheritedSource(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.dueDateFromInheritedSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFromMilestonesIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .dueDateFromMilestones(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.dueDateFromMilestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .state(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebEditUrlIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .webEditUrl(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.webEditUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .webUrl(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferencesIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .references(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.references()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .reference(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .createdAt(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .updatedAt(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedAtIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .closedAt(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.closedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .labels(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpvotesIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .upvotes(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.upvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownvotesIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .downvotes(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.downvotes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .subscribed(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .links(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelatedEpicLinkIdIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .relatedEpicLinkId(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.relatedEpicLinkId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .linkType(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkCreatedAtIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .linkCreatedAt(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.linkCreatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkUpdatedAtIsNullable() {
        final GitLabRelatedEpicBuilder builder = GitLabRelatedEpicBuilder.builder(CommonCatalogFixtures.relatedEpic())
                .linkUpdatedAt(null);

        final GitLabRelatedEpic built = builder.build();

        assertThat(built.linkUpdatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelatedEpic value = CommonCatalogFixtures.relatedEpic();

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
            softly.assertThat(value.startDateFixed()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDateFromInheritedSource()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDateFromMilestones()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.endDate()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.dueDate()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.dueDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.dueDateFixed()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
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
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.relatedEpicLinks());
            softly.assertThat(value.relatedEpicLinkId()).isEqualTo(1L);
            softly.assertThat(value.linkType()).isEqualTo("relates_to");
            softly.assertThat(value.linkCreatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.linkUpdatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRelatedEpic original = CommonCatalogFixtures.relatedEpic();

        final GitLabRelatedEpic rebuilt =
                GitLabRelatedEpicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelatedEpic.class.getRecordComponents())
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
                        "links",
                        "relatedEpicLinkId",
                        "linkType",
                        "linkCreatedAt",
                        "linkUpdatedAt");
    }
}
