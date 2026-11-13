package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDeploymentTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .id(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .iid(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .ref(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShaIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .sha(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.sha()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .createdAt(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUpdatedAtIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .updatedAt(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.updatedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .user(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEnvironmentIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .environment(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.environment()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeployableIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .deployable(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.deployable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabDeploymentBuilder builder = GitLabDeploymentBuilder.builder(CommonCatalogFixtures.deployment())
                .status(null);

        final GitLabDeployment built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDeployment value = CommonCatalogFixtures.deployment();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.ref()).isEqualTo("main");
            softly.assertThat(value.sha()).isEqualTo("99d03678b90d914dbb1b109132516d71a4a03ea8");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.updatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.environment()).isEqualTo(CommonCatalogFixtures.environmentBasic());
            softly.assertThat(value.deployable()).isEqualTo(CommonCatalogFixtures.ciJob());
            softly.assertThat(value.status()).isEqualTo("created");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDeployment original = CommonCatalogFixtures.deployment();

        final GitLabDeployment rebuilt =
                GitLabDeploymentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDeployment.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "iid",
                        "ref",
                        "sha",
                        "createdAt",
                        "updatedAt",
                        "user",
                        "environment",
                        "deployable",
                        "status");
    }
}
