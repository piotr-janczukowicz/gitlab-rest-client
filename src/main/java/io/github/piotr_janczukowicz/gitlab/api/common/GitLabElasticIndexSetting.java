package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab elastic index setting.
 *
 * @param aliasName the alias name
 * @param numberOfShards the number of shards
 * @param numberOfReplicas the number of replicas
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesElasticIndexSetting")
public record GitLabElasticIndexSetting(
        @Nullable String aliasName,
        @Nullable Integer numberOfShards,
        @Nullable Integer numberOfReplicas) {}
