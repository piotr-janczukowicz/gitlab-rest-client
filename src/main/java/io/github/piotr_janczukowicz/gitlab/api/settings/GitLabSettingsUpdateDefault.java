package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param defaultArtifactsExpireIn the default artifacts expire in
 * @param defaultCiConfigPath the default ci config path
 * @param defaultProjectCreation the default project creation
 * @param defaultRemoveSourceBranchAfterMerge the default remove source branch after merge
 * @param defaultBranchProtection the default branch protection
 * @param defaultBranchProtectionDefaults the default branch protection defaults
 * @param defaultGroupVisibility the default group visibility
 * @param defaultProjectVisibility the default project visibility
 * @param defaultProjectsLimit the default projects limit
 * @param defaultSnippetVisibility the default snippet visibility
 * @param defaultBranchName the default branch name
 * @param defaultDarkSyntaxHighlightingTheme the default dark syntax highlighting theme
 * @param defaultPreferredLanguage the default preferred language
 * @param defaultSyntaxHighlightingTheme the default syntax highlighting theme
 * @param defaultProjectDeletionProtection the default project deletion protection
 * @param defaultSearchScope the default search scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateDefault(
        @Nullable String defaultArtifactsExpireIn,
        @Nullable String defaultCiConfigPath,
        @Nullable GitLabSettingsUpdateDefaultProjectCreation defaultProjectCreation,
        @Nullable Boolean defaultRemoveSourceBranchAfterMerge,
        @Nullable GitLabSettingsUpdateDefaultBranchProtection defaultBranchProtection,
        @Nullable GitLabSettingsUpdateDefaultBranchProtectionDefaults defaultBranchProtectionDefaults,
        @Nullable GitLabSettingsUpdateDefaultGroupVisibility defaultGroupVisibility,
        @Nullable GitLabSettingsUpdateDefaultProjectVisibility defaultProjectVisibility,
        @Nullable Integer defaultProjectsLimit,
        @Nullable GitLabSettingsUpdateDefaultSnippetVisibility defaultSnippetVisibility,
        @Nullable String defaultBranchName,
        @Nullable String defaultDarkSyntaxHighlightingTheme,
        @Nullable String defaultPreferredLanguage,
        @Nullable String defaultSyntaxHighlightingTheme,
        @Nullable Boolean defaultProjectDeletionProtection,
        @Nullable String defaultSearchScope) {}
