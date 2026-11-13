package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsUpdateClusterPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .name(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .enabled(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .domain(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .environmentScope(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .namespacePerEnvironment(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .managementProjectId(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .managed(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabGroupGroupsUpdateClusterPayloadBuilder builder =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsUpdateClusterPayload())
                        .platformKubernetesAttributes(null);

        final GitLabGroupGroupsUpdateClusterPayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsUpdateClusterPayload value = GroupsCatalogFixtures.groupGroupsUpdateClusterPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(GroupsCatalogFixtures.groupGroupsUpdateClusterPlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsUpdateClusterPayload original = GroupsCatalogFixtures.groupGroupsUpdateClusterPayload();

        final GitLabGroupGroupsUpdateClusterPayload rebuilt =
                GitLabGroupGroupsUpdateClusterPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupsUpdateClusterPayload.class.getRecordComponents())
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
