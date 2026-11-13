package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectLevelVariablesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .key(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .value(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .protectedValue(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .masked(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedAndHiddenIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .maskedAndHidden(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.maskedAndHidden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .raw(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .variableType(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .environmentScope(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectLevelVariablesCreatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload())
                        .description(null);

        final GitLabProjectProjectLevelVariablesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectLevelVariablesCreatePayload value =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.maskedAndHidden()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType())
                    .isEqualTo(GitLabProjectProjectLevelVariablesCreateVariableType.ENV_VAR);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectLevelVariablesCreatePayload original =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesCreatePayload();

        final GitLabProjectProjectLevelVariablesCreatePayload rebuilt =
                GitLabProjectProjectLevelVariablesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectLevelVariablesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "key",
                        "value",
                        "protectedValue",
                        "masked",
                        "maskedAndHidden",
                        "raw",
                        "variableType",
                        "environmentScope",
                        "description");
    }
}
