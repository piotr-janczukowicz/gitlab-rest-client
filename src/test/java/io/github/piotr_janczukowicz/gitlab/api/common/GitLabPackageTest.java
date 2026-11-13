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
class GitLabPackageTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .id(null);

        final GitLabPackage built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .name(null);

        final GitLabPackage built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConanPackageNameIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .conanPackageName(null);

        final GitLabPackage built = builder.build();

        assertThat(built.conanPackageName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .version(null);

        final GitLabPackage built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageTypeIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .packageType(null);

        final GitLabPackage built = builder.build();

        assertThat(built.packageType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .status(null);

        final GitLabPackage built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinksIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .links(null);

        final GitLabPackage built = builder.build();

        assertThat(built.links()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .createdAt(null);

        final GitLabPackage built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastDownloadedAtIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .lastDownloadedAt(null);

        final GitLabPackage built = builder.build();

        assertThat(built.lastDownloadedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatorIdIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .creatorId(null);

        final GitLabPackage built = builder.build();

        assertThat(built.creatorId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .projectId(null);

        final GitLabPackage built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .projectPath(null);

        final GitLabPackage built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagsIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .tags(null);

        final GitLabPackage built = builder.build();

        assertThat(built.tags()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelineIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .pipeline(null);

        final GitLabPackage built = builder.build();

        assertThat(built.pipeline()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelinesIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .pipelines(null);

        final GitLabPackage built = builder.build();

        assertThat(built.pipelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionsIsNullable() {
        final GitLabPackageBuilder builder = GitLabPackageBuilder.builder(CommonCatalogFixtures.packageValue())
                .versions(null);

        final GitLabPackage built = builder.build();

        assertThat(built.versions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackage value = CommonCatalogFixtures.packageValue();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("@foo/bar");
            softly.assertThat(value.conanPackageName()).isEqualTo("conan_package_name");
            softly.assertThat(value.version()).isEqualTo("1.0.3");
            softly.assertThat(value.packageType()).isEqualTo("npm");
            softly.assertThat(value.status()).isEqualTo("default");
            softly.assertThat(value.links()).isEqualTo(CommonCatalogFixtures.packageLinks());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.lastDownloadedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.creatorId()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.projectPath()).isEqualTo("gitlab/foo/bar");
            softly.assertThat(value.tags()).isEqualTo(List.of(CommonCatalogFixtures.packageTag()));
            softly.assertThat(value.pipeline()).isEqualTo(CommonCatalogFixtures.packagePipeline());
            softly.assertThat(value.pipelines()).isEqualTo(List.of(CommonCatalogFixtures.packagePipeline()));
            softly.assertThat(value.versions()).isEqualTo(List.of(CommonCatalogFixtures.packageVersion()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackage original = CommonCatalogFixtures.packageValue();

        final GitLabPackage rebuilt = GitLabPackageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "conanPackageName",
                        "version",
                        "packageType",
                        "status",
                        "links",
                        "createdAt",
                        "lastDownloadedAt",
                        "creatorId",
                        "projectId",
                        "projectPath",
                        "tags",
                        "pipeline",
                        "pipelines",
                        "versions");
    }
}
