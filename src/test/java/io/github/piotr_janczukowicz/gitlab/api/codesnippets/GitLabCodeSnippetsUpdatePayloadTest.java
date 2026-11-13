package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSnippetsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .content(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .description(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .fileName(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .title(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .visibility(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabCodeSnippetsUpdatePayloadBuilder builder = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .files(null);

        final GitLabCodeSnippetsUpdatePayload built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsUpdatePayload value = CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.fileName()).isEqualTo("file_name");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.visibility()).isEqualTo(GitLabCodeSnippetsUpdateVisibility.PRIVATE);
            softly.assertThat(value.files()).isEqualTo(List.of(CodesnippetsCatalogFixtures.codeSnippetsUpdateFile()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsUpdatePayload original = CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload();

        final GitLabCodeSnippetsUpdatePayload rebuilt =
                GitLabCodeSnippetsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFilesSourceChangesLater() {
        final List<GitLabCodeSnippetsUpdateFile> source =
                new ArrayList<>(List.of(CodesnippetsCatalogFixtures.codeSnippetsUpdateFile()));
        final GitLabCodeSnippetsUpdatePayload built = GitLabCodeSnippetsUpdatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload())
                .files(source)
                .build();
        source.clear();

        assertThat(built.files()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFilesIsRead() {
        final GitLabCodeSnippetsUpdatePayload built = CodesnippetsCatalogFixtures.codeSnippetsUpdatePayload();
        final List<GitLabCodeSnippetsUpdateFile> values = built.files();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSnippetsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("content", "description", "fileName", "title", "visibility", "files");
    }
}
