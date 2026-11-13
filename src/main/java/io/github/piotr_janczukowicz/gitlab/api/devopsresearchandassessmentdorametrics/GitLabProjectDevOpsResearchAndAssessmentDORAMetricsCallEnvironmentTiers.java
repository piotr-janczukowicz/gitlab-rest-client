package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project dev ops research and assessment dorametrics call environment tiers. */
@CatalogSchema("operations/getApiV4ProjectsIdDoraMetrics/parameters/environment_tiers/schema/items")
public enum GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers {
    PRODUCTION("production"),
    STAGING("staging"),
    TESTING("testing"),
    DEVELOPMENT("development"),
    OTHER("other");

    private static final EnumUtils.WireIndex<GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers.class,
                    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers::wireValue);

    private final String wireValue;

    GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers(final String wireValue) {
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
    public static GitLabProjectDevOpsResearchAndAssessmentDORAMetricsCallEnvironmentTiers fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
