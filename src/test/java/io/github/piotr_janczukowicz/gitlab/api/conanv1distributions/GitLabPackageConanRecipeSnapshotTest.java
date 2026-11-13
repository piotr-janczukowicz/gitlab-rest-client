package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanRecipeSnapshotTest {

    @Test
    void constructor_shouldAcceptNull_whenRecipeSnapshotIsNullable() {
        final GitLabPackageConanRecipeSnapshotBuilder builder = GitLabPackageConanRecipeSnapshotBuilder.builder(
                        Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot())
                .recipeSnapshot(null);

        final GitLabPackageConanRecipeSnapshot built = builder.build();

        assertThat(built.recipeSnapshot()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanRecipeSnapshot value = Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot();

        assertThat(value.recipeSnapshot()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanRecipeSnapshot original =
                Conanv1distributionsCatalogFixtures.packageConanRecipeSnapshot();

        final GitLabPackageConanRecipeSnapshot rebuilt =
                GitLabPackageConanRecipeSnapshotBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanRecipeSnapshot.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("recipeSnapshot");
    }
}
