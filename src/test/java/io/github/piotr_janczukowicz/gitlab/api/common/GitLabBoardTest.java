package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBoardTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).id(null);

        final GitLabBoard built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).name(null);

        final GitLabBoard built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideBacklogListIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).hideBacklogList(null);

        final GitLabBoard built = builder.build();

        assertThat(built.hideBacklogList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideClosedListIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).hideClosedList(null);

        final GitLabBoard built = builder.build();

        assertThat(built.hideClosedList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).project(null);

        final GitLabBoard built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenListsIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).lists(null);

        final GitLabBoard built = builder.build();

        assertThat(built.lists()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).group(null);

        final GitLabBoard built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).milestone(null);

        final GitLabBoard built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssigneeIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).assignee(null);

        final GitLabBoard built = builder.build();

        assertThat(built.assignee()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).labels(null);

        final GitLabBoard built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabBoardBuilder builder =
                GitLabBoardBuilder.builder(CommonCatalogFixtures.board()).weight(null);

        final GitLabBoard built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBoard value = CommonCatalogFixtures.board();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("Development");
            softly.assertThat(value.hideBacklogList()).isEqualTo(true);
            softly.assertThat(value.hideClosedList()).isEqualTo(true);
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(value.lists()).isEqualTo(List.of(CommonCatalogFixtures.list()));
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.basicGroupDetails());
            softly.assertThat(value.milestone()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.assignee()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.labels()).isEqualTo(List.of(CommonCatalogFixtures.labelBasic()));
            softly.assertThat(value.weight()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBoard original = CommonCatalogFixtures.board();

        final GitLabBoard rebuilt = GitLabBoardBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBoard.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "hideBacklogList",
                        "hideClosedList",
                        "project",
                        "lists",
                        "group",
                        "milestone",
                        "assignee",
                        "labels",
                        "weight");
    }
}
