package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

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
class GitLabProjectProjectSnippetsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .content(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .description(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .fileName(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .title(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .visibility(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabProjectProjectSnippetsUpdatePayloadBuilder builder =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .files(null);

        final GitLabProjectProjectSnippetsUpdatePayload built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectSnippetsUpdatePayload value =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.fileName()).isEqualTo("file_name");
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.visibility()).isEqualTo(GitLabProjectProjectSnippetsUpdateVisibility.PRIVATE);
            softly.assertThat(value.files())
                    .isEqualTo(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectSnippetsUpdatePayload original =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload();

        final GitLabProjectProjectSnippetsUpdatePayload rebuilt =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFilesSourceChangesLater() {
        final List<GitLabProjectProjectSnippetsUpdateFile> source =
                new ArrayList<>(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdateFile()));
        final GitLabProjectProjectSnippetsUpdatePayload built =
                GitLabProjectProjectSnippetsUpdatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload())
                        .files(source)
                        .build();
        source.clear();

        assertThat(built.files()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFilesIsRead() {
        final GitLabProjectProjectSnippetsUpdatePayload built =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsUpdatePayload();
        final List<GitLabProjectProjectSnippetsUpdateFile> values = built.files();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectSnippetsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("content", "description", "fileName", "title", "visibility", "files");
    }
}
