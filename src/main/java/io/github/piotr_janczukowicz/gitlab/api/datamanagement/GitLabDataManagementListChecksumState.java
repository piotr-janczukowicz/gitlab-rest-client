package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab data management list checksum state. */
@CatalogSchema("operations/getApiV4AdminDataManagementModelName/parameters/checksum_state/schema")
public enum GitLabDataManagementListChecksumState {
    PENDING("pending"),
    STARTED("started"),
    SUCCEEDED("succeeded"),
    FAILED("failed"),
    DISABLED("disabled");

    private static final EnumUtils.WireIndex<GitLabDataManagementListChecksumState> WIRE_INDEX = EnumUtils.index(
            GitLabDataManagementListChecksumState.class, GitLabDataManagementListChecksumState::wireValue);

    private final String wireValue;

    GitLabDataManagementListChecksumState(final String wireValue) {
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
    public static GitLabDataManagementListChecksumState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
