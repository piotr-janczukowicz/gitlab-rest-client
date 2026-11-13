package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectSnippetsUpdateFileTest {

    @Test
    void constructor_shouldRefuseNull_whenActionIsNull() {
        final GitLabProjectProjectSnippetsUpdateFileBuilder builder =
                GitLabProjectProjectSnippetsUpdateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile())
                        .action(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("action");
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectSnippetsUpdateFileBuilder builder =
                GitLabProjectProjectSnippetsUpdateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile())
                        .content(null);

        final GitLabProjectProjectSnippetsUpdateFile built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectProjectSnippetsUpdateFileBuilder builder =
                GitLabProjectProjectSnippetsUpdateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile())
                        .filePath(null);

        final GitLabProjectProjectSnippetsUpdateFile built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPreviousPathIsNullable() {
        final GitLabProjectProjectSnippetsUpdateFileBuilder builder =
                GitLabProjectProjectSnippetsUpdateFileBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile())
                        .previousPath(null);

        final GitLabProjectProjectSnippetsUpdateFile built = builder.build();

        assertThat(built.previousPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectSnippetsUpdateFile value =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile();

        assertSoftly(softly -> {
            softly.assertThat(value.action()).isEqualTo(GitLabProjectProjectSnippetsUpdateFileAction.CREATE);
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.previousPath()).isEqualTo("previous_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectSnippetsUpdateFile original =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile();

        final GitLabProjectProjectSnippetsUpdateFile rebuilt =
                GitLabProjectProjectSnippetsUpdateFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectSnippetsUpdateFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("action", "content", "filePath", "previousPath");
    }
}
