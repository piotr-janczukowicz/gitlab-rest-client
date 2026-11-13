package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectIdIsNullable() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectServiceGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectId(null);

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectNumberIsNullable() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectServiceGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectNumber(null);

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolIdIsNullable() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectServiceGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolId(null);

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolProviderIdIsNullable() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectServiceGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolProviderId(null);

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolProviderId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                IntegrationsCatalogFixtures
                                        .projectServiceGoogleCloudWorkloadIdentityFederationPayload())
                        .useInheritedSettings(null);

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload value =
                IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload();

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
        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload original =
                IntegrationsCatalogFixtures.projectServiceGoogleCloudWorkloadIdentityFederationPayload();

        final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload rebuilt =
                GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload.class.getRecordComponents())
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
