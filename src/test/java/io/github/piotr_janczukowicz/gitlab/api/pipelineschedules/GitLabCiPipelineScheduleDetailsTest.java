package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiPipelineScheduleDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .id(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .description(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .ref(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .cron(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.cron()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .cronTimezone(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextRunAtIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .nextRunAt(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.nextRunAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .active(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .createdAt(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .updatedAt(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .owner(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .inputs(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastPipelineIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .lastPipeline(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.lastPipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabCiPipelineScheduleDetailsBuilder builder = GitLabCiPipelineScheduleDetailsBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails())
                .variables(null);

        final GitLabCiPipelineScheduleDetails built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipelineScheduleDetails value = PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("Test schedule pipeline");
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.cron()).isEqualTo("* * * * *");
            softly.assertThat(value.cronTimezone()).isEqualTo("Asia/Tokyo");
            softly.assertThat(value.nextRunAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.owner()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.inputs()).isEqualTo(List.of(PipelineschedulesCatalogFixtures.ciInput()));
            softly.assertThat(value.lastPipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(value.variables()).isEqualTo(List.of(CommonCatalogFixtures.ciVariable()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipelineScheduleDetails original = PipelineschedulesCatalogFixtures.ciPipelineScheduleDetails();

        final GitLabCiPipelineScheduleDetails rebuilt =
                GitLabCiPipelineScheduleDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipelineScheduleDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "description",
                        "ref",
                        "cron",
                        "cronTimezone",
                        "nextRunAt",
                        "active",
                        "createdAt",
                        "updatedAt",
                        "owner",
                        "inputs",
                        "lastPipeline",
                        "variables");
    }
}
