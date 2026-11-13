package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabWikiAttachmentTest {

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabWikiAttachmentBuilder builder = GitLabWikiAttachmentBuilder.builder(
                        CommonCatalogFixtures.wikiAttachment())
                .fileName(null);

        final GitLabWikiAttachment built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabWikiAttachmentBuilder builder = GitLabWikiAttachmentBuilder.builder(
                        CommonCatalogFixtures.wikiAttachment())
                .filePath(null);

        final GitLabWikiAttachment built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchIsNullable() {
        final GitLabWikiAttachmentBuilder builder = GitLabWikiAttachmentBuilder.builder(
                        CommonCatalogFixtures.wikiAttachment())
                .branch(null);

        final GitLabWikiAttachment built = builder.build();

        assertThat(built.branch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkIsNullable() {
        final GitLabWikiAttachmentBuilder builder = GitLabWikiAttachmentBuilder.builder(
                        CommonCatalogFixtures.wikiAttachment())
                .link(null);

        final GitLabWikiAttachment built = builder.build();

        assertThat(built.link()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabWikiAttachment value = CommonCatalogFixtures.wikiAttachment();

        assertSoftly(softly -> {
            softly.assertThat(value.fileName()).isEqualTo("dk.png");
            softly.assertThat(value.filePath()).isEqualTo("uploads/6a061c4cf9f1c28cb22c384b4b8d4e3c/dk.png");
            softly.assertThat(value.branch()).isEqualTo("main");
            softly.assertThat(value.link()).isEqualTo(CommonCatalogFixtures.wikiAttachmentLink());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabWikiAttachment original = CommonCatalogFixtures.wikiAttachment();

        final GitLabWikiAttachment rebuilt =
                GitLabWikiAttachmentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabWikiAttachment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("fileName", "filePath", "branch", "link");
    }
}
