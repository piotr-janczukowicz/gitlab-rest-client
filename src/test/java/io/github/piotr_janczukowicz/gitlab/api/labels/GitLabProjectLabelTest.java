package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .id(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .name(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .description(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTextColorIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .textColor(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.textColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .descriptionHtml(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .color(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .archived(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenIssuesCountIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .openIssuesCount(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.openIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedIssuesCountIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .closedIssuesCount(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.closedIssuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenMergeRequestsCountIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .openMergeRequestsCount(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.openMergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubscribedIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .subscribed(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.subscribed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .priority(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsProjectLabelIsNullable() {
        final GitLabProjectLabelBuilder builder = GitLabProjectLabelBuilder.builder(
                        LabelsCatalogFixtures.projectLabel())
                .isProjectLabel(null);

        final GitLabProjectLabel built = builder.build();

        assertThat(built.isProjectLabel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabel value = LabelsCatalogFixtures.projectLabel();

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
            softly.assertThat(value.priority()).isEqualTo(1);
            softly.assertThat(value.isProjectLabel()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabel original = LabelsCatalogFixtures.projectLabel();

        final GitLabProjectLabel rebuilt =
                GitLabProjectLabelBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabel.class.getRecordComponents())
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
                        "subscribed",
                        "priority",
                        "isProjectLabel");
    }
}
