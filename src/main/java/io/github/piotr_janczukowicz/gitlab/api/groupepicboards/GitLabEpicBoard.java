package io.github.piotr_janczukowicz.gitlab.api.groupepicboards;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabBasicGroupDetails;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLabelBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab epic board.
 *
 * @param id the id
 * @param name the name
 * @param hideBacklogList the hide backlog list
 * @param hideClosedList the hide closed list
 * @param group the group
 * @param labels the labels
 * @param lists the lists
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesEpicBoard")
public record GitLabEpicBoard(
        @Nullable Long id,
        @Nullable String name,
        @Nullable Boolean hideBacklogList,
        @Nullable Boolean hideClosedList,
        @Nullable GitLabBasicGroupDetails group,
        @Nullable List<GitLabLabelBasic> labels,
        @Nullable List<GitLabEpicBoardsList> lists) {}
