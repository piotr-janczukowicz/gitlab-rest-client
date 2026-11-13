package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetPackagesMetadataItemTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetPackagesMetadataItemBuilder builder = GitLabNugetPackagesMetadataItemBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadataItem())
                .atId(null);

        final GitLabNugetPackagesMetadataItem built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLowerIsNullable() {
        final GitLabNugetPackagesMetadataItemBuilder builder = GitLabNugetPackagesMetadataItemBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadataItem())
                .lower(null);

        final GitLabNugetPackagesMetadataItem built = builder.build();

        assertThat(built.lower()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpperIsNullable() {
        final GitLabNugetPackagesMetadataItemBuilder builder = GitLabNugetPackagesMetadataItemBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadataItem())
                .upper(null);

        final GitLabNugetPackagesMetadataItem built = builder.build();

        assertThat(built.upper()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabNugetPackagesMetadataItemBuilder builder = GitLabNugetPackagesMetadataItemBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadataItem())
                .count(null);

        final GitLabNugetPackagesMetadataItem built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenItemsIsNullable() {
        final GitLabNugetPackagesMetadataItemBuilder builder = GitLabNugetPackagesMetadataItemBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadataItem())
                .items(null);

        final GitLabNugetPackagesMetadataItem built = builder.build();

        assertThat(built.items()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetPackagesMetadataItem value = CommonCatalogFixtures.nugetPackagesMetadataItem();

        assertSoftly(softly -> {
            softly.assertThat(value.atId())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json");
            softly.assertThat(value.lower()).isEqualTo("1.3.0.17");
            softly.assertThat(value.upper()).isEqualTo("1.3.0.17");
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.items()).isEqualTo(List.of(CommonCatalogFixtures.nugetPackageMetadata()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetPackagesMetadataItem original = CommonCatalogFixtures.nugetPackagesMetadataItem();

        final GitLabNugetPackagesMetadataItem rebuilt =
                GitLabNugetPackagesMetadataItemBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetPackagesMetadataItem.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("atId", "lower", "upper", "count", "items");
    }
}
