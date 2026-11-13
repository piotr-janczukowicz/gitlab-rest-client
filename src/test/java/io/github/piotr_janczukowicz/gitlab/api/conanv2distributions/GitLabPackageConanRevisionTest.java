package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanRevisionTest {

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabPackageConanRevisionBuilder builder = GitLabPackageConanRevisionBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanRevision())
                .revision(null);

        final GitLabPackageConanRevision built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeIsNullable() {
        final GitLabPackageConanRevisionBuilder builder = GitLabPackageConanRevisionBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanRevision())
                .time(null);

        final GitLabPackageConanRevision built = builder.build();

        assertThat(built.time()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanRevision value = Conanv2distributionsCatalogFixtures.packageConanRevision();

        assertSoftly(softly -> {
            softly.assertThat(value.revision()).isEqualTo("75151329520e7685dcf5da49ded2fec0");
            softly.assertThat(value.time()).isEqualTo("2024-12-17T09:16:40.334Z");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanRevision original = Conanv2distributionsCatalogFixtures.packageConanRevision();

        final GitLabPackageConanRevision rebuilt =
                GitLabPackageConanRevisionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanRevision.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("revision", "time");
    }
}
