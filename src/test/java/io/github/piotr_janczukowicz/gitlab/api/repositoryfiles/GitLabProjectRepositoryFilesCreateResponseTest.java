package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryFilesCreateResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectRepositoryFilesCreateResponseBuilder builder =
                GitLabProjectRepositoryFilesCreateResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse())
                        .filePath(null);

        final GitLabProjectRepositoryFilesCreateResponse built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectRepositoryFilesCreateResponseBuilder builder =
                GitLabProjectRepositoryFilesCreateResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse())
                        .branch(null);

        final GitLabProjectRepositoryFilesCreateResponse built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryFilesCreateResponse value =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.branch()).isEqualTo("branch");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryFilesCreateResponse original =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesCreateResponse();

        final GitLabProjectRepositoryFilesCreateResponse rebuilt =
                GitLabProjectRepositoryFilesCreateResponseBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryFilesCreateResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filePath", "branch");
    }
}
