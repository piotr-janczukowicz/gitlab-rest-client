package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestGitInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenRepoUrlIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .repoUrl(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.repoUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .ref(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .sha(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBeforeShaIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .beforeSha(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.beforeSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefTypeIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .refType(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.refType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefspecsIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .refspecs(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.refspecs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDepthIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .depth(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.depth()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepoObjectFormatIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .repoObjectFormat(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.repoObjectFormat()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtectedValueIsNullable() {
        final GitLabCiJobRequestGitInfoBuilder builder = GitLabCiJobRequestGitInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestGitInfo())
                .protectedValue(null);

        final GitLabCiJobRequestGitInfo built = builder.build();

        assertThat(built.protectedValue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestGitInfo value = JobsCatalogFixtures.ciJobRequestGitInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.repoUrl()).isEqualTo("repo_url");
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.sha()).isEqualTo("sha");
            softly.assertThat(value.beforeSha()).isEqualTo("before_sha");
            softly.assertThat(value.refType()).isEqualTo("ref_type");
            softly.assertThat(value.refspecs()).isEqualTo("refspecs");
            softly.assertThat(value.depth()).isEqualTo("depth");
            softly.assertThat(value.repoObjectFormat()).isEqualTo("repo_object_format");
            softly.assertThat(value.protectedValue()).isEqualTo("protected");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestGitInfo original = JobsCatalogFixtures.ciJobRequestGitInfo();

        final GitLabCiJobRequestGitInfo rebuilt =
                GitLabCiJobRequestGitInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestGitInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "repoUrl",
                        "ref",
                        "sha",
                        "beforeSha",
                        "refType",
                        "refspecs",
                        "depth",
                        "repoObjectFormat",
                        "protectedValue");
    }
}
