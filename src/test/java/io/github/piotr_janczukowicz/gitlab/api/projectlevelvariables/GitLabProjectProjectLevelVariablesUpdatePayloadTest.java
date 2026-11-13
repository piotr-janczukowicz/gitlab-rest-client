package io.github.piotr_janczukowicz.gitlab.api.projectlevelvariables;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectLevelVariablesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .value(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .protectedValue(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .masked(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .environmentScope(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .raw(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .variableType(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilterIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .filter(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.filter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectLevelVariablesUpdatePayloadBuilder builder =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(
                                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload())
                        .description(null);

        final GitLabProjectProjectLevelVariablesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectLevelVariablesUpdatePayload value =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.value()).isEqualTo("value");
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.variableType())
                    .isEqualTo(GitLabProjectProjectLevelVariablesUpdateVariableType.ENV_VAR);
            softly.assertThat(value.filter())
                    .isEqualTo(ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdateFilter());
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectLevelVariablesUpdatePayload original =
                ProjectlevelvariablesCatalogFixtures.projectProjectLevelVariablesUpdatePayload();

        final GitLabProjectProjectLevelVariablesUpdatePayload rebuilt =
                GitLabProjectProjectLevelVariablesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectLevelVariablesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "value",
                        "protectedValue",
                        "masked",
                        "environmentScope",
                        "raw",
                        "variableType",
                        "filter",
                        "description");
    }
}
