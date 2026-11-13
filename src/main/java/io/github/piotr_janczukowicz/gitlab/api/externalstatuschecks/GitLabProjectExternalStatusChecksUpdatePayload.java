package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ProjectsIdExternalStatusChecksCheckId}.
 *
 * @param name the name
 * @param sharedSecret the shared secret
 * @param externalUrl the external url
 * @param protectedBranchIds the protected branch ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdExternalStatusChecksCheckId/requestBody")
public record GitLabProjectExternalStatusChecksUpdatePayload(
        @Nullable String name,
        @Nullable String sharedSecret,
        @Nullable String externalUrl,
        @Nullable List<Long> protectedBranchIds) {
    public GitLabProjectExternalStatusChecksUpdatePayload {
        if (protectedBranchIds != null) {
            protectedBranchIds = List.copyOf(protectedBranchIds);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code sharedSecret} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectExternalStatusChecksUpdatePayload[" + "name=" + name + ", sharedSecret=<redacted>"
                + ", externalUrl=" + externalUrl + ", protectedBranchIds=" + protectedBranchIds + "]";
    }
}
