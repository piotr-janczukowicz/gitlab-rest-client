package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectSnippetsCreateFileTest {

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectProjectSnippetsCreateFileBuilder builder =
                GitLabProjectProjectSnippetsCreateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile())
                        .filePath(null);

        final GitLabProjectProjectSnippetsCreateFile built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectSnippetsCreateFileBuilder builder =
                GitLabProjectProjectSnippetsCreateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile())
                        .content(null);

        final GitLabProjectProjectSnippetsCreateFile built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectSnippetsCreateFile value =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile();

        assertSoftly(softly -> {
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.content()).isEqualTo("content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectSnippetsCreateFile original =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile();

        final GitLabProjectProjectSnippetsCreateFile rebuilt =
                GitLabProjectProjectSnippetsCreateFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectSnippetsCreateFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filePath", "content");
    }
}
