package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam())
                        .key(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam())
                        .value(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam value =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam original =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunParam();

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam rebuilt =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParamBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunParam.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
