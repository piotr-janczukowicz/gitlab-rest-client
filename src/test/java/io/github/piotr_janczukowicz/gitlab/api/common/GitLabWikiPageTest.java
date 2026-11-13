package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabWikiPageTest {

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).format(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).slug(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).title(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageMetaIdIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).wikiPageMetaId(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.wikiPageMetaId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).content(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEncodingIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).encoding(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.encoding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFrontMatterIsNullable() {
        final GitLabWikiPageBuilder builder =
                GitLabWikiPageBuilder.builder(CommonCatalogFixtures.wikiPage()).frontMatter(null);

        final GitLabWikiPage built = builder.build();

        assertThat(built.frontMatter()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabWikiPage value = CommonCatalogFixtures.wikiPage();

        assertSoftly(softly -> {
            softly.assertThat(value.format()).isEqualTo("markdown");
            softly.assertThat(value.slug()).isEqualTo("deploy");
            softly.assertThat(value.title()).isEqualTo("deploy");
            softly.assertThat(value.wikiPageMetaId()).isEqualTo(1L);
            softly.assertThat(value.content()).isEqualTo("Here is an instruction how to deploy this project.");
            softly.assertThat(value.encoding()).isEqualTo("UTF-8");
            softly.assertThat(value.frontMatter()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabWikiPage original = CommonCatalogFixtures.wikiPage();

        final GitLabWikiPage rebuilt = GitLabWikiPageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabWikiPage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("format", "slug", "title", "wikiPageMetaId", "content", "encoding", "frontMatter");
    }
}
