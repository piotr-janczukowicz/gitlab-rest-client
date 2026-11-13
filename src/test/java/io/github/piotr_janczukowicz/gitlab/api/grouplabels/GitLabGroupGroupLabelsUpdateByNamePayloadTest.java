package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLabelsUpdateByNamePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNewNameIsNullable() {
        final GitLabGroupGroupLabelsUpdateByNamePayloadBuilder builder =
                GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder(
                                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload())
                        .newName(null);

        final GitLabGroupGroupLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.newName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupGroupLabelsUpdateByNamePayloadBuilder builder =
                GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder(
                                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload())
                        .color(null);

        final GitLabGroupGroupLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupLabelsUpdateByNamePayloadBuilder builder =
                GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder(
                                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload())
                        .description(null);

        final GitLabGroupGroupLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupLabelsUpdateByNamePayloadBuilder builder =
                GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder(
                                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload())
                        .archived(null);

        final GitLabGroupGroupLabelsUpdateByNamePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLabelsUpdateByNamePayload value =
                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.newName()).isEqualTo("new_name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLabelsUpdateByNamePayload original =
                GrouplabelsCatalogFixtures.groupGroupLabelsUpdateByNamePayload();

        final GitLabGroupGroupLabelsUpdateByNamePayload rebuilt =
                GitLabGroupGroupLabelsUpdateByNamePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLabelsUpdateByNamePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("newName", "color", "description", "archived");
    }
}
