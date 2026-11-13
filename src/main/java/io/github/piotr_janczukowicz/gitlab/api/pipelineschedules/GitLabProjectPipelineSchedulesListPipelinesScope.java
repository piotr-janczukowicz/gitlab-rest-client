package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project pipeline schedules list pipelines scope. */
@CatalogSchema("operations/getApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdPipelines/parameters/scope/schema")
public enum GitLabProjectPipelineSchedulesListPipelinesScope {
    RUNNING("running"),
    PENDING("pending"),
    FINISHED("finished"),
    BRANCHES("branches"),
    TAGS("tags");

    private static final EnumUtils.WireIndex<GitLabProjectPipelineSchedulesListPipelinesScope> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectPipelineSchedulesListPipelinesScope.class,
                    GitLabProjectPipelineSchedulesListPipelinesScope::wireValue);

    private final String wireValue;

    GitLabProjectPipelineSchedulesListPipelinesScope(final String wireValue) {
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
    public static GitLabProjectPipelineSchedulesListPipelinesScope fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
