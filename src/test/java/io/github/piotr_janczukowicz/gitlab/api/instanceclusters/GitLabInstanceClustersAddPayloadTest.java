package io.github.piotr_janczukowicz.gitlab.api.instanceclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceClustersAddPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .name(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .enabled(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .environmentScope(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .namespacePerEnvironment(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .domain(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .managementProjectId(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .managed(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabInstanceClustersAddPayloadBuilder builder = GitLabInstanceClustersAddPayloadBuilder.builder(
                        InstanceclustersCatalogFixtures.instanceClustersAddPayload())
                .platformKubernetesAttributes(null);

        final GitLabInstanceClustersAddPayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceClustersAddPayload value = InstanceclustersCatalogFixtures.instanceClustersAddPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(InstanceclustersCatalogFixtures.instanceClustersAddPlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceClustersAddPayload original = InstanceclustersCatalogFixtures.instanceClustersAddPayload();

        final GitLabInstanceClustersAddPayload rebuilt =
                GitLabInstanceClustersAddPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceClustersAddPayload.class.getRecordComponents())
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
