package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project merge requests create status check response status. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidStatusCheckResponses/requestBody/properties/status")
public enum GitLabProjectMergeRequestsCreateStatusCheckResponseStatus {
    PASSED("passed"),
    FAILED("failed"),
    PENDING("pending");

    private static final EnumUtils.WireIndex<GitLabProjectMergeRequestsCreateStatusCheckResponseStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.class,
                    GitLabProjectMergeRequestsCreateStatusCheckResponseStatus::wireValue);

    private final String wireValue;

    GitLabProjectMergeRequestsCreateStatusCheckResponseStatus(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabProjectMergeRequestsCreateStatusCheckResponseStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
