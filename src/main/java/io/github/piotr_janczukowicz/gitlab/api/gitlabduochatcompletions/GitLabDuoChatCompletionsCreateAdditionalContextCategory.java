package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab duo chat completions create additional context category. */
@CatalogSchema(
        "operations/postApiV4ChatCompletions/requestBody/properties/additional_context/items/properties/category")
public enum GitLabDuoChatCompletionsCreateAdditionalContextCategory {
    FILE("file"),
    SNIPPET("snippet"),
    MERGE_REQUEST("merge_request"),
    ISSUE("issue"),
    DEPENDENCY("dependency"),
    LOCAL_GIT("local_git"),
    TERMINAL("terminal"),
    USER_RULE("user_rule"),
    REPOSITORY("repository"),
    DIRECTORY("directory"),
    AGENT_USER_ENVIRONMENT("agent_user_environment"),
    ATTACHMENTS("attachments");

    private static final EnumUtils.WireIndex<GitLabDuoChatCompletionsCreateAdditionalContextCategory> WIRE_INDEX =
            EnumUtils.index(
                    GitLabDuoChatCompletionsCreateAdditionalContextCategory.class,
                    GitLabDuoChatCompletionsCreateAdditionalContextCategory::wireValue);

    private final String wireValue;

    GitLabDuoChatCompletionsCreateAdditionalContextCategory(final String wireValue) {
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
    public static GitLabDuoChatCompletionsCreateAdditionalContextCategory fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
