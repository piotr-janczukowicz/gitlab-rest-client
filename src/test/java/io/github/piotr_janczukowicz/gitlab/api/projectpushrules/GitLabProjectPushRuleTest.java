package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPushRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .id(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .projectId(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .createdAt(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .commitMessageRegex(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .commitMessageNegativeRegex(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .branchNameRegex(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .denyDeleteTag(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .memberCheck(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .preventSecrets(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .authorEmailRegex(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .fileNameRegex(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .maxFileSize(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .commitCommitterCheck(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .commitCommitterNameCheck(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .rejectUnsignedCommits(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabProjectPushRuleBuilder builder = GitLabProjectPushRuleBuilder.builder(
                        ProjectpushrulesCatalogFixtures.projectPushRule())
                .rejectNonDcoCommits(null);

        final GitLabProjectPushRule built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPushRule value = ProjectpushrulesCatalogFixtures.projectPushRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.commitMessageRegex()).isEqualTo("Fixed \\d+\\..*");
            softly.assertThat(value.commitMessageNegativeRegex()).isEqualTo("ssh\\:\\/\\/");
            softly.assertThat(value.branchNameRegex()).isEqualTo("(feature|hotfix)\\/.*");
            softly.assertThat(value.denyDeleteTag()).isEqualTo(true);
            softly.assertThat(value.memberCheck()).isEqualTo(true);
            softly.assertThat(value.preventSecrets()).isEqualTo(true);
            softly.assertThat(value.authorEmailRegex()).isEqualTo("@my-company.com$");
            softly.assertThat(value.fileNameRegex()).isEqualTo("(jar|exe)$");
            softly.assertThat(value.maxFileSize()).isEqualTo(1L);
            softly.assertThat(value.commitCommitterCheck()).isEqualTo(true);
            softly.assertThat(value.commitCommitterNameCheck()).isEqualTo(true);
            softly.assertThat(value.rejectUnsignedCommits()).isEqualTo(true);
            softly.assertThat(value.rejectNonDcoCommits()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPushRule original = ProjectpushrulesCatalogFixtures.projectPushRule();

        final GitLabProjectPushRule rebuilt =
                GitLabProjectPushRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPushRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "projectId",
                        "createdAt",
                        "commitMessageRegex",
                        "commitMessageNegativeRegex",
                        "branchNameRegex",
                        "denyDeleteTag",
                        "memberCheck",
                        "preventSecrets",
                        "authorEmailRegex",
                        "fileNameRegex",
                        "maxFileSize",
                        "commitCommitterCheck",
                        "commitCommitterNameCheck",
                        "rejectUnsignedCommits",
                        "rejectNonDcoCommits");
    }
}
