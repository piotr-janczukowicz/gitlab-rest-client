package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMockMonitoringPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMockMonitoringPayloadBuilder builder =
                GitLabProjectIntegrationsMockMonitoringPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMockMonitoringPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMockMonitoringPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload();

        assertThat(value.useInheritedSettings()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsMockMonitoringPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringPayload();

        final GitLabProjectIntegrationsMockMonitoringPayload rebuilt =
                GitLabProjectIntegrationsMockMonitoringPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMockMonitoringPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("useInheritedSettings");
    }
}
