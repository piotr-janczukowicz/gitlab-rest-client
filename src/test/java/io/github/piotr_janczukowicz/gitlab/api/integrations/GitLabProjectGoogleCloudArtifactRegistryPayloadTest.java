package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectGoogleCloudArtifactRegistryPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryProjectIdIsNullable() {
        final GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryProjectId(null);

        final GitLabProjectGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryRepositoriesIsNullable() {
        final GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryRepositories(null);

        final GitLabProjectGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryRepositories()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryLocationIsNullable() {
        final GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryLocation(null);

        final GitLabProjectGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryLocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload())
                        .useInheritedSettings(null);

        final GitLabProjectGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectGoogleCloudArtifactRegistryPayload value =
                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.artifactRegistryProjectId()).isEqualTo("artifact_registry_project_id");
            softly.assertThat(value.artifactRegistryRepositories()).isEqualTo("artifact_registry_repositories");
            softly.assertThat(value.artifactRegistryLocation()).isEqualTo("artifact_registry_location");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectGoogleCloudArtifactRegistryPayload original =
                IntegrationsCatalogFixtures.projectGoogleCloudArtifactRegistryPayload();

        final GitLabProjectGoogleCloudArtifactRegistryPayload rebuilt =
                GitLabProjectGoogleCloudArtifactRegistryPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectGoogleCloudArtifactRegistryPayload.class.getRecordComponents())
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
