package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEnvironmentsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .name(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .externalUrl(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTierIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .tier(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.tier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterAgentIdIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .clusterAgentId(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.clusterAgentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKubernetesNamespaceIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .kubernetesNamespace(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.kubernetesNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFluxResourcePathIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .fluxResourcePath(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.fluxResourcePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .description(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoStopSettingIsNullable() {
        final GitLabProjectEnvironmentsCreatePayloadBuilder builder =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload())
                        .autoStopSetting(null);

        final GitLabProjectEnvironmentsCreatePayload built = builder.build();

        assertThat(built.autoStopSetting()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsCreatePayload value =
                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.externalUrl()).isEqualTo("external_url");
            softly.assertThat(value.tier()).isEqualTo(GitLabProjectEnvironmentsCreateTier.PRODUCTION);
            softly.assertThat(value.clusterAgentId()).isEqualTo(1L);
            softly.assertThat(value.kubernetesNamespace()).isEqualTo("kubernetes_namespace");
            softly.assertThat(value.fluxResourcePath()).isEqualTo("flux_resource_path");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.autoStopSetting()).isEqualTo(GitLabProjectEnvironmentsCreateAutoStopSetting.ALWAYS);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsCreatePayload original =
                EnvironmentsCatalogFixtures.projectEnvironmentsCreatePayload();

        final GitLabProjectEnvironmentsCreatePayload rebuilt =
                GitLabProjectEnvironmentsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "externalUrl",
                        "tier",
                        "clusterAgentId",
                        "kubernetesNamespace",
                        "fluxResourcePath",
                        "description",
                        "autoStopSetting");
    }
}
