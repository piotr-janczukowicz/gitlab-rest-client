package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGoogleCloudArtifactRegistryPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryProjectIdIsNullable() {
        final GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryProjectId(null);

        final GitLabGroupGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryRepositoriesIsNullable() {
        final GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryRepositories(null);

        final GitLabGroupGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryRepositories()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactRegistryLocationIsNullable() {
        final GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload())
                        .artifactRegistryLocation(null);

        final GitLabGroupGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.artifactRegistryLocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder builder =
                GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGoogleCloudArtifactRegistryPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGoogleCloudArtifactRegistryPayload value =
                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.artifactRegistryProjectId()).isEqualTo("artifact_registry_project_id");
            softly.assertThat(value.artifactRegistryRepositories()).isEqualTo("artifact_registry_repositories");
            softly.assertThat(value.artifactRegistryLocation()).isEqualTo("artifact_registry_location");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGoogleCloudArtifactRegistryPayload original =
                GroupintegrationsCatalogFixtures.groupGoogleCloudArtifactRegistryPayload();

        final GitLabGroupGoogleCloudArtifactRegistryPayload rebuilt =
                GitLabGroupGoogleCloudArtifactRegistryPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGoogleCloudArtifactRegistryPayload.class.getRecordComponents())
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
