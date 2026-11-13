package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowRunTest {

    @Test
    void constructor_shouldAcceptNull_whenInfoIsNullable() {
        final GitLabMlMlflowRunBuilder builder = GitLabMlMlflowRunBuilder.builder(ProjectsCatalogFixtures.mlMlflowRun())
                .info(null);

        final GitLabMlMlflowRun built = builder.build();

        assertThat(built.info()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabMlMlflowRunBuilder builder = GitLabMlMlflowRunBuilder.builder(ProjectsCatalogFixtures.mlMlflowRun())
                .data(null);

        final GitLabMlMlflowRun built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowRun value = ProjectsCatalogFixtures.mlMlflowRun();

        assertSoftly(softly -> {
            softly.assertThat(value.info()).isEqualTo(ProjectsCatalogFixtures.mlMlflowRunInfo());
            softly.assertThat(value.data()).isEqualTo(ProjectsCatalogFixtures.mlMlflowRunData());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowRun original = ProjectsCatalogFixtures.mlMlflowRun();

        final GitLabMlMlflowRun rebuilt =
                GitLabMlMlflowRunBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowRun.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("info", "data");
    }
}
