package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param globalSearchSnippetTitlesEnabled the global search snippet titles enabled
 * @param globalSearchUsersEnabled the global search users enabled
 * @param globalSearchGroupsEnabled the global search groups enabled
 * @param globalSearchWorkItemsEnabled the global search work items enabled
 * @param globalSearchMergeRequestsEnabled the global search merge requests enabled
 * @param globalSearchBlockAnonymousSearchesEnabled the global search block anonymous searches enabled
 * @param globalSearchCodeEnabled the global search code enabled
 * @param globalSearchCommitsEnabled the global search commits enabled
 * @param globalSearchWikiEnabled the global search wiki enabled
 * @param globalSearchLimitedIndexingEnabled the global search limited indexing enabled
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateGlobal(
        @Nullable String globalSearchSnippetTitlesEnabled,
        @Nullable String globalSearchUsersEnabled,
        @Nullable String globalSearchGroupsEnabled,
        @Nullable String globalSearchWorkItemsEnabled,
        @Nullable String globalSearchMergeRequestsEnabled,
        @Nullable String globalSearchBlockAnonymousSearchesEnabled,
        @Nullable String globalSearchCodeEnabled,
        @Nullable String globalSearchCommitsEnabled,
        @Nullable String globalSearchWikiEnabled,
        @Nullable String globalSearchLimitedIndexingEnabled) {}
