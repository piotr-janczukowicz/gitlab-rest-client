package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowUpdateRunTest {

    @Test
    void constructor_shouldAcceptNull_whenRunInfoIsNullable() {
        final GitLabMlMlflowUpdateRunBuilder builder = GitLabMlMlflowUpdateRunBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowUpdateRun())
                .runInfo(null);

        final GitLabMlMlflowUpdateRun built = builder.build();

        assertThat(built.runInfo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowUpdateRun value = ProjectsCatalogFixtures.mlMlflowUpdateRun();

        assertThat(value.runInfo()).isEqualTo(ProjectsCatalogFixtures.mlMlflowRunInfo());
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowUpdateRun original = ProjectsCatalogFixtures.mlMlflowUpdateRun();

        final GitLabMlMlflowUpdateRun rebuilt =
                GitLabMlMlflowUpdateRunBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowUpdateRun.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runInfo");
    }
}
