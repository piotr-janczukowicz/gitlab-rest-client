package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user preferences.
 *
 * @param id the id
 * @param userId the user id
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
@CatalogSchema("components/schemas/APIEntitiesUserPreferences")
public record GitLabUserPreferences(
        @Nullable Long id,
        @Nullable Long userId,
        @Nullable Boolean viewDiffsFileByFile,
        @Nullable Boolean showWhitespaceInDiffs,
        @Nullable Boolean passUserIdentitiesToCiJwt,
        @Nullable Boolean policyAdvancedEditor,
        @Nullable String emojiSkinTone,
        @Nullable Boolean mobilePushWorkingHoursEnabled,
        @Nullable Integer mobilePushWorkingHoursStart,
        @Nullable Integer mobilePushWorkingHoursEnd,
        @Nullable List<String> mobilePushWorkingDays,
        @Nullable String mobilePushWorkingHoursTimeZone) {}
