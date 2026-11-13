package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExperimentCurrentStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabExperimentCurrentStatusBuilder builder = GitLabExperimentCurrentStatusBuilder.builder(
                        ExperimentsCatalogFixtures.experimentCurrentStatus())
                .state(null);

        final GitLabExperimentCurrentStatus built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGatesIsNullable() {
        final GitLabExperimentCurrentStatusBuilder builder = GitLabExperimentCurrentStatusBuilder.builder(
                        ExperimentsCatalogFixtures.experimentCurrentStatus())
                .gates(null);

        final GitLabExperimentCurrentStatus built = builder.build();

        assertThat(built.gates()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperimentCurrentStatus value = ExperimentsCatalogFixtures.experimentCurrentStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo("on");
            softly.assertThat(value.gates()).isEqualTo(CommonCatalogFixtures.featureGate());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperimentCurrentStatus original = ExperimentsCatalogFixtures.experimentCurrentStatus();

        final GitLabExperimentCurrentStatus rebuilt =
                GitLabExperimentCurrentStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperimentCurrentStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("state", "gates");
    }
}
