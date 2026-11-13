package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdWikisSlug}.
 *
 * @param title the title
 * @param frontMatter the front matter
 * @param content the content
 * @param format the format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdWikisSlug/requestBody")
public record GitLabProjectProjectWikisUpdatePayload(
        @Nullable String title,
        @Nullable GitLabProjectProjectWikisUpdateFrontMatter frontMatter,
        @Nullable String content,
        @Nullable GitLabProjectProjectWikisUpdateFormat format) {}
