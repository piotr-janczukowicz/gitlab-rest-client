package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request diff full.
 *
 * @param id the id
 * @param headCommitSha the head commit sha
 * @param baseCommitSha the base commit sha
 * @param startCommitSha the start commit sha
 * @param createdAt the created at
 * @param mergeRequestId the merge request id
 * @param state the state
 * @param realSize the real size
 * @param patchIdSha the patch id sha
 * @param commits the commits
 * @param diffs the diffs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestDiffFull")
public record GitLabMergeRequestDiffFull(
        @Nullable Long id,
        @Nullable String headCommitSha,
        @Nullable String baseCommitSha,
        @Nullable String startCommitSha,
        @Nullable Instant createdAt,
        @Nullable Long mergeRequestId,
        @Nullable String state,
        @Nullable String realSize,
        @Nullable String patchIdSha,
        @Nullable List<GitLabCommit> commits,
        @Nullable List<GitLabDiff> diffs) {}
