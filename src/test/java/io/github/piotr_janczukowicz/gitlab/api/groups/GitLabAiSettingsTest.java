package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAiSettingsTest {

    @Test
    void constructor_shouldAcceptNull_whenDuoAgentPlatformEnabledIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .duoAgentPlatformEnabled(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.duoAgentPlatformEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDuoWorkflowMcpEnabledIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .duoWorkflowMcpEnabled(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.duoWorkflowMcpEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundationalAgentsDefaultEnabledIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .foundationalAgentsDefaultEnabled(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.foundationalAgentsDefaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiCatalogRestrictedToGroupHierarchyIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .aiCatalogRestrictedToGroupHierarchy(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.aiCatalogRestrictedToGroupHierarchy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAiUsageDataCollectionEnabledIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .aiUsageDataCollectionEnabled(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.aiUsageDataCollectionEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPromptInjectionProtectionLevelIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .promptInjectionProtectionLevel(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.promptInjectionProtectionLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebSearchEnabledIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .webSearchEnabled(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.webSearchEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIncludeRecommendedAllowedIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .includeRecommendedAllowed(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.includeRecommendedAllowed()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowAllUnixSocketsIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .allowAllUnixSockets(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.allowAllUnixSockets()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowProjectExtensionIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .allowProjectExtension(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.allowProjectExtension()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequireSandboxIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .requireSandbox(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.requireSandbox()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelExecuteIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .minimumAccessLevelExecute(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.minimumAccessLevelExecute()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelExecuteAsyncIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .minimumAccessLevelExecuteAsync(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.minimumAccessLevelExecuteAsync()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelManageIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .minimumAccessLevelManage(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.minimumAccessLevelManage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMinimumAccessLevelEnableOnProjectsIsNullable() {
        final GitLabAiSettingsBuilder builder = GitLabAiSettingsBuilder.builder(GroupsCatalogFixtures.aiSettings())
                .minimumAccessLevelEnableOnProjects(null);

        final GitLabAiSettings built = builder.build();

        assertThat(built.minimumAccessLevelEnableOnProjects()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAiSettings value = GroupsCatalogFixtures.aiSettings();

        assertSoftly(softly -> {
            softly.assertThat(value.duoAgentPlatformEnabled()).isEqualTo(true);
            softly.assertThat(value.duoWorkflowMcpEnabled()).isEqualTo(true);
            softly.assertThat(value.foundationalAgentsDefaultEnabled()).isEqualTo(true);
            softly.assertThat(value.aiCatalogRestrictedToGroupHierarchy()).isEqualTo(true);
            softly.assertThat(value.aiUsageDataCollectionEnabled()).isEqualTo(true);
            softly.assertThat(value.promptInjectionProtectionLevel()).isEqualTo("no_checks");
            softly.assertThat(value.webSearchEnabled()).isEqualTo(true);
            softly.assertThat(value.includeRecommendedAllowed()).isEqualTo(true);
            softly.assertThat(value.allowAllUnixSockets()).isEqualTo(true);
            softly.assertThat(value.allowProjectExtension()).isEqualTo(true);
            softly.assertThat(value.requireSandbox()).isEqualTo(true);
            softly.assertThat(value.minimumAccessLevelExecute()).isEqualTo("developer");
            softly.assertThat(value.minimumAccessLevelExecuteAsync()).isEqualTo("developer");
            softly.assertThat(value.minimumAccessLevelManage()).isEqualTo("maintainer");
            softly.assertThat(value.minimumAccessLevelEnableOnProjects()).isEqualTo("maintainer");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAiSettings original = GroupsCatalogFixtures.aiSettings();

        final GitLabAiSettings rebuilt =
                GitLabAiSettingsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAiSettings.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "duoAgentPlatformEnabled",
                        "duoWorkflowMcpEnabled",
                        "foundationalAgentsDefaultEnabled",
                        "aiCatalogRestrictedToGroupHierarchy",
                        "aiUsageDataCollectionEnabled",
                        "promptInjectionProtectionLevel",
                        "webSearchEnabled",
                        "includeRecommendedAllowed",
                        "allowAllUnixSockets",
                        "allowProjectExtension",
                        "requireSandbox",
                        "minimumAccessLevelExecute",
                        "minimumAccessLevelExecuteAsync",
                        "minimumAccessLevelManage",
                        "minimumAccessLevelEnableOnProjects");
    }
}
