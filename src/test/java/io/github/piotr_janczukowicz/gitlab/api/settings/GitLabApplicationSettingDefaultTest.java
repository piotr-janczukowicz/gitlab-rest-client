package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingDefaultTest {

    @Test
    void constructor_shouldAcceptNull_whenDefaultArtifactsExpireInIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultArtifactsExpireIn(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultArtifactsExpireIn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchNameIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultBranchName(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultBranchName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultBranchProtection(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultBranchProtection()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultBranchProtectionDefaultsIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultBranchProtectionDefaults(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultBranchProtectionDefaults()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultCiConfigPathIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultCiConfigPath(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultCiConfigPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultGroupVisibilityIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultGroupVisibility(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultGroupVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultPreferredLanguageIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultPreferredLanguage(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultPreferredLanguage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectCreationIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultProjectCreation(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultProjectCreation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectVisibilityIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultProjectVisibility(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultProjectVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectsLimitIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultProjectsLimit(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultProjectsLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultRemoveSourceBranchAfterMergeIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultRemoveSourceBranchAfterMerge(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultRemoveSourceBranchAfterMerge()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSnippetVisibilityIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultSnippetVisibility(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultSnippetVisibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSyntaxHighlightingThemeIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultSyntaxHighlightingTheme(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultSyntaxHighlightingTheme()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultDarkSyntaxHighlightingThemeIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultDarkSyntaxHighlightingTheme(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultDarkSyntaxHighlightingTheme()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultSearchScopeIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultSearchScope(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultSearchScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultProjectDeletionProtectionIsNullable() {
        final GitLabApplicationSettingDefaultBuilder builder = GitLabApplicationSettingDefaultBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingDefault())
                .defaultProjectDeletionProtection(null);

        final GitLabApplicationSettingDefault built = builder.build();

        assertThat(built.defaultProjectDeletionProtection()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingDefault value = SettingsCatalogFixtures.applicationSettingDefault();

        assertSoftly(softly -> {
            softly.assertThat(value.defaultArtifactsExpireIn()).isEqualTo("default_artifacts_expire_in");
            softly.assertThat(value.defaultBranchName()).isEqualTo("default_branch_name");
            softly.assertThat(value.defaultBranchProtection()).isEqualTo("default_branch_protection");
            softly.assertThat(value.defaultBranchProtectionDefaults())
                    .isEqualTo(SettingsCatalogFixtures.applicationSettingDefaultBranchProtectionDefaults());
            softly.assertThat(value.defaultCiConfigPath()).isEqualTo("default_ci_config_path");
            softly.assertThat(value.defaultGroupVisibility()).isEqualTo("default_group_visibility");
            softly.assertThat(value.defaultPreferredLanguage()).isEqualTo("default_preferred_language");
            softly.assertThat(value.defaultProjectCreation()).isEqualTo("default_project_creation");
            softly.assertThat(value.defaultProjectVisibility()).isEqualTo("default_project_visibility");
            softly.assertThat(value.defaultProjectsLimit()).isEqualTo("default_projects_limit");
            softly.assertThat(value.defaultRemoveSourceBranchAfterMerge())
                    .isEqualTo("default_remove_source_branch_after_merge");
            softly.assertThat(value.defaultSnippetVisibility()).isEqualTo("default_snippet_visibility");
            softly.assertThat(value.defaultSyntaxHighlightingTheme()).isEqualTo("default_syntax_highlighting_theme");
            softly.assertThat(value.defaultDarkSyntaxHighlightingTheme())
                    .isEqualTo("default_dark_syntax_highlighting_theme");
            softly.assertThat(value.defaultSearchScope()).isEqualTo("default_search_scope");
            softly.assertThat(value.defaultProjectDeletionProtection())
                    .isEqualTo("default_project_deletion_protection");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingDefault original = SettingsCatalogFixtures.applicationSettingDefault();

        final GitLabApplicationSettingDefault rebuilt =
                GitLabApplicationSettingDefaultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingDefault.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "defaultArtifactsExpireIn",
                        "defaultBranchName",
                        "defaultBranchProtection",
                        "defaultBranchProtectionDefaults",
                        "defaultCiConfigPath",
                        "defaultGroupVisibility",
                        "defaultPreferredLanguage",
                        "defaultProjectCreation",
                        "defaultProjectVisibility",
                        "defaultProjectsLimit",
                        "defaultRemoveSourceBranchAfterMerge",
                        "defaultSnippetVisibility",
                        "defaultSyntaxHighlightingTheme",
                        "defaultDarkSyntaxHighlightingTheme",
                        "defaultSearchScope",
                        "defaultProjectDeletionProtection");
    }
}
