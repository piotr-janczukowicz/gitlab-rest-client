package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetSearchResultVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetSearchResultVersionBuilder builder = GitLabNugetSearchResultVersionBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResultVersion())
                .atId(null);

        final GitLabNugetSearchResultVersion built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabNugetSearchResultVersionBuilder builder = GitLabNugetSearchResultVersionBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResultVersion())
                .version(null);

        final GitLabNugetSearchResultVersion built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDownloadsIsNullable() {
        final GitLabNugetSearchResultVersionBuilder builder = GitLabNugetSearchResultVersionBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResultVersion())
                .downloads(null);

        final GitLabNugetSearchResultVersion built = builder.build();

        assertThat(built.downloads()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetSearchResultVersion value = CommonCatalogFixtures.nugetSearchResultVersion();

        assertSoftly(softly -> {
            softly.assertThat(value.atId())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json");
            softly.assertThat(value.version()).isEqualTo("1.3.0.17");
            softly.assertThat(value.downloads()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetSearchResultVersion original = CommonCatalogFixtures.nugetSearchResultVersion();

        final GitLabNugetSearchResultVersion rebuilt =
                GitLabNugetSearchResultVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetSearchResultVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("atId", "version", "downloads");
    }
}
