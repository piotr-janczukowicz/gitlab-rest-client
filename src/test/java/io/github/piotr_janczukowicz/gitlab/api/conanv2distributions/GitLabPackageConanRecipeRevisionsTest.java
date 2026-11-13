package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanRecipeRevisionsTest {

    @Test
    void constructor_shouldAcceptNull_whenReferenceIsNullable() {
        final GitLabPackageConanRecipeRevisionsBuilder builder = GitLabPackageConanRecipeRevisionsBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions())
                .reference(null);

        final GitLabPackageConanRecipeRevisions built = builder.build();

        assertThat(built.reference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionsIsNullable() {
        final GitLabPackageConanRecipeRevisionsBuilder builder = GitLabPackageConanRecipeRevisionsBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions())
                .revisions(null);

        final GitLabPackageConanRecipeRevisions built = builder.build();

        assertThat(built.revisions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanRecipeRevisions value =
                Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions();

        assertSoftly(softly -> {
            softly.assertThat(value.reference()).isEqualTo("packageTest/1.2.3@gitlab-org+conan/stable");
            softly.assertThat(value.revisions())
                    .isEqualTo(List.of(Conanv2distributionsCatalogFixtures.packageConanRevision()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanRecipeRevisions original =
                Conanv2distributionsCatalogFixtures.packageConanRecipeRevisions();

        final GitLabPackageConanRecipeRevisions rebuilt =
                GitLabPackageConanRecipeRevisionsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanRecipeRevisions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("reference", "revisions");
    }
}
