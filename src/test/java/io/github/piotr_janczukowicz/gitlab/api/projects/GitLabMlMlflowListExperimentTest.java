package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowListExperimentTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentsIsNullable() {
        final GitLabMlMlflowListExperimentBuilder builder = GitLabMlMlflowListExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowListExperiment())
                .experiments(null);

        final GitLabMlMlflowListExperiment built = builder.build();

        assertThat(built.experiments()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNextPageTokenIsNullable() {
        final GitLabMlMlflowListExperimentBuilder builder = GitLabMlMlflowListExperimentBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowListExperiment())
                .nextPageToken(null);

        final GitLabMlMlflowListExperiment built = builder.build();

        assertThat(built.nextPageToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowListExperiment value = ProjectsCatalogFixtures.mlMlflowListExperiment();

        assertSoftly(softly -> {
            softly.assertThat(value.experiments()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowExperiment()));
            softly.assertThat(value.nextPageToken()).isEqualTo("next_page_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowListExperiment original = ProjectsCatalogFixtures.mlMlflowListExperiment();

        final GitLabMlMlflowListExperiment rebuilt =
                GitLabMlMlflowListExperimentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenNextPageTokenIsACredential() {
        final GitLabMlMlflowListExperiment value = ProjectsCatalogFixtures.mlMlflowListExperiment();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowListExperiment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experiments", "nextPageToken");
    }
}
