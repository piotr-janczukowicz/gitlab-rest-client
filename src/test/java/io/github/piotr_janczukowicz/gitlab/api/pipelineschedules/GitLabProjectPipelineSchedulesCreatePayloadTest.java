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
class GitLabProjectPipelineSchedulesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .description(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .ref(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .cron(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.cron()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCronTimezoneIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .cronTimezone(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.cronTimezone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenActiveIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .active(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.active()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectPipelineSchedulesCreatePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .inputs(null);

        final GitLabProjectPipelineSchedulesCreatePayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesCreatePayload value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("Test schedule pipeline");
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.cron()).isEqualTo("* * * * *");
            softly.assertThat(value.cronTimezone()).isEqualTo("Asia/Tokyo");
            softly.assertThat(value.active()).isEqualTo(true);
            softly.assertThat(value.inputs())
                    .isEqualTo(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesCreatePayload original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload();

        final GitLabProjectPipelineSchedulesCreatePayload rebuilt =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenInputsSourceChangesLater() {
        final List<GitLabProjectPipelineSchedulesCreateInput> source =
                new ArrayList<>(List.of(PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateInput()));
        final GitLabProjectPipelineSchedulesCreatePayload built =
                GitLabProjectPipelineSchedulesCreatePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload())
                        .inputs(source)
                        .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenInputsIsRead() {
        final GitLabProjectPipelineSchedulesCreatePayload built =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreatePayload();
        final List<GitLabProjectPipelineSchedulesCreateInput> values = built.inputs();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineSchedulesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "ref", "cron", "cronTimezone", "active", "inputs");
    }
}
