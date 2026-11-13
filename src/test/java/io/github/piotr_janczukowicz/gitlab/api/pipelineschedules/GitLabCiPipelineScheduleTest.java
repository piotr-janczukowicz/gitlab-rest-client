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
class GitLabCiPipelineScheduleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .id(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .description(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .ref(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .cron(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.cron()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .cronTimezone(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextRunAtIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .nextRunAt(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.nextRunAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .active(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .createdAt(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .updatedAt(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOwnerIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .owner(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.owner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabCiPipelineScheduleBuilder builder = GitLabCiPipelineScheduleBuilder.builder(
                        PipelineschedulesCatalogFixtures.ciPipelineSchedule())
                .inputs(null);

        final GitLabCiPipelineSchedule built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipelineSchedule value = PipelineschedulesCatalogFixtures.ciPipelineSchedule();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipelineSchedule original = PipelineschedulesCatalogFixtures.ciPipelineSchedule();

        final GitLabCiPipelineSchedule rebuilt =
                GitLabCiPipelineScheduleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipelineSchedule.class.getRecordComponents())
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
                        "inputs");
    }
}
