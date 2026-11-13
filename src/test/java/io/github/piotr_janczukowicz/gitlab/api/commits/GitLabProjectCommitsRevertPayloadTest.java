package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitsRevertPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectCommitsRevertPayloadBuilder builder = GitLabProjectCommitsRevertPayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsRevertPayload())
                .branch(null);

        final GitLabProjectCommitsRevertPayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDryRunIsNullable() {
        final GitLabProjectCommitsRevertPayloadBuilder builder = GitLabProjectCommitsRevertPayloadBuilder.builder(
                        CommitsCatalogFixtures.projectCommitsRevertPayload())
                .dryRun(null);

        final GitLabProjectCommitsRevertPayload built = builder.build();

        assertThat(built.dryRun()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitsRevertPayload value = CommitsCatalogFixtures.projectCommitsRevertPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.branch()).isEqualTo("master");
            softly.assertThat(value.dryRun()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitsRevertPayload original = CommitsCatalogFixtures.projectCommitsRevertPayload();

        final GitLabProjectCommitsRevertPayload rebuilt =
                GitLabProjectCommitsRevertPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitsRevertPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("branch", "dryRun");
    }
}
