package io.github.piotr_janczukowicz.gitlab.api.grouppushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupPushRulesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .denyDeleteTag(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .memberCheck(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .preventSecrets(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .commitMessageRegex(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .commitMessageNegativeRegex(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .branchNameRegex(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .authorEmailRegex(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .fileNameRegex(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .maxFileSize(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .commitCommitterCheck(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .commitCommitterNameCheck(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .rejectUnsignedCommits(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabGroupGroupPushRulesCreatePayloadBuilder builder =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(
                                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload())
                        .rejectNonDcoCommits(null);

        final GitLabGroupGroupPushRulesCreatePayload built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupPushRulesCreatePayload value =
                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload();

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
        final GitLabGroupGroupPushRulesCreatePayload original =
                GrouppushrulesCatalogFixtures.groupGroupPushRulesCreatePayload();

        final GitLabGroupGroupPushRulesCreatePayload rebuilt =
                GitLabGroupGroupPushRulesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupPushRulesCreatePayload.class.getRecordComponents())
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
