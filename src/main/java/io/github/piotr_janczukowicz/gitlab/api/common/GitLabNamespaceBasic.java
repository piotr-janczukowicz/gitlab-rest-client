package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab namespace basic.
 *
 * @param id the id
 * @param name the name
 * @param path the path
 * @param kind the kind
 * @param fullPath the full path
 * @param parentId the parent id
 * @param avatarUrl the avatar url
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesNamespaceBasic")
public record GitLabNamespaceBasic(
        @Nullable Long id,
        @Nullable String name,
        @Nullable String path,
        @Nullable String kind,
        @Nullable String fullPath,
        @Nullable Long parentId,
        @Nullable String avatarUrl,
        @Nullable String webUrl) {}
