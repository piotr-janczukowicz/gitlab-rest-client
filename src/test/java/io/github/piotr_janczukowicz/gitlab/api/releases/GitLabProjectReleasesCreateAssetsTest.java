package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleasesCreateAssetsTest {

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabProjectReleasesCreateAssetsBuilder builder = GitLabProjectReleasesCreateAssetsBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreateAssets())
                .links(null);

        final GitLabProjectReleasesCreateAssets built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleasesCreateAssets value = ReleasesCatalogFixtures.projectReleasesCreateAssets();

        assertThat(value.links()).isEqualTo(List.of(ReleasesCatalogFixtures.projectReleasesCreateAssetsLink()));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleasesCreateAssets original = ReleasesCatalogFixtures.projectReleasesCreateAssets();

        final GitLabProjectReleasesCreateAssets rebuilt =
                GitLabProjectReleasesCreateAssetsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenLinksSourceChangesLater() {
        final List<GitLabProjectReleasesCreateAssetsLink> source =
                new ArrayList<>(List.of(ReleasesCatalogFixtures.projectReleasesCreateAssetsLink()));
        final GitLabProjectReleasesCreateAssets built = GitLabProjectReleasesCreateAssetsBuilder.builder(
                        ReleasesCatalogFixtures.projectReleasesCreateAssets())
                .links(source)
                .build();
        source.clear();

        assertThat(built.links()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenLinksIsRead() {
        final GitLabProjectReleasesCreateAssets built = ReleasesCatalogFixtures.projectReleasesCreateAssets();
        final List<GitLabProjectReleasesCreateAssetsLink> values = built.links();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleasesCreateAssets.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("links");
    }
}
