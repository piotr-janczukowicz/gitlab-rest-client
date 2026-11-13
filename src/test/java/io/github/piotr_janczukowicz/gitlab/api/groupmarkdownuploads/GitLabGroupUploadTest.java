package io.github.piotr_janczukowicz.gitlab.api.groupmarkdownuploads;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupUploadTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupUploadBuilder builder = GitLabGroupUploadBuilder.builder(
                        GroupmarkdownuploadsCatalogFixtures.groupUpload())
                .id(null);

        final GitLabGroupUpload built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAltIsNullable() {
        final GitLabGroupUploadBuilder builder = GitLabGroupUploadBuilder.builder(
                        GroupmarkdownuploadsCatalogFixtures.groupUpload())
                .alt(null);

        final GitLabGroupUpload built = builder.build();

        assertThat(built.alt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupUploadBuilder builder = GitLabGroupUploadBuilder.builder(
                        GroupmarkdownuploadsCatalogFixtures.groupUpload())
                .url(null);

        final GitLabGroupUpload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabGroupUploadBuilder builder = GitLabGroupUploadBuilder.builder(
                        GroupmarkdownuploadsCatalogFixtures.groupUpload())
                .fullPath(null);

        final GitLabGroupUpload built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkdownIsNullable() {
        final GitLabGroupUploadBuilder builder = GitLabGroupUploadBuilder.builder(
                        GroupmarkdownuploadsCatalogFixtures.groupUpload())
                .markdown(null);

        final GitLabGroupUpload built = builder.build();

        assertThat(built.markdown()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupUpload value = GroupmarkdownuploadsCatalogFixtures.groupUpload();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.alt()).isEqualTo("alt");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.fullPath()).isEqualTo("full_path");
            softly.assertThat(value.markdown()).isEqualTo("markdown");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupUpload original = GroupmarkdownuploadsCatalogFixtures.groupUpload();

        final GitLabGroupUpload rebuilt =
                GitLabGroupUploadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupUpload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "alt", "url", "fullPath", "markdown");
    }
}
