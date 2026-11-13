package io.github.piotr_janczukowicz.gitlab.api.projectbadges;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectBadgesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLinkUrlIsNullable() {
        final GitLabProjectProjectBadgesCreatePayloadBuilder builder =
                GitLabProjectProjectBadgesCreatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesCreatePayload())
                        .linkUrl(null);

        final GitLabProjectProjectBadgesCreatePayload built = builder.build();

        assertThat(built.linkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageUrlIsNullable() {
        final GitLabProjectProjectBadgesCreatePayloadBuilder builder =
                GitLabProjectProjectBadgesCreatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesCreatePayload())
                        .imageUrl(null);

        final GitLabProjectProjectBadgesCreatePayload built = builder.build();

        assertThat(built.imageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectBadgesCreatePayloadBuilder builder =
                GitLabProjectProjectBadgesCreatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesCreatePayload())
                        .name(null);

        final GitLabProjectProjectBadgesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectBadgesCreatePayload value =
                ProjectbadgesCatalogFixtures.projectProjectBadgesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.linkUrl()).isEqualTo("link_url");
            softly.assertThat(value.imageUrl()).isEqualTo("image_url");
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectBadgesCreatePayload original =
                ProjectbadgesCatalogFixtures.projectProjectBadgesCreatePayload();

        final GitLabProjectProjectBadgesCreatePayload rebuilt =
                GitLabProjectProjectBadgesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectBadgesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("linkUrl", "imageUrl", "name");
    }
}
