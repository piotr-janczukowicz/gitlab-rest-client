package io.github.piotr_janczukowicz.gitlab.api.members;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab billable membership access level of a GitLab resource.
 *
 * @param stringValue the string value
 * @param integerValue the integer value
 * @param customRole the custom role
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBillableMembership/properties/access_level")
public record GitLabBillableMembershipAccessLevel(
        @Nullable String stringValue,
        @Nullable Integer integerValue,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customRole) {}
