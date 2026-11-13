package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleasesCreateAssetsLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectReleasesCreateAssetsLinkBuilder builder =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(
                                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink())
                        .name(null);

        final GitLabProjectReleasesCreateAssetsLink built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectReleasesCreateAssetsLinkBuilder builder =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(
                                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink())
                        .url(null);

        final GitLabProjectReleasesCreateAssetsLink built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDirectAssetPathIsNullable() {
        final GitLabProjectReleasesCreateAssetsLinkBuilder builder =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(
                                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink())
                        .directAssetPath(null);

        final GitLabProjectReleasesCreateAssetsLink built = builder.build();

        assertThat(built.directAssetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilepathIsNullable() {
        final GitLabProjectReleasesCreateAssetsLinkBuilder builder =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(
                                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink())
                        .filepath(null);

        final GitLabProjectReleasesCreateAssetsLink built = builder.build();

        assertThat(built.filepath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabProjectReleasesCreateAssetsLinkBuilder builder =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(
                                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink())
                        .linkType(null);

        final GitLabProjectReleasesCreateAssetsLink built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesCreateAssetsLink value = ReleasesCatalogFixtures.projectReleasesCreateAssetsLink();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.directAssetPath()).isEqualTo("direct_asset_path");
            softly.assertThat(value.filepath()).isEqualTo("filepath");
            softly.assertThat(value.linkType()).isEqualTo(GitLabProjectReleasesCreateAssetsLinkType.OTHER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesCreateAssetsLink original =
                ReleasesCatalogFixtures.projectReleasesCreateAssetsLink();

        final GitLabProjectReleasesCreateAssetsLink rebuilt =
                GitLabProjectReleasesCreateAssetsLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesCreateAssetsLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "url", "directAssetPath", "filepath", "linkType");
    }
}
