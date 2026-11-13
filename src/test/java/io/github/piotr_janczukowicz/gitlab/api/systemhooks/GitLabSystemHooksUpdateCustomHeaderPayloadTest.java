package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksUpdateCustomHeaderPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksUpdateCustomHeaderPayloadBuilder builder =
                GitLabSystemHooksUpdateCustomHeaderPayloadBuilder.builder(
                                SystemhooksCatalogFixtures.systemHooksUpdateCustomHeaderPayload())
                        .value(null);

        final GitLabSystemHooksUpdateCustomHeaderPayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksUpdateCustomHeaderPayload value =
                SystemhooksCatalogFixtures.systemHooksUpdateCustomHeaderPayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksUpdateCustomHeaderPayload original =
                SystemhooksCatalogFixtures.systemHooksUpdateCustomHeaderPayload();

        final GitLabSystemHooksUpdateCustomHeaderPayload rebuilt =
                GitLabSystemHooksUpdateCustomHeaderPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksUpdateCustomHeaderPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
