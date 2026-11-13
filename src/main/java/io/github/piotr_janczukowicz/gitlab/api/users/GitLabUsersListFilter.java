package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Optional query parameters of the operation {@code getApiV4Users}, without paging.
 *
 * @param username the username
 * @param externUid the extern uid
 * @param publicEmail the public email
 * @param provider the provider
 * @param search the search
 * @param active the active
 * @param humans the humans
 * @param external the external
 * @param blocked the blocked
 * @param createdAfter the created after
 * @param createdBefore the created before
 * @param withoutProjects the without projects
 * @param withoutProjectBots the without project bots
 * @param admins the admins
 * @param twoFactor the two factor
 * @param excludeActive the exclude active
 * @param excludeExternal the exclude external
 * @param excludeHumans the exclude humans
 * @param excludeInternal the exclude internal
 * @param withCustomAttributes the with custom attributes
 * @param customAttributes the custom attributes
 * @param skipLdap the skip ldap
 * @param auditors the auditors
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/getApiV4Users/parameters")
public record GitLabUsersListFilter(
        @Nullable String username,
        @Nullable String externUid,
        @Nullable String publicEmail,
        @Nullable String provider,
        @Nullable String search,
        @Nullable Boolean active,
        @Nullable Boolean humans,
        @Nullable Boolean external,
        @Nullable Boolean blocked,
        @Nullable Instant createdAfter,
        @Nullable Instant createdBefore,
        @Nullable Boolean withoutProjects,
        @Nullable Boolean withoutProjectBots,
        @Nullable Boolean admins,
        @Nullable String twoFactor,
        @Nullable Boolean excludeActive,
        @Nullable Boolean excludeExternal,
        @Nullable Boolean excludeHumans,
        @Nullable Boolean excludeInternal,
        @Nullable Boolean withCustomAttributes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> customAttributes,

        @Nullable Boolean skipLdap,
        @Nullable Boolean auditors) {
    public GitLabUsersListFilter {
        if (customAttributes != null) {
            customAttributes = Map.copyOf(customAttributes);
        }
    }

    /**
     * A filter with no parameter set.
     *
     * @return the empty filter
     */
    public static GitLabUsersListFilter empty() {
        return GitLabUsersListFilterBuilder.builder().build();
    }

    /**
     * The query parameters that are set, in declaration order.
     *
     * @return an unmodifiable map
     */
    public Map<String, String> toQueryParameters() {
        return GitLabQueryParameters.builder()
                .text("username", username)
                .text("extern_uid", externUid)
                .text("public_email", publicEmail)
                .text("provider", provider)
                .text("search", search)
                .value("active", active)
                .value("humans", humans)
                .value("external", external)
                .value("blocked", blocked)
                .value("created_after", createdAfter)
                .value("created_before", createdBefore)
                .value("without_projects", withoutProjects)
                .value("without_project_bots", withoutProjectBots)
                .value("admins", admins)
                .text("two_factor", twoFactor)
                .value("exclude_active", excludeActive)
                .value("exclude_external", excludeExternal)
                .value("exclude_humans", excludeHumans)
                .value("exclude_internal", excludeInternal)
                .value("with_custom_attributes", withCustomAttributes)
                .map("custom_attributes", customAttributes)
                .value("skip_ldap", skipLdap)
                .value("auditors", auditors)
                .build();
    }
}
