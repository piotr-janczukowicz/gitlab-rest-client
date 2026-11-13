package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectIdIsNullable() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectId(null);

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityFederationProjectNumberIsNullable() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityFederationProjectNumber(null);

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityFederationProjectNumber()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolIdIsNullable() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolId(null);

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkloadIdentityPoolProviderIdIsNullable() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload())
                        .workloadIdentityPoolProviderId(null);

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.workloadIdentityPoolProviderId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder builder =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload value =
                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload();

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
        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload original =
                GroupintegrationsCatalogFixtures.groupGoogleCloudWorkloadIdentityFederationPayload();

        final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload rebuilt =
                GitLabGroupGoogleCloudWorkloadIdentityFederationPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGoogleCloudWorkloadIdentityFederationPayload.class.getRecordComponents())
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
