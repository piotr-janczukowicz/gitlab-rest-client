package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectPushRulesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .denyDeleteTag(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .memberCheck(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .preventSecrets(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .commitMessageRegex(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .commitMessageNegativeRegex(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .branchNameRegex(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .authorEmailRegex(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .fileNameRegex(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .maxFileSize(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .commitCommitterCheck(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .commitCommitterNameCheck(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .rejectUnsignedCommits(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabProjectProjectPushRulesUpdatePayloadBuilder builder =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload())
                        .rejectNonDcoCommits(null);

        final GitLabProjectProjectPushRulesUpdatePayload built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectPushRulesUpdatePayload value =
                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload();

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
        final GitLabProjectProjectPushRulesUpdatePayload original =
                ProjectpushrulesCatalogFixtures.projectProjectPushRulesUpdatePayload();

        final GitLabProjectProjectPushRulesUpdatePayload rebuilt =
                GitLabProjectProjectPushRulesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectPushRulesUpdatePayload.class.getRecordComponents())
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
