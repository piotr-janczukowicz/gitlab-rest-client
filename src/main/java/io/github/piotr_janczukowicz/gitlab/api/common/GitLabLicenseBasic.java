package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab license basic.
 *
 * @param key the key
 * @param name the name
 * @param nickname the nickname
 * @param htmlUrl the html url
 * @param sourceUrl the source url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesLicenseBasic")
public record GitLabLicenseBasic(
        @Nullable String key,
        @Nullable String name,
        @Nullable String nickname,
        @Nullable String htmlUrl,
        @Nullable String sourceUrl) {}
