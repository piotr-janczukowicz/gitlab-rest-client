package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWebhooksUpdateUrlVariablePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectWebhooksUpdateUrlVariablePayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdateUrlVariablePayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariablePayload())
                        .value(null);

        final GitLabProjectProjectWebhooksUpdateUrlVariablePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksUpdateUrlVariablePayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariablePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksUpdateUrlVariablePayload original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateUrlVariablePayload();

        final GitLabProjectProjectWebhooksUpdateUrlVariablePayload rebuilt =
                GitLabProjectProjectWebhooksUpdateUrlVariablePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectWebhooksUpdateUrlVariablePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
