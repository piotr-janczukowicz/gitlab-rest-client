package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab integration.
 *
 * @param id the id
 * @param title the title
 * @param slug the slug
 * @param createdAt the created at
 * @param updatedAt the updated at
 * @param active the active
 * @param commitEvents the commit events
 * @param pushEvents the push events
 * @param issuesEvents the issues events
 * @param incidentEvents the incident events
 * @param alertEvents the alert events
 * @param confidentialIssuesEvents the confidential issues events
 * @param mergeRequestsEvents the merge requests events
 * @param tagPushEvents the tag push events
 * @param deploymentEvents the deployment events
 * @param noteEvents the note events
 * @param confidentialNoteEvents the confidential note events
 * @param pipelineEvents the pipeline events
 * @param wikiPageEvents the wiki page events
 * @param jobEvents the job events
 * @param commentOnEventEnabled the comment on event enabled
 * @param inherited the inherited
 * @param vulnerabilityEvents the vulnerability events
 * @param properties the properties
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIntegration")
public record GitLabIntegration(
        @Nullable Long id,
        @Nullable String title,
        @Nullable String slug,
        @Nullable Instant createdAt,
        @Nullable Instant updatedAt,
        @Nullable Boolean active,
        @Nullable Boolean commitEvents,
        @Nullable Boolean pushEvents,
        @Nullable Boolean issuesEvents,
        @Nullable Boolean incidentEvents,
        @Nullable Boolean alertEvents,
        @Nullable Boolean confidentialIssuesEvents,
        @Nullable Boolean mergeRequestsEvents,
        @Nullable Boolean tagPushEvents,
        @Nullable Boolean deploymentEvents,
        @Nullable Boolean noteEvents,
        @Nullable Boolean confidentialNoteEvents,
        @Nullable Boolean pipelineEvents,
        @Nullable Boolean wikiPageEvents,
        @Nullable Boolean jobEvents,
        @Nullable Boolean commentOnEventEnabled,
        @Nullable Boolean inherited,
        @Nullable Boolean vulnerabilityEvents,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> properties) {}
