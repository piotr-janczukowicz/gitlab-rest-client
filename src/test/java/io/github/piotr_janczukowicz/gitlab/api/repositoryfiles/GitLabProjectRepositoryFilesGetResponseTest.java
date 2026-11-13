package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryFilesGetResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .fileName(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .filePath(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .size(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEncodingIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .encoding(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.encoding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .content(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentSha256IsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .contentSha256(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.contentSha256()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .ref(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBlobIdIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .blobId(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.blobId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIdIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .commitId(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.commitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastCommitIdIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .lastCommitId(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.lastCommitId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExecuteFilemodeIsNullable() {
        final GitLabProjectRepositoryFilesGetResponseBuilder builder =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse())
                        .executeFilemode(null);

        final GitLabProjectRepositoryFilesGetResponse built = builder.build();

        assertThat(built.executeFilemode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryFilesGetResponse value =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.fileName()).isEqualTo("file_name");
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.encoding()).isEqualTo("encoding");
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.contentSha256()).isEqualTo("content_sha256");
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.blobId()).isEqualTo("blob_id");
            softly.assertThat(value.commitId()).isEqualTo("commit_id");
            softly.assertThat(value.lastCommitId()).isEqualTo("last_commit_id");
            softly.assertThat(value.executeFilemode()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryFilesGetResponse original =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesGetResponse();

        final GitLabProjectRepositoryFilesGetResponse rebuilt =
                GitLabProjectRepositoryFilesGetResponseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryFilesGetResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "fileName",
                        "filePath",
                        "size",
                        "encoding",
                        "content",
                        "contentSha256",
                        "ref",
                        "blobId",
                        "commitId",
                        "lastCommitId",
                        "executeFilemode");
    }
}
