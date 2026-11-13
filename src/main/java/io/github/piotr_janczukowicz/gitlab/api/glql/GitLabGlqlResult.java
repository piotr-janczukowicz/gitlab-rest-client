package io.github.piotr_janczukowicz.gitlab.api.glql;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab glql result.
 *
 * @param data the data
 * @param error the error
 * @param fields the fields
 * @param success the success
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesGlqlResult")
public record GitLabGlqlResult(
        @Nullable GitLabGlqlData data,
        @Nullable String error,
        @Nullable List<GitLabGlqlField> fields,
        @Nullable Boolean success) {}
