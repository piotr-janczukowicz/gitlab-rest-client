package io.github.piotr_janczukowicz.gitlab.api.markdownuploads;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectUploadTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectUploadBuilder builder = GitLabProjectUploadBuilder.builder(
                        MarkdownuploadsCatalogFixtures.projectUpload())
                .id(null);

        final GitLabProjectUpload built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAltIsNullable() {
        final GitLabProjectUploadBuilder builder = GitLabProjectUploadBuilder.builder(
                        MarkdownuploadsCatalogFixtures.projectUpload())
                .alt(null);

        final GitLabProjectUpload built = builder.build();

        assertThat(built.alt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectUploadBuilder builder = GitLabProjectUploadBuilder.builder(
                        MarkdownuploadsCatalogFixtures.projectUpload())
                .url(null);

        final GitLabProjectUpload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabProjectUploadBuilder builder = GitLabProjectUploadBuilder.builder(
                        MarkdownuploadsCatalogFixtures.projectUpload())
                .fullPath(null);

        final GitLabProjectUpload built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkdownIsNullable() {
        final GitLabProjectUploadBuilder builder = GitLabProjectUploadBuilder.builder(
                        MarkdownuploadsCatalogFixtures.projectUpload())
                .markdown(null);

        final GitLabProjectUpload built = builder.build();

        assertThat(built.markdown()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectUpload value = MarkdownuploadsCatalogFixtures.projectUpload();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.alt()).isEqualTo("filename");
            softly.assertThat(value.url()).isEqualTo("/uploads/secret/filename");
            softly.assertThat(value.fullPath()).isEqualTo("/-/project/1/uploads/secret/filename");
            softly.assertThat(value.markdown()).isEqualTo("[filename](/uploads/secret/filename)");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectUpload original = MarkdownuploadsCatalogFixtures.projectUpload();

        final GitLabProjectUpload rebuilt =
                GitLabProjectUploadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectUpload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "alt", "url", "fullPath", "markdown");
    }
}
