package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4UsersUserIdStarredProjects}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param archived the archived
 * @param visibility the visibility
 * @param search the search
 * @param searchNamespaces the search namespaces
 * @param owned the owned
 * @param starred the starred
 * @param imported the imported
 * @param membership the membership
 * @param withIssuesEnabled the with issues enabled
 * @param withMergeRequestsEnabled the with merge requests enabled
 * @param withProgrammingLanguage the with programming language
 * @param minAccessLevel the min access level
 * @param idAfter the id after
 * @param idBefore the id before
 * @param lastActivityAfter the last activity after
 * @param lastActivityBefore the last activity before
 * @param repositoryStorage the repository storage
 * @param topic the topic
 * @param topicId the topic id
 * @param updatedBefore the updated before
 * @param updatedAfter the updated after
 * @param includePendingDelete the include pending delete
 * @param markedForDeletionOn the marked for deletion on
 * @param active the active
 * @param wikiChecksumFailed the wiki checksum failed
 * @param repositoryChecksumFailed the repository checksum failed
 * @param includeHidden the include hidden
 * @param simple the simple
 * @param statistics the statistics
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4UsersUserIdStarredProjects/parameters")
public record GitLabInstanceProjectsListUsersStarredProjectsFilter(
        @Nullable GitLabInstanceProjectsListUsersStarredProjectsOrderBy orderBy,
        @Nullable GitLabInstanceProjectsListUsersStarredProjectsSort sort,
        @Nullable Boolean archived,
        @Nullable GitLabInstanceProjectsListUsersStarredProjectsVisibility visibility,
        @Nullable String search,
        @Nullable Boolean searchNamespaces,
        @Nullable Boolean owned,
        @Nullable Boolean starred,
        @Nullable Boolean imported,
        @Nullable Boolean membership,
        @Nullable Boolean withIssuesEnabled,
        @Nullable Boolean withMergeRequestsEnabled,
        @Nullable String withProgrammingLanguage,
        @Nullable GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel minAccessLevel,
        @Nullable Integer idAfter,
        @Nullable Integer idBefore,
        @Nullable Instant lastActivityAfter,
        @Nullable Instant lastActivityBefore,
        @Nullable String repositoryStorage,
        @Nullable List<String> topic,
        @Nullable Long topicId,
        @Nullable Instant updatedBefore,
        @Nullable Instant updatedAfter,
        @Nullable Boolean includePendingDelete,
        @Nullable LocalDate markedForDeletionOn,
        @Nullable Boolean active,
        @Nullable Boolean wikiChecksumFailed,
        @Nullable Boolean repositoryChecksumFailed,
        @Nullable Boolean includeHidden,
        @Nullable Boolean simple,
        @Nullable Boolean statistics,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes) {
    public GitLabInstanceProjectsListUsersStarredProjectsFilter {
        if (topic != null) {
            topic = List.copyOf(topic);
        }
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabInstanceProjectsListUsersStarredProjectsFilter empty() {
        return GitLabInstanceProjectsListUsersStarredProjectsFilterBuilder.builder()
                .build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabInstanceProjectsListUsersStarredProjectsOrderBy::wireValue)
                .wire("sort", sort, GitLabInstanceProjectsListUsersStarredProjectsSort::wireValue)
                .value("archived", archived)
                .wire("visibility", visibility, GitLabInstanceProjectsListUsersStarredProjectsVisibility::wireValue)
                .text("search", search)
                .value("search_namespaces", searchNamespaces)
                .value("owned", owned)
                .value("starred", starred)
                .value("imported", imported)
                .value("membership", membership)
                .value("with_issues_enabled", withIssuesEnabled)
                .value("with_merge_requests_enabled", withMergeRequestsEnabled)
                .text("with_programming_language", withProgrammingLanguage)
                .wire(
                        "min_access_level",
                        minAccessLevel,
                        GitLabInstanceProjectsListUsersStarredProjectsMinAccessLevel::wireValue)
                .value("id_after", idAfter)
                .value("id_before", idBefore)
                .value("last_activity_after", lastActivityAfter)
                .value("last_activity_before", lastActivityBefore)
                .text("repository_storage", repositoryStorage)
                .list("topic", topic)
                .value("topic_id", topicId)
                .value("updated_before", updatedBefore)
                .value("updated_after", updatedAfter)
                .value("include_pending_delete", includePendingDelete)
                .value("marked_for_deletion_on", markedForDeletionOn)
                .value("active", active)
                .value("wiki_checksum_failed", wikiChecksumFailed)
                .value("repository_checksum_failed", repositoryChecksumFailed)
                .value("include_hidden", includeHidden)
                .value("simple", simple)
                .value("statistics", statistics)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .build();
    }
}
