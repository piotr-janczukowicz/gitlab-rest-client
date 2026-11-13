package io.github.piotr_janczukowicz.gitlab.api.releases;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project releases create assets link type. */
@CatalogSchema(
        "operations/postApiV4ProjectsIdReleases/requestBody/properties/assets/properties/links/items/properties/link_type")
public enum GitLabProjectReleasesCreateAssetsLinkType {
    OTHER("other"),
    RUNBOOK("runbook"),
    PACKAGE("package"),
    IMAGE("image");

    private static final EnumUtils.WireIndex<GitLabProjectReleasesCreateAssetsLinkType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectReleasesCreateAssetsLinkType.class, GitLabProjectReleasesCreateAssetsLinkType::wireValue);

    private final String wireValue;

    GitLabProjectReleasesCreateAssetsLinkType(final String wireValue) {
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
    public static GitLabProjectReleasesCreateAssetsLinkType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
