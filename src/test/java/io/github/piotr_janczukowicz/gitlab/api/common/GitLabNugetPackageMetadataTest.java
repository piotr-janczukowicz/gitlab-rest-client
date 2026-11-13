package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetPackageMetadataTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetPackageMetadataBuilder builder = GitLabNugetPackageMetadataBuilder.builder(
                        CommonCatalogFixtures.nugetPackageMetadata())
                .atId(null);

        final GitLabNugetPackageMetadata built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageContentIsNullable() {
        final GitLabNugetPackageMetadataBuilder builder = GitLabNugetPackageMetadataBuilder.builder(
                        CommonCatalogFixtures.nugetPackageMetadata())
                .packageContent(null);

        final GitLabNugetPackageMetadata built = builder.build();

        assertThat(built.packageContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCatalogEntryIsNullable() {
        final GitLabNugetPackageMetadataBuilder builder = GitLabNugetPackageMetadataBuilder.builder(
                        CommonCatalogFixtures.nugetPackageMetadata())
                .catalogEntry(null);

        final GitLabNugetPackageMetadata built = builder.build();

        assertThat(built.catalogEntry()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetPackageMetadata value = CommonCatalogFixtures.nugetPackageMetadata();

        assertSoftly(softly -> {
            softly.assertThat(value.atId())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json");
            softly.assertThat(value.packageContent())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/download/MyNuGetPkg/1.3.0.17/helloworld.1.3.0.17.nupkg");
            softly.assertThat(value.catalogEntry()).isEqualTo(CommonCatalogFixtures.nugetPackageMetadataCatalogEntry());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetPackageMetadata original = CommonCatalogFixtures.nugetPackageMetadata();

        final GitLabNugetPackageMetadata rebuilt =
                GitLabNugetPackageMetadataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetPackageMetadata.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("atId", "packageContent", "catalogEntry");
    }
}
