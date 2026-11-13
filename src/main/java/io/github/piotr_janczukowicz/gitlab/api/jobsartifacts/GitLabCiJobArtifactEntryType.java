package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab ci job artifact entry type. */
@CatalogSchema("components/schemas/APIEntitiesCiJobArtifactEntry/properties/type")
public enum GitLabCiJobArtifactEntryType {
    FILE("file"),
    DIRECTORY("directory"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabCiJobArtifactEntryType> WIRE_INDEX =
            EnumUtils.index(GitLabCiJobArtifactEntryType.class, GitLabCiJobArtifactEntryType::wireValue);

    private final String wireValue;

    GitLabCiJobArtifactEntryType(final String wireValue) {
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
     */
    @JsonCreator
    public static GitLabCiJobArtifactEntryType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
