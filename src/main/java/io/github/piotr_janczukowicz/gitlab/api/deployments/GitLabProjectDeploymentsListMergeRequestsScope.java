package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project deployments list merge requests scope. */
@CatalogSchema("operations/getApiV4ProjectsIdDeploymentsDeploymentIdMergeRequests/parameters/scope/schema")
public enum GitLabProjectDeploymentsListMergeRequestsScope {
    CREATED_BY_ME_DASHED("created-by-me"),
    ASSIGNED_TO_ME_DASHED("assigned-to-me"),
    CREATED_BY_ME("created_by_me"),
    ASSIGNED_TO_ME("assigned_to_me"),
    REVIEWS_FOR_ME("reviews_for_me"),
    ALL("all");

    private static final EnumUtils.WireIndex<GitLabProjectDeploymentsListMergeRequestsScope> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectDeploymentsListMergeRequestsScope.class,
                    GitLabProjectDeploymentsListMergeRequestsScope::wireValue);

    private final String wireValue;

    GitLabProjectDeploymentsListMergeRequestsScope(final String wireValue) {
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
    public static GitLabProjectDeploymentsListMergeRequestsScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
