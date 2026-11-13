package io.github.piotr_janczukowicz.gitlab.api.repositorysubmodules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositorySubmodulesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCommitShaIsNullable() {
        final GitLabProjectRepositorySubmodulesUpdatePayloadBuilder builder =
                GitLabProjectRepositorySubmodulesUpdatePayloadBuilder.builder(
                                RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload())
                        .commitSha(null);

        final GitLabProjectRepositorySubmodulesUpdatePayload built = builder.build();

        assertThat(built.commitSha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectRepositorySubmodulesUpdatePayloadBuilder builder =
                GitLabProjectRepositorySubmodulesUpdatePayloadBuilder.builder(
                                RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload())
                        .branch(null);

        final GitLabProjectRepositorySubmodulesUpdatePayload built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageIsNullable() {
        final GitLabProjectRepositorySubmodulesUpdatePayloadBuilder builder =
                GitLabProjectRepositorySubmodulesUpdatePayloadBuilder.builder(
                                RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload())
                        .commitMessage(null);

        final GitLabProjectRepositorySubmodulesUpdatePayload built = builder.build();

        assertThat(built.commitMessage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositorySubmodulesUpdatePayload value =
                RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.commitSha()).isEqualTo("ed899a2f4b50b4370feeea94676502b42383c746");
            softly.assertThat(value.branch()).isEqualTo("main");
            softly.assertThat(value.commitMessage()).isEqualTo("Commit message");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositorySubmodulesUpdatePayload original =
                RepositorysubmodulesCatalogFixtures.projectRepositorySubmodulesUpdatePayload();

        final GitLabProjectRepositorySubmodulesUpdatePayload rebuilt =
                GitLabProjectRepositorySubmodulesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositorySubmodulesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("commitSha", "branch", "commitMessage");
    }
}
