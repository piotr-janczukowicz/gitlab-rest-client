package io.github.piotr_janczukowicz.gitlab.api.instancelevelcicdvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceLevelCICDVariablesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .key(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .description(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .value(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .protectedValue(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .masked(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .raw(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabInstanceLevelCICDVariablesCreatePayloadBuilder builder =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(
                                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload())
                        .variableType(null);

        final GitLabInstanceLevelCICDVariablesCreatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceLevelCICDVariablesCreatePayload value =
                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType())
                    .isEqualTo(GitLabInstanceLevelCICDVariablesCreateVariableType.ENV_VAR);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceLevelCICDVariablesCreatePayload original =
                InstancelevelcicdvariablesCatalogFixtures.instanceLevelCICDVariablesCreatePayload();

        final GitLabInstanceLevelCICDVariablesCreatePayload rebuilt =
                GitLabInstanceLevelCICDVariablesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceLevelCICDVariablesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("key", "description", "value", "protectedValue", "masked", "raw", "variableType");
    }
}
