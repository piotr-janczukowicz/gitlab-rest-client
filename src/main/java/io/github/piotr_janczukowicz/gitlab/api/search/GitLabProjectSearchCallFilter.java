package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4ProjectsIdDashSearch}, without paging.
 *
 * @param ref the ref
 * @param state the state
 * @param confidential the confidential
 * @param type the type
 * @param fields the fields
 * @param numContextLines the num context lines
 * @param regex the regex
 * @param sourceBranch the source branch
 * @param targetBranch the target branch
 * @param authorUsername the author username
 * @param labelName the label name
 * @param notSourceBranch the not source branch
 * @param notTargetBranch the not target branch
 * @param notAuthorUsername the not author username
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4ProjectsIdDashSearch/parameters")
public record GitLabProjectSearchCallFilter(
        @Nullable String ref,
        @Nullable GitLabProjectSearchCallState state,
        @Nullable Boolean confidential,
        @Nullable List<String> type,
        @Nullable List<GitLabProjectSearchCallFields> fields,
        @Nullable Integer numContextLines,
        @Nullable Boolean regex,
        @Nullable String sourceBranch,
        @Nullable String targetBranch,
        @Nullable String authorUsername,
        @Nullable List<String> labelName,
        @Nullable @JsonProperty("not[source_branch]") String notSourceBranch,
        @Nullable @JsonProperty("not[target_branch]") String notTargetBranch,
        @Nullable @JsonProperty("not[author_username]") String notAuthorUsername) {
    public GitLabProjectSearchCallFilter {
        if (type != null) {
            type = List.copyOf(type);
        }
        if (fields != null) {
            fields = List.copyOf(fields);
        }
        requireBetweenIfPresent(numContextLines, 0, 20, "numContextLines");
        if (labelName != null) {
            labelName = List.copyOf(labelName);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabProjectSearchCallFilter empty() {
        return GitLabProjectSearchCallFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("ref", ref)
                .wire("state", state, GitLabProjectSearchCallState::wireValue)
                .value("confidential", confidential)
                .list("type", type)
                .wireList("fields", fields, GitLabProjectSearchCallFields::wireValue)
                .value("num_context_lines", numContextLines)
                .value("regex", regex)
                .text("source_branch", sourceBranch)
                .text("target_branch", targetBranch)
                .text("author_username", authorUsername)
                .list("label_name", labelName)
                .text("not[source_branch]", notSourceBranch)
                .text("not[target_branch]", notTargetBranch)
                .text("not[author_username]", notAuthorUsername)
                .build();
    }
}
