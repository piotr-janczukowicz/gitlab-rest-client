package io.github.piotr_janczukowicz.gitlab.api.labels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLabelsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectLabelsCreatePayloadBuilder builder = GitLabProjectLabelsCreatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsCreatePayload())
                .name(null);

        final GitLabProjectLabelsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabProjectLabelsCreatePayloadBuilder builder = GitLabProjectLabelsCreatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsCreatePayload())
                .color(null);

        final GitLabProjectLabelsCreatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectLabelsCreatePayloadBuilder builder = GitLabProjectLabelsCreatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsCreatePayload())
                .description(null);

        final GitLabProjectLabelsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabProjectLabelsCreatePayloadBuilder builder = GitLabProjectLabelsCreatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsCreatePayload())
                .archived(null);

        final GitLabProjectLabelsCreatePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPriorityIsNullable() {
        final GitLabProjectLabelsCreatePayloadBuilder builder = GitLabProjectLabelsCreatePayloadBuilder.builder(
                        LabelsCatalogFixtures.projectLabelsCreatePayload())
                .priority(null);

        final GitLabProjectLabelsCreatePayload built = builder.build();

        assertThat(built.priority()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLabelsCreatePayload value = LabelsCatalogFixtures.projectLabelsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
            softly.assertThat(value.priority()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLabelsCreatePayload original = LabelsCatalogFixtures.projectLabelsCreatePayload();

        final GitLabProjectLabelsCreatePayload rebuilt =
                GitLabProjectLabelsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLabelsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "color", "description", "archived", "priority");
    }
}
