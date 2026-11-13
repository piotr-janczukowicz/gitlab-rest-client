package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4AdminDataManagementModelNameChecksum}.
 *
 * @param identifiers the identifiers
 * @param checksumState the checksum state
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4AdminDataManagementModelNameChecksum/requestBody")
public record GitLabDataManagementChecksumPayload(
        @Nullable List<String> identifiers, @Nullable GitLabDataManagementChecksumState checksumState) {
    public GitLabDataManagementChecksumPayload {
        if (identifiers != null) {
            identifiers = List.copyOf(identifiers);
        }
    }
}
