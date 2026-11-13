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
class GitLabProjectProjectSnippetsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .title(null);

        final GitLabProjectProjectSnippetsCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .description(null);

        final GitLabProjectProjectSnippetsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenVisibilityIsNull() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .visibility(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("visibility");
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .files(null);

        final GitLabProjectProjectSnippetsCreatePayload built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .content(null);

        final GitLabProjectProjectSnippetsCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabProjectProjectSnippetsCreatePayloadBuilder builder =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .fileName(null);

        final GitLabProjectProjectSnippetsCreatePayload built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectSnippetsCreatePayload value =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.visibility()).isEqualTo(GitLabProjectProjectSnippetsCreateVisibility.PRIVATE);
            softly.assertThat(value.files())
                    .isEqualTo(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile()));
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.fileName()).isEqualTo("file_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectSnippetsCreatePayload original =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload();

        final GitLabProjectProjectSnippetsCreatePayload rebuilt =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFilesSourceChangesLater() {
        final List<GitLabProjectProjectSnippetsCreateFile> source =
                new ArrayList<>(List.of(ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreateFile()));
        final GitLabProjectProjectSnippetsCreatePayload built =
                GitLabProjectProjectSnippetsCreatePayloadBuilder.builder(
                                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload())
                        .files(source)
                        .build();
        source.clear();

        assertThat(built.files()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFilesIsRead() {
        final GitLabProjectProjectSnippetsCreatePayload built =
                ProjectsnippetsCatalogFixtures.projectProjectSnippetsCreatePayload();
        final List<GitLabProjectProjectSnippetsCreateFile> values = built.files();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectSnippetsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "description", "visibility", "files", "content", "fileName");
    }
}
