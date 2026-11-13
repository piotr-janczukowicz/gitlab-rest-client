package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanPackageSnapshotTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageSnapshotIsNullable() {
        final GitLabPackageConanPackageSnapshotBuilder builder = GitLabPackageConanPackageSnapshotBuilder.builder(
                        Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot())
                .packageSnapshot(null);

        final GitLabPackageConanPackageSnapshot built = builder.build();

        assertThat(built.packageSnapshot()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanPackageSnapshot value =
                Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot();

        assertThat(value.packageSnapshot()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanPackageSnapshot original =
                Conanv1distributionsCatalogFixtures.packageConanPackageSnapshot();

        final GitLabPackageConanPackageSnapshot rebuilt =
                GitLabPackageConanPackageSnapshotBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanPackageSnapshot.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("packageSnapshot");
    }
}
