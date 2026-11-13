package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesCreateVariablePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload())
                        .key(null);

        final GitLabProjectPipelineSchedulesCreateVariablePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload())
                        .value(null);

        final GitLabProjectPipelineSchedulesCreateVariablePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder builder =
                GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload())
                        .variableType(null);

        final GitLabProjectPipelineSchedulesCreateVariablePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesCreateVariablePayload value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("NEW_VARIABLE");
            softly.assertThat(value.value()).isEqualTo("new value");
            softly.assertThat(value.variableType()).isEqualTo(GitLabProjectPipelineSchedulesCreateVariableType.ENV_VAR);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesCreateVariablePayload original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesCreateVariablePayload();

        final GitLabProjectPipelineSchedulesCreateVariablePayload rebuilt =
                GitLabProjectPipelineSchedulesCreateVariablePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectPipelineSchedulesCreateVariablePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value", "variableType");
    }
}
