package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryFilesDeleteFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStartBranchIsNullable() {
        final GitLabProjectRepositoryFilesDeleteFilterBuilder builder =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder(
                                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                                        .startBranch("start_branch")
                                        .authorEmail("author_email")
                                        .authorName("author_name")
                                        .lastCommitId("last_commit_id")
                                        .build())
                        .startBranch(null);

        final GitLabProjectRepositoryFilesDeleteFilter built = builder.build();

        assertThat(built.startBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorEmailIsNullable() {
        final GitLabProjectRepositoryFilesDeleteFilterBuilder builder =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder(
                                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                                        .startBranch("start_branch")
                                        .authorEmail("author_email")
                                        .authorName("author_name")
                                        .lastCommitId("last_commit_id")
                                        .build())
                        .authorEmail(null);

        final GitLabProjectRepositoryFilesDeleteFilter built = builder.build();

        assertThat(built.authorEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorNameIsNullable() {
        final GitLabProjectRepositoryFilesDeleteFilterBuilder builder =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder(
                                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                                        .startBranch("start_branch")
                                        .authorEmail("author_email")
                                        .authorName("author_name")
                                        .lastCommitId("last_commit_id")
                                        .build())
                        .authorName(null);

        final GitLabProjectRepositoryFilesDeleteFilter built = builder.build();

        assertThat(built.authorName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastCommitIdIsNullable() {
        final GitLabProjectRepositoryFilesDeleteFilterBuilder builder =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder(
                                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                                        .startBranch("start_branch")
                                        .authorEmail("author_email")
                                        .authorName("author_name")
                                        .lastCommitId("last_commit_id")
                                        .build())
                        .lastCommitId(null);

        final GitLabProjectRepositoryFilesDeleteFilter built = builder.build();

        assertThat(built.lastCommitId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryFilesDeleteFilter value = GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                .startBranch("start_branch")
                .authorEmail("author_email")
                .authorName("author_name")
                .lastCommitId("last_commit_id")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.startBranch()).isEqualTo("start_branch");
            softly.assertThat(value.authorEmail()).isEqualTo("author_email");
            softly.assertThat(value.authorName()).isEqualTo("author_name");
            softly.assertThat(value.lastCommitId()).isEqualTo("last_commit_id");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryFilesDeleteFilter original =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                        .startBranch("start_branch")
                        .authorEmail("author_email")
                        .authorName("author_name")
                        .lastCommitId("last_commit_id")
                        .build();

        final GitLabProjectRepositoryFilesDeleteFilter rebuilt =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryFilesDeleteFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("startBranch", "authorEmail", "authorName", "lastCommitId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoryFilesDeleteFilter empty = GitLabProjectRepositoryFilesDeleteFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoryFilesDeleteFilter filter =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                        .startBranch("start_branch")
                        .authorEmail("author_email")
                        .authorName("author_name")
                        .lastCommitId("last_commit_id")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("start_branch", "start_branch"),
                        Map.entry("author_email", "author_email"),
                        Map.entry("author_name", "author_name"),
                        Map.entry("last_commit_id", "last_commit_id"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoryFilesDeleteFilter filter =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                        .startBranch("start_branch")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("start_branch", "start_branch"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoryFilesDeleteFilter filter =
                GitLabProjectRepositoryFilesDeleteFilterBuilder.builder()
                        .startBranch("start_branch")
                        .authorEmail("author_email")
                        .authorName("author_name")
                        .lastCommitId("last_commit_id")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
