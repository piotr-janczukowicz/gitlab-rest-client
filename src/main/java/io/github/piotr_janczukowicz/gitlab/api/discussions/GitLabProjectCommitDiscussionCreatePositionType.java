package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project commit discussion create position type. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdRepositoryCommitsNoteableIdDiscussions/requestBody/properties/position/properties/position_type")
public enum GitLabProjectCommitDiscussionCreatePositionType {
    TEXT("text"),
    IMAGE("image"),
    FILE("file");

    private static final EnumUtils.WireIndex<GitLabProjectCommitDiscussionCreatePositionType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectCommitDiscussionCreatePositionType.class,
                    GitLabProjectCommitDiscussionCreatePositionType::wireValue);

    private final String wireValue;

    GitLabProjectCommitDiscussionCreatePositionType(final String wireValue) {
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
    public static GitLabProjectCommitDiscussionCreatePositionType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
