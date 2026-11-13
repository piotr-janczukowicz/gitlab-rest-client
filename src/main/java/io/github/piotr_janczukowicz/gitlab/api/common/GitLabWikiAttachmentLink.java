package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab wiki attachment link of a GitLab resource.
 *
 * @param url the url
 * @param markdown the markdown
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesWikiAttachment/properties/link")
public record GitLabWikiAttachmentLink(
        @Nullable String url, @Nullable String markdown) {}
