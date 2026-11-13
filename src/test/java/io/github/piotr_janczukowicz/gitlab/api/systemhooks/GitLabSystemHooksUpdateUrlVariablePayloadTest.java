package io.github.piotr_janczukowicz.gitlab.api.systemhooks;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSystemHooksUpdateUrlVariablePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabSystemHooksUpdateUrlVariablePayloadBuilder builder =
                GitLabSystemHooksUpdateUrlVariablePayloadBuilder.builder(
                                SystemhooksCatalogFixtures.systemHooksUpdateUrlVariablePayload())
                        .value(null);

        final GitLabSystemHooksUpdateUrlVariablePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSystemHooksUpdateUrlVariablePayload value =
                SystemhooksCatalogFixtures.systemHooksUpdateUrlVariablePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSystemHooksUpdateUrlVariablePayload original =
                SystemhooksCatalogFixtures.systemHooksUpdateUrlVariablePayload();

        final GitLabSystemHooksUpdateUrlVariablePayload rebuilt =
                GitLabSystemHooksUpdateUrlVariablePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSystemHooksUpdateUrlVariablePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
