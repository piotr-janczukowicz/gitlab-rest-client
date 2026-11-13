package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects create managed license approval status. */
@CatalogSchema("operations/postApiV4ProjectsIdManagedLicenses/requestBody/properties/approval_status")
public enum GitLabProjectProjectsCreateManagedLicenseApprovalStatus {
    ALLOWED("allowed"),
    DENIED("denied");

    private static final EnumUtils.WireIndex<GitLabProjectProjectsCreateManagedLicenseApprovalStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectsCreateManagedLicenseApprovalStatus.class,
                    GitLabProjectProjectsCreateManagedLicenseApprovalStatus::wireValue);

    private final String wireValue;

    GitLabProjectProjectsCreateManagedLicenseApprovalStatus(final String wireValue) {
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
    public static GitLabProjectProjectsCreateManagedLicenseApprovalStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
