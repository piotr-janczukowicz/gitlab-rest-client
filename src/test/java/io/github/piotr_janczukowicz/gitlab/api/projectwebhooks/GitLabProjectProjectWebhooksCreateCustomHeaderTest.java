package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWebhooksCreateCustomHeaderTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectWebhooksCreateCustomHeaderBuilder builder =
                GitLabProjectProjectWebhooksCreateCustomHeaderBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader())
                        .key(null);

        final GitLabProjectProjectWebhooksCreateCustomHeader built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectWebhooksCreateCustomHeaderBuilder builder =
                GitLabProjectProjectWebhooksCreateCustomHeaderBuilder.builder(
                                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader())
                        .value(null);

        final GitLabProjectProjectWebhooksCreateCustomHeader built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWebhooksCreateCustomHeader value =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("X-Custom-Header");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWebhooksCreateCustomHeader original =
                ProjectwebhooksCatalogFixtures.projectProjectWebhooksCreateCustomHeader();

        final GitLabProjectProjectWebhooksCreateCustomHeader rebuilt =
                GitLabProjectProjectWebhooksCreateCustomHeaderBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWebhooksCreateCustomHeader.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
