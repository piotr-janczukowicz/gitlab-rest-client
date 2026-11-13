package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSnippetsUpdateFileTest {

    @Test
    void constructor_shouldRefuseNull_whenActionIsNull() {
        final GitLabCodeSnippetsUpdateFileBuilder builder = GitLabCodeSnippetsUpdateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdateFile())
                .action(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("action");
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabCodeSnippetsUpdateFileBuilder builder = GitLabCodeSnippetsUpdateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdateFile())
                .content(null);

        final GitLabCodeSnippetsUpdateFile built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabCodeSnippetsUpdateFileBuilder builder = GitLabCodeSnippetsUpdateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdateFile())
                .filePath(null);

        final GitLabCodeSnippetsUpdateFile built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreviousPathIsNullable() {
        final GitLabCodeSnippetsUpdateFileBuilder builder = GitLabCodeSnippetsUpdateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsUpdateFile())
                .previousPath(null);

        final GitLabCodeSnippetsUpdateFile built = builder.build();

        assertThat(built.previousPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsUpdateFile value = CodesnippetsCatalogFixtures.codeSnippetsUpdateFile();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo(GitLabCodeSnippetsUpdateFileAction.CREATE);
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.previousPath()).isEqualTo("previous_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsUpdateFile original = CodesnippetsCatalogFixtures.codeSnippetsUpdateFile();

        final GitLabCodeSnippetsUpdateFile rebuilt =
                GitLabCodeSnippetsUpdateFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSnippetsUpdateFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("action", "content", "filePath", "previousPath");
    }
}
