package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab group and project migration by direct transfer create configuration of a GitLab resource.
 *
 * @param url the url
 * @param accessToken the access token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4BulkImports/requestBody/properties/configuration")
public record GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration(
        @Nullable String url, @Nullable String accessToken) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code accessToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration[" + "url=" + url
                + ", accessToken=<redacted>" + "]";
    }
}
