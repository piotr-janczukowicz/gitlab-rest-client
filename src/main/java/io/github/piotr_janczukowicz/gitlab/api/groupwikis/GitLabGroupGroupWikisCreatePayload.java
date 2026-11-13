package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4GroupsIdWikis}.
 *
 * @param title the title
 * @param frontMatter the front matter
 * @param content the content
 * @param format the format
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4GroupsIdWikis/requestBody")
public record GitLabGroupGroupWikisCreatePayload(
        @Nullable String title,
        @Nullable GitLabGroupGroupWikisCreateFrontMatter frontMatter,
        @Nullable String content,
        @Nullable GitLabGroupGroupWikisCreateFormat format) {}
