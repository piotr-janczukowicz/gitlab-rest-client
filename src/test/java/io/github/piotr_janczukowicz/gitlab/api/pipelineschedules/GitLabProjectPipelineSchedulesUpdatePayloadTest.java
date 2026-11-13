package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .description(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .ref(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .cron(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.cron()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .cronTimezone(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .active(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectPipelineSchedulesUpdatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .inputs(null);

        final GitLabProjectPipelineSchedulesUpdatePayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesUpdatePayload value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("Test schedule pipeline");
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.cron()).isEqualTo("* * * * *");
            softly.assertThat(value.cronTimezone()).isEqualTo("Asia/Tokyo");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.inputs())
                    .isEqualTo(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesUpdatePayload original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload();

        final GitLabProjectPipelineSchedulesUpdatePayload rebuilt =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenInputsSourceChangesLater() {
        final List<GitLabProjectPipelineSchedulesUpdateInput> source =
                new ArrayList<>(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateInput()));
        final GitLabProjectPipelineSchedulesUpdatePayload built =
                GitLabProjectPipelineSchedulesUpdatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload())
                        .inputs(source)
                        .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenInputsIsRead() {
        final GitLabProjectPipelineSchedulesUpdatePayload built =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdatePayload();
        final List<GitLabProjectPipelineSchedulesUpdateInput> values = built.inputs();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineSchedulesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "ref", "cron", "cronTimezone", "active", "inputs");
    }
}
