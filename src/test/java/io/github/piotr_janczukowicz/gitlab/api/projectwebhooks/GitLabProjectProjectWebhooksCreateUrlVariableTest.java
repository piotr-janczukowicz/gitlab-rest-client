package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWebhooksCreateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectWebhooksCreateUrlVariableBuilder builder =
                GitLabProjectProjectWebhooksCreateUrlVariableBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable())
                        .key(null);

        final GitLabProjectProjectWebhooksCreateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectWebhooksCreateUrlVariableBuilder builder =
                GitLabProjectProjectWebhooksCreateUrlVariableBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable())
                        .value(null);

        final GitLabProjectProjectWebhooksCreateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksCreateUrlVariable value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksCreateUrlVariable original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateUrlVariable();

        final GitLabProjectProjectWebhooksCreateUrlVariable rebuilt =
                GitLabProjectProjectWebhooksCreateUrlVariableBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksCreateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
