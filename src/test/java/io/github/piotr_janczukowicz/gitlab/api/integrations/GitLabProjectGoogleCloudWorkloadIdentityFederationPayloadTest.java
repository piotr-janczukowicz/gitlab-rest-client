package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectIdIsNullable() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectId(null);

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectNumberIsNullable() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectNumber(null);

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolIdIsNullable() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolId(null);

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolProviderIdIsNullable() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolProviderId(null);

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolProviderId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload())
                        .useInheritedSettings(null);

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload value =
                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.workloadIdentityFederationProjectId())
                    .isEqualTo("workload_identity_federation_project_id");
            softly.assertThat(value.workloadIdentityFederationProjectNumber())
                    .isEqualTo("workload_identity_federation_project_number");
            softly.assertThat(value.workloadIdentityPoolId()).isEqualTo("workload_identity_pool_id");
            softly.assertThat(value.workloadIdentityPoolProviderId()).isEqualTo("workload_identity_pool_provider_id");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload original =
                IntegrationsCatalogFixtures.projectGoogleCloudWorkloadIdentityFederationPayload();

        final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload rebuilt =
                GitLabProjectGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectGoogleCloudWorkloadIdentityFederationPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "workloadIdentityFederationProjectId",
                        "workloadIdentityFederationProjectNumber",
                        "workloadIdentityPoolId",
                        "workloadIdentityPoolProviderId",
                        "useInheritedSettings");
    }
}
