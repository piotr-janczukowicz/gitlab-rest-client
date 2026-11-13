package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * The git lab duo agent platform flows create workflows audit event event of a GitLab resource.
 *
 * @param id the id
 * @param type the type
 * @param source the source
 * @param time the time
 * @param data the data
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflowsIdAuditEvents/requestBody/properties/events/items")
public record GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent(
        @Nullable String id,
        @Nullable String type,
        @Nullable String source,
        @Nullable Instant time,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> data) {
    public GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent {
        if (data != null) {
            data = Map.copyOf(data);
        }
    }
}
