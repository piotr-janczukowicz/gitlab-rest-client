package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsMockCiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableSslVerificationIsNullable() {
        final GitLabGroupGroupIntegrationsMockCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload())
                        .enableSslVerification(null);

        final GitLabGroupGroupIntegrationsMockCiPayload built = builder.build();

        assertThat(built.enableSslVerification()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMockServiceUrlIsNullable() {
        final GitLabGroupGroupIntegrationsMockCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload())
                        .mockServiceUrl(null);

        final GitLabGroupGroupIntegrationsMockCiPayload built = builder.build();

        assertThat(built.mockServiceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPushEventsIsNullable() {
        final GitLabGroupGroupIntegrationsMockCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload())
                        .pushEvents(null);

        final GitLabGroupGroupIntegrationsMockCiPayload built = builder.build();

        assertThat(built.pushEvents()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsMockCiPayloadBuilder builder =
                GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsMockCiPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsMockCiPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.enableSslVerification()).isEqualTo(true);
            softly.assertThat(value.mockServiceUrl()).isEqualTo("mock_service_url");
            softly.assertThat(value.pushEvents()).isEqualTo(true);
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsMockCiPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsMockCiPayload();

        final GitLabGroupGroupIntegrationsMockCiPayload rebuilt =
                GitLabGroupGroupIntegrationsMockCiPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsMockCiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("enableSslVerification", "mockServiceUrl", "pushEvents", "useInheritedSettings");
    }
}
