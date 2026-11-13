package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRunnerControllersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabRunnerControllersUpdatePayloadBuilder builder = GitLabRunnerControllersUpdatePayloadBuilder.builder(
                        RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload())
                .description(null);

        final GitLabRunnerControllersUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabRunnerControllersUpdatePayloadBuilder builder = GitLabRunnerControllersUpdatePayloadBuilder.builder(
                        RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload())
                .state(null);

        final GitLabRunnerControllersUpdatePayload built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRunnerControllersUpdatePayload value =
                RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.state()).isEqualTo(GitLabRunnerControllersUpdateState.DISABLED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRunnerControllersUpdatePayload original =
                RunnercontrollersCatalogFixtures.runnerControllersUpdatePayload();

        final GitLabRunnerControllersUpdatePayload rebuilt =
                GitLabRunnerControllersUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRunnerControllersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "state");
    }
}
