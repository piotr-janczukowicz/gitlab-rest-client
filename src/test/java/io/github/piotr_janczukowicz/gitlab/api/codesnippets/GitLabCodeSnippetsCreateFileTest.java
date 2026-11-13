package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSnippetsCreateFileTest {

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabCodeSnippetsCreateFileBuilder builder = GitLabCodeSnippetsCreateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreateFile())
                .filePath(null);

        final GitLabCodeSnippetsCreateFile built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabCodeSnippetsCreateFileBuilder builder = GitLabCodeSnippetsCreateFileBuilder.builder(
                        CodesnippetsCatalogFixtures.codeSnippetsCreateFile())
                .content(null);

        final GitLabCodeSnippetsCreateFile built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsCreateFile value = CodesnippetsCatalogFixtures.codeSnippetsCreateFile();

        assertSoftly(softly -> {
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.content()).isEqualTo("content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsCreateFile original = CodesnippetsCatalogFixtures.codeSnippetsCreateFile();

        final GitLabCodeSnippetsCreateFile rebuilt =
                GitLabCodeSnippetsCreateFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSnippetsCreateFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filePath", "content");
    }
}
