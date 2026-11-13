package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectPushRulesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDenyDeleteTagIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .denyDeleteTag(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.denyDeleteTag()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberCheckIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .memberCheck(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.memberCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreventSecretsIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .preventSecrets(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.preventSecrets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageRegexIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .commitMessageRegex(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.commitMessageRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitMessageNegativeRegexIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .commitMessageNegativeRegex(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.commitMessageNegativeRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchNameRegexIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .branchNameRegex(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.branchNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailRegexIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .authorEmailRegex(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.authorEmailRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameRegexIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .fileNameRegex(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.fileNameRegex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMaxFileSizeIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .maxFileSize(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.maxFileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterCheckIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .commitCommitterCheck(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.commitCommitterCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitCommitterNameCheckIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .commitCommitterNameCheck(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.commitCommitterNameCheck()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectUnsignedCommitsIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .rejectUnsignedCommits(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.rejectUnsignedCommits()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRejectNonDcoCommitsIsNullable() {
        final GitLabProjectProjectPushRulesCreatePayloadBuilder builder =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(
                                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload())
                        .rejectNonDcoCommits(null);

        final GitLabProjectProjectPushRulesCreatePayload built = builder.build();

        assertThat(built.rejectNonDcoCommits()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectPushRulesCreatePayload value =
                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload();

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
        final GitLabProjectProjectPushRulesCreatePayload original =
                ProjectpushrulesCatalogFixtures.projectProjectPushRulesCreatePayload();

        final GitLabProjectProjectPushRulesCreatePayload rebuilt =
                GitLabProjectProjectPushRulesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectPushRulesCreatePayload.class.getRecordComponents())
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
