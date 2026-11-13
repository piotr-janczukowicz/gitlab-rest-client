package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIntegrationsJiraCloudAppServicePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppServiceIdsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload())
                        .jiraCloudAppServiceIds(null);

        final GitLabProjectIntegrationsJiraCloudAppServicePayload built = builder.build();

        assertThat(built.jiraCloudAppServiceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppEnableDeploymentGatingIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload())
                        .jiraCloudAppEnableDeploymentGating(null);

        final GitLabProjectIntegrationsJiraCloudAppServicePayload built = builder.build();

        assertThat(built.jiraCloudAppEnableDeploymentGating()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJiraCloudAppDeploymentGatingEnvironmentsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload())
                        .jiraCloudAppDeploymentGatingEnvironments(null);

        final GitLabProjectIntegrationsJiraCloudAppServicePayload built = builder.build();

        assertThat(built.jiraCloudAppDeploymentGatingEnvironments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder builder =
                GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload())
                        .useInheritedSettings(null);

        final GitLabProjectIntegrationsJiraCloudAppServicePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIntegrationsJiraCloudAppServicePayload value =
                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload();

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
        final GitLabProjectIntegrationsJiraCloudAppServicePayload original =
                IntegrationsCatalogFixtures.projectIntegrationsJiraCloudAppServicePayload();

        final GitLabProjectIntegrationsJiraCloudAppServicePayload rebuilt =
                GitLabProjectIntegrationsJiraCloudAppServicePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectIntegrationsJiraCloudAppServicePayload.class.getRecordComponents())
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
