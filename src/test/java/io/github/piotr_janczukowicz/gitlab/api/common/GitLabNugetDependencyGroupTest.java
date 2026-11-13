package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetDependencyGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetDependencyGroupBuilder builder = GitLabNugetDependencyGroupBuilder.builder(
                        CommonCatalogFixtures.nugetDependencyGroup())
                .atId(null);

        final GitLabNugetDependencyGroup built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAtTypeIsNullable() {
        final GitLabNugetDependencyGroupBuilder builder = GitLabNugetDependencyGroupBuilder.builder(
                        CommonCatalogFixtures.nugetDependencyGroup())
                .atType(null);

        final GitLabNugetDependencyGroup built = builder.build();

        assertThat(built.atType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetFrameworkIsNullable() {
        final GitLabNugetDependencyGroupBuilder builder = GitLabNugetDependencyGroupBuilder.builder(
                        CommonCatalogFixtures.nugetDependencyGroup())
                .targetFramework(null);

        final GitLabNugetDependencyGroup built = builder.build();

        assertThat(built.targetFramework()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependenciesIsNullable() {
        final GitLabNugetDependencyGroupBuilder builder = GitLabNugetDependencyGroupBuilder.builder(
                        CommonCatalogFixtures.nugetDependencyGroup())
                .dependencies(null);

        final GitLabNugetDependencyGroup built = builder.build();

        assertThat(built.dependencies()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetDependencyGroup value = CommonCatalogFixtures.nugetDependencyGroup();

        assertSoftly(softly -> {
            softly.assertThat(value.atId()).isEqualTo("http://gitlab.com/Sandbox.App/1.0.0.json#dependencygroup");
            softly.assertThat(value.atType()).isEqualTo("PackageDependencyGroup");
            softly.assertThat(value.targetFramework()).isEqualTo("fwk test");
            softly.assertThat(value.dependencies()).isEqualTo(List.of(CommonCatalogFixtures.nugetDependency()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetDependencyGroup original = CommonCatalogFixtures.nugetDependencyGroup();

        final GitLabNugetDependencyGroup rebuilt =
                GitLabNugetDependencyGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetDependencyGroup.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("atId", "atType", "targetFramework", "dependencies");
    }
}
