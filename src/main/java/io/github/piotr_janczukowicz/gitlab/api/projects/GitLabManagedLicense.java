package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab managed license.
 *
 * @param id the id
 * @param name the name
 * @param approvalStatus the approval status
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesManagedLicense")
public record GitLabManagedLicense(
        @Nullable Long id, @Nullable String name, @Nullable String approvalStatus) {}
