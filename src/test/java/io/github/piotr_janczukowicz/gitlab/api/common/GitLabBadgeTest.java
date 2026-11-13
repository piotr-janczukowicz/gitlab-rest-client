package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBadgeTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).name(null);

        final GitLabBadge built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkUrlIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).linkUrl(null);

        final GitLabBadge built = builder.build();

        assertThat(built.linkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageUrlIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).imageUrl(null);

        final GitLabBadge built = builder.build();

        assertThat(built.imageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderedLinkUrlIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).renderedLinkUrl(null);

        final GitLabBadge built = builder.build();

        assertThat(built.renderedLinkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRenderedImageUrlIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).renderedImageUrl(null);

        final GitLabBadge built = builder.build();

        assertThat(built.renderedImageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).id(null);

        final GitLabBadge built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKindIsNullable() {
        final GitLabBadgeBuilder builder =
                GitLabBadgeBuilder.builder(CommonCatalogFixtures.badge()).kind(null);

        final GitLabBadge built = builder.build();

        assertThat(built.kind()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBadge value = CommonCatalogFixtures.badge();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("Pipeline Status");
            softly.assertThat(value.linkUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.imageUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.renderedLinkUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.renderedImageUrl()).isEqualTo("https://example.gitlab.com");
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.kind()).isEqualTo("project");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBadge original = CommonCatalogFixtures.badge();

        final GitLabBadge rebuilt = GitLabBadgeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBadge.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("name", "linkUrl", "imageUrl", "renderedLinkUrl", "renderedImageUrl", "id", "kind");
    }
}
