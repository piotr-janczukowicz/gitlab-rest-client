package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRunnersCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenRunnerIdIsNullable() {
        final GitLabProjectRunnersCreatePayloadBuilder builder = GitLabProjectRunnersCreatePayloadBuilder.builder(
                        RunnersCatalogFixtures.projectRunnersCreatePayload())
                .runnerId(null);

        final GitLabProjectRunnersCreatePayload built = builder.build();

        assertThat(built.runnerId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRunnersCreatePayload value = RunnersCatalogFixtures.projectRunnersCreatePayload();

        assertThat(value.runnerId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRunnersCreatePayload original = RunnersCatalogFixtures.projectRunnersCreatePayload();

        final GitLabProjectRunnersCreatePayload rebuilt =
                GitLabProjectRunnersCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRunnersCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runnerId");
    }
}
