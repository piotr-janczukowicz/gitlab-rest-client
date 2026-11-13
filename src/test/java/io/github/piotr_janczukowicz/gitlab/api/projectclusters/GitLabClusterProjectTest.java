package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterProjectTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .id(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .name(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .createdAt(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .domain(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .enabled(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .managed(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderTypeIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .providerType(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.providerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformTypeIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .platformType(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.platformType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .environmentScope(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterTypeIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .clusterType(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.clusterType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .namespacePerEnvironment(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .user(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .platformKubernetes(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.platformKubernetes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderGcpIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .providerGcp(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.providerGcp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .managementProject(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.managementProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .project(null);

        final GitLabClusterProject built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterProject value = ProjectclustersCatalogFixtures.clusterProject();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("id");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.enabled()).isEqualTo("enabled");
            softly.assertThat(value.managed()).isEqualTo("managed");
            softly.assertThat(value.providerType()).isEqualTo("provider_type");
            softly.assertThat(value.platformType()).isEqualTo("platform_type");
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.clusterType()).isEqualTo("cluster_type");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo("namespace_per_environment");
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.platformKubernetes()).isEqualTo(CommonCatalogFixtures.platformKubernetes());
            softly.assertThat(value.providerGcp()).isEqualTo(CommonCatalogFixtures.providerGcp());
            softly.assertThat(value.managementProject()).isEqualTo(CommonCatalogFixtures.projectIdentity());
            softly.assertThat(value.project()).isEqualTo(CommonCatalogFixtures.basicProjectDetails());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterProject original = ProjectclustersCatalogFixtures.clusterProject();

        final GitLabClusterProject rebuilt =
                GitLabClusterProjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabClusterProjectBuilder builder = GitLabClusterProjectBuilder.builder(
                        ProjectclustersCatalogFixtures.clusterProject())
                .createdAt(instant);

        final GitLabClusterProject built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterProject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "createdAt",
                        "domain",
                        "enabled",
                        "managed",
                        "providerType",
                        "platformType",
                        "environmentScope",
                        "clusterType",
                        "namespacePerEnvironment",
                        "user",
                        "platformKubernetes",
                        "providerGcp",
                        "managementProject",
                        "project");
    }
}
