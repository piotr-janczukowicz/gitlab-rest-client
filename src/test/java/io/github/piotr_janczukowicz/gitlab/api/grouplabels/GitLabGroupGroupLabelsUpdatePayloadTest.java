package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLabelsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelIdIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .labelId(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.labelId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .name(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .newName(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .color(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .description(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupLabelsUpdatePayloadBuilder builder = GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload())
                .archived(null);

        final GitLabGroupGroupLabelsUpdatePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLabelsUpdatePayload value = GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.labelId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLabelsUpdatePayload original = GrouplabelsCatalogFixtures.groupGroupLabelsUpdatePayload();

        final GitLabGroupGroupLabelsUpdatePayload rebuilt =
                GitLabGroupGroupLabelsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLabelsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelId", "name", "newName", "color", "description", "archived");
    }
}
