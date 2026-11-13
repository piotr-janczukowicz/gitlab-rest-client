package io.github.piotr_janczukowicz.gitlab.api.agents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cluster agent token basic.
 *
 * @param id the id
 * @param name the name
 * @param description the description
 * @param agentId the agent id
 * @param status the status
 * @param createdAt the created at
 * @param createdByUserId the created by user id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesClustersAgentTokenBasic")
public record GitLabClusterAgentTokenBasic(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String description,
        @Nullable Long agentId,
        @Nullable String status,
        @Nullable Instant createdAt,
        @Nullable Long createdByUserId) {}
