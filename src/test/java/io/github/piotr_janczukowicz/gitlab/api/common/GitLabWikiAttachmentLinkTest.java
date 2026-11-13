package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabWikiAttachmentLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabWikiAttachmentLinkBuilder builder = GitLabWikiAttachmentLinkBuilder.builder(
                        CommonCatalogFixtures.wikiAttachmentLink())
                .url(null);

        final GitLabWikiAttachmentLink built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMarkdownIsNullable() {
        final GitLabWikiAttachmentLinkBuilder builder = GitLabWikiAttachmentLinkBuilder.builder(
                        CommonCatalogFixtures.wikiAttachmentLink())
                .markdown(null);

        final GitLabWikiAttachmentLink built = builder.build();

        assertThat(built.markdown()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabWikiAttachmentLink value = CommonCatalogFixtures.wikiAttachmentLink();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png");
            softly.assertThat(value.markdown()).isEqualTo("![dk](uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png)");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabWikiAttachmentLink original = CommonCatalogFixtures.wikiAttachmentLink();

        final GitLabWikiAttachmentLink rebuilt =
                GitLabWikiAttachmentLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabWikiAttachmentLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "markdown");
    }
}
