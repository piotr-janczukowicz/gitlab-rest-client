package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMockCiServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsMockCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsMockCiServicePayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMockServiceUrlIsNullable() {
        final GitLabProjectIntegrationsMockCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload())
                        .mockServiceUrl(null);

        final GitLabProjectIntegrationsMockCiServicePayload built = builder.build();

        assertThat(built.mockServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMockCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMockCiServicePayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMockCiServicePayloadBuilder builder =
                GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMockCiServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMockCiServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.mockServiceUrl()).isEqualTo("mock_service_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsMockCiServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMockCiServicePayload();

        final GitLabProjectIntegrationsMockCiServicePayload rebuilt =
                GitLabProjectIntegrationsMockCiServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMockCiServicePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("enableSslVerification", "mockServiceUrl", "pushEvents", "useInheritedSettings");
    }
}
