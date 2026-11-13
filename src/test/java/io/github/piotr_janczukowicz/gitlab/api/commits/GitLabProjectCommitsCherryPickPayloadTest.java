package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsCherryPickPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectCommitsCherryPickPayloadBuilder builder =
                GitLabProjectCommitsCherryPickPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCherryPickPayload())
                        .branch(null);

        final GitLabProjectCommitsCherryPickPayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunIsNullable() {
        final GitLabProjectCommitsCherryPickPayloadBuilder builder =
                GitLabProjectCommitsCherryPickPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCherryPickPayload())
                        .dryRun(null);

        final GitLabProjectCommitsCherryPickPayload built = builder.build();

        assertThat(built.dryRun()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabProjectCommitsCherryPickPayloadBuilder builder =
                GitLabProjectCommitsCherryPickPayloadBuilder.builder(
                                CommitsCatalogFixtures.projectCommitsCherryPickPayload())
                        .message(null);

        final GitLabProjectCommitsCherryPickPayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsCherryPickPayload value = CommitsCatalogFixtures.projectCommitsCherryPickPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.branch()).isEqualTo("master");
            softly.assertThat(value.dryRun()).isEqualTo(true);
            softly.assertThat(value.message()).isEqualTo("Initial commit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsCherryPickPayload original = CommitsCatalogFixtures.projectCommitsCherryPickPayload();

        final GitLabProjectCommitsCherryPickPayload rebuilt =
                GitLabProjectCommitsCherryPickPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsCherryPickPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("branch", "dryRun", "message");
    }
}
