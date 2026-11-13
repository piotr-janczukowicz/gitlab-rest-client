package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowGetExperimentTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIsNullable() {
        final GitLabMlMlflowGetExperimentBuilder builder = GitLabMlMlflowGetExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowGetExperiment())
                .experiment(null);

        final GitLabMlMlflowGetExperiment built = builder.build();

        assertThat(built.experiment()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowGetExperiment value = ProjectsCatalogFixtures.mlMlflowGetExperiment();

        assertThat(value.experiment()).isEqualTo(ProjectsCatalogFixtures.mlMlflowExperiment());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowGetExperiment original = ProjectsCatalogFixtures.mlMlflowGetExperiment();

        final GitLabMlMlflowGetExperiment rebuilt =
                GitLabMlMlflowGetExperimentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowGetExperiment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experiment");
    }
}
