package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksCreateCustomHeaderTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabSystemHooksCreateCustomHeaderBuilder builder = GitLabSystemHooksCreateCustomHeaderBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreateCustomHeader())
                .key(null);

        final GitLabSystemHooksCreateCustomHeader built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksCreateCustomHeaderBuilder builder = GitLabSystemHooksCreateCustomHeaderBuilder.builder(
                        SystemhooksCatalogFixtures.systemHooksCreateCustomHeader())
                .value(null);

        final GitLabSystemHooksCreateCustomHeader built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksCreateCustomHeader value = SystemhooksCatalogFixtures.systemHooksCreateCustomHeader();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("X-Custom-Header");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksCreateCustomHeader original = SystemhooksCatalogFixtures.systemHooksCreateCustomHeader();

        final GitLabSystemHooksCreateCustomHeader rebuilt =
                GitLabSystemHooksCreateCustomHeaderBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksCreateCustomHeader.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
