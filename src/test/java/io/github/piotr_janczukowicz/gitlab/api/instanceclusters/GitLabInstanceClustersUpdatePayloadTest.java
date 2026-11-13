package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceClustersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .name(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .enabled(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .environmentScope(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .namespacePerEnvironment(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .domain(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .managementProjectId(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .managed(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabInstanceClustersUpdatePayloadBuilder builder = GitLabInstanceClustersUpdatePayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersUpdatePayload())
                .platformKubernetesAttributes(null);

        final GitLabInstanceClustersUpdatePayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceClustersUpdatePayload value =
                InstanceclustersCatalogFixtures.instanceClustersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(InstanceclustersCatalogFixtures.instanceClustersUpdatePlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceClustersUpdatePayload original =
                InstanceclustersCatalogFixtures.instanceClustersUpdatePayload();

        final GitLabInstanceClustersUpdatePayload rebuilt =
                GitLabInstanceClustersUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceClustersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "enabled",
                        "environmentScope",
                        "namespacePerEnvironment",
                        "domain",
                        "managementProjectId",
                        "managed",
                        "platformKubernetesAttributes");
    }
}
