package io.github.piotr_janczukowicz.gitlab.api.groupbadges;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupBadgesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLinkUrlIsNullable() {
        final GitLabGroupGroupBadgesUpdatePayloadBuilder builder = GitLabGroupGroupBadgesUpdatePayloadBuilder.builder(
                        GroupbadgesCatalogFixtures.groupGroupBadgesUpdatePayload())
                .linkUrl(null);

        final GitLabGroupGroupBadgesUpdatePayload built = builder.build();

        assertThat(built.linkUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImageUrlIsNullable() {
        final GitLabGroupGroupBadgesUpdatePayloadBuilder builder = GitLabGroupGroupBadgesUpdatePayloadBuilder.builder(
                        GroupbadgesCatalogFixtures.groupGroupBadgesUpdatePayload())
                .imageUrl(null);

        final GitLabGroupGroupBadgesUpdatePayload built = builder.build();

        assertThat(built.imageUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupBadgesUpdatePayloadBuilder builder = GitLabGroupGroupBadgesUpdatePayloadBuilder.builder(
                        GroupbadgesCatalogFixtures.groupGroupBadgesUpdatePayload())
                .name(null);

        final GitLabGroupGroupBadgesUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupBadgesUpdatePayload value = GroupbadgesCatalogFixtures.groupGroupBadgesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.linkUrl()).isEqualTo("link_url");
            softly.assertThat(value.imageUrl()).isEqualTo("image_url");
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupBadgesUpdatePayload original = GroupbadgesCatalogFixtures.groupGroupBadgesUpdatePayload();

        final GitLabGroupGroupBadgesUpdatePayload rebuilt =
                GitLabGroupGroupBadgesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupBadgesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("linkUrl", "imageUrl", "name");
    }
}
