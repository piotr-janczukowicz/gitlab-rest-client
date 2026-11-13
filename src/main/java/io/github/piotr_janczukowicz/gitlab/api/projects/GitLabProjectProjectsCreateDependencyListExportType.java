package io.github.piotr_janczukowicz.gitlab.api.projects;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project projects create dependency list export type. */
@CatalogSchema("operations/postApiV4ProjectsIdDependencyListExports/requestBody/properties/export_type")
public enum GitLabProjectProjectsCreateDependencyListExportType {
    DEPENDENCY_LIST("dependency_list"),
    CSV("csv"),
    CYCLONEDX_1_6_JSON("cyclonedx_1_6_json");

    private static final EnumUtils.WireIndex<GitLabProjectProjectsCreateDependencyListExportType> WIRE_INDEX =
            EnumUtils.index(
                    GitLabProjectProjectsCreateDependencyListExportType.class,
                    GitLabProjectProjectsCreateDependencyListExportType::wireValue);

    private final String wireValue;

    GitLabProjectProjectsCreateDependencyListExportType(final String wireValue) {
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
    public static GitLabProjectProjectsCreateDependencyListExportType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
