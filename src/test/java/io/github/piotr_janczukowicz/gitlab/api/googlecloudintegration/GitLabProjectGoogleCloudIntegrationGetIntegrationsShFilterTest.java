package io.github.piotr_janczukowicz.gitlab.api.googlecloudintegration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenEnableGoogleCloudArtifactRegistryIsNullable() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder builder =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder(
                                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                                        .enableGoogleCloudArtifactRegistry(true)
                                        .googleCloudArtifactRegistryProjectId("my-project-123")
                                        .build())
                        .enableGoogleCloudArtifactRegistry(null);

        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter built = builder.build();

        assertThat(built.enableGoogleCloudArtifactRegistry()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGoogleCloudArtifactRegistryProjectIdIsNullable() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder builder =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder(
                                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                                        .enableGoogleCloudArtifactRegistry(true)
                                        .googleCloudArtifactRegistryProjectId("my-project-123")
                                        .build())
                        .googleCloudArtifactRegistryProjectId(null);

        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter built = builder.build();

        assertThat(built.googleCloudArtifactRegistryProjectId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter value =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                        .enableGoogleCloudArtifactRegistry(true)
                        .googleCloudArtifactRegistryProjectId("my-project-123")
                        .build();

        assertSoftly(softly -> {
            softly.assertThat(value.enableGoogleCloudArtifactRegistry()).isEqualTo(true);
            softly.assertThat(value.googleCloudArtifactRegistryProjectId()).isEqualTo("my-project-123");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter original =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                        .enableGoogleCloudArtifactRegistry(true)
                        .googleCloudArtifactRegistryProjectId("my-project-123")
                        .build();

        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter rebuilt =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("enableGoogleCloudArtifactRegistry", "googleCloudArtifactRegistryProjectId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter empty =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter filter =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                        .enableGoogleCloudArtifactRegistry(true)
                        .googleCloudArtifactRegistryProjectId("my-project-123")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("enable_google_cloud_artifact_registry", "true"),
                        Map.entry("google_cloud_artifact_registry_project_id", "my-project-123"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter filter =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                        .enableGoogleCloudArtifactRegistry(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("enable_google_cloud_artifact_registry", "true"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilter filter =
                GitLabProjectGoogleCloudIntegrationGetIntegrationsShFilterBuilder.builder()
                        .enableGoogleCloudArtifactRegistry(true)
                        .googleCloudArtifactRegistryProjectId("my-project-123")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
