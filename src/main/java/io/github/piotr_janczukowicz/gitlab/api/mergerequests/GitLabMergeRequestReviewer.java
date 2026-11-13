package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabUserBasic;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab merge request reviewer.
 *
 * @param user the user
 * @param state the state
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMergeRequestReviewer")
public record GitLabMergeRequestReviewer(
        @Nullable GitLabUserBasic user,
        @Nullable String state,
        @Nullable Instant createdAt) {}
