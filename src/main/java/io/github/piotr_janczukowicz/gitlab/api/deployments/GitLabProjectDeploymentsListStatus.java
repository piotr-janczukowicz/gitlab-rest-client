package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project deployments list status. */
@CatalogSchema("operations/getApiV4ProjectsIdDeployments/parameters/status/schema")
public enum GitLabProjectDeploymentsListStatus {
    CREATED("created"),
    RUNNING("running"),
    SUCCESS("success"),
    FAILED("failed"),
    CANCELED("canceled"),
    SKIPPED("skipped"),
    BLOCKED("blocked");

    private static final EnumUtils.WireIndex<GitLabProjectDeploymentsListStatus> WIRE_INDEX =
            EnumUtils.index(GitLabProjectDeploymentsListStatus.class, GitLabProjectDeploymentsListStatus::wireValue);

    private final String wireValue;

    GitLabProjectDeploymentsListStatus(final String wireValue) {
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
    public static GitLabProjectDeploymentsListStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
