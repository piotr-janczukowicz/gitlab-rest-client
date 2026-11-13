package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupClusterUserCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .name(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnabledIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .enabled(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.enabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentScopeIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .environmentScope(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.environmentScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePerEnvironmentIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .namespacePerEnvironment(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.namespacePerEnvironment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .domain(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagementProjectIdIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .managementProjectId(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.managementProjectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenManagedIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .managed(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.managed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformKubernetesAttributesIsNullable() {
        final GitLabGroupClusterUserCreatePayloadBuilder builder = GitLabGroupClusterUserCreatePayloadBuilder.builder(
                        GroupsCatalogFixtures.groupClusterUserCreatePayload())
                .platformKubernetesAttributes(null);

        final GitLabGroupClusterUserCreatePayload built = builder.build();

        assertThat(built.platformKubernetesAttributes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupClusterUserCreatePayload value = GroupsCatalogFixtures.groupClusterUserCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.enabled()).isEqualTo(true);
            softly.assertThat(value.environmentScope()).isEqualTo("environment_scope");
            softly.assertThat(value.namespacePerEnvironment()).isEqualTo(true);
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.managementProjectId()).isEqualTo(1L);
            softly.assertThat(value.managed()).isEqualTo(true);
            softly.assertThat(value.platformKubernetesAttributes())
                    .isEqualTo(GroupsCatalogFixtures.groupClusterUserCreatePlatformKubernetesAttributes());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupClusterUserCreatePayload original = GroupsCatalogFixtures.groupClusterUserCreatePayload();

        final GitLabGroupClusterUserCreatePayload rebuilt =
                GitLabGroupClusterUserCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupClusterUserCreatePayload.class.getRecordComponents())
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
