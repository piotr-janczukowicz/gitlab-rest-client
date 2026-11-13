package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).name(null);

        final GitLabRelease built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagNameIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).tagName(null);

        final GitLabRelease built = builder.build();

        assertThat(built.tagName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).description(null);

        final GitLabRelease built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).createdAt(null);

        final GitLabRelease built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReleasedAtIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).releasedAt(null);

        final GitLabRelease built = builder.build();

        assertThat(built.releasedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpcomingReleaseIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).upcomingRelease(null);

        final GitLabRelease built = builder.build();

        assertThat(built.upcomingRelease()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionHtmlIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).descriptionHtml(null);

        final GitLabRelease built = builder.build();

        assertThat(built.descriptionHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).author(null);

        final GitLabRelease built = builder.build();

        assertThat(built.author()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).commit(null);

        final GitLabRelease built = builder.build();

        assertThat(built.commit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestonesIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).milestones(null);

        final GitLabRelease built = builder.build();

        assertThat(built.milestones()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommitPathIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).commitPath(null);

        final GitLabRelease built = builder.build();

        assertThat(built.commitPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagPathIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).tagPath(null);

        final GitLabRelease built = builder.build();

        assertThat(built.tagPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAssetsIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).assets(null);

        final GitLabRelease built = builder.build();

        assertThat(built.assets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEvidencesIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).evidences(null);

        final GitLabRelease built = builder.build();

        assertThat(built.evidences()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabReleaseBuilder builder =
                GitLabReleaseBuilder.builder(CommonCatalogFixtures.release()).links(null);

        final GitLabRelease built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRelease value = CommonCatalogFixtures.release();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("Release v1.0");
            softly.assertThat(value.tagName()).isEqualTo("v1.0");
            softly.assertThat(value.description()).isEqualTo("Finally released v1.0");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.releasedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.upcomingRelease()).isEqualTo(true);
            softly.assertThat(value.descriptionHtml()).isEqualTo("description_html");
            softly.assertThat(value.author()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.commit()).isEqualTo(CommonCatalogFixtures.commit());
            softly.assertThat(value.milestones()).isEqualTo(List.of(CommonCatalogFixtures.milestoneWithStats()));
            softly.assertThat(value.commitPath())
                    .isEqualTo("/root/app/commit/588440f66559714280628a4f9799f0c4eb880a4a");
            softly.assertThat(value.tagPath()).isEqualTo("/root/app/-/tags/v1.0");
            softly.assertThat(value.assets()).isEqualTo(CommonCatalogFixtures.releaseAssets());
            softly.assertThat(value.evidences()).isEqualTo(List.of(CommonCatalogFixtures.releaseEvidence()));
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.releaseLinks());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRelease original = CommonCatalogFixtures.release();

        final GitLabRelease rebuilt = GitLabReleaseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRelease.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "tagName",
                        "description",
                        "createdAt",
                        "releasedAt",
                        "upcomingRelease",
                        "descriptionHtml",
                        "author",
                        "commit",
                        "milestones",
                        "commitPath",
                        "tagPath",
                        "assets",
                        "evidences",
                        "links");
    }
}
