package io.github.piotr_janczukowicz.gitlab.api.vulnerabilities;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetween;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4VulnerabilitiesVulnerabilityIdFlagsAiDetection}.
 *
 * @param confidenceScore the confidence score
 * @param description the description
 * @param origin the origin
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4VulnerabilitiesVulnerabilityIdFlagsAiDetection/requestBody")
public record GitLabProjectVulnerabilitiesAiDetectionFlagPayload(
        int confidenceScore,
        @Nullable String description,
        @Nullable String origin) {
    public GitLabProjectVulnerabilitiesAiDetectionFlagPayload {
        requireBetween(confidenceScore, 0, 100, "confidenceScore");
    }
}
