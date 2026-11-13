package io.github.piotr_janczukowicz.gitlab.api.projectclusters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectClusterUserCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .name(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .enabled(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .domain(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .environmentScope(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .namespacePerEnvironment(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .managementProjectId(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .managed(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabProjectClusterUserCreatePayloadBuilder builder =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(
                                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload())
                        .platformKubernetesAttributes(null);

        final GitLabProjectClusterUserCreatePayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectClusterUserCreatePayload value =
                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(ProjectclustersCatalogFixtures.projectClusterUserCreatePlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectClusterUserCreatePayload original =
                ProjectclustersCatalogFixtures.projectClusterUserCreatePayload();

        final GitLabProjectClusterUserCreatePayload rebuilt =
                GitLabProjectClusterUserCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectClusterUserCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "enabled",
                        "domain",
                        "environmentScope",
                        "namespacePerEnvironment",
                        "managementProjectId",
                        "managed",
                        "platformKubernetesAttributes");
    }
}
