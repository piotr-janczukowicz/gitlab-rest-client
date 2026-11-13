package io.github.piotr_janczukowicz.gitlab.api.protectedtags;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedRefAccess;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab protected tag.
 *
 * @param name the name
 * @param createAccessLevels the create access levels
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesProtectedTag")
public record GitLabProtectedTag(
        @Nullable String name, @Nullable List<GitLabProtectedRefAccess> createAccessLevels) {}
