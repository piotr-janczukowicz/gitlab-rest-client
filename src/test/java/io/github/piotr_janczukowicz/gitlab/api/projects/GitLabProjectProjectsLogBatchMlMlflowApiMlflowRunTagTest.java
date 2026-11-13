package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag())
                        .key(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder builder =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag())
                        .value(null);

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag value =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("key");
            softly.assertThat(value.value()).isEqualTo("value");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag original =
                ProjectsCatalogFixtures.projectProjectsLogBatchMlMlflowApiMlflowRunTag();

        final GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag rebuilt =
                GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTagBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsLogBatchMlMlflowApiMlflowRunTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
