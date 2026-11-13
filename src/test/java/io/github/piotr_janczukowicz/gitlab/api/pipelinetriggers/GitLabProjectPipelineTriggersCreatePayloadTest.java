package io.github.piotr_janczukowicz.gitlab.api.pipelinetriggers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelineTriggersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectPipelineTriggersCreatePayloadBuilder builder =
                GitLabProjectPipelineTriggersCreatePayloadBuilder.builder(
                                PipelinetriggersCatalogFixtures.projectPipelineTriggersCreatePayload())
                        .description(null);

        final GitLabProjectPipelineTriggersCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabProjectPipelineTriggersCreatePayloadBuilder builder =
                GitLabProjectPipelineTriggersCreatePayloadBuilder.builder(
                                PipelinetriggersCatalogFixtures.projectPipelineTriggersCreatePayload())
                        .expiresAt(null);

        final GitLabProjectPipelineTriggersCreatePayload built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelineTriggersCreatePayload value =
                PipelinetriggersCatalogFixtures.projectPipelineTriggersCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("my trigger token description");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelineTriggersCreatePayload original =
                PipelinetriggersCatalogFixtures.projectPipelineTriggersCreatePayload();

        final GitLabProjectPipelineTriggersCreatePayload rebuilt =
                GitLabProjectPipelineTriggersCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelineTriggersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "expiresAt");
    }
}
