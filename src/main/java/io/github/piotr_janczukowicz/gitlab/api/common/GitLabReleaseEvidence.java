package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab release evidence.
 *
 * @param sha the sha
 * @param filepath the filepath
 * @param collectedAt the collected at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesReleasesEvidence")
public record GitLabReleaseEvidence(
        @Nullable String sha,
        @Nullable String filepath,
        @Nullable Instant collectedAt) {}
