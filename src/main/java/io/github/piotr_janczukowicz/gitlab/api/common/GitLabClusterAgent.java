package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab cluster agent.
 *
 * @param id the id
 * @param name the name
 * @param configProject the config project
 * @param createdAt the created at
 * @param createdByUserId the created by user id
 * @param isReceptive the is receptive
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesClustersAgent")
public record GitLabClusterAgent(
        @Nullable Long id,
        @Nullable String name,
        @Nullable GitLabProjectIdentity configProject,
        @Nullable Instant createdAt,
        @Nullable Long createdByUserId,
        @Nullable Boolean isReceptive) {}
