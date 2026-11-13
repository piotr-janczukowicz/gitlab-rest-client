package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupLabelTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .id(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .name(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .description(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextColorIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .textColor(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.textColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .descriptionHtml(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .color(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .archived(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .openIssuesCount(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedIssuesCountIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .closedIssuesCount(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.closedIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenMergeRequestsCountIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .openMergeRequestsCount(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.openMergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabGroupLabelBuilder builder = GitLabGroupLabelBuilder.builder(CommonCatalogFixtures.groupLabel())
                .subscribed(null);

        final GitLabGroupLabel built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupLabel value = CommonCatalogFixtures.groupLabel();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("bug");
            softly.assertThat(value.description()).isEqualTo("Bug reported by user");
            softly.assertThat(value.textColor()).isEqualTo("#FFFFFF");
            softly.assertThat(value.descriptionHtml()).isEqualTo("<p>Bug reported by user</p>");
            softly.assertThat(value.color()).isEqualTo("#FF0000");
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.openIssuesCount()).isEqualTo(1);
            softly.assertThat(value.closedIssuesCount()).isEqualTo(1);
            softly.assertThat(value.openMergeRequestsCount()).isEqualTo(1);
            softly.assertThat(value.subscribed()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupLabel original = CommonCatalogFixtures.groupLabel();

        final GitLabGroupLabel rebuilt =
                GitLabGroupLabelBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupLabel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "description",
                        "textColor",
                        "descriptionHtml",
                        "color",
                        "archived",
                        "openIssuesCount",
                        "closedIssuesCount",
                        "openMergeRequestsCount",
                        "subscribed");
    }
}
