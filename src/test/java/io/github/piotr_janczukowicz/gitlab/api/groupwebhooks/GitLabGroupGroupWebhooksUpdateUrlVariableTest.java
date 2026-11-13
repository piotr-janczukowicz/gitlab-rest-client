package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksUpdateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGroupGroupWebhooksUpdateUrlVariableBuilder builder =
                GitLabGroupGroupWebhooksUpdateUrlVariableBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable())
                        .key(null);

        final GitLabGroupGroupWebhooksUpdateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupWebhooksUpdateUrlVariableBuilder builder =
                GitLabGroupGroupWebhooksUpdateUrlVariableBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable())
                        .value(null);

        final GitLabGroupGroupWebhooksUpdateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksUpdateUrlVariable value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksUpdateUrlVariable original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariable();

        final GitLabGroupGroupWebhooksUpdateUrlVariable rebuilt =
                GitLabGroupGroupWebhooksUpdateUrlVariableBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksUpdateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
