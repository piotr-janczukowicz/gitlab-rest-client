package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanPackageManifestTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageUrlsIsNullable() {
        final GitLabPackageConanPackageManifestBuilder builder = GitLabPackageConanPackageManifestBuilder.builder(
                        Conanv1distributionsCatalogFixtures.packageConanPackageManifest())
                .packageUrls(null);

        final GitLabPackageConanPackageManifest built = builder.build();

        assertThat(built.packageUrls()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanPackageManifest value =
                Conanv1distributionsCatalogFixtures.packageConanPackageManifest();

        assertThat(value.packageUrls()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanPackageManifest original =
                Conanv1distributionsCatalogFixtures.packageConanPackageManifest();

        final GitLabPackageConanPackageManifest rebuilt =
                GitLabPackageConanPackageManifestBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanPackageManifest.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("packageUrls");
    }
}
