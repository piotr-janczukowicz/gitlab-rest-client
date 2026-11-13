package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab wiki attachment.
 *
 * @param fileName the file name
 * @param filePath the file path
 * @param branch the branch
 * @param link the link
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesWikiAttachment")
public record GitLabWikiAttachment(
        @Nullable String fileName,
        @Nullable String filePath,
        @Nullable String branch,
        @Nullable GitLabWikiAttachmentLink link) {}
