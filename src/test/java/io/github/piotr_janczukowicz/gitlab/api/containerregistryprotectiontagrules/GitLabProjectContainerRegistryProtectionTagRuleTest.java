package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectContainerRegistryProtectionTagRuleTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectContainerRegistryProtectionTagRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(
                                ContainerregistryprotectiontagrulesCatalogFixtures
                                        .projectContainerRegistryProtectionTagRule())
                        .id(null);

        final GitLabProjectContainerRegistryProtectionTagRule built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectContainerRegistryProtectionTagRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(
                                ContainerregistryprotectiontagrulesCatalogFixtures
                                        .projectContainerRegistryProtectionTagRule())
                        .projectId(null);

        final GitLabProjectContainerRegistryProtectionTagRule built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTagNamePatternIsNullable() {
        final GitLabProjectContainerRegistryProtectionTagRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(
                                ContainerregistryprotectiontagrulesCatalogFixtures
                                        .projectContainerRegistryProtectionTagRule())
                        .tagNamePattern(null);

        final GitLabProjectContainerRegistryProtectionTagRule built = builder.build();

        assertThat(built.tagNamePattern()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForPushIsNullable() {
        final GitLabProjectContainerRegistryProtectionTagRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(
                                ContainerregistryprotectiontagrulesCatalogFixtures
                                        .projectContainerRegistryProtectionTagRule())
                        .minimumAccessLevelForPush(null);

        final GitLabProjectContainerRegistryProtectionTagRule built = builder.build();

        assertThat(built.minimumAccessLevelForPush()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelForDeleteIsNullable() {
        final GitLabProjectContainerRegistryProtectionTagRuleBuilder builder =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(
                                ContainerregistryprotectiontagrulesCatalogFixtures
                                        .projectContainerRegistryProtectionTagRule())
                        .minimumAccessLevelForDelete(null);

        final GitLabProjectContainerRegistryProtectionTagRule built = builder.build();

        assertThat(built.minimumAccessLevelForDelete()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectContainerRegistryProtectionTagRule value =
                ContainerregistryprotectiontagrulesCatalogFixtures.projectContainerRegistryProtectionTagRule();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.tagNamePattern()).isEqualTo("v*-release");
            softly.assertThat(value.minimumAccessLevelForPush()).isEqualTo("maintainer");
            softly.assertThat(value.minimumAccessLevelForDelete()).isEqualTo("maintainer");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectContainerRegistryProtectionTagRule original =
                ContainerregistryprotectiontagrulesCatalogFixtures.projectContainerRegistryProtectionTagRule();

        final GitLabProjectContainerRegistryProtectionTagRule rebuilt =
                GitLabProjectContainerRegistryProtectionTagRuleBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectContainerRegistryProtectionTagRule.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "projectId",
                        "tagNamePattern",
                        "minimumAccessLevelForPush",
                        "minimumAccessLevelForDelete");
    }
}
