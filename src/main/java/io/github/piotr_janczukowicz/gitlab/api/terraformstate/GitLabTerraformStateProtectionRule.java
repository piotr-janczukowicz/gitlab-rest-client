package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab terraform state protection rule.
 *
 * @param id the id
 * @param projectId the project id
 * @param stateName the state name
 * @param minimumAccessLevelForWrite the minimum access level for write
 * @param allowedFrom the allowed from
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesTerraformStateProtectionRule")
public record GitLabTerraformStateProtectionRule(
        @Nullable Long id,
        @Nullable Long projectId,
        @Nullable String stateName,
        @Nullable String minimumAccessLevelForWrite,
        @Nullable String allowedFrom) {}
