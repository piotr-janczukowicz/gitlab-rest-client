package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab board.
 *
 * @param id the id
 * @param name the name
 * @param hideBacklogList the hide backlog list
 * @param hideClosedList the hide closed list
 * @param project the project
 * @param lists the lists
 * @param group the group
 * @param milestone the milestone
 * @param assignee the assignee
 * @param labels the labels
 * @param weight the weight
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBoard")
public record GitLabBoard(
        @Nullable Long id,
        @Nullable String name,
        @Nullable Boolean hideBacklogList,
        @Nullable Boolean hideClosedList,
        @Nullable GitLabBasicProjectDetails project,
        @Nullable List<GitLabList> lists,
        @Nullable GitLabBasicGroupDetails group,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> milestone,

        @Nullable GitLabUserBasic assignee,
        @Nullable List<GitLabLabelBasic> labels,
        @Nullable Integer weight) {}
