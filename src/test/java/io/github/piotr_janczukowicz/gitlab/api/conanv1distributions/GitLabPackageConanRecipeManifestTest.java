package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanRecipeManifestTest {

    @Test
    void constructor_shouldAcceptNull_whenRecipeUrlsIsNullable() {
        final GitLabPackageConanRecipeManifestBuilder builder = GitLabPackageConanRecipeManifestBuilder.builder(
                        Conanv1distributionsCatalogFixtures.packageConanRecipeManifest())
                .recipeUrls(null);

        final GitLabPackageConanRecipeManifest built = builder.build();

        assertThat(built.recipeUrls()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanRecipeManifest value = Conanv1distributionsCatalogFixtures.packageConanRecipeManifest();

        assertThat(value.recipeUrls()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanRecipeManifest original =
                Conanv1distributionsCatalogFixtures.packageConanRecipeManifest();

        final GitLabPackageConanRecipeManifest rebuilt =
                GitLabPackageConanRecipeManifestBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanRecipeManifest.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("recipeUrls");
    }
}
