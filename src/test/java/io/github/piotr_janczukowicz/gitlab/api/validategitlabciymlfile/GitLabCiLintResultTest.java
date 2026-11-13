package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiLintResultTest {

    @Test
    void constructor_shouldAcceptNull_whenValidIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .valid(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.valid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorsIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .errors(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.errors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarningsIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .warnings(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.warnings()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedYamlIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .mergedYaml(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.mergedYaml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludesIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .includes(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.includes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenJobsIsNullable() {
        final GitLabCiLintResultBuilder builder = GitLabCiLintResultBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResult())
                .jobs(null);

        final GitLabCiLintResult built = builder.build();

        assertThat(built.jobs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiLintResult value = ValidategitlabciymlfileCatalogFixtures.ciLintResult();

        assertSoftly(softly -> {
            softly.assertThat(value.valid()).isEqualTo(true);
            softly.assertThat(value.errors())
                    .isEqualTo(List.of("variables config should be a hash of key value pairs"));
            softly.assertThat(value.warnings()).isEqualTo(List.of("jobs:job may allow multiple pipelines ..."));
            softly.assertThat(value.mergedYaml())
                    .isEqualTo(
                            "---\\n:another_test:\\n  :stage: test\\n\n          :script: echo 2\\n:test:\\n  :stage: test\\n  :script: echo 1\\n");
            softly.assertThat(value.includes())
                    .isEqualTo(List.of(ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude()));
            softly.assertThat(value.jobs()).isEqualTo(List.of(Map.of("key", "value")));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiLintResult original = ValidategitlabciymlfileCatalogFixtures.ciLintResult();

        final GitLabCiLintResult rebuilt =
                GitLabCiLintResultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiLintResult.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("valid", "errors", "warnings", "mergedYaml", "includes", "jobs");
    }
}
