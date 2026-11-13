package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectPipelinesCreatePayloadBuilder builder = GitLabProjectPipelinesCreatePayloadBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreatePayload())
                .ref(null);

        final GitLabProjectPipelinesCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabProjectPipelinesCreatePayloadBuilder builder = GitLabProjectPipelinesCreatePayloadBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreatePayload())
                .variables(null);

        final GitLabProjectPipelinesCreatePayload built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectPipelinesCreatePayloadBuilder builder = GitLabProjectPipelinesCreatePayloadBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreatePayload())
                .inputs(null);

        final GitLabProjectPipelinesCreatePayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesCreatePayload value = PipelinesCatalogFixtures.projectPipelinesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.ref()).isEqualTo("develop");
            softly.assertThat(value.variables())
                    .isEqualTo(List.of(PipelinesCatalogFixtures.projectPipelinesCreateVariable()));
            softly.assertThat(value.inputs()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesCreatePayload original = PipelinesCatalogFixtures.projectPipelinesCreatePayload();

        final GitLabProjectPipelinesCreatePayload rebuilt =
                GitLabProjectPipelinesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenVariablesSourceChangesLater() {
        final List<GitLabProjectPipelinesCreateVariable> source =
                new ArrayList<>(List.of(PipelinesCatalogFixtures.projectPipelinesCreateVariable()));
        final GitLabProjectPipelinesCreatePayload built = GitLabProjectPipelinesCreatePayloadBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreatePayload())
                .variables(source)
                .build();
        source.clear();

        assertThat(built.variables()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenVariablesIsRead() {
        final GitLabProjectPipelinesCreatePayload built = PipelinesCatalogFixtures.projectPipelinesCreatePayload();
        final List<GitLabProjectPipelinesCreateVariable> values = built.variables();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheMap_whenInputsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectPipelinesCreatePayload built = GitLabProjectPipelinesCreatePayloadBuilder.builder(
                        PipelinesCatalogFixtures.projectPipelinesCreatePayload())
                .inputs(source)
                .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref", "variables", "inputs");
    }
}
