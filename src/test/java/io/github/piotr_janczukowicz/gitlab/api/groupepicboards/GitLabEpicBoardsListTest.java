package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicBoardsListTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicBoardsListBuilder builder = GitLabEpicBoardsListBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoardsList())
                .id(null);

        final GitLabEpicBoardsList built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabEpicBoardsListBuilder builder = GitLabEpicBoardsListBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoardsList())
                .label(null);

        final GitLabEpicBoardsList built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabEpicBoardsListBuilder builder = GitLabEpicBoardsListBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoardsList())
                .position(null);

        final GitLabEpicBoardsList built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenListTypeIsNullable() {
        final GitLabEpicBoardsListBuilder builder = GitLabEpicBoardsListBuilder.builder(
                        GroupepicboardsCatalogFixtures.epicBoardsList())
                .listType(null);

        final GitLabEpicBoardsList built = builder.build();

        assertThat(built.listType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicBoardsList value = GroupepicboardsCatalogFixtures.epicBoardsList();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.label()).isEqualTo(CommonCatalogFixtures.labelBasic());
            softly.assertThat(value.position()).isEqualTo(1);
            softly.assertThat(value.listType()).isEqualTo("backlog");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicBoardsList original = GroupepicboardsCatalogFixtures.epicBoardsList();

        final GitLabEpicBoardsList rebuilt =
                GitLabEpicBoardsListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicBoardsList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "label", "position", "listType");
    }
}
