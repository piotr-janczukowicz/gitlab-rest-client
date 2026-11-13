package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group and project migration by direct transfer create entity source type. */
@CatalogSchema("operations/postApiV4BulkImports/requestBody/properties/entities/items/properties/source_type")
public enum GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType {
    GROUP_ENTITY("group_entity"),
    PROJECT_ENTITY("project_entity");

    private static final EnumUtils.WireIndex<GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType>
            WIRE_INDEX = EnumUtils.index(
                    GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType.class,
                    GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType::wireValue);

    private final String wireValue;

    GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType(final String wireValue) {
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
    public static GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
