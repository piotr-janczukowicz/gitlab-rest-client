package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).id(null);

        final GitLabCluster built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).name(null);

        final GitLabCluster built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).createdAt(null);

        final GitLabCluster built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).domain(null);

        final GitLabCluster built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).enabled(null);

        final GitLabCluster built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).managed(null);

        final GitLabCluster built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderTypeIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).providerType(null);

        final GitLabCluster built = builder.build();

        assertThat(built.providerType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformTypeIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).platformType(null);

        final GitLabCluster built = builder.build();

        assertThat(built.platformType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).environmentScope(null);

        final GitLabCluster built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterTypeIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).clusterType(null);

        final GitLabCluster built = builder.build();

        assertThat(built.clusterType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).namespacePerEnvironment(null);

        final GitLabCluster built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).user(null);

        final GitLabCluster built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).platformKubernetes(null);

        final GitLabCluster built = builder.build();

        assertThat(built.platformKubernetes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderGcpIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).providerGcp(null);

        final GitLabCluster built = builder.build();

        assertThat(built.providerGcp()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIsNullable() {
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).managementProject(null);

        final GitLabCluster built = builder.build();

        assertThat(built.managementProject()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCluster value = CommonCatalogFixtures.cluster();

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
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCluster original = CommonCatalogFixtures.cluster();

        final GitLabCluster rebuilt = GitLabClusterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabClusterBuilder builder =
                GitLabClusterBuilder.builder(CommonCatalogFixtures.cluster()).createdAt(instant);

        final GitLabCluster built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCluster.class.getRecordComponents())
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
                        "managementProject");
    }
}
