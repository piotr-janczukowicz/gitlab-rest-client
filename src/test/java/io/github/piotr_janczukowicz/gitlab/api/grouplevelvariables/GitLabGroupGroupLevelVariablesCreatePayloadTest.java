package io.github.piotr_janczukowicz.gitlab.api.grouplevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLevelVariablesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .key(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .value(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .protectedValue(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedAndHiddenIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .maskedAndHidden(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.maskedAndHidden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .masked(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .raw(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .variableType(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .environmentScope(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupLevelVariablesCreatePayloadBuilder builder =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(
                                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload())
                        .description(null);

        final GitLabGroupGroupLevelVariablesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLevelVariablesCreatePayload value =
                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.maskedAndHidden()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType()).isEqualTo(GitLabGroupGroupLevelVariablesCreateVariableType.ENV_VAR);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLevelVariablesCreatePayload original =
                GrouplevelvariablesCatalogFixtures.groupGroupLevelVariablesCreatePayload();

        final GitLabGroupGroupLevelVariablesCreatePayload rebuilt =
                GitLabGroupGroupLevelVariablesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLevelVariablesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "key",
                        "value",
                        "protectedValue",
                        "maskedAndHidden",
                        "masked",
                        "raw",
                        "variableType",
                        "environmentScope",
                        "description");
    }
}
