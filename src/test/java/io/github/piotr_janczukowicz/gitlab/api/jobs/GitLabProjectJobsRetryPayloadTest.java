package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsRetryPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenInputsIsNullable() {
        final GitLabProjectJobsRetryPayloadBuilder builder = GitLabProjectJobsRetryPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsRetryPayload())
                .inputs(null);

        final GitLabProjectJobsRetryPayload built = builder.build();

        assertThat(built.inputs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsRetryPayload value = JobsCatalogFixtures.projectJobsRetryPayload();

        assertThat(value.inputs()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsRetryPayload original = JobsCatalogFixtures.projectJobsRetryPayload();

        final GitLabProjectJobsRetryPayload rebuilt =
                GitLabProjectJobsRetryPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenInputsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectJobsRetryPayload built = GitLabProjectJobsRetryPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsRetryPayload())
                .inputs(source)
                .build();
        source.clear();

        assertThat(built.inputs()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsRetryPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("inputs");
    }
}
