package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab code suggestions create completion generation type. */
@CatalogSchema("operations/postApiV4CodeSuggestionsCompletions/requestBody/properties/generation_type")
public enum GitLabCodeSuggestionsCreateCompletionGenerationType {
    COMMENT("comment"),
    EMPTY_FUNCTION("empty_function"),
    SMALL_FILE("small_file");

    private static final EnumUtils.WireIndex<GitLabCodeSuggestionsCreateCompletionGenerationType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabCodeSuggestionsCreateCompletionGenerationType.class,
                    GitLabCodeSuggestionsCreateCompletionGenerationType::wireValue);

    private final String wireValue;

    GitLabCodeSuggestionsCreateCompletionGenerationType(final String wireValue) {
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
    public static GitLabCodeSuggestionsCreateCompletionGenerationType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
