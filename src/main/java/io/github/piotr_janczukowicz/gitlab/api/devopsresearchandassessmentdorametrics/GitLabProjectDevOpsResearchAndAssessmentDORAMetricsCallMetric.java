package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project dev ops research and assessment dorametrics call metric. */
@CatalogSchema("operations/getApiV4ProjectsIdDoraMetrics/parameters/metric/schema")
public enum GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric {
    DEPLOYMENT_FREQUENCY("deployment_frequency"),
    LEAD_TIME_FOR_CHANGES("lead_time_for_changes"),
    TIME_TO_RESTORE_SERVICE("time_to_restore_service"),
    CHANGE_FAILURE_RATE("change_failure_rate");

    private static final EnumUtils.WireIndex<GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric.class,
                    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric::wireValue);

    private final String wireValue;

    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric(final String wireValue) {
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
    public static GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallMetric fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
