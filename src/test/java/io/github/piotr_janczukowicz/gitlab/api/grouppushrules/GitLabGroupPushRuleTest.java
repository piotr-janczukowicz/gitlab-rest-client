package io.github.piotr_janczukowicz.gitlab.api.grouppushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupPushRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .id(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .createdAt(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .commitMessageRegex(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .commitMessageNegativeRegex(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .branchNameRegex(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .authorEmailRegex(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .fileNameRegex(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .denyDeleteTag(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .memberCheck(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .preventSecrets(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .maxFileSize(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .commitCommitterCheck(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .commitCommitterNameCheck(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .rejectUnsignedCommits(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabGroupPushRuleBuilder builder = GitLabGroupPushRuleBuilder.builder(
                        GrouppushrulesCatalogFixtures.groupPushRule())
                .rejectNonDcoCommits(null);

        final GitLabGroupPushRule built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupPushRule value = GrouppushrulesCatalogFixtures.groupPushRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.commitMessageRegex()).isEqualTo("[a-zA-Z]");
            softly.assertThat(value.commitMessageNegativeRegex()).isEqualTo("[x+]");
            softly.assertThat(value.branchNameRegex()).isEqualTo("[a-z]");
            softly.assertThat(value.authorEmailRegex()).isEqualTo("^[A-Za-z0-9.]+@gitlab.com$");
            softly.assertThat(value.fileNameRegex()).isEqualTo("(exe)$");
            softly.assertThat(value.denyDeleteTag()).isEqualTo(true);
            softly.assertThat(value.memberCheck()).isEqualTo(true);
            softly.assertThat(value.preventSecrets()).isEqualTo(true);
            softly.assertThat(value.maxFileSize()).isEqualTo(1L);
            softly.assertThat(value.commitCommitterCheck()).isEqualTo(true);
            softly.assertThat(value.commitCommitterNameCheck()).isEqualTo(true);
            softly.assertThat(value.rejectUnsignedCommits()).isEqualTo(true);
            softly.assertThat(value.rejectNonDcoCommits()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupPushRule original = GrouppushrulesCatalogFixtures.groupPushRule();

        final GitLabGroupPushRule rebuilt =
                GitLabGroupPushRuleBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupPushRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "createdAt",
                        "commitMessageRegex",
                        "commitMessageNegativeRegex",
                        "branchNameRegex",
                        "authorEmailRegex",
                        "fileNameRegex",
                        "denyDeleteTag",
                        "memberCheck",
                        "preventSecrets",
                        "maxFileSize",
                        "commitCommitterCheck",
                        "commitCommitterNameCheck",
                        "rejectUnsignedCommits",
                        "rejectNonDcoCommits");
    }
}
