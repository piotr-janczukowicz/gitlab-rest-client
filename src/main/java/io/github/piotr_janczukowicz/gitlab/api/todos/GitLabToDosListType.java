package io.github.piotr_janczukowicz.gitlab.api.todos;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab to dos list type. */
@CatalogSchema("operations/getApiV4Todos/parameters/type/schema")
public enum GitLabToDosListType {
    COMMIT("Commit"),
    ISSUE("Issue"),
    WORK_ITEM("WorkItem"),
    MERGE_REQUEST("MergeRequest"),
    DESIGN_MANAGEMENT_DESIGN("DesignManagement::Design"),
    ALERT_MANAGEMENT_ALERT("AlertManagement::Alert"),
    NAMESPACE("Namespace"),
    PROJECT("Project"),
    KEY("Key"),
    WIKI_PAGE_META("WikiPage::Meta"),
    EPIC("Epic"),
    VULNERABILITY("Vulnerability"),
    USER("User"),
    COMPLIANCE_MANAGEMENT_PROJECTS_COMPLIANCE_VIOLATION("ComplianceManagement::Projects::ComplianceViolation"),
    AI_DUO_WORKFLOWS_WORKFLOW("Ai::DuoWorkflows::Workflow");

    private static final EnumUtils.WireIndex<GitLabToDosListType> WIRE_INDEX =
            EnumUtils.index(GitLabToDosListType.class, GitLabToDosListType::wireValue);

    private final String wireValue;

    GitLabToDosListType(final String wireValue) {
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
    public static GitLabToDosListType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
