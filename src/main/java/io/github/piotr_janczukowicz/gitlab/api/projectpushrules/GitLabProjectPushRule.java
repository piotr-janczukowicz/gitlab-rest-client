package io.github.piotr_janczukowicz.gitlab.api.projectpushrules;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project push rule.
 *
 * @param id the id
 * @param projectId the project id
 * @param createdAt the created at
 * @param commitMessageRegex the commit message regex
 * @param commitMessageNegativeRegex the commit message negative regex
 * @param branchNameRegex the branch name regex
 * @param denyDeleteTag the deny delete tag
 * @param memberCheck the member check
 * @param preventSecrets the prevent secrets
 * @param authorEmailRegex the author email regex
 * @param fileNameRegex the file name regex
 * @param maxFileSize the max file size
 * @param commitCommitterCheck the commit committer check
 * @param commitCommitterNameCheck the commit committer name check
 * @param rejectUnsignedCommits the reject unsigned commits
 * @param rejectNonDcoCommits the reject non dco commits
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectPushRule")
public record GitLabProjectPushRule(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable Instant createdAt,
        @Nullable String commitMessageRegex,
        @Nullable String commitMessageNegativeRegex,
        @Nullable String branchNameRegex,
        @Nullable Boolean denyDeleteTag,
        @Nullable Boolean memberCheck,
        @Nullable Boolean preventSecrets,
        @Nullable String authorEmailRegex,
        @Nullable String fileNameRegex,
        @Nullable Long maxFileSize,
        @Nullable Boolean commitCommitterCheck,
        @Nullable Boolean commitCommitterNameCheck,
        @Nullable Boolean rejectUnsignedCommits,
        @Nullable Boolean rejectNonDcoCommits) {}
