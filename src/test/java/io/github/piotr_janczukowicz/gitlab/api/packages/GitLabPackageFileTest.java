package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageFileTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .id(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageIdIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .packageId(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.packageId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .createdAt(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileNameIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .fileName(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.fileName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .size(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileMd5IsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .fileMd5(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.fileMd5()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileSha1IsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .fileSha1(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.fileSha1()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileSha256IsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .fileSha256(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.fileSha256()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPipelinesIsNullable() {
        final GitLabPackageFileBuilder builder = GitLabPackageFileBuilder.builder(PackagesCatalogFixtures.packageFile())
                .pipelines(null);

        final GitLabPackageFile built = builder.build();

        assertThat(built.pipelines()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageFile value = PackagesCatalogFixtures.packageFile();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.packageId()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.fileName()).isEqualTo("my-app-1.5-20181107.152550-1.jar");
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.fileMd5()).isEqualTo("58e6a45a629910c6ff99145a688971ac");
            softly.assertThat(value.fileSha1()).isEqualTo("ebd193463d3915d7e22219f52740056dfd26cbfe");
            softly.assertThat(value.fileSha256()).isEqualTo("a903393463d3915d7e22219f52740056dfd26cbfeff321b");
            softly.assertThat(value.pipelines()).isEqualTo(List.of(CommonCatalogFixtures.packagePipeline()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageFile original = PackagesCatalogFixtures.packageFile();

        final GitLabPackageFile rebuilt =
                GitLabPackageFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "packageId",
                        "createdAt",
                        "fileName",
                        "size",
                        "fileMd5",
                        "fileSha1",
                        "fileSha256",
                        "pipelines");
    }
}
