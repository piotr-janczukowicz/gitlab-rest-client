package io.github.piotr_janczukowicz.gitlab.api.mergetrains;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab merge trains car status. */
@CatalogSchema("components/schemas/APIEntitiesMergeTrainsCar/properties/status")
public enum GitLabMergeTrainsCarStatus {
    IDLE("idle"),
    STALE("stale"),
    FRESH("fresh"),
    MERGING("merging"),
    MERGED("merged"),
    SKIP_MERGED("skip_merged"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabMergeTrainsCarStatus> WIRE_INDEX =
            EnumUtils.index(GitLabMergeTrainsCarStatus.class, GitLabMergeTrainsCarStatus::wireValue);

    private final String wireValue;

    GitLabMergeTrainsCarStatus(final String wireValue) {
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
    public static GitLabMergeTrainsCarStatus fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
