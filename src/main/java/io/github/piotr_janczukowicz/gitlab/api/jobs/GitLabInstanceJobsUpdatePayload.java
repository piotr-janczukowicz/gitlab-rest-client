package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4JobsId}.
 *
 * @param token the token
 * @param state the state
 * @param checksum the checksum
 * @param failureReason the failure reason
 * @param output the output
 * @param exitCode the exit code
 * @param runtimeEnvironmentKey the runtime environment key
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4JobsId/requestBody")
public record GitLabInstanceJobsUpdatePayload(
        @Nullable String token,
        @Nullable String state,
        @Nullable String checksum,
        @Nullable String failureReason,
        @Nullable GitLabInstanceJobsUpdateOutput output,
        @Nullable Integer exitCode,
        @Nullable String runtimeEnvironmentKey) {
    public GitLabInstanceJobsUpdatePayload {
        requireMaxLengthIfPresent(runtimeEnvironmentKey, 512, "runtimeEnvironmentKey");
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabInstanceJobsUpdatePayload[" + "token=<redacted>" + ", state=" + state + ", checksum=" + checksum
                + ", failureReason=" + failureReason + ", output=" + output + ", exitCode=" + exitCode
                + ", runtimeEnvironmentKey=" + runtimeEnvironmentKey + "]";
    }
}
