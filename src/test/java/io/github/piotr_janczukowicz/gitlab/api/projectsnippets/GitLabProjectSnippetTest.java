package io.github.piotr_janczukowicz.gitlab.api.projectsnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectSnippetTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .id(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .title(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .description(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .visibility(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .author(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .createdAt(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .updatedAt(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .projectId(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .webUrl(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawUrlIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .rawUrl(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.rawUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .sshUrlToRepo(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .httpUrlToRepo(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .fileName(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .files(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .imported(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .importedFrom(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectSnippetBuilder builder = GitLabProjectSnippetBuilder.builder(
                        ProjectsnippetsCatalogFixtures.projectSnippet())
                .repositoryStorage(null);

        final GitLabProjectSnippet built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectSnippet value = ProjectsnippetsCatalogFixtures.projectSnippet();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.title()).isEqualTo("test");
            softly.assertThat(value.description()).isEqualTo("Ruby test snippet");
            softly.assertThat(value.visibility()).isEqualTo("public");
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.webUrl()).isEqualTo("http://example.com/example/example/snippets/1");
            softly.assertThat(value.rawUrl()).isEqualTo("http://example.com/example/example/snippets/1/raw");
            softly.assertThat(value.sshUrlToRepo()).isEqualTo("ssh://user@gitlab.example.com/snippets/65.git");
            softly.assertThat(value.httpUrlToRepo()).isEqualTo("https://gitlab.example.com/snippets/65.git");
            softly.assertThat(value.fileName()).isEqualTo("add.rb");
            softly.assertThat(value.files()).isEqualTo(List.of(Map.of("key", "value")));
            softly.assertThat(value.imported()).isEqualTo(true);
            softly.assertThat(value.importedFrom()).isEqualTo("none");
            softly.assertThat(value.repositoryStorage()).isEqualTo("default");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectSnippet original = ProjectsnippetsCatalogFixtures.projectSnippet();

        final GitLabProjectSnippet rebuilt =
                GitLabProjectSnippetBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectSnippet.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "title",
                        "description",
                        "visibility",
                        "author",
                        "createdAt",
                        "updatedAt",
                        "projectId",
                        "webUrl",
                        "rawUrl",
                        "sshUrlToRepo",
                        "httpUrlToRepo",
                        "fileName",
                        "files",
                        "imported",
                        "importedFrom",
                        "repositoryStorage");
    }
}
