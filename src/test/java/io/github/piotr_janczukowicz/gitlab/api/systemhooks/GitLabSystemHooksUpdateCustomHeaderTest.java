package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksUpdateCustomHeaderTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSystemHooksUpdateCustomHeaderBuilder builder = GitLabSystemHooksUpdateCustomHeaderBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader())
                .key(null);

        final GitLabSystemHooksUpdateCustomHeader built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksUpdateCustomHeaderBuilder builder = GitLabSystemHooksUpdateCustomHeaderBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader())
                .value(null);

        final GitLabSystemHooksUpdateCustomHeader built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksUpdateCustomHeader value = SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("X-Custom-Header");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksUpdateCustomHeader original = SystemhooksCatalogFixtures.systemHooksUpdateCustomHeader();

        final GitLabSystemHooksUpdateCustomHeader rebuilt =
                GitLabSystemHooksUpdateCustomHeaderBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksUpdateCustomHeader.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
