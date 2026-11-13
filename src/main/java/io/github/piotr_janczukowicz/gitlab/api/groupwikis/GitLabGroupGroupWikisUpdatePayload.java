package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdWikisSlug}.
 *
 * @param title the title
 * @param frontMatter the front matter
 * @param content the content
 * @param format the format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdWikisSlug/requestBody")
public record GitLabGroupGroupWikisUpdatePayload(
        @Nullable String title,
        @Nullable GitLabGroupGroupWikisUpdateFrontMatter frontMatter,
        @Nullable String content,
        @Nullable GitLabGroupGroupWikisUpdateFormat format) {}
