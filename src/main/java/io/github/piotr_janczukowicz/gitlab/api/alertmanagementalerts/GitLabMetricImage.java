package io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab metric image.
 *
 * @param id the id
 * @param createdAt the created at
 * @param filename the filename
 * @param filePath the file path
 * @param url the url
 * @param urlText the url text
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMetricImage")
public record GitLabMetricImage(
        @Nullable Long id,
        @Nullable Instant createdAt,
        @Nullable String filename,
        @Nullable String filePath,
        @Nullable String url,
        @Nullable String urlText) {}
