package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLabelBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab epic boards list.
 *
 * @param id the id
 * @param label the label
 * @param position the position
 * @param listType the list type
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEpicBoardsList")
public record GitLabEpicBoardsList(
        @Nullable Long id,
        @Nullable GitLabLabelBasic label,
        @Nullable Integer position,
        @Nullable String listType) {}
