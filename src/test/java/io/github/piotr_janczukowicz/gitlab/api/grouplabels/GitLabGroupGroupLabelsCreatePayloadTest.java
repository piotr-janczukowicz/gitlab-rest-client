package io.github.piotr_janczukowicz.gitlab.api.grouplabels;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupLabelsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupLabelsCreatePayloadBuilder builder = GitLabGroupGroupLabelsCreatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload())
                .name(null);

        final GitLabGroupGroupLabelsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenColorIsNullable() {
        final GitLabGroupGroupLabelsCreatePayloadBuilder builder = GitLabGroupGroupLabelsCreatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload())
                .color(null);

        final GitLabGroupGroupLabelsCreatePayload built = builder.build();

        assertThat(built.color()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabGroupGroupLabelsCreatePayloadBuilder builder = GitLabGroupGroupLabelsCreatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload())
                .description(null);

        final GitLabGroupGroupLabelsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchivedIsNullable() {
        final GitLabGroupGroupLabelsCreatePayloadBuilder builder = GitLabGroupGroupLabelsCreatePayloadBuilder.builder(
                        GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload())
                .archived(null);

        final GitLabGroupGroupLabelsCreatePayload built = builder.build();

        assertThat(built.archived()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupLabelsCreatePayload value = GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.color()).isEqualTo("color");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.archived()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupLabelsCreatePayload original = GrouplabelsCatalogFixtures.groupGroupLabelsCreatePayload();

        final GitLabGroupGroupLabelsCreatePayload rebuilt =
                GitLabGroupGroupLabelsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupLabelsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "color", "description", "archived");
    }
}
