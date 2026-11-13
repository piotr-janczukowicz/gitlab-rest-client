package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerRegistryTagTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabContainerRegistryTagBuilder builder = GitLabContainerRegistryTagBuilder.builder(
                        CommonCatalogFixtures.containerRegistryTag())
                .name(null);

        final GitLabContainerRegistryTag built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabContainerRegistryTagBuilder builder = GitLabContainerRegistryTagBuilder.builder(
                        CommonCatalogFixtures.containerRegistryTag())
                .path(null);

        final GitLabContainerRegistryTag built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabContainerRegistryTagBuilder builder = GitLabContainerRegistryTagBuilder.builder(
                        CommonCatalogFixtures.containerRegistryTag())
                .location(null);

        final GitLabContainerRegistryTag built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerRegistryTag value = CommonCatalogFixtures.containerRegistryTag();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("latest");
            softly.assertThat(value.path()).isEqualTo("namespace1/project1/test_image_1:latest");
            softly.assertThat(value.location()).isEqualTo("registry.dev/namespace1/project1/test_image_1:latest");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerRegistryTag original = CommonCatalogFixtures.containerRegistryTag();

        final GitLabContainerRegistryTag rebuilt =
                GitLabContainerRegistryTagBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerRegistryTag.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "path", "location");
    }
}
