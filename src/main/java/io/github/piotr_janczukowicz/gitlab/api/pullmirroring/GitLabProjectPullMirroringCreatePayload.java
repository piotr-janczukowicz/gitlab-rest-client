package io.github.piotr_janczukowicz.gitlab.api.pullmirroring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMirrorPull}.
 *
 * @param action the action
 * @param pullRequestNumber the pull request number
 * @param pullRequestHeadRef the pull request head ref
 * @param pullRequestHeadSha the pull request head sha
 * @param pullRequestHeadRepoFullName the pull request head repo full name
 * @param pullRequestBaseRef the pull request base ref
 * @param pullRequestBaseSha the pull request base sha
 * @param pullRequestBaseRepoFullName the pull request base repo full name
 * @param force the force
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMirrorPull/requestBody")
public record GitLabProjectPullMirroringCreatePayload(
        @Nullable String action,
        @Nullable @JsonProperty("pull_request.number") Integer pullRequestNumber,
        @Nullable @JsonProperty("pull_request.head.ref") String pullRequestHeadRef,
        @Nullable @JsonProperty("pull_request.head.sha") String pullRequestHeadSha,

        @Nullable @JsonProperty("pull_request.head.repo.full_name")
        String pullRequestHeadRepoFullName,

        @Nullable @JsonProperty("pull_request.base.ref") String pullRequestBaseRef,
        @Nullable @JsonProperty("pull_request.base.sha") String pullRequestBaseSha,

        @Nullable @JsonProperty("pull_request.base.repo.full_name")
        String pullRequestBaseRepoFullName,

        @Nullable Boolean force) {}
