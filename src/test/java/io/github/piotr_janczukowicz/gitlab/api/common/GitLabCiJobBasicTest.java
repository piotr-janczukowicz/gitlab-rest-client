package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .id(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .status(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStageIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .stage(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.stage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .name(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .ref(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .tag(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.tag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCoverageIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .coverage(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.coverage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .allowFailure(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .createdAt(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .startedAt(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .finishedAt(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErasedAtIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .erasedAt(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.erasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDurationIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .duration(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.duration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenQueuedDurationIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .queuedDuration(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.queuedDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .user(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .commit(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .pipeline(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailureReasonIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .failureReason(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.failureReason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .webUrl(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabCiJobBasicBuilder builder = GitLabCiJobBasicBuilder.builder(CommonCatalogFixtures.ciJobBasic())
                .project(null);

        final GitLabCiJobBasic built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobBasic value = CommonCatalogFixtures.ciJobBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.status()).isEqualTo("waiting_for_resource");
            softly.assertThat(value.stage()).isEqualTo("deploy");
            softly.assertThat(value.name()).isEqualTo("deploy_to_production");
            softly.assertThat(value.ref()).isEqualTo("main");
            softly.assertThat(value.tag()).isEqualTo(true);
            softly.assertThat(value.coverage()).isEqualTo(1.5);
            softly.assertThat(value.allowFailure()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.erasedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.duration()).isEqualTo(1.5);
            softly.assertThat(value.queuedDuration()).isEqualTo(1.5);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.user());
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.ciPipelineBasic());
            softly.assertThat(value.failureReason()).isEqualTo("script_failure");
            softly.assertThat(value.webUrl()).isEqualTo("https://example.com/foo/bar/-/jobs/1");
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.ciJobBasicProject());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobBasic original = CommonCatalogFixtures.ciJobBasic();

        final GitLabCiJobBasic rebuilt =
                GitLabCiJobBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "status",
                        "stage",
                        "name",
                        "ref",
                        "tag",
                        "coverage",
                        "allowFailure",
                        "createdAt",
                        "startedAt",
                        "finishedAt",
                        "erasedAt",
                        "duration",
                        "queuedDuration",
                        "user",
                        "commit",
                        "pipeline",
                        "failureReason",
                        "webUrl",
                        "project");
    }
}
