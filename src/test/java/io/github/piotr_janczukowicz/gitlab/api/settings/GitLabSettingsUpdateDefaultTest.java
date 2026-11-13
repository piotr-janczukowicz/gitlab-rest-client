package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateDefaultTest {

    @Test
    void constructor_shouldAcceptNull_whenDefaultArtifactsExpireInIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultArtifactsExpireIn(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultArtifactsExpireIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultCiConfigPathIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultCiConfigPath(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultCiConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectCreationIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultProjectCreation(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultProjectCreation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultRemoveSourceBranchAfterMerge(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultRemoveSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultBranchProtection(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionDefaultsIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultBranchProtectionDefaults(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultBranchProtectionDefaults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultGroupVisibilityIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultGroupVisibility(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultGroupVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectVisibilityIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultProjectVisibility(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultProjectVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectsLimitIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultProjectsLimit(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultProjectsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSnippetVisibilityIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultSnippetVisibility(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultSnippetVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchNameIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultBranchName(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultBranchName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultDarkSyntaxHighlightingThemeIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultDarkSyntaxHighlightingTheme(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultDarkSyntaxHighlightingTheme()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultPreferredLanguageIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultPreferredLanguage(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultPreferredLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSyntaxHighlightingThemeIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultSyntaxHighlightingTheme(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultSyntaxHighlightingTheme()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectDeletionProtectionIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultProjectDeletionProtection(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultProjectDeletionProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSearchScopeIsNullable() {
        final GitLabSettingsUpdateDefaultBuilder builder = GitLabSettingsUpdateDefaultBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateDefault())
                .defaultSearchScope(null);

        final GitLabSettingsUpdateDefault built = builder.build();

        assertThat(built.defaultSearchScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateDefault value = SettingsCatalogFixtures.settingsUpdateDefault();

        assertSoftly(softly -> {
            softly.assertThat(value.defaultArtifactsExpireIn()).isEqualTo("default_artifacts_expire_in");
            softly.assertThat(value.defaultCiConfigPath()).isEqualTo("default_ci_config_path");
            softly.assertThat(value.defaultProjectCreation()).isEqualTo(GitLabSettingsUpdateDefaultProjectCreation.N_0);
            softly.assertThat(value.defaultRemoveSourceBranchAfterMerge()).isEqualTo(true);
            softly.assertThat(value.defaultBranchProtection())
                    .isEqualTo(GitLabSettingsUpdateDefaultBranchProtection.N_0);
            softly.assertThat(value.defaultBranchProtectionDefaults())
                    .isEqualTo(SettingsCatalogFixtures.settingsUpdateDefaultBranchProtectionDefaults());
            softly.assertThat(value.defaultGroupVisibility())
                    .isEqualTo(GitLabSettingsUpdateDefaultGroupVisibility.PRIVATE);
            softly.assertThat(value.defaultProjectVisibility())
                    .isEqualTo(GitLabSettingsUpdateDefaultProjectVisibility.PRIVATE);
            softly.assertThat(value.defaultProjectsLimit()).isEqualTo(1);
            softly.assertThat(value.defaultSnippetVisibility())
                    .isEqualTo(GitLabSettingsUpdateDefaultSnippetVisibility.PRIVATE);
            softly.assertThat(value.defaultBranchName()).isEqualTo("default_branch_name");
            softly.assertThat(value.defaultDarkSyntaxHighlightingTheme())
                    .isEqualTo("default_dark_syntax_highlighting_theme");
            softly.assertThat(value.defaultPreferredLanguage()).isEqualTo("default_preferred_language");
            softly.assertThat(value.defaultSyntaxHighlightingTheme()).isEqualTo("default_syntax_highlighting_theme");
            softly.assertThat(value.defaultProjectDeletionProtection()).isEqualTo(true);
            softly.assertThat(value.defaultSearchScope()).isEqualTo("default_search_scope");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateDefault original = SettingsCatalogFixtures.settingsUpdateDefault();

        final GitLabSettingsUpdateDefault rebuilt =
                GitLabSettingsUpdateDefaultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateDefault.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "defaultArtifactsExpireIn",
                        "defaultCiConfigPath",
                        "defaultProjectCreation",
                        "defaultRemoveSourceBranchAfterMerge",
                        "defaultBranchProtection",
                        "defaultBranchProtectionDefaults",
                        "defaultGroupVisibility",
                        "defaultProjectVisibility",
                        "defaultProjectsLimit",
                        "defaultSnippetVisibility",
                        "defaultBranchName",
                        "defaultDarkSyntaxHighlightingTheme",
                        "defaultPreferredLanguage",
                        "defaultSyntaxHighlightingTheme",
                        "defaultProjectDeletionProtection",
                        "defaultSearchScope");
    }
}
