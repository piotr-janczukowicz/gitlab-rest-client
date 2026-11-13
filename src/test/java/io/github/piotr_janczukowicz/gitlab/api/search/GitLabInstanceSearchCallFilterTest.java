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
class GitLabInstanceSearchCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeArchivedIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.includeArchived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFieldsIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.fields()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExcludeForksIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.excludeForks()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumContextLinesIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.numContextLines()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNumContextLinesIsBelowTheMinimum() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.regex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelNameIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.labelName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotSourceBranchIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.notSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotTargetBranchIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.notTargetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabInstanceSearchCallFilterBuilder builder = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceSearchCallFilter value = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
            softly.assertThat(value.state()).isEqualTo(GitLabInstanceSearchCallState.ALL);
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.type()).isEqualTo(List.of("type"));
            softly.assertThat(value.includeArchived()).isEqualTo(true);
            softly.assertThat(value.fields()).isEqualTo(List.of(GitLabInstanceSearchCallFields.TITLE));
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
        final GitLabInstanceSearchCallFilter original = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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

        final GitLabInstanceSearchCallFilter rebuilt =
                GitLabInstanceSearchCallFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTypeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("type"));
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final List<GitLabInstanceSearchCallFields> source =
                new ArrayList<>(List.of(GitLabInstanceSearchCallFields.TITLE));
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final List<GitLabInstanceSearchCallFields> values = built.fields();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelNameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("label_name"));
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder(
                        GitLabInstanceSearchCallFilterBuilder.builder()
                                .state(GitLabInstanceSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .includeArchived(true)
                                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilter built = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final String[] names = Arrays.stream(GitLabInstanceSearchCallFilter.class.getRecordComponents())
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
        final GitLabInstanceSearchCallFilter empty = GitLabInstanceSearchCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabInstanceSearchCallFilter filter = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
        final GitLabInstanceSearchCallFilter filter = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("state", "all"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabInstanceSearchCallFilter filter = GitLabInstanceSearchCallFilterBuilder.builder()
                .state(GitLabInstanceSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .includeArchived(true)
                .fields(List.of(GitLabInstanceSearchCallFields.TITLE))
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
