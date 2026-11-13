package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksCreateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSystemHooksCreateUrlVariableBuilder builder = GitLabSystemHooksCreateUrlVariableBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreateUrlVariable())
                .key(null);

        final GitLabSystemHooksCreateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksCreateUrlVariableBuilder builder = GitLabSystemHooksCreateUrlVariableBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreateUrlVariable())
                .value(null);

        final GitLabSystemHooksCreateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksCreateUrlVariable value = SystemhooksCatalogFixtures.systemHooksCreateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksCreateUrlVariable original = SystemhooksCatalogFixtures.systemHooksCreateUrlVariable();

        final GitLabSystemHooksCreateUrlVariable rebuilt =
                GitLabSystemHooksCreateUrlVariableBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksCreateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
