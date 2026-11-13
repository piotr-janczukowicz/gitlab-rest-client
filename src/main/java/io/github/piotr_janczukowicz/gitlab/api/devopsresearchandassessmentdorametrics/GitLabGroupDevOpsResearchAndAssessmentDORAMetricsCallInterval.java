package io.github.piotr_janczukowicz.gitlab.api.devopsresearchandassessmentdorametrics;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group dev ops research and assessment dorametrics call interval. */
@CatalogSchema("operations/getApiV4GroupsIdDoraMetrics/parameters/interval/schema")
public enum GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval {
    ALL("all"),
    MONTHLY("monthly"),
    DAILY("daily");

    private static final EnumUtils.WireIndex<GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval> WIRE_INDEX =
            EnumUtils.index(
                    GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval.class,
                    GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval::wireValue);

    private final String wireValue;

    GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval(final String wireValue) {
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
    public static GitLabGroupDevOpsResearchAndAssessmentDORAMetricsCallInterval fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
