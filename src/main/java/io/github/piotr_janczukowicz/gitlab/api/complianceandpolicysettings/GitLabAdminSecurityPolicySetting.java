package io.github.piotr_janczukowicz.gitlab.api.complianceandpolicysettings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab admin security policy setting.
 *
 * @param cspNamespaceId the csp namespace id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAdminSecurityPolicySetting")
public record GitLabAdminSecurityPolicySetting(@Nullable Long cspNamespaceId) {}
