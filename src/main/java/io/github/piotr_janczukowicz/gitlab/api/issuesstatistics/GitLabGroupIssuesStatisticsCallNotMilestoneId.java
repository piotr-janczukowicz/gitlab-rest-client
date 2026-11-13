package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group issues statistics call not milestone id. */
@CatalogSchema("operations/getApiV4GroupsIdIssuesStatistics/parameters/not[milestone_id]/schema")
public enum GitLabGroupIssuesStatisticsCallNotMilestoneId {
    ANY("Any"),
    NONE("None"),
    UPCOMING("Upcoming"),
    STARTED("Started");

    private static final EnumUtils.WireIndex<GitLabGroupIssuesStatisticsCallNotMilestoneId> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupIssuesStatisticsCallNotMilestoneId.class,
                    GitLabGroupIssuesStatisticsCallNotMilestoneId::wireValue);

    private final String wireValue;

    GitLabGroupIssuesStatisticsCallNotMilestoneId(final String wireValue) {
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
    public static GitLabGroupIssuesStatisticsCallNotMilestoneId fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
