package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWebhooksUpdateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectWebhooksUpdateUrlVariableBuilder builder =
                GitLabProjectProjectWebhooksUpdateUrlVariableBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable())
                        .key(null);

        final GitLabProjectProjectWebhooksUpdateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectWebhooksUpdateUrlVariableBuilder builder =
                GitLabProjectProjectWebhooksUpdateUrlVariableBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable())
                        .value(null);

        final GitLabProjectProjectWebhooksUpdateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksUpdateUrlVariable value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksUpdateUrlVariable original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariable();

        final GitLabProjectProjectWebhooksUpdateUrlVariable rebuilt =
                GitLabProjectProjectWebhooksUpdateUrlVariableBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksUpdateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
