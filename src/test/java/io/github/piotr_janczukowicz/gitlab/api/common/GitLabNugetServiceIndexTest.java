package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNugetServiceIndexTest {

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabNugetServiceIndexBuilder builder = GitLabNugetServiceIndexBuilder.builder(
                        CommonCatalogFixtures.nugetServiceIndex())
                .version(null);

        final GitLabNugetServiceIndex built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResourcesIsNullable() {
        final GitLabNugetServiceIndexBuilder builder = GitLabNugetServiceIndexBuilder.builder(
                        CommonCatalogFixtures.nugetServiceIndex())
                .resources(null);

        final GitLabNugetServiceIndex built = builder.build();

        assertThat(built.resources()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNugetServiceIndex value = CommonCatalogFixtures.nugetServiceIndex();

        assertSoftly(softly -> {
            softly.assertThat(value.version()).isEqualTo("1.3.0.17");
            softly.assertThat(value.resources()).isEqualTo(List.of(Map.of("key", "value")));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNugetServiceIndex original = CommonCatalogFixtures.nugetServiceIndex();

        final GitLabNugetServiceIndex rebuilt =
                GitLabNugetServiceIndexBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNugetServiceIndex.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("version", "resources");
    }
}
