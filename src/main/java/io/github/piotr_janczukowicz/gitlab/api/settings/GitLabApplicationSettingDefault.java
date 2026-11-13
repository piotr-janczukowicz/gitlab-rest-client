package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param defaultArtifactsExpireIn the default artifacts expire in
 * @param defaultBranchName the default branch name
 * @param defaultBranchProtection the default branch protection
 * @param defaultBranchProtectionDefaults the default branch protection defaults
 * @param defaultCiConfigPath the default ci config path
 * @param defaultGroupVisibility the default group visibility
 * @param defaultPreferredLanguage the default preferred language
 * @param defaultProjectCreation the default project creation
 * @param defaultProjectVisibility the default project visibility
 * @param defaultProjectsLimit the default projects limit
 * @param defaultRemoveSourceBranchAfterMerge the default remove source branch after merge
 * @param defaultSnippetVisibility the default snippet visibility
 * @param defaultSyntaxHighlightingTheme the default syntax highlighting theme
 * @param defaultDarkSyntaxHighlightingTheme the default dark syntax highlighting theme
 * @param defaultSearchScope the default search scope
 * @param defaultProjectDeletionProtection the default project deletion protection
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingDefault(
        @Nullable String defaultArtifactsExpireIn,
        @Nullable String defaultBranchName,
        @Nullable String defaultBranchProtection,
        @Nullable GitLabApplicationSettingDefaultBranchProtectionDefaults defaultBranchProtectionDefaults,
        @Nullable String defaultCiConfigPath,
        @Nullable String defaultGroupVisibility,
        @Nullable String defaultPreferredLanguage,
        @Nullable String defaultProjectCreation,
        @Nullable String defaultProjectVisibility,
        @Nullable String defaultProjectsLimit,
        @Nullable String defaultRemoveSourceBranchAfterMerge,
        @Nullable String defaultSnippetVisibility,
        @Nullable String defaultSyntaxHighlightingTheme,
        @Nullable String defaultDarkSyntaxHighlightingTheme,
        @Nullable String defaultSearchScope,
        @Nullable String defaultProjectDeletionProtection) {}
