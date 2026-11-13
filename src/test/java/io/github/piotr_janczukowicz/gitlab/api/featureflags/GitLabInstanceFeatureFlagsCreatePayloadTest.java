package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceFeatureFlagsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .value(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .key(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureGroupIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .featureGroup(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.featureGroup()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .user(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .group(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .namespace(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .project(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.project()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOrganizationIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .organization(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.organization()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .repository(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.repository()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .runner(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.runner()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndpointIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .endpoint(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.endpoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForceIsNullable() {
        final GitLabInstanceFeatureFlagsCreatePayloadBuilder builder =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(
                                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload())
                        .force(null);

        final GitLabInstanceFeatureFlagsCreatePayload built = builder.build();

        assertThat(built.force()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceFeatureFlagsCreatePayload value =
                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.value()).isEqualTo("text");
            softly.assertThat(value.key()).isEqualTo(GitLabInstanceFeatureFlagsCreateKey.PERCENTAGE_OF_ACTORS);
            softly.assertThat(value.featureGroup()).isEqualTo("feature_group");
            softly.assertThat(value.user()).isEqualTo("user");
            softly.assertThat(value.group()).isEqualTo("group");
            softly.assertThat(value.namespace()).isEqualTo("namespace");
            softly.assertThat(value.project()).isEqualTo("project");
            softly.assertThat(value.organization()).isEqualTo("organization");
            softly.assertThat(value.repository()).isEqualTo("repository");
            softly.assertThat(value.runner()).isEqualTo("runner");
            softly.assertThat(value.endpoint()).isEqualTo("endpoint");
            softly.assertThat(value.force()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceFeatureFlagsCreatePayload original =
                FeatureflagsCatalogFixtures.instanceFeatureFlagsCreatePayload();

        final GitLabInstanceFeatureFlagsCreatePayload rebuilt =
                GitLabInstanceFeatureFlagsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceFeatureFlagsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "value",
                        "key",
                        "featureGroup",
                        "user",
                        "group",
                        "namespace",
                        "project",
                        "organization",
                        "repository",
                        "runner",
                        "endpoint",
                        "force");
    }
}
