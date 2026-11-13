package io.github.piotr_janczukowicz.gitlab.api.remotemirrors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRemoteMirrorTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .id(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .enabled(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .url(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdateStatusIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .updateStatus(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.updateStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdateAtIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .lastUpdateAt(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.lastUpdateAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdateStartedAtIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .lastUpdateStartedAt(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.lastUpdateStartedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastSuccessfulUpdateAtIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .lastSuccessfulUpdateAt(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.lastSuccessfulUpdateAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastErrorIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .lastError(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.lastError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOnlyProtectedBranchesIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .onlyProtectedBranches(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.onlyProtectedBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeepDivergentRefsIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .keepDivergentRefs(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.keepDivergentRefs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthMethodIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .authMethod(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.authMethod()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHostKeysIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .hostKeys(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.hostKeys()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMirrorBranchRegexIsNullable() {
        final GitLabRemoteMirrorBuilder builder = GitLabRemoteMirrorBuilder.builder(
                        RemotemirrorsCatalogFixtures.remoteMirror())
                .mirrorBranchRegex(null);

        final GitLabRemoteMirror built = builder.build();

        assertThat(built.mirrorBranchRegex()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRemoteMirror value = RemotemirrorsCatalogFixtures.remoteMirror();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.url()).isEqualTo("https://*****:*****@example.com/gitlab/example.git");
            softly.assertThat(value.updateStatus()).isEqualTo("finished");
            softly.assertThat(value.lastUpdateAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastUpdateStartedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastSuccessfulUpdateAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastError()).isEqualTo("The remote mirror URL is invalid.");
            softly.assertThat(value.onlyProtectedBranches()).isEqualTo(true);
            softly.assertThat(value.keepDivergentRefs()).isEqualTo(true);
            softly.assertThat(value.authMethod()).isEqualTo("password");
            softly.assertThat(value.hostKeys()).isEqualTo(List.of(RemotemirrorsCatalogFixtures.mirrorHostKey()));
            softly.assertThat(value.mirrorBranchRegex()).isEqualTo("feature-.*");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRemoteMirror original = RemotemirrorsCatalogFixtures.remoteMirror();

        final GitLabRemoteMirror rebuilt =
                GitLabRemoteMirrorBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRemoteMirror.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "enabled",
                        "url",
                        "updateStatus",
                        "lastUpdateAt",
                        "lastUpdateStartedAt",
                        "lastSuccessfulUpdateAt",
                        "lastError",
                        "onlyProtectedBranches",
                        "keepDivergentRefs",
                        "authMethod",
                        "hostKeys",
                        "mirrorBranchRegex");
    }
}
