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
class GitLabProjectSearchCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
                .ref(null);

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFieldsIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.fields()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumContextLinesIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.numContextLines()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNumContextLinesIsBelowTheMinimum() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.regex()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceBranchIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.sourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetBranchIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.targetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorUsernameIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.authorUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelNameIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.labelName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotSourceBranchIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.notSourceBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotTargetBranchIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.notTargetBranch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotAuthorUsernameIsNullable() {
        final GitLabProjectSearchCallFilterBuilder builder = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter built = builder.build();

        assertThat(built.notAuthorUsername()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectSearchCallFilter value = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.state()).isEqualTo(GitLabProjectSearchCallState.ALL);
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.type()).isEqualTo(List.of("type"));
            softly.assertThat(value.fields()).isEqualTo(List.of(GitLabProjectSearchCallFields.TITLE));
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
        final GitLabProjectSearchCallFilter original = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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

        final GitLabProjectSearchCallFilter rebuilt =
                GitLabProjectSearchCallFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTypeSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("type"));
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final List<GitLabProjectSearchCallFields> source =
                new ArrayList<>(List.of(GitLabProjectSearchCallFields.TITLE));
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final List<GitLabProjectSearchCallFields> values = built.fields();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenLabelNameSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("label_name"));
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder(
                        GitLabProjectSearchCallFilterBuilder.builder()
                                .ref("ref")
                                .state(GitLabProjectSearchCallState.ALL)
                                .confidential(true)
                                .type(List.of("type"))
                                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final GitLabProjectSearchCallFilter built = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
        final String[] names = Arrays.stream(GitLabProjectSearchCallFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "ref",
                        "state",
                        "confidential",
                        "type",
                        "fields",
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
        final GitLabProjectSearchCallFilter empty = GitLabProjectSearchCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectSearchCallFilter filter = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
                        Map.entry("ref", "ref"),
                        Map.entry("state", "all"),
                        Map.entry("confidential", "true"),
                        Map.entry("type", "type"),
                        Map.entry("fields", "title"),
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
        final GitLabProjectSearchCallFilter filter =
                GitLabProjectSearchCallFilterBuilder.builder().ref("ref").build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectSearchCallFilter filter = GitLabProjectSearchCallFilterBuilder.builder()
                .ref("ref")
                .state(GitLabProjectSearchCallState.ALL)
                .confidential(true)
                .type(List.of("type"))
                .fields(List.of(GitLabProjectSearchCallFields.TITLE))
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
