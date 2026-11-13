package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

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
class GitLabSnippetTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .id(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .title(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .description(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .visibility(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .author(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .createdAt(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .updatedAt(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .projectId(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .webUrl(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawUrlIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .rawUrl(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.rawUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .sshUrlToRepo(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .httpUrlToRepo(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .fileName(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .files(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .imported(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.imported()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportedFromIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .importedFrom(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.importedFrom()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabSnippetBuilder builder = GitLabSnippetBuilder.builder(CodesnippetsCatalogFixtures.snippet())
                .repositoryStorage(null);

        final GitLabSnippet built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSnippet value = CodesnippetsCatalogFixtures.snippet();

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
        final GitLabSnippet original = CodesnippetsCatalogFixtures.snippet();

        final GitLabSnippet rebuilt = GitLabSnippetBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSnippet.class.getRecordComponents())
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
