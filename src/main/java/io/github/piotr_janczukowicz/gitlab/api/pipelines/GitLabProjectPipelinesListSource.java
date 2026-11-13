package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project pipelines list source. */
@CatalogSchema("operations/getApiV4Pipelines/parameters/source/schema")
public enum GitLabProjectPipelinesListSource {
    UNKNOWN("unknown"),
    PUSH("push"),
    WEB("web"),
    TRIGGER("trigger"),
    SCHEDULE("schedule"),
    API("api"),
    EXTERNAL("external"),
    PIPELINE("pipeline"),
    CHAT("chat"),
    WEBIDE("webide"),
    MERGE_REQUEST_EVENT("merge_request_event"),
    EXTERNAL_PULL_REQUEST_EVENT("external_pull_request_event"),
    PARENT_PIPELINE("parent_pipeline"),
    ONDEMAND_DAST_SCAN("ondemand_dast_scan"),
    ONDEMAND_DAST_VALIDATION("ondemand_dast_validation"),
    SECURITY_ORCHESTRATION_POLICY("security_orchestration_policy"),
    CONTAINER_REGISTRY_PUSH("container_registry_push"),
    DUO_WORKFLOW("duo_workflow"),
    PIPELINE_EXECUTION_POLICY_SCHEDULE("pipeline_execution_policy_schedule"),
    DEPENDENCY_MANAGEMENT_SECURITY_UPDATE("dependency_management_security_update");

    private static final EnumUtils.WireIndex<GitLabProjectPipelinesListSource> WIRE_INDEX =
            EnumUtils.index(GitLabProjectPipelinesListSource.class, GitLabProjectPipelinesListSource::wireValue);

    private final String wireValue;

    GitLabProjectPipelinesListSource(final String wireValue) {
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
    public static GitLabProjectPipelinesListSource fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
