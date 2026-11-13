package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetPackageMetadataCatalogEntryTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .atId(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyGroupsIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .dependencyGroups(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.dependencyGroups()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .id(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .version(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .tags(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageContentIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .packageContent(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.packageContent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorsIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .authors(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.authors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .description(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSummaryIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .summary(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.summary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .projectUrl(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .licenseUrl(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIconUrlIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .iconUrl(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.iconUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublishedIsNullable() {
        final GitLabNugetPackageMetadataCatalogEntryBuilder builder =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(
                                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry())
                        .published(null);

        final GitLabNugetPackageMetadataCatalogEntry built = builder.build();

        assertThat(built.published()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetPackageMetadataCatalogEntry value = CommonCatalogFixtures.nugetPackageMetadataCatalogEntry();

        assertSoftly(softly -> {
            softly.assertThat(value.atId())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/metadata/MyNuGetPkg/1.3.0.17.json");
            softly.assertThat(value.dependencyGroups())
                    .isEqualTo(List.of(CommonCatalogFixtures.nugetDependencyGroup()));
            softly.assertThat(value.id()).isEqualTo("MyNuGetPkg");
            softly.assertThat(value.version()).isEqualTo("1.3.0.17");
            softly.assertThat(value.tags()).isEqualTo("tag#1 tag#2");
            softly.assertThat(value.packageContent())
                    .isEqualTo(
                            "https://gitlab.example.com/api/v4/projects/1/packages/nuget/download/MyNuGetPkg/1.3.0.17/helloworld.1.3.0.17.nupkg");
            softly.assertThat(value.authors()).isEqualTo("Authors");
            softly.assertThat(value.description()).isEqualTo("Description");
            softly.assertThat(value.summary()).isEqualTo("Description");
            softly.assertThat(value.projectUrl()).isEqualTo("http://sandbox.com/project");
            softly.assertThat(value.licenseUrl()).isEqualTo("http://sandbox.com/license");
            softly.assertThat(value.iconUrl()).isEqualTo("http://sandbox.com/icon");
            softly.assertThat(value.published()).isEqualTo("2023-05-08T17:23:25Z");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetPackageMetadataCatalogEntry original =
                CommonCatalogFixtures.nugetPackageMetadataCatalogEntry();

        final GitLabNugetPackageMetadataCatalogEntry rebuilt =
                GitLabNugetPackageMetadataCatalogEntryBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetPackageMetadataCatalogEntry.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "atId",
                        "dependencyGroups",
                        "id",
                        "version",
                        "tags",
                        "packageContent",
                        "authors",
                        "description",
                        "summary",
                        "projectUrl",
                        "licenseUrl",
                        "iconUrl",
                        "published");
    }
}
