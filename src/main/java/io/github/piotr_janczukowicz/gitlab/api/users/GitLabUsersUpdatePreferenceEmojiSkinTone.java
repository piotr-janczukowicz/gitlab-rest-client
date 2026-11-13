package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab users update preference emoji skin tone. */
@CatalogSchema("operations/putApiV4UserPreferences/requestBody/properties/emoji_skin_tone")
public enum GitLabUsersUpdatePreferenceEmojiSkinTone {
    DEFAULT("default"),
    LIGHT("light"),
    MEDIUM_LIGHT("medium_light"),
    MEDIUM("medium"),
    MEDIUM_DARK("medium_dark"),
    DARK("dark");

    private static final EnumUtils.WireIndex<GitLabUsersUpdatePreferenceEmojiSkinTone> WIRE_INDEX = EnumUtils.index(
            GitLabUsersUpdatePreferenceEmojiSkinTone.class, GitLabUsersUpdatePreferenceEmojiSkinTone::wireValue);

    private final String wireValue;

    GitLabUsersUpdatePreferenceEmojiSkinTone(final String wireValue) {
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
    public static GitLabUsersUpdatePreferenceEmojiSkinTone fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
