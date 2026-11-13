package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEnvironmentsStopPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenForceIsNullable() {
        final GitLabProjectEnvironmentsStopPayloadBuilder builder = GitLabProjectEnvironmentsStopPayloadBuilder.builder(
                        EnvironmentsCatalogFixtures.projectEnvironmentsStopPayload())
                .force(null);

        final GitLabProjectEnvironmentsStopPayload built = builder.build();

        assertThat(built.force()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsStopPayload value = EnvironmentsCatalogFixtures.projectEnvironmentsStopPayload();

        assertThat(value.force()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsStopPayload original =
                EnvironmentsCatalogFixtures.projectEnvironmentsStopPayload();

        final GitLabProjectEnvironmentsStopPayload rebuilt =
                GitLabProjectEnvironmentsStopPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsStopPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("force");
    }
}
