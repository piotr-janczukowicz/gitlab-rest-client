package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiRuntimeEnvironmentKeyTest {

    @Test
    void constructor_shouldAcceptNull_whenRuntimeEnvironmentKeyIsNullable() {
        final GitLabCiRuntimeEnvironmentKeyBuilder builder = GitLabCiRuntimeEnvironmentKeyBuilder.builder(
                        JobsCatalogFixtures.ciRuntimeEnvironmentKey())
                .runtimeEnvironmentKey(null);

        final GitLabCiRuntimeEnvironmentKey built = builder.build();

        assertThat(built.runtimeEnvironmentKey()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiRuntimeEnvironmentKey value = JobsCatalogFixtures.ciRuntimeEnvironmentKey();

        assertThat(value.runtimeEnvironmentKey()).isEqualTo("42/s_machineid/data");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiRuntimeEnvironmentKey original = JobsCatalogFixtures.ciRuntimeEnvironmentKey();

        final GitLabCiRuntimeEnvironmentKey rebuilt =
                GitLabCiRuntimeEnvironmentKeyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiRuntimeEnvironmentKey.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("runtimeEnvironmentKey");
    }
}
