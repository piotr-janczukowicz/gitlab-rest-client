package io.github.piotr_janczukowicz.gitlab.api.projectbadges;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectBadgesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLinkUrlIsNullable() {
        final GitLabProjectProjectBadgesUpdatePayloadBuilder builder =
                GitLabProjectProjectBadgesUpdatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesUpdatePayload())
                        .linkUrl(null);

        final GitLabProjectProjectBadgesUpdatePayload built = builder.build();

        assertThat(built.linkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageUrlIsNullable() {
        final GitLabProjectProjectBadgesUpdatePayloadBuilder builder =
                GitLabProjectProjectBadgesUpdatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesUpdatePayload())
                        .imageUrl(null);

        final GitLabProjectProjectBadgesUpdatePayload built = builder.build();

        assertThat(built.imageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectBadgesUpdatePayloadBuilder builder =
                GitLabProjectProjectBadgesUpdatePayloadBuilder.builder(
                                ProjectbadgesCatalogFixtures.projectProjectBadgesUpdatePayload())
                        .name(null);

        final GitLabProjectProjectBadgesUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectBadgesUpdatePayload value =
                ProjectbadgesCatalogFixtures.projectProjectBadgesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.linkUrl()).isEqualTo("link_url");
            softly.assertThat(value.imageUrl()).isEqualTo("image_url");
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectBadgesUpdatePayload original =
                ProjectbadgesCatalogFixtures.projectProjectBadgesUpdatePayload();

        final GitLabProjectProjectBadgesUpdatePayload rebuilt =
                GitLabProjectProjectBadgesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectBadgesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("linkUrl", "imageUrl", "name");
    }
}
