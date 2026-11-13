package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project release links create link type. */
@CatalogSchema("operations/postApiV4ProjectsIdReleasesTagNameAssetsLinks/requestBody/properties/link_type")
public enum GitLabProjectReleaseLinksCreateLinkType {
    OTHER("other"),
    RUNBOOK("runbook"),
    IMAGE("image"),
    PACKAGE("package");

    private static final EnumUtils.WireIndex<GitLabProjectReleaseLinksCreateLinkType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectReleaseLinksCreateLinkType.class, GitLabProjectReleaseLinksCreateLinkType::wireValue);

    private final String wireValue;

    GitLabProjectReleaseLinksCreateLinkType(final String wireValue) {
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
    public static GitLabProjectReleaseLinksCreateLinkType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
