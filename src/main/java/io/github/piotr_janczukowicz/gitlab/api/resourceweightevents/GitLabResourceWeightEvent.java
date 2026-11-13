package io.github.piotr_janczukowicz.gitlab.api.resourceweightevents;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab resource weight event.
 *
 * @param id the id
 * @param user the user
 * @param createdAt the created at
 * @param issueId the issue id
 * @param weight the weight
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesResourceWeightEvent")
public record GitLabResourceWeightEvent(
        @Nullable Long id,
        @Nullable GitLabUserBasic user,
        @Nullable Instant createdAt,
        @Nullable Long issueId,
        @Nullable Integer weight) {}
