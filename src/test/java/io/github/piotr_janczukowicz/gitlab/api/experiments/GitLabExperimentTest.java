package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExperimentTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabExperimentBuilder builder = GitLabExperimentBuilder.builder(ExperimentsCatalogFixtures.experiment())
                .key(null);

        final GitLabExperiment built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextIsNullable() {
        final GitLabExperimentBuilder builder = GitLabExperimentBuilder.builder(ExperimentsCatalogFixtures.experiment())
                .context(null);

        final GitLabExperiment built = builder.build();

        assertThat(built.context()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefinitionIsNullable() {
        final GitLabExperimentBuilder builder = GitLabExperimentBuilder.builder(ExperimentsCatalogFixtures.experiment())
                .definition(null);

        final GitLabExperiment built = builder.build();

        assertThat(built.definition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCurrentStatusIsNullable() {
        final GitLabExperimentBuilder builder = GitLabExperimentBuilder.builder(ExperimentsCatalogFixtures.experiment())
                .currentStatus(null);

        final GitLabExperiment built = builder.build();

        assertThat(built.currentStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperiment value = ExperimentsCatalogFixtures.experiment();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("code_quality_walkthrough");
            softly.assertThat(value.context()).isEqualTo(List.of("user"));
            softly.assertThat(value.definition()).isEqualTo(CommonCatalogFixtures.featureDefinition());
            softly.assertThat(value.currentStatus()).isEqualTo(ExperimentsCatalogFixtures.experimentCurrentStatus());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperiment original = ExperimentsCatalogFixtures.experiment();

        final GitLabExperiment rebuilt =
                GitLabExperimentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperiment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "context", "definition", "currentStatus");
    }
}
