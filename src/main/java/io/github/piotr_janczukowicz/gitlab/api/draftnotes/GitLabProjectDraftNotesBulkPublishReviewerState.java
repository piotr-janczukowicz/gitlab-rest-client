package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project draft notes bulk publish reviewer state. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdMergeRequestsMergeRequestIidDraftNotesBulkPublish/requestBody/properties/reviewer_state")
public enum GitLabProjectDraftNotesBulkPublishReviewerState {
    REQUESTED_CHANGES("requested_changes"),
    REVIEWED("reviewed");

    private static final EnumUtils.WireIndex<GitLabProjectDraftNotesBulkPublishReviewerState> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectDraftNotesBulkPublishReviewerState.class,
                    GitLabProjectDraftNotesBulkPublishReviewerState::wireValue);

    private final String wireValue;

    GitLabProjectDraftNotesBulkPublishReviewerState(final String wireValue) {
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
    public static GitLabProjectDraftNotesBulkPublishReviewerState fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
