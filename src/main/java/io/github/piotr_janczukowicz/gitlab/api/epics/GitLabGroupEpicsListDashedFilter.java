package io.github.piotr_janczukowicz.gitlab.api.epics;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4GroupsIdDashEpics}, without paging.
 *
 * @param orderBy the order by
 * @param sort the sort
 * @param search the search
 * @param state the state
 * @param authorId the author id
 * @param authorUsername the author username
 * @param labels the labels
 * @param withLabelsDetails the with labels details
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param updatedAfter the updated after
 * @param updatedBefore the updated before
 * @param includeAncestorGroups the include ancestor groups
 * @param includeDescendantGroups the include descendant groups
 * @param myReactionEmoji the my reaction emoji
 * @param confidential the confidential
 * @param notLabels the not labels
 * @param notAuthorId the not author id
 * @param notAuthorUsername the not author username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4GroupsIdDashEpics/parameters")
public record GitLabGroupEpicsListDashedFilter(
        @Nullable GitLabGroupEpicsListDashedOrderBy orderBy,
        @Nullable GitLabGroupEpicsListDashedSort sort,
        @Nullable String search,
        @Nullable GitLabGroupEpicsListDashedState state,
        @Nullable Long authorId,
        @Nullable String authorUsername,
        @Nullable List<String> labels,
        @Nullable Boolean withLabelsDetails,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable Instant updatedAfter,
        @Nullable Instant updatedBefore,
        @Nullable Boolean includeAncestorGroups,
        @Nullable Boolean includeDescendantGroups,
        @Nullable String myReactionEmoji,
        @Nullable Boolean confidential,
        @Nullable @JsonProperty("not[labels]") List<String> notLabels,
        @Nullable @JsonProperty("not[author_id]") Integer notAuthorId,
        @Nullable @JsonProperty("not[author_username]") String notAuthorUsername) {
    public GitLabGroupEpicsListDashedFilter {
        if (labels != null) {
            labels = List.copyOf(labels);
        }
        if (notLabels != null) {
            notLabels = List.copyOf(notLabels);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabGroupEpicsListDashedFilter empty() {
        return GitLabGroupEpicsListDashedFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .wire("order_by", orderBy, GitLabGroupEpicsListDashedOrderBy::wireValue)
                .wire("sort", sort, GitLabGroupEpicsListDashedSort::wireValue)
                .text("search", search)
                .wire("state", state, GitLabGroupEpicsListDashedState::wireValue)
                .value("author_id", authorId)
                .text("author_username", authorUsername)
                .list("labels", labels)
                .value("with_labels_details", withLabelsDetails)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .value("updated_after", updatedAfter)
                .value("updated_before", updatedBefore)
                .value("include_ancestor_groups", includeAncestorGroups)
                .value("include_descendant_groups", includeDescendantGroups)
                .text("my_reaction_emoji", myReactionEmoji)
                .value("confidential", confidential)
                .list("not[labels]", notLabels)
                .value("not[author_id]", notAuthorId)
                .text("not[author_username]", notAuthorUsername)
                .build();
    }
}
