package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabWorkItemsStatusTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .id(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .name(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIconNameIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .iconName(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.iconName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .color(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .position(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .description(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCategoryIsNullable() {
        final GitLabWorkItemsStatusBuilder builder = GitLabWorkItemsStatusBuilder.builder(
                        CommonCatalogFixtures.workItemsStatus())
                .category(null);

        final GitLabWorkItemsStatus built = builder.build();

        assertThat(built.category()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabWorkItemsStatus value = CommonCatalogFixtures.workItemsStatus();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("To do");
            softly.assertThat(value.iconName()).isEqualTo(GitLabWorkItemsStatusIconName.STATUS_NEUTRAL);
            softly.assertThat(value.color()).isEqualTo("#737278");
            softly.assertThat(value.position()).isEqualTo(1);
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.category()).isEqualTo(GitLabWorkItemsStatusCategory.TRIAGE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabWorkItemsStatus original = CommonCatalogFixtures.workItemsStatus();

        final GitLabWorkItemsStatus rebuilt =
                GitLabWorkItemsStatusBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabWorkItemsStatus.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "iconName", "color", "position", "description", "category");
    }
}
