package io.github.piotr_janczukowicz.gitlab.api.epics;

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
class GitLabGroupEpicsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .title(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .color(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .description(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .confidential(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .updatedAt(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .startDate(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFixedIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .startDateFixed(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.startDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsFixedIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .startDateIsFixed(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.startDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .endDate(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFixedIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .dueDateFixed(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.dueDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsFixedIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .dueDateIsFixed(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.dueDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .labels(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAddLabelsIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .addLabels(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.addLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRemoveLabelsIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .removeLabels(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.removeLabels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateEventIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .stateEvent(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.stateEvent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabGroupEpicsUpdatePayloadBuilder builder = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .parentId(null);

        final GitLabGroupEpicsUpdatePayload built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicsUpdatePayload value = EpicsCatalogFixtures.groupEpicsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("My Epic");
            softly.assertThat(value.color()).isEqualTo("#1068bf");
            softly.assertThat(value.description()).isEqualTo("Epic description");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDate()).isEqualTo("2018-07-31");
            softly.assertThat(value.startDateFixed()).isEqualTo("2018-07-31");
            softly.assertThat(value.startDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.endDate()).isEqualTo("2019-08-11");
            softly.assertThat(value.dueDateFixed()).isEqualTo("2019-08-11");
            softly.assertThat(value.dueDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.addLabels()).isEqualTo(List.of("add_labels"));
            softly.assertThat(value.removeLabels()).isEqualTo(List.of("remove_labels"));
            softly.assertThat(value.stateEvent()).isEqualTo(GitLabGroupEpicsUpdateStateEvent.REOPEN);
            softly.assertThat(value.parentId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicsUpdatePayload original = EpicsCatalogFixtures.groupEpicsUpdatePayload();

        final GitLabGroupEpicsUpdatePayload rebuilt =
                GitLabGroupEpicsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabGroupEpicsUpdatePayload built = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabGroupEpicsUpdatePayload built = EpicsCatalogFixtures.groupEpicsUpdatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenAddLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("add_labels"));
        final GitLabGroupEpicsUpdatePayload built = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .addLabels(source)
                .build();
        source.clear();

        assertThat(built.addLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenAddLabelsIsRead() {
        final GitLabGroupEpicsUpdatePayload built = EpicsCatalogFixtures.groupEpicsUpdatePayload();
        final List<String> values = built.addLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenRemoveLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("remove_labels"));
        final GitLabGroupEpicsUpdatePayload built = GitLabGroupEpicsUpdatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsUpdatePayload())
                .removeLabels(source)
                .build();
        source.clear();

        assertThat(built.removeLabels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenRemoveLabelsIsRead() {
        final GitLabGroupEpicsUpdatePayload built = EpicsCatalogFixtures.groupEpicsUpdatePayload();
        final List<String> values = built.removeLabels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "color",
                        "description",
                        "confidential",
                        "updatedAt",
                        "startDate",
                        "startDateFixed",
                        "startDateIsFixed",
                        "endDate",
                        "dueDateFixed",
                        "dueDateIsFixed",
                        "labels",
                        "addLabels",
                        "removeLabels",
                        "stateEvent",
                        "parentId");
    }
}
