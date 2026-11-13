package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance issues call issues statistics health status. */
@CatalogSchema("operations/getApiV4IssuesStatistics/parameters/health_status/schema")
public enum GitLabInstanceIssuesCallIssuesStatisticsHealthStatus {
    ON_TRACK("on_track"),
    NEEDS_ATTENTION("needs_attention"),
    AT_RISK("at_risk"),
    NONE("none"),
    ANY("any");

    private static final EnumUtils.WireIndex<GitLabInstanceIssuesCallIssuesStatisticsHealthStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabInstanceIssuesCallIssuesStatisticsHealthStatus.class,
                    GitLabInstanceIssuesCallIssuesStatisticsHealthStatus::wireValue);

    private final String wireValue;

    GitLabInstanceIssuesCallIssuesStatisticsHealthStatus(final String wireValue) {
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
    public static GitLabInstanceIssuesCallIssuesStatisticsHealthStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
