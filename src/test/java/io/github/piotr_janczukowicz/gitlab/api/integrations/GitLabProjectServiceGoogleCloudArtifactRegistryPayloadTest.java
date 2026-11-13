package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectServiceGoogleCloudArtifactRegistryPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryProjectIdIsNullable() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryProjectId(null);

        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryRepositoriesIsNullable() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryRepositories(null);

        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryRepositories()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryLocationIsNullable() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryLocation(null);

        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryLocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload())
                        .useInheritedSettings(null);

        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload value =
                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.artifactRegistryProjectId()).isEqualTo("artifact_registry_project_id");
            softly.assertThat(value.artifactRegistryRepositories()).isEqualTo("artifact_registry_repositories");
            softly.assertThat(value.artifactRegistryLocation()).isEqualTo("artifact_registry_location");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload original =
                IntegrationsCatalogFixtures.projectServiceGoogleCloudArtifactRegistryPayload();

        final GitLabProjectServiceGoogleCloudArtifactRegistryPayload rebuilt =
                GitLabProjectServiceGoogleCloudArtifactRegistryPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectServiceGoogleCloudArtifactRegistryPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "artifactRegistryProjectId",
                        "artifactRegistryRepositories",
                        "artifactRegistryLocation",
                        "useInheritedSettings");
    }
}
