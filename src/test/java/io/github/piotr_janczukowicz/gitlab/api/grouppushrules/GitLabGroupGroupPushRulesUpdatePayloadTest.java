package io.github.piotr_janczukowicz.gitlab.api.grouppushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupPushRulesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .denyDeleteTag(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .memberCheck(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .preventSecrets(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .commitMessageRegex(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .commitMessageNegativeRegex(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .branchNameRegex(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .authorEmailRegex(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .fileNameRegex(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .maxFileSize(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .commitCommitterCheck(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .commitCommitterNameCheck(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .rejectUnsignedCommits(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabGroupGroupPushRulesUpdatePayloadBuilder builder =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload())
                        .rejectNonDcoCommits(null);

        final GitLabGroupGroupPushRulesUpdatePayload built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupPushRulesUpdatePayload value =
                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.denyDeleteTag()).isEqualTo(true);
            softly.assertThat(value.memberCheck()).isEqualTo(true);
            softly.assertThat(value.preventSecrets()).isEqualTo(true);
            softly.assertThat(value.commitMessageRegex()).isEqualTo("Fixed \\d+\\..*");
            softly.assertThat(value.commitMessageNegativeRegex()).isEqualTo("ssh\\:\\/\\/");
            softly.assertThat(value.branchNameRegex()).isEqualTo("(feature|hotfix)\\/.*");
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
        final GitLabGroupGroupPushRulesUpdatePayload original =
                GrouppushrulesCatalogFixtures.groupGroupPushRulesUpdatePayload();

        final GitLabGroupGroupPushRulesUpdatePayload rebuilt =
                GitLabGroupGroupPushRulesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupPushRulesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "denyDeleteTag",
                        "memberCheck",
                        "preventSecrets",
                        "commitMessageRegex",
                        "commitMessageNegativeRegex",
                        "branchNameRegex",
                        "authorEmailRegex",
                        "fileNameRegex",
                        "maxFileSize",
                        "commitCommitterCheck",
                        "commitCommitterNameCheck",
                        "rejectUnsignedCommits",
                        "rejectNonDcoCommits");
    }
}
