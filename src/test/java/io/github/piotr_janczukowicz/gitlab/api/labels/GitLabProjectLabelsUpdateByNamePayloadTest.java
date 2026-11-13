package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsUpdateByNamePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabProjectLabelsUpdateByNamePayloadBuilder builder =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(
                                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload())
                        .newName(null);

        final GitLabProjectLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabProjectLabelsUpdateByNamePayloadBuilder builder =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(
                                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload())
                        .color(null);

        final GitLabProjectLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectLabelsUpdateByNamePayloadBuilder builder =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(
                                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload())
                        .description(null);

        final GitLabProjectLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectLabelsUpdateByNamePayloadBuilder builder =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(
                                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload())
                        .archived(null);

        final GitLabProjectLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectLabelsUpdateByNamePayloadBuilder builder =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(
                                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload())
                        .priority(null);

        final GitLabProjectLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsUpdateByNamePayload value = LabelsCatalogFixtures.projectLabelsUpdateByNamePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.priority()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsUpdateByNamePayload original =
                LabelsCatalogFixtures.projectLabelsUpdateByNamePayload();

        final GitLabProjectLabelsUpdateByNamePayload rebuilt =
                GitLabProjectLabelsUpdateByNamePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsUpdateByNamePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("newName", "color", "description", "archived", "priority");
    }
}
