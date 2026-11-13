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
class GitLabProjectReleasesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectReleasesUpdatePayloadBuilder builder = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .name(null);

        final GitLabProjectReleasesUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectReleasesUpdatePayloadBuilder builder = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .description(null);

        final GitLabProjectReleasesUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasedAtIsNullable() {
        final GitLabProjectReleasesUpdatePayloadBuilder builder = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .releasedAt(null);

        final GitLabProjectReleasesUpdatePayload built = builder.build();

        assertThat(built.releasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestonesIsNullable() {
        final GitLabProjectReleasesUpdatePayloadBuilder builder = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .milestones(null);

        final GitLabProjectReleasesUpdatePayload built = builder.build();

        assertThat(built.milestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIdsIsNullable() {
        final GitLabProjectReleasesUpdatePayloadBuilder builder = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .milestoneIds(null);

        final GitLabProjectReleasesUpdatePayload built = builder.build();

        assertThat(built.milestoneIds()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesUpdatePayload value = ReleasesCatalogFixtures.projectReleasesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.releasedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.milestones()).isEqualTo(List.of("milestones"));
            softly.assertThat(value.milestoneIds()).isEqualTo("text");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesUpdatePayload original = ReleasesCatalogFixtures.projectReleasesUpdatePayload();

        final GitLabProjectReleasesUpdatePayload rebuilt =
                GitLabProjectReleasesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenMilestonesSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("milestones"));
        final GitLabProjectReleasesUpdatePayload built = GitLabProjectReleasesUpdatePayloadBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesUpdatePayload())
                .milestones(source)
                .build();
        source.clear();

        assertThat(built.milestones()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenMilestonesIsRead() {
        final GitLabProjectReleasesUpdatePayload built = ReleasesCatalogFixtures.projectReleasesUpdatePayload();
        final List<String> values = built.milestones();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description", "releasedAt", "milestones", "milestoneIds");
    }
}
