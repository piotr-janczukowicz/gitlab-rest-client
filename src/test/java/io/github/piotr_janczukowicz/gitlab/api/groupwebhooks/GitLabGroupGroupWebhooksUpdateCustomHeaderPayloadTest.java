package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksUpdateCustomHeaderPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupWebhooksUpdateCustomHeaderPayloadBuilder builder =
                GitLabGroupGroupWebhooksUpdateCustomHeaderPayloadBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload())
                        .value(null);

        final GitLabGroupGroupWebhooksUpdateCustomHeaderPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksUpdateCustomHeaderPayload value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksUpdateCustomHeaderPayload original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksUpdateCustomHeaderPayload();

        final GitLabGroupGroupWebhooksUpdateCustomHeaderPayload rebuilt =
                GitLabGroupGroupWebhooksUpdateCustomHeaderPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupWebhooksUpdateCustomHeaderPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
