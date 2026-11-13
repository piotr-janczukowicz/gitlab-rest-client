package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabContainerRegistryTagDetailsTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .name(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .path(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLocationIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .location(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.location()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .revision(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShortRevisionIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .shortRevision(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.shortRevision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDigestIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .digest(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.digest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .createdAt(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTotalSizeIsNullable() {
        final GitLabContainerRegistryTagDetailsBuilder builder = GitLabContainerRegistryTagDetailsBuilder.builder(
                        ContainerregistryCatalogFixtures.containerRegistryTagDetails())
                .totalSize(null);

        final GitLabContainerRegistryTagDetails built = builder.build();

        assertThat(built.totalSize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabContainerRegistryTagDetails value = ContainerregistryCatalogFixtures.containerRegistryTagDetails();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("latest");
            softly.assertThat(value.path()).isEqualTo("namespace1/project1/test_image_1:latest");
            softly.assertThat(value.location()).isEqualTo("registry.dev/namespace1/project1/test_image_1:latest");
            softly.assertThat(value.revision()).isEqualTo("tagrevision");
            softly.assertThat(value.shortRevision()).isEqualTo("shortrevison");
            softly.assertThat(value.digest()).isEqualTo("shadigest");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.totalSize()).isEqualTo(1L);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabContainerRegistryTagDetails original =
                ContainerregistryCatalogFixtures.containerRegistryTagDetails();

        final GitLabContainerRegistryTagDetails rebuilt =
                GitLabContainerRegistryTagDetailsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabContainerRegistryTagDetails.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "path", "location", "revision", "shortRevision", "digest", "createdAt", "totalSize");
    }
}
