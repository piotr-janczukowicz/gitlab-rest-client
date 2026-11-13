package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab wiki page.
 *
 * @param format the format
 * @param slug the slug
 * @param title the title
 * @param wikiPageMetaId the wiki page meta id
 * @param content the content
 * @param encoding the encoding
 * @param frontMatter the front matter
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesWikiPage")
public record GitLabWikiPage(
        @Nullable String format,
        @Nullable String slug,
        @Nullable String title,
        @Nullable Long wikiPageMetaId,
        @Nullable String content,
        @Nullable String encoding,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> frontMatter) {}
