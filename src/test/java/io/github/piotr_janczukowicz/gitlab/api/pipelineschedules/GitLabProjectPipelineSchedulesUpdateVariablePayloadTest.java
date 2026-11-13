package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineSchedulesUpdateVariablePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload())
                        .value(null);

        final GitLabProjectPipelineSchedulesUpdateVariablePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder builder =
                GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder.builder(
                                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload())
                        .variableType(null);

        final GitLabProjectPipelineSchedulesUpdateVariablePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineSchedulesUpdateVariablePayload value =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.value()).isEqualTo("new value");
            softly.assertThat(value.variableType()).isEqualTo(GitLabProjectPipelineSchedulesUpdateVariableType.ENV_VAR);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineSchedulesUpdateVariablePayload original =
                PipelineschedulesCatalogFixtures.projectPipelineSchedulesUpdateVariablePayload();

        final GitLabProjectPipelineSchedulesUpdateVariablePayload rebuilt =
                GitLabProjectPipelineSchedulesUpdateVariablePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectPipelineSchedulesUpdateVariablePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value", "variableType");
    }
}
