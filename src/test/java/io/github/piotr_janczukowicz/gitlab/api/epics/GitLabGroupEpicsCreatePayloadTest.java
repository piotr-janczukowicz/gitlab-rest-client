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
class GitLabGroupEpicsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .title(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .description(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .color(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .confidential(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .createdAt(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .startDate(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.startDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateFixedIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .startDateFixed(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.startDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartDateIsFixedIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .startDateIsFixed(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.startDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndDateIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .endDate(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.endDate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateFixedIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .dueDateFixed(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.dueDateFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDueDateIsFixedIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .dueDateIsFixed(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.dueDateIsFixed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .labels(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabGroupEpicsCreatePayloadBuilder builder = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .parentId(null);

        final GitLabGroupEpicsCreatePayload built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicsCreatePayload value = EpicsCatalogFixtures.groupEpicsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("My Epic");
            softly.assertThat(value.description()).isEqualTo("Epic description");
            softly.assertThat(value.color()).isEqualTo("#1068bf");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startDate()).isEqualTo("2018-07-31");
            softly.assertThat(value.startDateFixed()).isEqualTo("2018-07-31");
            softly.assertThat(value.startDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.endDate()).isEqualTo("2019-08-11");
            softly.assertThat(value.dueDateFixed()).isEqualTo("2019-08-11");
            softly.assertThat(value.dueDateIsFixed()).isEqualTo(true);
            softly.assertThat(value.labels()).isEqualTo(List.of("labels"));
            softly.assertThat(value.parentId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicsCreatePayload original = EpicsCatalogFixtures.groupEpicsCreatePayload();

        final GitLabGroupEpicsCreatePayload rebuilt =
                GitLabGroupEpicsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelsSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("labels"));
        final GitLabGroupEpicsCreatePayload built = GitLabGroupEpicsCreatePayloadBuilder.builder(
                        EpicsCatalogFixtures.groupEpicsCreatePayload())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelsIsRead() {
        final GitLabGroupEpicsCreatePayload built = EpicsCatalogFixtures.groupEpicsCreatePayload();
        final List<String> values = built.labels();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "description",
                        "color",
                        "confidential",
                        "createdAt",
                        "startDate",
                        "startDateFixed",
                        "startDateIsFixed",
                        "endDate",
                        "dueDateFixed",
                        "dueDateIsFixed",
                        "labels",
                        "parentId");
    }
}
