package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab approval rule short.
 *
 * @param id the id
 * @param name the name
 * @param ruleType the rule type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApprovalRuleShort")
public record GitLabApprovalRuleShort(
        @Nullable Long id, @Nullable String name, @Nullable String ruleType) {}
