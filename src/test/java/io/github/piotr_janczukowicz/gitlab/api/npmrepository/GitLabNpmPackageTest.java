package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNpmPackageTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabNpmPackageBuilder builder = GitLabNpmPackageBuilder.builder(
                        NpmrepositoryCatalogFixtures.npmPackage())
                .name(null);

        final GitLabNpmPackage built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionsIsNullable() {
        final GitLabNpmPackageBuilder builder = GitLabNpmPackageBuilder.builder(
                        NpmrepositoryCatalogFixtures.npmPackage())
                .versions(null);

        final GitLabNpmPackage built = builder.build();

        assertThat(built.versions()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDistTagsIsNullable() {
        final GitLabNpmPackageBuilder builder = GitLabNpmPackageBuilder.builder(
                        NpmrepositoryCatalogFixtures.npmPackage())
                .distTags(null);

        final GitLabNpmPackage built = builder.build();

        assertThat(built.distTags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNpmPackage value = NpmrepositoryCatalogFixtures.npmPackage();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("my_package");
            softly.assertThat(value.versions()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.distTags()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNpmPackage original = NpmrepositoryCatalogFixtures.npmPackage();

        final GitLabNpmPackage rebuilt =
                GitLabNpmPackageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNpmPackage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "versions", "distTags");
    }
}
