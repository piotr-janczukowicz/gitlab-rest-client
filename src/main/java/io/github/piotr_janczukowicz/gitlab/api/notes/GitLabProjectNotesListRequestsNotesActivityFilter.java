package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project notes list requests notes activity filter. */
@CatalogSchema("operations/getApiV4ProjectsIdMergeRequestsNoteableIdNotes/parameters/activity_filter/schema")
public enum GitLabProjectNotesListRequestsNotesActivityFilter {
    ALL_NOTES("all_notes"),
    ONLY_COMMENTS("only_comments"),
    ONLY_ACTIVITY("only_activity");

    private static final EnumUtils.WireIndex<GitLabProjectNotesListRequestsNotesActivityFilter> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectNotesListRequestsNotesActivityFilter.class,
                    GitLabProjectNotesListRequestsNotesActivityFilter::wireValue);

    private final String wireValue;

    GitLabProjectNotesListRequestsNotesActivityFilter(final String wireValue) {
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
    public static GitLabProjectNotesListRequestsNotesActivityFilter fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
