package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleasesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTagNameIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .tagName(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.tagName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagMessageIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .tagMessage(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.tagMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .name(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .description(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .ref(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetsIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .assets(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.assets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestonesIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .milestones(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.milestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdsIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .milestoneIds(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.milestoneIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasedAtIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .releasedAt(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.releasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLegacyCatalogPublishIsNullable() {
        final GitLabProjectReleasesCreatePayloadBuilder builder = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .legacyCatalogPublish(null);

        final GitLabProjectReleasesCreatePayload built = builder.build();

        assertThat(built.legacyCatalogPublish()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesCreatePayload value = ReleasesCatalogFixtures.projectReleasesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.tagName()).isEqualTo("tag_name");
            softly.assertThat(value.tagMessage()).isEqualTo("tag_message");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.assets()).isEqualTo(ReleasesCatalogFixtures.projectReleasesCreateAssets());
            softly.assertThat(value.milestones()).isEqualTo(List.of("milestones"));
            softly.assertThat(value.milestoneIds()).isEqualTo("text");
            softly.assertThat(value.releasedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.legacyCatalogPublish()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesCreatePayload original = ReleasesCatalogFixtures.projectReleasesCreatePayload();

        final GitLabProjectReleasesCreatePayload rebuilt =
                GitLabProjectReleasesCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenMilestonesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("milestones"));
        final GitLabProjectReleasesCreatePayload built = GitLabProjectReleasesCreatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreatePayload())
                .milestones(source)
                .build();
        source.clear();

        assertThat(built.milestones()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenMilestonesIsRead() {
        final GitLabProjectReleasesCreatePayload built = ReleasesCatalogFixtures.projectReleasesCreatePayload();
        final List<String> values = built.milestones();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "tagName",
                        "tagMessage",
                        "name",
                        "description",
                        "ref",
                        "assets",
                        "milestones",
                        "milestoneIds",
                        "releasedAt",
                        "legacyCatalogPublish");
    }
}
