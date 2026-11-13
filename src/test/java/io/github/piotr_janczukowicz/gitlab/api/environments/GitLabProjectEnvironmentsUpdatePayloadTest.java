package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEnvironmentsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenExternalUrlIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .externalUrl(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.externalUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTierIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .tier(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.tier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterAgentIdIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .clusterAgentId(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.clusterAgentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKubernetesNamespaceIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .kubernetesNamespace(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.kubernetesNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFluxResourcePathIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .fluxResourcePath(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.fluxResourcePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .description(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoStopSettingIsNullable() {
        final GitLabProjectEnvironmentsUpdatePayloadBuilder builder =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(
                                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload())
                        .autoStopSetting(null);

        final GitLabProjectEnvironmentsUpdatePayload built = builder.build();

        assertThat(built.autoStopSetting()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEnvironmentsUpdatePayload value =
                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.externalUrl()).isEqualTo("external_url");
            softly.assertThat(value.tier()).isEqualTo(GitLabProjectEnvironmentsUpdateTier.PRODUCTION);
            softly.assertThat(value.clusterAgentId()).isEqualTo(1L);
            softly.assertThat(value.kubernetesNamespace()).isEqualTo("kubernetes_namespace");
            softly.assertThat(value.fluxResourcePath()).isEqualTo("flux_resource_path");
            softly.assertThat(value.description()).isEqualTo("description");
            softly.assertThat(value.autoStopSetting()).isEqualTo(GitLabProjectEnvironmentsUpdateAutoStopSetting.ALWAYS);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEnvironmentsUpdatePayload original =
                EnvironmentsCatalogFixtures.projectEnvironmentsUpdatePayload();

        final GitLabProjectEnvironmentsUpdatePayload rebuilt =
                GitLabProjectEnvironmentsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEnvironmentsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "externalUrl",
                        "tier",
                        "clusterAgentId",
                        "kubernetesNamespace",
                        "fluxResourcePath",
                        "description",
                        "autoStopSetting");
    }
}
