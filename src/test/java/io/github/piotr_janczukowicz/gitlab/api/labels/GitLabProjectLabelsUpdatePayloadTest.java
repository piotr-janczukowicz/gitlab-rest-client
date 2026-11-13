package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLabelIdIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .labelId(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.labelId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .name(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .newName(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .color(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .description(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .archived(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectLabelsUpdatePayloadBuilder builder = GitLabProjectLabelsUpdatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsUpdatePayload())
                .priority(null);

        final GitLabProjectLabelsUpdatePayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsUpdatePayload value = LabelsCatalogFixtures.projectLabelsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.labelId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.priority()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsUpdatePayload original = LabelsCatalogFixtures.projectLabelsUpdatePayload();

        final GitLabProjectLabelsUpdatePayload rebuilt =
                GitLabProjectLabelsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("labelId", "name", "newName", "color", "description", "archived", "priority");
    }
}
