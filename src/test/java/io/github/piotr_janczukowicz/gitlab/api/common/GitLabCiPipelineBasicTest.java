package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiPipelineBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .id(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .iid(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .projectId(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .sha(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .ref(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .status(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .source(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .createdAt(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .updatedAt(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiPipelineBasicBuilder builder = GitLabCiPipelineBasicBuilder.builder(
                        CommonCatalogFixtures.ciPipelineBasic())
                .webUrl(null);

        final GitLabCiPipelineBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiPipelineBasic value = CommonCatalogFixtures.ciPipelineBasic();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiPipelineBasic original = CommonCatalogFixtures.ciPipelineBasic();

        final GitLabCiPipelineBasic rebuilt =
                GitLabCiPipelineBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiPipelineBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "iid", "projectId", "sha", "ref", "status", "source", "createdAt", "updatedAt", "webUrl");
    }
}
