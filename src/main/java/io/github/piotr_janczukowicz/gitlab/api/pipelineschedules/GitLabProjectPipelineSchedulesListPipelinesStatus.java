package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project pipeline schedules list pipelines status. */
@CatalogSchema("operations/getApiV4ProjectsIdPipelineSchedulesPipelineScheduleIdPipelines/parameters/status/schema")
public enum GitLabProjectPipelineSchedulesListPipelinesStatus {
    CREATED("created"),
    WAITING_FOR_RESOURCE("waiting_for_resource"),
    PREPARING("preparing"),
    WAITING_FOR_CALLBACK("waiting_for_callback"),
    PENDING("pending"),
    RUNNING("running"),
    SUCCESS("success"),
    FAILED("failed"),
    CANCELING("canceling"),
    CANCELED("canceled"),
    SKIPPED("skipped"),
    MANUAL("manual"),
    SCHEDULED("scheduled");

    private static final EnumUtils.WireIndex<GitLabProjectPipelineSchedulesListPipelinesStatus> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectPipelineSchedulesListPipelinesStatus.class,
                    GitLabProjectPipelineSchedulesListPipelinesStatus::wireValue);

    private final String wireValue;

    GitLabProjectPipelineSchedulesListPipelinesStatus(final String wireValue) {
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
    public static GitLabProjectPipelineSchedulesListPipelinesStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
