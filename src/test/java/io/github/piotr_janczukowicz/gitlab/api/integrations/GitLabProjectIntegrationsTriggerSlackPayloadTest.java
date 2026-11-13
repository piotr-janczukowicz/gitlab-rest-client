package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsTriggerSlackPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTextIsNullable() {
        final GitLabProjectIntegrationsTriggerSlackPayloadBuilder builder =
                GitLabProjectIntegrationsTriggerSlackPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload())
                        .text(null);

        final GitLabProjectIntegrationsTriggerSlackPayload built = builder.build();

        assertThat(built.text()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsTriggerSlackPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload();

        assertThat(value.text()).isEqualTo("text");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsTriggerSlackPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsTriggerSlackPayload();

        final GitLabProjectIntegrationsTriggerSlackPayload rebuilt =
                GitLabProjectIntegrationsTriggerSlackPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsTriggerSlackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("text");
    }
}
