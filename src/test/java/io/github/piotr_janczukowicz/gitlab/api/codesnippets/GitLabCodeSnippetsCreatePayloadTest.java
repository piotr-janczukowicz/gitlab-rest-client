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
class GitLabCodeSnippetsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .title(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .description(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .visibility(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .files(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .content(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabCodeSnippetsCreatePayloadBuilder builder = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .fileName(null);

        final GitLabCodeSnippetsCreatePayload built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsCreatePayload value = CodesnippetsCatalogFixtures.codeSnippetsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.visibility()).isEqualTo(GitLabCodeSnippetsCreateVisibility.PRIVATE);
            softly.assertThat(value.files()).isEqualTo(List.of(CodesnippetsCatalogFixtures.codeSnippetsCreateFile()));
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.fileName()).isEqualTo("file_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsCreatePayload original = CodesnippetsCatalogFixtures.codeSnippetsCreatePayload();

        final GitLabCodeSnippetsCreatePayload rebuilt =
                GitLabCodeSnippetsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFilesSourceChangesLater() {
        final List<GitLabCodeSnippetsCreateFile> source =
                new ArrayList<>(List.of(CodesnippetsCatalogFixtures.codeSnippetsCreateFile()));
        final GitLabCodeSnippetsCreatePayload built = GitLabCodeSnippetsCreatePayloadBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreatePayload())
                .files(source)
                .build();
        source.clear();

        assertThat(built.files()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFilesIsRead() {
        final GitLabCodeSnippetsCreatePayload built = CodesnippetsCatalogFixtures.codeSnippetsCreatePayload();
        final List<GitLabCodeSnippetsCreateFile> values = built.files();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSnippetsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "description", "visibility", "files", "content", "fileName");
    }
}
