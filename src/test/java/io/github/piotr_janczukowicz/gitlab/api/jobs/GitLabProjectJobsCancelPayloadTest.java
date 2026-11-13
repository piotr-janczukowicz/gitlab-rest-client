package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectJobsCancelPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenForceIsNullable() {
        final GitLabProjectJobsCancelPayloadBuilder builder = GitLabProjectJobsCancelPayloadBuilder.builder(
                        JobsCatalogFixtures.projectJobsCancelPayload())
                .force(null);

        final GitLabProjectJobsCancelPayload built = builder.build();

        assertThat(built.force()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectJobsCancelPayload value = JobsCatalogFixtures.projectJobsCancelPayload();

        assertThat(value.force()).isEqualTo(true);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectJobsCancelPayload original = JobsCatalogFixtures.projectJobsCancelPayload();

        final GitLabProjectJobsCancelPayload rebuilt =
                GitLabProjectJobsCancelPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectJobsCancelPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("force");
    }
}
