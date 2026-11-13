package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group milestones update state event. */
@CatalogSchema("operations/putApiV4GroupsIdMilestonesMilestoneId/requestBody/properties/state_event")
public enum GitLabGroupGroupMilestonesUpdateStateEvent {
    CLOSE("close"),
    ACTIVATE("activate");

    private static final EnumUtils.WireIndex<GitLabGroupGroupMilestonesUpdateStateEvent> WIRE_INDEX = EnumUtils.index(
            GitLabGroupGroupMilestonesUpdateStateEvent.class, GitLabGroupGroupMilestonesUpdateStateEvent::wireValue);

    private final String wireValue;

    GitLabGroupGroupMilestonesUpdateStateEvent(final String wireValue) {
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
    public static GitLabGroupGroupMilestonesUpdateStateEvent fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
