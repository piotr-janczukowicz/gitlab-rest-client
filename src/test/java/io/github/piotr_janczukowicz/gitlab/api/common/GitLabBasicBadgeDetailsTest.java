package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBasicBadgeDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBasicBadgeDetailsBuilder builder = GitLabBasicBadgeDetailsBuilder.builder(
                        CommonCatalogFixtures.basicBadgeDetails())
                .name(null);

        final GitLabBasicBadgeDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkUrlIsNullable() {
        final GitLabBasicBadgeDetailsBuilder builder = GitLabBasicBadgeDetailsBuilder.builder(
                        CommonCatalogFixtures.basicBadgeDetails())
                .linkUrl(null);

        final GitLabBasicBadgeDetails built = builder.build();

        assertThat(built.linkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageUrlIsNullable() {
        final GitLabBasicBadgeDetailsBuilder builder = GitLabBasicBadgeDetailsBuilder.builder(
                        CommonCatalogFixtures.basicBadgeDetails())
                .imageUrl(null);

        final GitLabBasicBadgeDetails built = builder.build();

        assertThat(built.imageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderedLinkUrlIsNullable() {
        final GitLabBasicBadgeDetailsBuilder builder = GitLabBasicBadgeDetailsBuilder.builder(
                        CommonCatalogFixtures.basicBadgeDetails())
                .renderedLinkUrl(null);

        final GitLabBasicBadgeDetails built = builder.build();

        assertThat(built.renderedLinkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderedImageUrlIsNullable() {
        final GitLabBasicBadgeDetailsBuilder builder = GitLabBasicBadgeDetailsBuilder.builder(
                        CommonCatalogFixtures.basicBadgeDetails())
                .renderedImageUrl(null);

        final GitLabBasicBadgeDetails built = builder.build();

        assertThat(built.renderedImageUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBasicBadgeDetails value = CommonCatalogFixtures.basicBadgeDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("Pipeline Status");
            softly.assertThat(value.linkUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.imageUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.renderedLinkUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.renderedImageUrl()).isEqualTo("https://example.gitlab.com");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBasicBadgeDetails original = CommonCatalogFixtures.basicBadgeDetails();

        final GitLabBasicBadgeDetails rebuilt =
                GitLabBasicBadgeDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBasicBadgeDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "linkUrl", "imageUrl", "renderedLinkUrl", "renderedImageUrl");
    }
}
