package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsJiraCloudAppPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppServiceIdsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppServiceIds(null);

        final GitLabGroupGroupIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppServiceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppEnableDeploymentGatingIsNullable() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppEnableDeploymentGating(null);

        final GitLabGroupGroupIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppEnableDeploymentGating()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppDeploymentGatingEnvironmentsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload())
                        .jiraCloudAppDeploymentGatingEnvironments(null);

        final GitLabGroupGroupIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.jiraCloudAppDeploymentGatingEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder builder =
                GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsJiraCloudAppPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.jiraCloudAppServiceIds()).isEqualTo("jira_cloud_app_service_ids");
            softly.assertThat(value.jiraCloudAppEnableDeploymentGating()).isEqualTo(true);
            softly.assertThat(value.jiraCloudAppDeploymentGatingEnvironments())
                    .isEqualTo("jira_cloud_app_deployment_gating_environments");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsJiraCloudAppPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsJiraCloudAppPayload();

        final GitLabGroupGroupIntegrationsJiraCloudAppPayload rebuilt =
                GitLabGroupGroupIntegrationsJiraCloudAppPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupIntegrationsJiraCloudAppPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "jiraCloudAppServiceIds",
                        "jiraCloudAppEnableDeploymentGating",
                        "jiraCloudAppDeploymentGatingEnvironments",
                        "useInheritedSettings");
    }
}
