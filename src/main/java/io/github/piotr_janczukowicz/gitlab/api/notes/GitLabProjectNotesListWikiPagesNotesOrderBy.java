package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project notes list wiki pages notes order by. */
@CatalogSchema("operations/getApiV4ProjectsIdWikiPagesNoteableIdNotes/parameters/order_by/schema")
public enum GitLabProjectNotesListWikiPagesNotesOrderBy {
    CREATED_AT("created_at"),
    UPDATED_AT("updated_at");

    private static final EnumUtils.WireIndex<GitLabProjectNotesListWikiPagesNotesOrderBy> WIRE_INDEX = EnumUtils.index(
            GitLabProjectNotesListWikiPagesNotesOrderBy.class, GitLabProjectNotesListWikiPagesNotesOrderBy::wireValue);

    private final String wireValue;

    GitLabProjectNotesListWikiPagesNotesOrderBy(final String wireValue) {
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
    public static GitLabProjectNotesListWikiPagesNotesOrderBy fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
