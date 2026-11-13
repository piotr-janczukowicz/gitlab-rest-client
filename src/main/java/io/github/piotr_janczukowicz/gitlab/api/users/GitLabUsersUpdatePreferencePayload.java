package io.github.piotr_janczukowicz.gitlab.api.users;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireBetweenIfPresent;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4UserPreferences}.
 *
 * @param viewDiffsFileByFile the view diffs file by file
 * @param showWhitespaceInDiffs the show whitespace in diffs
 * @param passUserIdentitiesToCiJwt the pass user identities to ci jwt
 * @param policyAdvancedEditor the policy advanced editor
 * @param emojiSkinTone the emoji skin tone
 * @param mobilePushWorkingHoursEnabled the mobile push working hours enabled
 * @param mobilePushWorkingHoursStart the mobile push working hours start
 * @param mobilePushWorkingHoursEnd the mobile push working hours end
 * @param mobilePushWorkingDays the mobile push working days
 * @param mobilePushWorkingHoursTimeZone the mobile push working hours time zone
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4UserPreferences/requestBody")
public record GitLabUsersUpdatePreferencePayload(
        @Nullable Boolean viewDiffsFileByFile,
        @Nullable Boolean showWhitespaceInDiffs,
        @Nullable Boolean passUserIdentitiesToCiJwt,
        @Nullable Boolean policyAdvancedEditor,
        @Nullable GitLabUsersUpdatePreferenceEmojiSkinTone emojiSkinTone,
        @Nullable Boolean mobilePushWorkingHoursEnabled,
        @Nullable Integer mobilePushWorkingHoursStart,
        @Nullable Integer mobilePushWorkingHoursEnd,
        @Nullable List<GitLabUsersUpdatePreferenceMobilePushWorkingDays> mobilePushWorkingDays,
        @Nullable String mobilePushWorkingHoursTimeZone) {
    public GitLabUsersUpdatePreferencePayload {
        requireBetweenIfPresent(mobilePushWorkingHoursStart, 0, 1439, "mobilePushWorkingHoursStart");
        requireBetweenIfPresent(mobilePushWorkingHoursEnd, 0, 1439, "mobilePushWorkingHoursEnd");
        if (mobilePushWorkingDays != null) {
            mobilePushWorkingDays = List.copyOf(mobilePushWorkingDays);
        }
        requireMaxLengthIfPresent(mobilePushWorkingHoursTimeZone, 64, "mobilePushWorkingHoursTimeZone");
    }
}
