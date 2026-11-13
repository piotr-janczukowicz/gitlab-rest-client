package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowGetDownloadTest {

    @Test
    void constructor_shouldAcceptNull_whenArtifactUriIsNullable() {
        final GitLabMlMlflowGetDownloadBuilder builder = GitLabMlMlflowGetDownloadBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowGetDownload())
                .artifactUri(null);

        final GitLabMlMlflowGetDownload built = builder.build();

        assertThat(built.artifactUri()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowGetDownload value = ProjectsCatalogFixtures.mlMlflowGetDownload();

        assertThat(value.artifactUri()).isEqualTo("artifact_uri");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowGetDownload original = ProjectsCatalogFixtures.mlMlflowGetDownload();

        final GitLabMlMlflowGetDownload rebuilt =
                GitLabMlMlflowGetDownloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowGetDownload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("artifactUri");
    }
}
