package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsPipelineRefTriggerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectProjectsPipelineRefTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload())
                        .token(null);

        final GitLabProjectProjectsPipelineRefTriggerPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabProjectProjectsPipelineRefTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload())
                        .variables(null);

        final GitLabProjectProjectsPipelineRefTriggerPayload built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectProjectsPipelineRefTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload())
                        .inputs(null);

        final GitLabProjectProjectsPipelineRefTriggerPayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsPipelineRefTriggerPayload value =
                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("6d056f63e50fe6f8c5f8f4aa10edb7");
            softly.assertThat(value.variables()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.inputs()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsPipelineRefTriggerPayload original =
                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload();

        final GitLabProjectProjectsPipelineRefTriggerPayload rebuilt =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenVariablesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsPipelineRefTriggerPayload built =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload())
                        .variables(source)
                        .build();
        source.clear();

        assertThat(built.variables()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheMap_whenInputsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsPipelineRefTriggerPayload built =
                GitLabProjectProjectsPipelineRefTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload())
                        .inputs(source)
                        .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectProjectsPipelineRefTriggerPayload value =
                ProjectsCatalogFixtures.projectProjectsPipelineRefTriggerPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsPipelineRefTriggerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "variables", "inputs");
    }
}
