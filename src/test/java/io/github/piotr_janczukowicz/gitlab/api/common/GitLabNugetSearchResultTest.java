package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetSearchResultTest {

    @Test
    void constructor_shouldAcceptNull_whenAtTypeIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .atType(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.atType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .id(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .title(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalDownloadsIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .totalDownloads(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.totalDownloads()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVerifiedIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .verified(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.verified()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .version(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionsIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .versions(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.versions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .tags(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorsIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .authors(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.authors()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .description(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSummaryIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .summary(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.summary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectUrlIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .projectUrl(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.projectUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicenseUrlIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .licenseUrl(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.licenseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIconUrlIsNullable() {
        final GitLabNugetSearchResultBuilder builder = GitLabNugetSearchResultBuilder.builder(
                        CommonCatalogFixtures.nugetSearchResult())
                .iconUrl(null);

        final GitLabNugetSearchResult built = builder.build();

        assertThat(built.iconUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetSearchResult value = CommonCatalogFixtures.nugetSearchResult();

        assertSoftly(softly -> {
            softly.assertThat(value.atType()).isEqualTo("Package");
            softly.assertThat(value.id()).isEqualTo("MyNuGetPkg");
            softly.assertThat(value.title()).isEqualTo("MyNuGetPkg");
            softly.assertThat(value.totalDownloads()).isEqualTo(1);
            softly.assertThat(value.verified()).isEqualTo(true);
            softly.assertThat(value.version()).isEqualTo("1.3.0.17");
            softly.assertThat(value.versions()).isEqualTo(List.of(CommonCatalogFixtures.nugetSearchResultVersion()));
            softly.assertThat(value.tags()).isEqualTo("tag#1 tag#2");
            softly.assertThat(value.authors()).isEqualTo("Authors");
            softly.assertThat(value.description()).isEqualTo("Description");
            softly.assertThat(value.summary()).isEqualTo("Description");
            softly.assertThat(value.projectUrl()).isEqualTo("http://sandbox.com/project");
            softly.assertThat(value.licenseUrl()).isEqualTo("http://sandbox.com/license");
            softly.assertThat(value.iconUrl()).isEqualTo("http://sandbox.com/icon");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetSearchResult original = CommonCatalogFixtures.nugetSearchResult();

        final GitLabNugetSearchResult rebuilt =
                GitLabNugetSearchResultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetSearchResult.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "atType",
                        "id",
                        "title",
                        "totalDownloads",
                        "verified",
                        "version",
                        "versions",
                        "tags",
                        "authors",
                        "description",
                        "summary",
                        "projectUrl",
                        "licenseUrl",
                        "iconUrl");
    }
}
