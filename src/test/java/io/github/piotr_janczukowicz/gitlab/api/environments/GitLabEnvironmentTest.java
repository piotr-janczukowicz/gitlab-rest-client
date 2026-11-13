package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEnvironmentTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .id(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .name(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSlugIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .slug(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.slug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .externalUrl(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .createdAt(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .updatedAt(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTierIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .tier(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.tier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .project(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastDeploymentIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .lastDeployment(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.lastDeployment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .state(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoStopAtIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .autoStopAt(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.autoStopAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterAgentIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .clusterAgent(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.clusterAgent()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKubernetesNamespaceIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .kubernetesNamespace(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.kubernetesNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFluxResourcePathIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .fluxResourcePath(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.fluxResourcePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .description(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoStopSettingIsNullable() {
        final GitLabEnvironmentBuilder builder = GitLabEnvironmentBuilder.builder(
                        EnvironmentsCatalogFixtures.environment())
                .autoStopSetting(null);

        final GitLabEnvironment built = builder.build();

        assertThat(built.autoStopSetting()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEnvironment value = EnvironmentsCatalogFixtures.environment();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("deploy");
            softly.assertThat(value.slug()).isEqualTo("deploy");
            softly.assertThat(value.externalUrl()).isEqualTo("https://deploy.gitlab.example.com");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.tier()).isEqualTo("development");
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.basicProjectDetails());
            softly.assertThat(value.lastDeployment()).isEqualTo(CommonCatalogFixtures.deployment());
            softly.assertThat(value.state()).isEqualTo("available");
            softly.assertThat(value.autoStopAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.clusterAgent()).isEqualTo(CommonCatalogFixtures.clusterAgent());
            softly.assertThat(value.kubernetesNamespace()).isEqualTo("kubernetes_namespace");
            softly.assertThat(value.fluxResourcePath()).isEqualTo("flux_resource_path");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.autoStopSetting()).isEqualTo("always");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEnvironment original = EnvironmentsCatalogFixtures.environment();

        final GitLabEnvironment rebuilt =
                GitLabEnvironmentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEnvironment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "slug",
                        "externalUrl",
                        "createdAt",
                        "updatedAt",
                        "tier",
                        "project",
                        "lastDeployment",
                        "state",
                        "autoStopAt",
                        "clusterAgent",
                        "kubernetesNamespace",
                        "fluxResourcePath",
                        "description",
                        "autoStopSetting");
    }
}
