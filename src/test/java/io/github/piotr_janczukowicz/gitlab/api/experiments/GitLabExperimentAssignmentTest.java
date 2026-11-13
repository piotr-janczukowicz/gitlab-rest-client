package io.github.piotr_janczukowicz.gitlab.api.experiments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabExperimentAssignmentTest {

    @Test
    void constructor_shouldAcceptNull_whenExperimentIsNullable() {
        final GitLabExperimentAssignmentBuilder builder = GitLabExperimentAssignmentBuilder.builder(
                        ExperimentsCatalogFixtures.experimentAssignment())
                .experiment(null);

        final GitLabExperimentAssignment built = builder.build();

        assertThat(built.experiment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariantIsNullable() {
        final GitLabExperimentAssignmentBuilder builder = GitLabExperimentAssignmentBuilder.builder(
                        ExperimentsCatalogFixtures.experimentAssignment())
                .variant(null);

        final GitLabExperimentAssignment built = builder.build();

        assertThat(built.variant()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextKeyIsNullable() {
        final GitLabExperimentAssignmentBuilder builder = GitLabExperimentAssignmentBuilder.builder(
                        ExperimentsCatalogFixtures.experimentAssignment())
                .contextKey(null);

        final GitLabExperimentAssignment built = builder.build();

        assertThat(built.contextKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCachedIsNullable() {
        final GitLabExperimentAssignmentBuilder builder = GitLabExperimentAssignmentBuilder.builder(
                        ExperimentsCatalogFixtures.experimentAssignment())
                .cached(null);

        final GitLabExperimentAssignment built = builder.build();

        assertThat(built.cached()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabExperimentAssignment value = ExperimentsCatalogFixtures.experimentAssignment();

        assertSoftly(softly -> {
            softly.assertThat(value.experiment()).isEqualTo("lightweight_trial_registration_redesign");
            softly.assertThat(value.variant()).isEqualTo("candidate");
            softly.assertThat(value.contextKey()).isEqualTo("abc123def456");
            softly.assertThat(value.cached()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabExperimentAssignment original = ExperimentsCatalogFixtures.experimentAssignment();

        final GitLabExperimentAssignment rebuilt =
                GitLabExperimentAssignmentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabExperimentAssignment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("experiment", "variant", "contextKey", "cached");
    }
}
