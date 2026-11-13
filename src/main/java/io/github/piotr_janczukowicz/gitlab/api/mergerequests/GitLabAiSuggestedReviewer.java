package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ai suggested reviewer.
 *
 * @param user the user
 * @param reason the reason
 * @param approvalRule the approval rule
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAiSuggestedReviewer")
public record GitLabAiSuggestedReviewer(
        @Nullable GitLabUserBasic user,
        @Nullable String reason,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> approvalRule,

        @Nullable Instant createdAt) {}
