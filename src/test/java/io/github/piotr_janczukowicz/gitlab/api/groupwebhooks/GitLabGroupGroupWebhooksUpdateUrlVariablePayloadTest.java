package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksUpdateUrlVariablePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupWebhooksUpdateUrlVariablePayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdateUrlVariablePayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload())
                        .value(null);

        final GitLabGroupGroupWebhooksUpdateUrlVariablePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksUpdateUrlVariablePayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksUpdateUrlVariablePayload original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateUrlVariablePayload();

        final GitLabGroupGroupWebhooksUpdateUrlVariablePayload rebuilt =
                GitLabGroupGroupWebhooksUpdateUrlVariablePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupWebhooksUpdateUrlVariablePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
