package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMockMonitoringServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMockMonitoringServicePayloadBuilder builder =
                GitLabProjectIntegrationsMockMonitoringServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMockMonitoringServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMockMonitoringServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload();

        assertThat(value.useInheritedSettings()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsMockMonitoringServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMockMonitoringServicePayload();

        final GitLabProjectIntegrationsMockMonitoringServicePayload rebuilt =
                GitLabProjectIntegrationsMockMonitoringServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsMockMonitoringServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("useInheritedSettings");
    }
}
