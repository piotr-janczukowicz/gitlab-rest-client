package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenVariableTypeIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .variableType(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.variableType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .key(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .value(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHiddenIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .hidden(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.hidden()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .protectedValue(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaskedIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .masked(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.masked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .raw(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .environmentScope(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCiVariableBuilder builder = GitLabCiVariableBuilder.builder(CommonCatalogFixtures.ciVariable())
                .description(null);

        final GitLabCiVariable built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiVariable value = CommonCatalogFixtures.ciVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.variableType()).isEqualTo("env_var");
            softly.assertThat(value.key()).isEqualTo("TEST_VARIABLE_1");
            softly.assertThat(value.value()).isEqualTo("TEST_1");
            softly.assertThat(value.hidden()).isEqualTo(true);
            softly.assertThat(value.protectedValue()).isEqualTo(true);
            softly.assertThat(value.masked()).isEqualTo(true);
            softly.assertThat(value.raw()).isEqualTo(true);
            softly.assertThat(value.environmentScope()).isEqualTo("*");
            softly.assertThat(value.description()).isEqualTo("This variable is being used for ...");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiVariable original = CommonCatalogFixtures.ciVariable();

        final GitLabCiVariable rebuilt =
                GitLabCiVariableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "variableType",
                        "key",
                        "value",
                        "hidden",
                        "protectedValue",
                        "masked",
                        "raw",
                        "environmentScope",
                        "description");
    }
}
