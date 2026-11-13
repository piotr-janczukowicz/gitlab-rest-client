package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowExperimentTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabMlMlflowExperimentBuilder builder = GitLabMlMlflowExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowExperiment())
                .experimentId(null);

        final GitLabMlMlflowExperiment built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMlMlflowExperimentBuilder builder = GitLabMlMlflowExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowExperiment())
                .name(null);

        final GitLabMlMlflowExperiment built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLifecycleStageIsNullable() {
        final GitLabMlMlflowExperimentBuilder builder = GitLabMlMlflowExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowExperiment())
                .lifecycleStage(null);

        final GitLabMlMlflowExperiment built = builder.build();

        assertThat(built.lifecycleStage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactLocationIsNullable() {
        final GitLabMlMlflowExperimentBuilder builder = GitLabMlMlflowExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowExperiment())
                .artifactLocation(null);

        final GitLabMlMlflowExperiment built = builder.build();

        assertThat(built.artifactLocation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabMlMlflowExperimentBuilder builder = GitLabMlMlflowExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowExperiment())
                .tags(null);

        final GitLabMlMlflowExperiment built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowExperiment value = ProjectsCatalogFixtures.mlMlflowExperiment();

        assertSoftly(softly -> {
            softly.assertThat(value.experimentId()).isEqualTo("1");
            softly.assertThat(value.name()).isEqualTo("my_experiment");
            softly.assertThat(value.lifecycleStage()).isEqualTo("active");
            softly.assertThat(value.artifactLocation()).isEqualTo("artifact_location");
            softly.assertThat(value.tags()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowExperiment original = ProjectsCatalogFixtures.mlMlflowExperiment();

        final GitLabMlMlflowExperiment rebuilt =
                GitLabMlMlflowExperimentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowExperiment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId", "name", "lifecycleStage", "artifactLocation", "tags");
    }
}
