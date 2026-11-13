package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group wikis create format. */
@CatalogSchema("operations/postApiV4GroupsIdWikis/requestBody/properties/format")
public enum GitLabGroupGroupWikisCreateFormat {
    MARKDOWN("markdown"),
    RDOC("rdoc"),
    ASCIIDOC("asciidoc"),
    ORG("org");

    private static final EnumUtils.WireIndex<GitLabGroupGroupWikisCreateFormat> WIRE_INDEX =
            EnumUtils.index(GitLabGroupGroupWikisCreateFormat.class, GitLabGroupGroupWikisCreateFormat::wireValue);

    private final String wireValue;

    GitLabGroupGroupWikisCreateFormat(final String wireValue) {
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
    public static GitLabGroupGroupWikisCreateFormat fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
