package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupSearchCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .state(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .confidential(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .type(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeArchivedIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .includeArchived(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.includeArchived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFieldsIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .fields(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.fields()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeForksIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .excludeForks(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.excludeForks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumContextLinesIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .numContextLines(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.numContextLines()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNumContextLinesIsBelowTheMinimum() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .numContextLines(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNumContextLinesIsTheMinimum() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .numContextLines(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNumContextLinesIsAboveTheMaximum() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .numContextLines(21);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNumContextLinesIsTheMaximum() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .numContextLines(20);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRegexIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .regex(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.regex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .sourceBranch(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .targetBranch(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .authorUsername(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelNameIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .labelName(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.labelName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotSourceBranchIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notSourceBranch(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.notSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotTargetBranchIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notTargetBranch(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.notTargetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabGroupSearchCallFilterBuilder builder = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .notAuthorUsername(null);

        final GitLabGroupSearchCallFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupSearchCallFilter value = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.state()).isEqualTo(GitLabGroupSearchCallState.ALL);
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.type()).isEqualTo(List.of("type"));
            softly.assertThat(value.includeArchived()).isEqualTo(true);
            softly.assertThat(value.fields()).isEqualTo(List.of(GitLabGroupSearchCallFields.TITLE));
            softly.assertThat(value.excludeForks()).isEqualTo(true);
            softly.assertThat(value.numContextLines()).isEqualTo(1);
            softly.assertThat(value.regex()).isEqualTo(true);
            softly.assertThat(value.sourceBranch()).isEqualTo("source_branch");
            softly.assertThat(value.targetBranch()).isEqualTo("target_branch");
            softly.assertThat(value.authorUsername()).isEqualTo("author_username");
            softly.assertThat(value.labelName()).isEqualTo(List.of("label_name"));
            softly.assertThat(value.notSourceBranch()).isEqualTo("not[source_branch]");
            softly.assertThat(value.notTargetBranch()).isEqualTo("not[target_branch]");
            softly.assertThat(value.notAuthorUsername()).isEqualTo("not[author_username]");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupSearchCallFilter original = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();

        final GitLabGroupSearchCallFilter rebuilt =
                GitLabGroupSearchCallFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTypeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("type"));
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .type(source)
                .build();
        source.clear();

        assertThat(built.type()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTypeIsRead() {
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();
        final List<String> values = built.type();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenFieldsSourceChangesLater() {
        final List<GitLabGroupSearchCallFields> source = new ArrayList<>(List.of(GitLabGroupSearchCallFields.TITLE));
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .fields(source)
                .build();
        source.clear();

        assertThat(built.fields()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFieldsIsRead() {
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();
        final List<GitLabGroupSearchCallFields> values = built.fields();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelNameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("label_name"));
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder(
                        GitLabGroupSearchCallFilterBuilder.builder()
                                .state(GitLabGroupSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                                .excludeForks(true)
                                .numContextLines(1)
                                .regex(true)
                                .sourceBranch("source_branch")
                                .targetBranch("target_branch")
                                .authorUsername("author_username")
                                .labelName(List.of("label_name"))
                                .notSourceBranch("not[source_branch]")
                                .notTargetBranch("not[target_branch]")
                                .notAuthorUsername("not[author_username]")
                                .build())
                .labelName(source)
                .build();
        source.clear();

        assertThat(built.labelName()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLabelNameIsRead() {
        final GitLabGroupSearchCallFilter built = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();
        final List<String> values = built.labelName();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupSearchCallFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "state",
                        "confidential",
                        "type",
                        "includeArchived",
                        "fields",
                        "excludeForks",
                        "numContextLines",
                        "regex",
                        "sourceBranch",
                        "targetBranch",
                        "authorUsername",
                        "labelName",
                        "notSourceBranch",
                        "notTargetBranch",
                        "notAuthorUsername");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabGroupSearchCallFilter empty = GitLabGroupSearchCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabGroupSearchCallFilter filter = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query)
                .containsExactly(
                        Map.entry("state", "all"),
                        Map.entry("confidential", "true"),
                        Map.entry("type", "type"),
                        Map.entry("include_archived", "true"),
                        Map.entry("fields", "title"),
                        Map.entry("exclude_forks", "true"),
                        Map.entry("num_context_lines", "1"),
                        Map.entry("regex", "true"),
                        Map.entry("source_branch", "source_branch"),
                        Map.entry("target_branch", "target_branch"),
                        Map.entry("author_username", "author_username"),
                        Map.entry("label_name", "label_name"),
                        Map.entry("not[source_branch]", "not[source_branch]"),
                        Map.entry("not[target_branch]", "not[target_branch]"),
                        Map.entry("not[author_username]", "not[author_username]"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabGroupSearchCallFilter filter = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "all"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabGroupSearchCallFilter filter = GitLabGroupSearchCallFilterBuilder.builder()
                .state(GitLabGroupSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabGroupSearchCallFields.TITLE))
                .excludeForks(true)
                .numContextLines(1)
                .regex(true)
                .sourceBranch("source_branch")
                .targetBranch("target_branch")
                .authorUsername("author_username")
                .labelName(List.of("label_name"))
                .notSourceBranch("not[source_branch]")
                .notTargetBranch("not[target_branch]")
                .notAuthorUsername("not[author_username]")
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
