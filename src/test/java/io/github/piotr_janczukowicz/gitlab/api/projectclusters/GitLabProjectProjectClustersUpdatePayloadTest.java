package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectClustersUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .name(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .domain(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .environmentScope(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .namespacePerEnvironment(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .managementProjectId(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .enabled(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .managed(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabProjectProjectClustersUpdatePayloadBuilder builder =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload())
                        .platformKubernetesAttributes(null);

        final GitLabProjectProjectClustersUpdatePayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectClustersUpdatePayload value =
                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(
                            ProjectclustersCatalogFixtures.projectProjectClustersUpdatePlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectClustersUpdatePayload original =
                ProjectclustersCatalogFixtures.projectProjectClustersUpdatePayload();

        final GitLabProjectProjectClustersUpdatePayload rebuilt =
                GitLabProjectProjectClustersUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectClustersUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "domain",
                        "environmentScope",
                        "namespacePerEnvironment",
                        "managementProjectId",
                        "enabled",
                        "managed",
                        "platformKubernetesAttributes");
    }
}
