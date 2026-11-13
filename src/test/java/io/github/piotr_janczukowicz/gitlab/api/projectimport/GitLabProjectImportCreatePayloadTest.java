package io.github.piotr_janczukowicz.gitlab.api.projectimport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectImportCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBitbucketEmailIsNullable() {
        final GitLabProjectImportCreatePayloadBuilder builder = GitLabProjectImportCreatePayloadBuilder.builder(
                        ProjectimportCatalogFixtures.projectImportCreatePayload())
                .bitbucketEmail(null);

        final GitLabProjectImportCreatePayload built = builder.build();

        assertThat(built.bitbucketEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBitbucketApiTokenIsNullable() {
        final GitLabProjectImportCreatePayloadBuilder builder = GitLabProjectImportCreatePayloadBuilder.builder(
                        ProjectimportCatalogFixtures.projectImportCreatePayload())
                .bitbucketApiToken(null);

        final GitLabProjectImportCreatePayload built = builder.build();

        assertThat(built.bitbucketApiToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepoPathIsNullable() {
        final GitLabProjectImportCreatePayloadBuilder builder = GitLabProjectImportCreatePayloadBuilder.builder(
                        ProjectimportCatalogFixtures.projectImportCreatePayload())
                .repoPath(null);

        final GitLabProjectImportCreatePayload built = builder.build();

        assertThat(built.repoPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetNamespaceIsNullable() {
        final GitLabProjectImportCreatePayloadBuilder builder = GitLabProjectImportCreatePayloadBuilder.builder(
                        ProjectimportCatalogFixtures.projectImportCreatePayload())
                .targetNamespace(null);

        final GitLabProjectImportCreatePayload built = builder.build();

        assertThat(built.targetNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabProjectImportCreatePayloadBuilder builder = GitLabProjectImportCreatePayloadBuilder.builder(
                        ProjectimportCatalogFixtures.projectImportCreatePayload())
                .newName(null);

        final GitLabProjectImportCreatePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectImportCreatePayload value = ProjectimportCatalogFixtures.projectImportCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.bitbucketEmail()).isEqualTo("bitbucket_email");
            softly.assertThat(value.bitbucketApiToken()).isEqualTo("bitbucket_api_token");
            softly.assertThat(value.repoPath()).isEqualTo("repo_path");
            softly.assertThat(value.targetNamespace()).isEqualTo("target_namespace");
            softly.assertThat(value.newName()).isEqualTo("new_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectImportCreatePayload original = ProjectimportCatalogFixtures.projectImportCreatePayload();

        final GitLabProjectImportCreatePayload rebuilt =
                GitLabProjectImportCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenBitbucketApiTokenIsACredential() {
        final GitLabProjectImportCreatePayload value = ProjectimportCatalogFixtures.projectImportCreatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectImportCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("bitbucketEmail", "bitbucketApiToken", "repoPath", "targetNamespace", "newName");
    }
}
