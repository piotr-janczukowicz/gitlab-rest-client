package io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLevelVariablesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .value(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .protectedValue(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .masked(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .raw(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .variableType(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .environmentScope(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupLevelVariablesUpdatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload())
                        .description(null);

        final GitLabGroupGroupLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLevelVariablesUpdatePayload value =
                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType()).isEqualTo(GitLabGroupGroupLevelVariablesUpdateVariableType.ENV_VAR);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLevelVariablesUpdatePayload original =
                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesUpdatePayload();

        final GitLabGroupGroupLevelVariablesUpdatePayload rebuilt =
                GitLabGroupGroupLevelVariablesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLevelVariablesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "value", "protectedValue", "masked", "raw", "variableType", "environmentScope", "description");
    }
}
