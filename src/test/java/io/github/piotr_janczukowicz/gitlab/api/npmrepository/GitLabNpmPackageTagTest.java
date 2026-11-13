package io.github.piotr_janczukowicz.gitlab.api.npmrepository;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNpmPackageTagTest {

    @Test
    void constructor_shouldAcceptNull_whenDistTagsIsNullable() {
        final GitLabNpmPackageTagBuilder builder = GitLabNpmPackageTagBuilder.builder(
                        NpmrepositoryCatalogFixtures.npmPackageTag())
                .distTags(null);

        final GitLabNpmPackageTag built = builder.build();

        assertThat(built.distTags()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNpmPackageTag value = NpmrepositoryCatalogFixtures.npmPackageTag();

        assertThat(value.distTags()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNpmPackageTag original = NpmrepositoryCatalogFixtures.npmPackageTag();

        final GitLabNpmPackageTag rebuilt =
                GitLabNpmPackageTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNpmPackageTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("distTags");
    }
}
