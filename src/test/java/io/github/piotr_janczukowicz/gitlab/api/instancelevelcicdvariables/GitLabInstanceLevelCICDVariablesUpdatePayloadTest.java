package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceLevelCICDVariablesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .description(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .value(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .protectedValue(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .masked(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .raw(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload())
                        .variableType(null);

        final GitLabInstanceLevelCICDVariablesUpdatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceLevelCICDVariablesUpdatePayload value =
                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType())
                    .isEqualTo(GitLabInstanceLevelCICDVariablesUpdateVariableType.ENV_VAR);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceLevelCICDVariablesUpdatePayload original =
                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesUpdatePayload();

        final GitLabInstanceLevelCICDVariablesUpdatePayload rebuilt =
                GitLabInstanceLevelCICDVariablesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceLevelCICDVariablesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "value", "protectedValue", "masked", "raw", "variableType");
    }
}
