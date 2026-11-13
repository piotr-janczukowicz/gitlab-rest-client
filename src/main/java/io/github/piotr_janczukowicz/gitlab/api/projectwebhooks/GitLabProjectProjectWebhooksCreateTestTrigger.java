package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project project webhooks create test trigger. */
@CatalogSchema("operations/postApiV4ProjectsIdHooksHookIdTestTrigger/parameters/trigger/schema")
public enum GitLabProjectProjectWebhooksCreateTestTrigger {
    CONFIDENTIAL_ISSUES_EVENTS("confidential_issues_events"),
    CONFIDENTIAL_NOTE_EVENTS("confidential_note_events"),
    DEPLOYMENT_EVENTS("deployment_events"),
    EMOJI_EVENTS("emoji_events"),
    FEATURE_FLAG_EVENTS("feature_flag_events"),
    ISSUES_EVENTS("issues_events"),
    JOB_EVENTS("job_events"),
    MERGE_REQUESTS_EVENTS("merge_requests_events"),
    MILESTONE_EVENTS("milestone_events"),
    NOTE_EVENTS("note_events"),
    PIPELINE_EVENTS("pipeline_events"),
    PUSH_EVENTS("push_events"),
    RELEASES_EVENTS("releases_events"),
    RESOURCE_ACCESS_TOKEN_EVENTS("resource_access_token_events"),
    RESOURCE_DEPLOY_TOKEN_EVENTS("resource_deploy_token_events"),
    TAG_PUSH_EVENTS("tag_push_events"),
    WIKI_PAGE_EVENTS("wiki_page_events"),
    VULNERABILITY_EVENTS("vulnerability_events");

    private static final EnumUtils.WireIndex<GitLabProjectProjectWebhooksCreateTestTrigger> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectWebhooksCreateTestTrigger.class,
                    GitLabProjectProjectWebhooksCreateTestTrigger::wireValue);

    private final String wireValue;

    GitLabProjectProjectWebhooksCreateTestTrigger(final String wireValue) {
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
    public static GitLabProjectProjectWebhooksCreateTestTrigger fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
