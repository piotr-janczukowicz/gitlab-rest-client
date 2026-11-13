package io.github.piotr_janczukowicz.gitlab.api.codereviewanalytics;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabMilestone;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab analytics code review merge request.
 *
 * @param id the id
 * @param iid the iid
 * @param projectId the project id
 * @param title the title
 * @param description the description
 * @param state the state
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param webUrl the web url
 * @param milestone the milestone
 * @param author the author
 * @param approvedBy the approved by
 * @param notesCount the notes count
 * @param reviewTime the review time
 * @param diffStats the diff stats
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAnalyticsCodeReviewMergeRequest")
public record GitLabAnalyticsCodeReviewMergeRequest(
        @Nullable Long id,
        @Nullable Long iid,
        @Nullable Long projectId,
        @Nullable String title,
        @Nullable String description,
        @Nullable String state,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable String webUrl,
        @Nullable GitLabMilestone milestone,
        @Nullable GitLabUserBasic author,
        @Nullable GitLabUserBasic approvedBy,
        @Nullable Integer notesCount,
        @Nullable Integer reviewTime,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> diffStats) {}
