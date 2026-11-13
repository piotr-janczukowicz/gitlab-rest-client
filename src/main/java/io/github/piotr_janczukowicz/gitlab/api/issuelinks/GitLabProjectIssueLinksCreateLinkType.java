package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project issue links create link type. */
@CatalogSchema("operations/postApiV4ProjectsIdIssuesIssueIidLinks/requestBody/properties/link_type")
public enum GitLabProjectIssueLinksCreateLinkType {
    RELATES_TO("relates_to"),
    BLOCKS("blocks"),
    IS_BLOCKED_BY("is_blocked_by");

    private static final EnumUtils.WireIndex<GitLabProjectIssueLinksCreateLinkType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectIssueLinksCreateLinkType.class, GitLabProjectIssueLinksCreateLinkType::wireValue);

    private final String wireValue;

    GitLabProjectIssueLinksCreateLinkType(final String wireValue) {
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
    public static GitLabProjectIssueLinksCreateLinkType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
