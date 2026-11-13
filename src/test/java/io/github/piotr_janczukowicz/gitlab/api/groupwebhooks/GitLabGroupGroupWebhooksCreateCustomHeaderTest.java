package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWebhooksCreateCustomHeaderTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGroupGroupWebhooksCreateCustomHeaderBuilder builder =
                GitLabGroupGroupWebhooksCreateCustomHeaderBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader())
                        .key(null);

        final GitLabGroupGroupWebhooksCreateCustomHeader built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupGroupWebhooksCreateCustomHeaderBuilder builder =
                GitLabGroupGroupWebhooksCreateCustomHeaderBuilder.builder(
                                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader())
                        .value(null);

        final GitLabGroupGroupWebhooksCreateCustomHeader built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWebhooksCreateCustomHeader value =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("X-Custom-Header");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWebhooksCreateCustomHeader original =
                GroupwebhooksCatalogFixtures.groupGroupWebhooksCreateCustomHeader();

        final GitLabGroupGroupWebhooksCreateCustomHeader rebuilt =
                GitLabGroupGroupWebhooksCreateCustomHeaderBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWebhooksCreateCustomHeader.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
