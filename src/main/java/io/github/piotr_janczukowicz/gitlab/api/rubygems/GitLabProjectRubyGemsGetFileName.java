package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project ruby gems get file name. */
@CatalogSchema("operations/getApiV4ProjectsIdPackagesRubygemsFileName/parameters/file_name/schema")
public enum GitLabProjectRubyGemsGetFileName {
    SPECS_4_8_GZ("specs.4.8.gz"),
    LATEST_SPECS_4_8_GZ("latest_specs.4.8.gz"),
    PRERELEASE_SPECS_4_8_GZ("prerelease_specs.4.8.gz");

    private static final EnumUtils.WireIndex<GitLabProjectRubyGemsGetFileName> WIRE_INDEX =
            EnumUtils.index(GitLabProjectRubyGemsGetFileName.class, GitLabProjectRubyGemsGetFileName::wireValue);

    private final String wireValue;

    GitLabProjectRubyGemsGetFileName(final String wireValue) {
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
    public static GitLabProjectRubyGemsGetFileName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
