package io.github.piotr_janczukowicz.gitlab.api.todos;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab to dos list action. */
@CatalogSchema("operations/getApiV4Todos/parameters/action/schema")
public enum GitLabToDosListAction {
    ASSIGNED("assigned"),
    REVIEW_REQUESTED("review_requested"),
    MENTIONED("mentioned"),
    BUILD_FAILED("build_failed"),
    MARKED("marked"),
    APPROVAL_REQUIRED("approval_required"),
    UNMERGEABLE("unmergeable"),
    DIRECTLY_ADDRESSED("directly_addressed"),
    MEMBER_ACCESS_REQUESTED("member_access_requested"),
    REVIEW_SUBMITTED("review_submitted"),
    REVIEW_APPROVED("review_approved"),
    REVIEW_CHANGES_REQUESTED("review_changes_requested"),
    SSH_KEY_EXPIRED("ssh_key_expired"),
    SSH_KEY_EXPIRING_SOON("ssh_key_expiring_soon"),
    TRANSFER_FAILED("transfer_failed"),
    MERGE_TRAIN_REMOVED("merge_train_removed"),
    OKR_CHECKIN_REQUESTED("okr_checkin_requested"),
    ADDED_APPROVER("added_approver"),
    DUO_PRO_ACCESS_GRANTED("duo_pro_access_granted"),
    DUO_ENTERPRISE_ACCESS_GRANTED("duo_enterprise_access_granted"),
    DUO_CORE_ACCESS_GRANTED("duo_core_access_granted"),
    DUO_WORKFLOW_INPUT_REQUIRED("duo_workflow_input_required"),
    ORBIT_ACCESS_GRANTED("orbit_access_granted");

    private static final EnumUtils.WireIndex<GitLabToDosListAction> WIRE_INDEX =
            EnumUtils.index(GitLabToDosListAction.class, GitLabToDosListAction::wireValue);

    private final String wireValue;

    GitLabToDosListAction(final String wireValue) {
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
    public static GitLabToDosListAction fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
