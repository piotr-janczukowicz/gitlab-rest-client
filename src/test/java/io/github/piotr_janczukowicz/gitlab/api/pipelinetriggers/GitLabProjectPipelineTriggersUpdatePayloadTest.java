package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineTriggersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectPipelineTriggersUpdatePayloadBuilder builder =
                GitLabProjectPipelineTriggersUpdatePayloadBuilder.builder(
                                PipelinetriggersCatalogFixtures.projectPipelineTriggersUpdatePayload())
                        .description(null);

        final GitLabProjectPipelineTriggersUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineTriggersUpdatePayload value =
                PipelinetriggersCatalogFixtures.projectPipelineTriggersUpdatePayload();

        assertThat(value.description()).isEqualTo("description");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineTriggersUpdatePayload original =
                PipelinetriggersCatalogFixtures.projectPipelineTriggersUpdatePayload();

        final GitLabProjectPipelineTriggersUpdatePayload rebuilt =
                GitLabProjectPipelineTriggersUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineTriggersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description");
    }
}
