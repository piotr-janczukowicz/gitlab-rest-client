package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryFilesUpdateResponseTest {

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectRepositoryFilesUpdateResponseBuilder builder =
                GitLabProjectRepositoryFilesUpdateResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse())
                        .filePath(null);

        final GitLabProjectRepositoryFilesUpdateResponse built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabProjectRepositoryFilesUpdateResponseBuilder builder =
                GitLabProjectRepositoryFilesUpdateResponseBuilder.builder(
                                RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse())
                        .branch(null);

        final GitLabProjectRepositoryFilesUpdateResponse built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryFilesUpdateResponse value =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse();

        assertSoftly(softly -> {
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.branch()).isEqualTo("branch");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryFilesUpdateResponse original =
                RepositoryfilesCatalogFixtures.projectRepositoryFilesUpdateResponse();

        final GitLabProjectRepositoryFilesUpdateResponse rebuilt =
                GitLabProjectRepositoryFilesUpdateResponseBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryFilesUpdateResponse.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filePath", "branch");
    }
}
