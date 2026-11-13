package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab wiki page basic.
 *
 * @param format the format
 * @param slug the slug
 * @param title the title
 * @param wikiPageMetaId the wiki page meta id
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesWikiPageBasic")
public record GitLabWikiPageBasic(
        @Nullable String format,
        @Nullable String slug,
        @Nullable String title,
        @Nullable Long wikiPageMetaId) {}
