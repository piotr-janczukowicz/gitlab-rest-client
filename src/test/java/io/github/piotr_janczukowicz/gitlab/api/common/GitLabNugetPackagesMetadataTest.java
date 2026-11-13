package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetPackagesMetadataTest {

    @Test
    void constructor_shouldAcceptNull_whenCountIsNullable() {
        final GitLabNugetPackagesMetadataBuilder builder = GitLabNugetPackagesMetadataBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadata())
                .count(null);

        final GitLabNugetPackagesMetadata built = builder.build();

        assertThat(built.count()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenItemsIsNullable() {
        final GitLabNugetPackagesMetadataBuilder builder = GitLabNugetPackagesMetadataBuilder.builder(
                        CommonCatalogFixtures.nugetPackagesMetadata())
                .items(null);

        final GitLabNugetPackagesMetadata built = builder.build();

        assertThat(built.items()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetPackagesMetadata value = CommonCatalogFixtures.nugetPackagesMetadata();

        assertSoftly(softly -> {
            softly.assertThat(value.count()).isEqualTo(1);
            softly.assertThat(value.items()).isEqualTo(List.of(CommonCatalogFixtures.nugetPackagesMetadataItem()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetPackagesMetadata original = CommonCatalogFixtures.nugetPackagesMetadata();

        final GitLabNugetPackagesMetadata rebuilt =
                GitLabNugetPackagesMetadataBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetPackagesMetadata.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("count", "items");
    }
}
