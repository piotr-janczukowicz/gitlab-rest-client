package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab instance runners list jobs status. */
@CatalogSchema("operations/getApiV4RunnersIdJobs/parameters/status/schema")
public enum GitLabInstanceRunnersListJobsStatus {
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

    private static final EnumUtils.WireIndex<GitLabInstanceRunnersListJobsStatus> WIRE_INDEX =
            EnumUtils.index(GitLabInstanceRunnersListJobsStatus.class, GitLabInstanceRunnersListJobsStatus::wireValue);

    private final String wireValue;

    GitLabInstanceRunnersListJobsStatus(final String wireValue) {
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
    public static GitLabInstanceRunnersListJobsStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
