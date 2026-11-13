package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksUpdateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSystemHooksUpdateUrlVariableBuilder builder = GitLabSystemHooksUpdateUrlVariableBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable())
                .key(null);

        final GitLabSystemHooksUpdateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksUpdateUrlVariableBuilder builder = GitLabSystemHooksUpdateUrlVariableBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable())
                .value(null);

        final GitLabSystemHooksUpdateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksUpdateUrlVariable value = SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksUpdateUrlVariable original = SystemhooksCatalogFixtures.systemHooksUpdateUrlVariable();

        final GitLabSystemHooksUpdateUrlVariable rebuilt =
                GitLabSystemHooksUpdateUrlVariableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksUpdateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
