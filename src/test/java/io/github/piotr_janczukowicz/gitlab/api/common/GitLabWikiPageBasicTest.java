package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabWikiPageBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabWikiPageBasicBuilder builder = GitLabWikiPageBasicBuilder.builder(
                        CommonCatalogFixtures.wikiPageBasic())
                .format(null);

        final GitLabWikiPageBasic built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabWikiPageBasicBuilder builder = GitLabWikiPageBasicBuilder.builder(
                        CommonCatalogFixtures.wikiPageBasic())
                .slug(null);

        final GitLabWikiPageBasic built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabWikiPageBasicBuilder builder = GitLabWikiPageBasicBuilder.builder(
                        CommonCatalogFixtures.wikiPageBasic())
                .title(null);

        final GitLabWikiPageBasic built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWikiPageMetaIdIsNullable() {
        final GitLabWikiPageBasicBuilder builder = GitLabWikiPageBasicBuilder.builder(
                        CommonCatalogFixtures.wikiPageBasic())
                .wikiPageMetaId(null);

        final GitLabWikiPageBasic built = builder.build();

        assertThat(built.wikiPageMetaId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabWikiPageBasic value = CommonCatalogFixtures.wikiPageBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.format()).isEqualTo("markdown");
            softly.assertThat(value.slug()).isEqualTo("deploy");
            softly.assertThat(value.title()).isEqualTo("deploy");
            softly.assertThat(value.wikiPageMetaId()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabWikiPageBasic original = CommonCatalogFixtures.wikiPageBasic();

        final GitLabWikiPageBasic rebuilt =
                GitLabWikiPageBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabWikiPageBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("format", "slug", "title", "wikiPageMetaId");
    }
}
