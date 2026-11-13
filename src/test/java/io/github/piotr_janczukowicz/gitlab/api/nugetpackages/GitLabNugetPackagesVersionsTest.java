package io.github.piotr_janczukowicz.gitlab.api.nugetpackages;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetPackagesVersionsTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionsIsNullable() {
        final GitLabNugetPackagesVersionsBuilder builder = GitLabNugetPackagesVersionsBuilder.builder(
                        NugetpackagesCatalogFixtures.nugetPackagesVersions())
                .versions(null);

        final GitLabNugetPackagesVersions built = builder.build();

        assertThat(built.versions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetPackagesVersions value = NugetpackagesCatalogFixtures.nugetPackagesVersions();

        assertThat(value.versions()).isEqualTo(List.of("1.3.0.17"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetPackagesVersions original = NugetpackagesCatalogFixtures.nugetPackagesVersions();

        final GitLabNugetPackagesVersions rebuilt =
                GitLabNugetPackagesVersionsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetPackagesVersions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("versions");
    }
}
