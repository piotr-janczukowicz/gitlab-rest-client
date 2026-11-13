package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicSnippetTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .id(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .title(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .description(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .visibility(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .author(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .createdAt(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .updatedAt(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .projectId(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .webUrl(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRawUrlIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .rawUrl(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.rawUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSshUrlToRepoIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .sshUrlToRepo(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.sshUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHttpUrlToRepoIsNullable() {
        final GitLabBasicSnippetBuilder builder = GitLabBasicSnippetBuilder.builder(
                        CommonCatalogFixtures.basicSnippet())
                .httpUrlToRepo(null);

        final GitLabBasicSnippet built = builder.build();

        assertThat(built.httpUrlToRepo()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicSnippet value = CommonCatalogFixtures.basicSnippet();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicSnippet original = CommonCatalogFixtures.basicSnippet();

        final GitLabBasicSnippet rebuilt =
                GitLabBasicSnippetBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicSnippet.class.getRecordComponents())
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
                        "httpUrlToRepo");
    }
}
