package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterGroupTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .id(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .name(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .createdAt(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .domain(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .enabled(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .managed(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderTypeIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .providerType(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.providerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformTypeIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .platformType(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.platformType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .environmentScope(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterTypeIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .clusterType(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.clusterType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .namespacePerEnvironment(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .user(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .platformKubernetes(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.platformKubernetes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderGcpIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .providerGcp(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.providerGcp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .managementProject(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.managementProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .group(null);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterGroup value = GroupsCatalogFixtures.clusterGroup();

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
            softly.assertThat(value.group()).isEqualTo(CommonCatalogFixtures.basicGroupDetails());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterGroup original = GroupsCatalogFixtures.clusterGroup();

        final GitLabClusterGroup rebuilt =
                GitLabClusterGroupBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabClusterGroupBuilder builder = GitLabClusterGroupBuilder.builder(
                        GroupsCatalogFixtures.clusterGroup())
                .createdAt(instant);

        final GitLabClusterGroup built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterGroup.class.getRecordComponents())
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
                        "group");
    }
}
