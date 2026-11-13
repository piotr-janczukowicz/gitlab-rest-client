package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeTrainsCarTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .id(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .mergeRequest(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.mergeRequest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .user(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .pipeline(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .createdAt(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .updatedAt(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .targetBranch(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .status(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedAtIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .mergedAt(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.mergedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabMergeTrainsCarBuilder builder = GitLabMergeTrainsCarBuilder.builder(
                        MergetrainsCatalogFixtures.mergeTrainsCar())
                .duration(null);

        final GitLabMergeTrainsCar built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeTrainsCar value = MergetrainsCatalogFixtures.mergeTrainsCar();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.mergeRequest()).isEqualTo(MergetrainsCatalogFixtures.mergeRequestSimple());
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.targetBranch()).isEqualTo("develop");
            softly.assertThat(value.status()).isEqualTo(GitLabMergeTrainsCarStatus.IDLE);
            softly.assertThat(value.mergedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.duration()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeTrainsCar original = MergetrainsCatalogFixtures.mergeTrainsCar();

        final GitLabMergeTrainsCar rebuilt =
                GitLabMergeTrainsCarBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeTrainsCar.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "mergeRequest",
                        "user",
                        "pipeline",
                        "createdAt",
                        "updatedAt",
                        "targetBranch",
                        "status",
                        "mergedAt",
                        "duration");
    }
}
