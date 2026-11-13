package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicBoardTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .id(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .name(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideBacklogListIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .hideBacklogList(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.hideBacklogList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHideClosedListIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .hideClosedList(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.hideClosedList()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .group(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .labels(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenListsIsNullable() {
        final GitLabEpicBoardBuilder builder = GitLabEpicBoardBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoard())
                .lists(null);

        final GitLabEpicBoard built = builder.build();

        assertThat(built.lists()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicBoard value = GroupepicboardsCatalogFixtures.epicBoard();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("Team Board");
            softly.assertThat(value.hideBacklogList()).isEqualTo(true);
            softly.assertThat(value.hideClosedList()).isEqualTo(true);
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.basicGroupDetails());
            softly.assertThat(value.labels()).isEqualTo(List.of(CommonCatalogFixtures.labelBasic()));
            softly.assertThat(value.lists()).isEqualTo(List.of(GroupepicboardsCatalogFixtures.epicBoardsList()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicBoard original = GroupepicboardsCatalogFixtures.epicBoard();

        final GitLabEpicBoard rebuilt = GitLabEpicBoardBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicBoard.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "name", "hideBacklogList", "hideClosedList", "group", "labels", "lists");
    }
}
