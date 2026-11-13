package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsRequestInfoConfigTest {

    @Test
    void constructor_shouldAcceptNull_whenGpusIsNullable() {
        final GitLabInstanceJobsRequestInfoConfigBuilder builder = GitLabInstanceJobsRequestInfoConfigBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfoConfig())
                .gpus(null);

        final GitLabInstanceJobsRequestInfoConfig built = builder.build();

        assertThat(built.gpus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsRequestInfoConfig value = JobsCatalogFixtures.instanceJobsRequestInfoConfig();

        assertThat(value.gpus()).isEqualTo("gpus");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsRequestInfoConfig original = JobsCatalogFixtures.instanceJobsRequestInfoConfig();

        final GitLabInstanceJobsRequestInfoConfig rebuilt =
                GitLabInstanceJobsRequestInfoConfigBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsRequestInfoConfig.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("gpus");
    }
}
