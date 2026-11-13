package io.github.piotr_janczukowicz.gitlab.api.tags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTagsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTagNameIsNullable() {
        final GitLabProjectTagsCreatePayloadBuilder builder = GitLabProjectTagsCreatePayloadBuilder.builder(
                        TagsCatalogFixtures.projectTagsCreatePayload())
                .tagName(null);

        final GitLabProjectTagsCreatePayload built = builder.build();

        assertThat(built.tagName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectTagsCreatePayloadBuilder builder = GitLabProjectTagsCreatePayloadBuilder.builder(
                        TagsCatalogFixtures.projectTagsCreatePayload())
                .ref(null);

        final GitLabProjectTagsCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageIsNullable() {
        final GitLabProjectTagsCreatePayloadBuilder builder = GitLabProjectTagsCreatePayloadBuilder.builder(
                        TagsCatalogFixtures.projectTagsCreatePayload())
                .message(null);

        final GitLabProjectTagsCreatePayload built = builder.build();

        assertThat(built.message()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTagsCreatePayload value = TagsCatalogFixtures.projectTagsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.tagName()).isEqualTo("v.1.0.0");
            softly.assertThat(value.ref()).isEqualTo("2695effb5807a22ff3d138d593fd856244e155e7");
            softly.assertThat(value.message()).isEqualTo("Release 1.0.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTagsCreatePayload original = TagsCatalogFixtures.projectTagsCreatePayload();

        final GitLabProjectTagsCreatePayload rebuilt =
                GitLabProjectTagsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTagsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tagName", "ref", "message");
    }
}
