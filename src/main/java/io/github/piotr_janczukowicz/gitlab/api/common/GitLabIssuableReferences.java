package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab issuable references.
 *
 * @param shortValue the short
 * @param relative the relative
 * @param full the full
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesIssuableReferences")
public record GitLabIssuableReferences(
        @Nullable @JsonProperty("short") String shortValue,
        @Nullable String relative,
        @Nullable String full) {}
