package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesCreateVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectPipelinesCreateVariableBuilder builder = GitLabProjectPipelinesCreateVariableBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreateVariable())
                .key(null);

        final GitLabProjectPipelinesCreateVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectPipelinesCreateVariableBuilder builder = GitLabProjectPipelinesCreateVariableBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreateVariable())
                .value(null);

        final GitLabProjectPipelinesCreateVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabProjectPipelinesCreateVariableBuilder builder = GitLabProjectPipelinesCreateVariableBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreateVariable())
                .variableType(null);

        final GitLabProjectPipelinesCreateVariable built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesCreateVariable value = PipelinesCatalogFixtures.projectPipelinesCreateVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("UPLOAD_TO_S3");
            softly.assertThat(value.value()).isEqualTo("true");
            softly.assertThat(value.variableType()).isEqualTo(GitLabProjectPipelinesCreateVariableType.ENV_VAR);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesCreateVariable original = PipelinesCatalogFixtures.projectPipelinesCreateVariable();

        final GitLabProjectPipelinesCreateVariable rebuilt =
                GitLabProjectPipelinesCreateVariableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesCreateVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value", "variableType");
    }
}
