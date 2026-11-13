package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMlMlflowRunDataTest {

    @Test
    void constructor_shouldAcceptNull_whenMetricsIsNullable() {
        final GitLabMlMlflowRunDataBuilder builder = GitLabMlMlflowRunDataBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunData())
                .metrics(null);

        final GitLabMlMlflowRunData built = builder.build();

        assertThat(built.metrics()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParamsIsNullable() {
        final GitLabMlMlflowRunDataBuilder builder = GitLabMlMlflowRunDataBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunData())
                .params(null);

        final GitLabMlMlflowRunData built = builder.build();

        assertThat(built.params()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabMlMlflowRunDataBuilder builder = GitLabMlMlflowRunDataBuilder.builder(
                        ProjectsCatalogFixtures.mlMlflowRunData())
                .tags(null);

        final GitLabMlMlflowRunData built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMlMlflowRunData value = ProjectsCatalogFixtures.mlMlflowRunData();

        assertSoftly(softly -> {
            softly.assertThat(value.metrics()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowMetric()));
            softly.assertThat(value.params()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()));
            softly.assertThat(value.tags()).isEqualTo(List.of(ProjectsCatalogFixtures.mlMlflowKeyValue()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMlMlflowRunData original = ProjectsCatalogFixtures.mlMlflowRunData();

        final GitLabMlMlflowRunData rebuilt =
                GitLabMlMlflowRunDataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMlMlflowRunData.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("metrics", "params", "tags");
    }
}
