package io.github.piotr_janczukowicz.gitlab.api.runnercontrollers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRunnerControllersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabRunnerControllersCreatePayloadBuilder builder = GitLabRunnerControllersCreatePayloadBuilder.builder(
                        RunnercontrollersCatalogFixtures.runnerControllersCreatePayload())
                .description(null);

        final GitLabRunnerControllersCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabRunnerControllersCreatePayloadBuilder builder = GitLabRunnerControllersCreatePayloadBuilder.builder(
                        RunnercontrollersCatalogFixtures.runnerControllersCreatePayload())
                .state(null);

        final GitLabRunnerControllersCreatePayload built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRunnerControllersCreatePayload value =
                RunnercontrollersCatalogFixtures.runnerControllersCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.description()).isEqualTo("Controller for managing runner");
            softly.assertThat(value.state()).isEqualTo(GitLabRunnerControllersCreateState.DISABLED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRunnerControllersCreatePayload original =
                RunnercontrollersCatalogFixtures.runnerControllersCreatePayload();

        final GitLabRunnerControllersCreatePayload rebuilt =
                GitLabRunnerControllersCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRunnerControllersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description", "state");
    }
}
