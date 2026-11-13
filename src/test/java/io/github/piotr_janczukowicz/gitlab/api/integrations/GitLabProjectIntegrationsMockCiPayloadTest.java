package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsMockCiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabProjectIntegrationsMockCiPayloadBuilder builder =
                GitLabProjectIntegrationsMockCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload())
                        .enableSslVerification(null);

        final GitLabProjectIntegrationsMockCiPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMockServiceUrlIsNullable() {
        final GitLabProjectIntegrationsMockCiPayloadBuilder builder =
                GitLabProjectIntegrationsMockCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload())
                        .mockServiceUrl(null);

        final GitLabProjectIntegrationsMockCiPayload built = builder.build();

        assertThat(built.mockServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabProjectIntegrationsMockCiPayloadBuilder builder =
                GitLabProjectIntegrationsMockCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload())
                        .pushEvents(null);

        final GitLabProjectIntegrationsMockCiPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsMockCiPayloadBuilder builder =
                GitLabProjectIntegrationsMockCiPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsMockCiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsMockCiPayload value =
                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.mockServiceUrl()).isEqualTo("mock_service_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIntegrationsMockCiPayload original =
                IntegrationsCatalogFixtures.projectIntegrationsMockCiPayload();

        final GitLabProjectIntegrationsMockCiPayload rebuilt =
                GitLabProjectIntegrationsMockCiPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIntegrationsMockCiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("enableSslVerification", "mockServiceUrl", "pushEvents", "useInheritedSettings");
    }
}
