package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetDependencyTest {

    @Test
    void constructor_shouldAcceptNull_whenAtIdIsNullable() {
        final GitLabNugetDependencyBuilder builder = GitLabNugetDependencyBuilder.builder(
                        CommonCatalogFixtures.nugetDependency())
                .atId(null);

        final GitLabNugetDependency built = builder.build();

        assertThat(built.atId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAtTypeIsNullable() {
        final GitLabNugetDependencyBuilder builder = GitLabNugetDependencyBuilder.builder(
                        CommonCatalogFixtures.nugetDependency())
                .atType(null);

        final GitLabNugetDependency built = builder.build();

        assertThat(built.atType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNugetDependencyBuilder builder = GitLabNugetDependencyBuilder.builder(
                        CommonCatalogFixtures.nugetDependency())
                .id(null);

        final GitLabNugetDependency built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRangeIsNullable() {
        final GitLabNugetDependencyBuilder builder = GitLabNugetDependencyBuilder.builder(
                        CommonCatalogFixtures.nugetDependency())
                .range(null);

        final GitLabNugetDependency built = builder.build();

        assertThat(built.range()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetDependency value = CommonCatalogFixtures.nugetDependency();

        assertSoftly(softly -> {
            softly.assertThat(value.atId()).isEqualTo("http://gitlab.com/Sandbox.App/1.0.0.json#dependency");
            softly.assertThat(value.atType()).isEqualTo("PackageDependency");
            softly.assertThat(value.id()).isEqualTo("Dependency");
            softly.assertThat(value.range()).isEqualTo("2.0.0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetDependency original = CommonCatalogFixtures.nugetDependency();

        final GitLabNugetDependency rebuilt =
                GitLabNugetDependencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetDependency.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("atId", "atType", "id", "range");
    }
}
