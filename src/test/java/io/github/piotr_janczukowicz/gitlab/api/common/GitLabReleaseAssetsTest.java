package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.releaselinks.ReleaselinksCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseAssetsTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabReleaseAssetsBuilder builder = GitLabReleaseAssetsBuilder.builder(
                        CommonCatalogFixtures.releaseAssets())
                .count(null);

        final GitLabReleaseAssets built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourcesIsNullable() {
        final GitLabReleaseAssetsBuilder builder = GitLabReleaseAssetsBuilder.builder(
                        CommonCatalogFixtures.releaseAssets())
                .sources(null);

        final GitLabReleaseAssets built = builder.build();

        assertThat(built.sources()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabReleaseAssetsBuilder builder = GitLabReleaseAssetsBuilder.builder(
                        CommonCatalogFixtures.releaseAssets())
                .links(null);

        final GitLabReleaseAssets built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabReleaseAssets value = CommonCatalogFixtures.releaseAssets();

        assertSoftly(softly -> {
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.sources()).isEqualTo(List.of(CommonCatalogFixtures.releaseSource()));
            softly.assertThat(value.links()).isEqualTo(List.of(ReleaselinksCatalogFixtures.releaseLink()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabReleaseAssets original = CommonCatalogFixtures.releaseAssets();

        final GitLabReleaseAssets rebuilt =
                GitLabReleaseAssetsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabReleaseAssets.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count", "sources", "links");
    }
}
