package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectContainerRegistryProtectionRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectContainerRegistryProtectionRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule())
                        .id(null);

        final GitLabProjectContainerRegistryProtectionRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectContainerRegistryProtectionRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule())
                        .projectId(null);

        final GitLabProjectContainerRegistryProtectionRule built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryPathPatternIsNullable() {
        final GitLabProjectContainerRegistryProtectionRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule())
                        .repositoryPathPattern(null);

        final GitLabProjectContainerRegistryProtectionRule built = builder.build();

        assertThat(built.repositoryPathPattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabProjectContainerRegistryProtectionRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule())
                        .minimumAccessLevelForPush(null);

        final GitLabProjectContainerRegistryProtectionRule built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabProjectContainerRegistryProtectionRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(
                                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule())
                        .minimumAccessLevelForDelete(null);

        final GitLabProjectContainerRegistryProtectionRule built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectContainerRegistryProtectionRule value =
                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.repositoryPathPattern()).isEqualTo("flightjs/flight0");
            softly.assertThat(value.minimumAccessLevelForPush()).isEqualTo("maintainer");
            softly.assertThat(value.minimumAccessLevelForDelete()).isEqualTo("maintainer");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectContainerRegistryProtectionRule original =
                ProtectedcontainerregistryCatalogFixtures.projectContainerRegistryProtectionRule();

        final GitLabProjectContainerRegistryProtectionRule rebuilt =
                GitLabProjectContainerRegistryProtectionRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectContainerRegistryProtectionRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "projectId",
                        "repositoryPathPattern",
                        "minimumAccessLevelForPush",
                        "minimumAccessLevelForDelete");
    }
}
