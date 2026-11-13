package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiCatalogResourcesVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenCatalogUrlIsNullable() {
        final GitLabCiCatalogResourcesVersionBuilder builder = GitLabCiCatalogResourcesVersionBuilder.builder(
                        ProjectsCatalogFixtures.ciCatalogResourcesVersion())
                .catalogUrl(null);

        final GitLabCiCatalogResourcesVersion built = builder.build();

        assertThat(built.catalogUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiCatalogResourcesVersion value = ProjectsCatalogFixtures.ciCatalogResourcesVersion();

        assertThat(value.catalogUrl())
                .isEqualTo("https://gitlab.example.com/explore/catalog/my-namespace/my-component-project");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiCatalogResourcesVersion original = ProjectsCatalogFixtures.ciCatalogResourcesVersion();

        final GitLabCiCatalogResourcesVersion rebuilt =
                GitLabCiCatalogResourcesVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiCatalogResourcesVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("catalogUrl");
    }
}
