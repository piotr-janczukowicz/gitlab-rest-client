package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiLintResultIncludeTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .type(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .location(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .blob(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.blob()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .raw(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.raw()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExtraIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .extra(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.extra()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextProjectIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .contextProject(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.contextProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContextShaIsNullable() {
        final GitLabCiLintResultIncludeBuilder builder = GitLabCiLintResultIncludeBuilder.builder(
                        ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude())
                .contextSha(null);

        final GitLabCiLintResultInclude built = builder.build();

        assertThat(built.contextSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiLintResultInclude value = ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude();

        assertSoftly(softly -> {
            softly.assertThat(value.type()).isEqualTo("local");
            softly.assertThat(value.location()).isEqualTo(".gitlab/ci/build-images.gitlab-ci.yml");
            softly.assertThat(value.blob())
                    .isEqualTo(
                            "https://gitlab.com/gitlab-org/gitlab/-/blob/e52d6d0246d7375291850e61f0abc101fbda9dc2/.gitlab/ci/build-images.gitlab-ci.yml");
            softly.assertThat(value.raw())
                    .isEqualTo(
                            "https://gitlab.com/gitlab-org/gitlab/-/raw/e52d6d0246d7375291850e61f0abc101fbda9dc2/.gitlab/ci/build-images.gitlab-ci.yml");
            softly.assertThat(value.extra()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.contextProject()).isEqualTo("gitlab-org/gitlab");
            softly.assertThat(value.contextSha()).isEqualTo("e52d6d0246d7375291850e61f0abc101fbda9dc2");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiLintResultInclude original = ValidategitlabciymlfileCatalogFixtures.ciLintResultInclude();

        final GitLabCiLintResultInclude rebuilt =
                GitLabCiLintResultIncludeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiLintResultInclude.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type", "location", "blob", "raw", "extra", "contextProject", "contextSha");
    }
}
