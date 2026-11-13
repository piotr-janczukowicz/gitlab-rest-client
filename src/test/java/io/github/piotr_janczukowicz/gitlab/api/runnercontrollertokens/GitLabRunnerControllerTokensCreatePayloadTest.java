package io.github.piotr_janczukowicz.gitlab.api.runnercontrollertokens;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRunnerControllerTokensCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabRunnerControllerTokensCreatePayloadBuilder builder =
                GitLabRunnerControllerTokensCreatePayloadBuilder.builder(
                                RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload())
                        .description(null);

        final GitLabRunnerControllerTokensCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRunnerControllerTokensCreatePayload value =
                RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload();

        assertThat(value.description()).isEqualTo("Token for managing runner");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRunnerControllerTokensCreatePayload original =
                RunnercontrollertokensCatalogFixtures.runnerControllerTokensCreatePayload();

        final GitLabRunnerControllerTokensCreatePayload rebuilt =
                GitLabRunnerControllerTokensCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRunnerControllerTokensCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("description");
    }
}
