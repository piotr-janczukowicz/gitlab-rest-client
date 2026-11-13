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
class GitLabProjectProjectsPipelineTriggerPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabProjectProjectsPipelineTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload())
                        .token(null);

        final GitLabProjectProjectsPipelineTriggerPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabProjectProjectsPipelineTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload())
                        .variables(null);

        final GitLabProjectProjectsPipelineTriggerPayload built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectProjectsPipelineTriggerPayloadBuilder builder =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload())
                        .inputs(null);

        final GitLabProjectProjectsPipelineTriggerPayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsPipelineTriggerPayload value =
                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("6d056f63e50fe6f8c5f8f4aa10edb7");
            softly.assertThat(value.variables()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.inputs()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsPipelineTriggerPayload original =
                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload();

        final GitLabProjectProjectsPipelineTriggerPayload rebuilt =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenVariablesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsPipelineTriggerPayload built =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload())
                        .variables(source)
                        .build();
        source.clear();

        assertThat(built.variables()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheMap_whenInputsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsPipelineTriggerPayload built =
                GitLabProjectProjectsPipelineTriggerPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload())
                        .inputs(source)
                        .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabProjectProjectsPipelineTriggerPayload value =
                ProjectsCatalogFixtures.projectProjectsPipelineTriggerPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsPipelineTriggerPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "variables", "inputs");
    }
}
