package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab duo agent platform flows create workflow source. */
@CatalogSchema("operations/postApiV4AiDuoWorkflowsWorkflows/requestBody/properties/source")
public enum GitLabDuoAgentPlatformFlowsCreateWorkflowSource {
    MERGE_REQUEST_CODE_CONFLICT("merge_request_code_conflict"),
    MERGE_REQUEST_DEPENDENCY_BUMP("merge_request_dependency_bump"),
    MERGE_REQUEST_FIX_PIPELINE("merge_request_fix_pipeline"),
    MERGE_REQUEST_RESOLVE_DISCUSSION("merge_request_resolve_discussion"),
    WORK_ITEM_TO_MERGE_REQUEST("work_item_to_merge_request"),
    FIX_PIPELINE("fix_pipeline"),
    CONVERT_PLATFORM_CI_PIPELINE("convert_platform_ci_pipeline"),
    DUO_CLI_INTERACTIVE("duo_cli_interactive"),
    DUO_CLI_RUN("duo_cli_run"),
    DUO_CLI_ACP("duo_cli_acp"),
    IDE_EXTENSION("ide_extension"),
    WORK_ITEM_PLAN_TO_MERGE_REQUEST("work_item_plan_to_merge_request"),
    WEB_CHAT("web_chat"),
    VULNERABILITY_LEAKED_TOKEN_ROTATION("vulnerability_leaked_token_rotation"),
    MOBILE_CHAT("mobile_chat");

    private static final EnumUtils.WireIndex<GitLabDuoAgentPlatformFlowsCreateWorkflowSource> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDuoAgentPlatformFlowsCreateWorkflowSource.class,
                    GitLabDuoAgentPlatformFlowsCreateWorkflowSource::wireValue);

    private final String wireValue;

    GitLabDuoAgentPlatformFlowsCreateWorkflowSource(final String wireValue) {
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
    public static GitLabDuoAgentPlatformFlowsCreateWorkflowSource fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
