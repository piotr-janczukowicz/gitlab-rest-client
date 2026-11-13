package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWebhooksUpdateCustomHeaderPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectWebhooksUpdateCustomHeaderPayloadBuilder builder =
                GitLabProjectProjectWebhooksUpdateCustomHeaderPayloadBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeaderPayload())
                        .value(null);

        final GitLabProjectProjectWebhooksUpdateCustomHeaderPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksUpdateCustomHeaderPayload value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeaderPayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksUpdateCustomHeaderPayload original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksUpdateCustomHeaderPayload();

        final GitLabProjectProjectWebhooksUpdateCustomHeaderPayload rebuilt =
                GitLabProjectProjectWebhooksUpdateCustomHeaderPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectWebhooksUpdateCustomHeaderPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
