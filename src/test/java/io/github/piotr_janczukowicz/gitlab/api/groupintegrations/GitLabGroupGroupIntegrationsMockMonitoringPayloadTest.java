package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsMockMonitoringPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsMockMonitoringPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMockMonitoringPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsMockMonitoringPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsMockMonitoringPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload();

        assertThat(value.useInheritedSettings()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsMockMonitoringPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockMonitoringPayload();

        final GitLabGroupGroupIntegrationsMockMonitoringPayload rebuilt =
                GitLabGroupGroupIntegrationsMockMonitoringPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsMockMonitoringPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("useInheritedSettings");
    }
}
