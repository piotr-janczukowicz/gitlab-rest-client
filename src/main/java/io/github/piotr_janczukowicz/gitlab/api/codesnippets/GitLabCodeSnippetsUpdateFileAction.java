package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab code snippets update file action. */
@CatalogSchema("operations/putApiV4SnippetsId/requestBody/properties/files/items/properties/action")
public enum GitLabCodeSnippetsUpdateFileAction {
    CREATE("create"),
    UPDATE("update"),
    DELETE("delete"),
    MOVE("move");

    private static final EnumUtils.WireIndex<GitLabCodeSnippetsUpdateFileAction> WIRE_INDEX =
            EnumUtils.index(GitLabCodeSnippetsUpdateFileAction.class, GitLabCodeSnippetsUpdateFileAction::wireValue);

    private final String wireValue;

    GitLabCodeSnippetsUpdateFileAction(final String wireValue) {
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
    public static GitLabCodeSnippetsUpdateFileAction fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
