package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowNewExperimentTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIdIsNullable() {
        final GitLabMlMlflowNewExperimentBuilder builder = GitLabMlMlflowNewExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowNewExperiment())
                .experimentId(null);

        final GitLabMlMlflowNewExperiment built = builder.build();

        assertThat(built.experimentId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowNewExperiment value = ProjectsCatalogFixtures.mlMlflowNewExperiment();

        assertThat(value.experimentId()).isEqualTo("1");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowNewExperiment original = ProjectsCatalogFixtures.mlMlflowNewExperiment();

        final GitLabMlMlflowNewExperiment rebuilt =
                GitLabMlMlflowNewExperimentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowNewExperiment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experimentId");
    }
}
