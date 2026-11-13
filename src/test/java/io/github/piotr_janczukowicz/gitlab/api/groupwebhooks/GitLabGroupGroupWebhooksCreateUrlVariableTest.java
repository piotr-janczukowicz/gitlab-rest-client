package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksCreateUrlVariableTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGroupGroupWebhooksCreateUrlVariableBuilder builder =
                GitLabGroupGroupWebhooksCreateUrlVariableBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable())
                        .key(null);

        final GitLabGroupGroupWebhooksCreateUrlVariable built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupWebhooksCreateUrlVariableBuilder builder =
                GitLabGroupGroupWebhooksCreateUrlVariableBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable())
                        .value(null);

        final GitLabGroupGroupWebhooksCreateUrlVariable built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksCreateUrlVariable value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("token");
            softly.assertThat(value.value()).isEqualTo("123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksCreateUrlVariable original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateUrlVariable();

        final GitLabGroupGroupWebhooksCreateUrlVariable rebuilt =
                GitLabGroupGroupWebhooksCreateUrlVariableBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksCreateUrlVariable.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
