package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectIdentityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .id(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .description(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .name(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameWithNamespaceIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .nameWithNamespace(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.nameWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .path(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathWithNamespaceIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .pathWithNamespace(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.pathWithNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectIdentityBuilder builder = GitLabProjectIdentityBuilder.builder(
                        CommonCatalogFixtures.projectIdentity())
                .createdAt(null);

        final GitLabProjectIdentity built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectIdentity value = CommonCatalogFixtures.projectIdentity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.description()).isEqualTo("desc");
            softly.assertThat(value.name()).isEqualTo("project1");
            softly.assertThat(value.nameWithNamespace()).isEqualTo("John Doe / project1");
            softly.assertThat(value.path()).isEqualTo("project1");
            softly.assertThat(value.pathWithNamespace()).isEqualTo("namespace1/project1");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectIdentity original = CommonCatalogFixtures.projectIdentity();

        final GitLabProjectIdentity rebuilt =
                GitLabProjectIdentityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectIdentity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id", "description", "name", "nameWithNamespace", "path", "pathWithNamespace", "createdAt");
    }
}
