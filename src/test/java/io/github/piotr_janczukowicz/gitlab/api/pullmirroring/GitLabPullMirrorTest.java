package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPullMirrorTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .id(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateStatusIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .updateStatus(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.updateStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .url(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastErrorIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .lastError(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.lastError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdateAtIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .lastUpdateAt(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.lastUpdateAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdateStartedAtIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .lastUpdateStartedAt(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.lastUpdateStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSuccessfulUpdateAtIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .lastSuccessfulUpdateAt(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.lastSuccessfulUpdateAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .enabled(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorTriggerBuildsIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .mirrorTriggerBuilds(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.mirrorTriggerBuilds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyMirrorProtectedBranchesIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .onlyMirrorProtectedBranches(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.onlyMirrorProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorOverwritesDivergedBranchesIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .mirrorOverwritesDivergedBranches(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.mirrorOverwritesDivergedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorBranchRegexIsNullable() {
        final GitLabPullMirrorBuilder builder = GitLabPullMirrorBuilder.builder(
                        PullmirroringCatalogFixtures.pullMirror())
                .mirrorBranchRegex(null);

        final GitLabPullMirror built = builder.build();

        assertThat(built.mirrorBranchRegex()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPullMirror value = PullmirroringCatalogFixtures.pullMirror();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.updateStatus()).isEqualTo("finished");
            softly.assertThat(value.url()).isEqualTo("https://*****:*****@gitlab.com/gitlab-org/security/gitlab.git");
            softly.assertThat(value.lastError()).isEqualTo("last_error");
            softly.assertThat(value.lastUpdateAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUpdateStartedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastSuccessfulUpdateAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.mirrorTriggerBuilds()).isEqualTo(true);
            softly.assertThat(value.onlyMirrorProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorOverwritesDivergedBranches()).isEqualTo(true);
            softly.assertThat(value.mirrorBranchRegex()).isEqualTo("branch_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPullMirror original = PullmirroringCatalogFixtures.pullMirror();

        final GitLabPullMirror rebuilt =
                GitLabPullMirrorBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPullMirror.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "updateStatus",
                        "url",
                        "lastError",
                        "lastUpdateAt",
                        "lastUpdateStartedAt",
                        "lastSuccessfulUpdateAt",
                        "enabled",
                        "mirrorTriggerBuilds",
                        "onlyMirrorProtectedBranches",
                        "mirrorOverwritesDivergedBranches",
                        "mirrorBranchRegex");
    }
}
