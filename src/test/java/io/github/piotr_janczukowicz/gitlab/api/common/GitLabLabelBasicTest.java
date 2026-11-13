package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLabelBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .id(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .name(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .description(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextColorIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .textColor(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.textColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .descriptionHtml(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .color(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabLabelBasicBuilder builder = GitLabLabelBasicBuilder.builder(CommonCatalogFixtures.labelBasic())
                .archived(null);

        final GitLabLabelBasic built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLabelBasic value = CommonCatalogFixtures.labelBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("bug");
            softly.assertThat(value.description()).isEqualTo("Bug reported by user");
            softly.assertThat(value.textColor()).isEqualTo("#FFFFFF");
            softly.assertThat(value.descriptionHtml()).isEqualTo("<p>Bug reported by user</p>");
            softly.assertThat(value.color()).isEqualTo("#FF0000");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLabelBasic original = CommonCatalogFixtures.labelBasic();

        final GitLabLabelBasic rebuilt =
                GitLabLabelBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLabelBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "name", "description", "textColor", "descriptionHtml", "color", "archived");
    }
}
