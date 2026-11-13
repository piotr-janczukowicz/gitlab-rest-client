package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab project approval settings.
 *
 * @param rules the rules
 * @param fallbackApprovalsRequired the fallback approvals required
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProjectApprovalSettings")
public record GitLabProjectApprovalSettings(
        @Nullable List<GitLabProjectApprovalSettingRule> rules,
        @Nullable Integer fallbackApprovalsRequired) {}
