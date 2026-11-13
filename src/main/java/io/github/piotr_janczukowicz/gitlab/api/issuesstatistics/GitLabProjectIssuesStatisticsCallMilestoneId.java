package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project issues statistics call milestone id. */
@CatalogSchema("operations/getApiV4ProjectsIdIssuesStatistics/parameters/milestone_id/schema")
public enum GitLabProjectIssuesStatisticsCallMilestoneId {
    ANY("Any"),
    NONE("None"),
    UPCOMING("Upcoming"),
    STARTED("Started");

    private static final EnumUtils.WireIndex<GitLabProjectIssuesStatisticsCallMilestoneId> WIRE_INDEX = EnumUtils.index(
            GitLabProjectIssuesStatisticsCallMilestoneId.class,
            GitLabProjectIssuesStatisticsCallMilestoneId::wireValue);

    private final String wireValue;

    GitLabProjectIssuesStatisticsCallMilestoneId(final String wireValue) {
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
    public static GitLabProjectIssuesStatisticsCallMilestoneId fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
