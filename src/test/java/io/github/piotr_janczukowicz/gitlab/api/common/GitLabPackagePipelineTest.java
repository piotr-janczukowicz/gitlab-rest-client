package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackagePipelineTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .id(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .iid(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .projectId(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .sha(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .ref(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .status(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .source(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .createdAt(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .updatedAt(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .webUrl(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabPackagePipelineBuilder builder = GitLabPackagePipelineBuilder.builder(
                        CommonCatalogFixtures.packagePipeline())
                .user(null);

        final GitLabPackagePipeline built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackagePipeline value = CommonCatalogFixtures.packagePipeline();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.sha()).isEqualTo("0ec9e58fdfca6cdd6652c083c9edb53abc0bad52");
            softly.assertThat(value.ref()).isEqualTo("feature-branch");
            softly.assertThat(value.status()).isEqualTo("success");
            softly.assertThat(value.source()).isEqualTo("push");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab-org/gitlab-foss/-/pipelines/61");
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackagePipeline original = CommonCatalogFixtures.packagePipeline();

        final GitLabPackagePipeline rebuilt =
                GitLabPackagePipelineBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackagePipeline.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "projectId",
                        "sha",
                        "ref",
                        "status",
                        "source",
                        "createdAt",
                        "updatedAt",
                        "webUrl",
                        "user");
    }
}
