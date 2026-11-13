package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4UserPushSubscriptions}.
 *
 * @param deviceToken the device token
 * @param platform the platform
 * @param apnsEnvironment the apns environment
 * @param bundleId the bundle id
 * @param deviceName the device name
 * @param appVersion the app version
 * @param locale the locale
 * @param payloadMode the payload mode
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4UserPushSubscriptions/requestBody")
public record GitLabMobilePushSubscriptionsCreatePayload(
        @Nullable String deviceToken,
        @Nullable GitLabMobilePushSubscriptionsCreatePlatform platform,
        @Nullable GitLabMobilePushSubscriptionsCreateApnsEnvironment apnsEnvironment,
        @Nullable String bundleId,
        @Nullable String deviceName,
        @Nullable String appVersion,
        @Nullable String locale,
        @Nullable GitLabMobilePushSubscriptionsCreatePayloadMode payloadMode) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code deviceToken} redacted
     */
    @Override
    public String toString() {
        return "GitLabMobilePushSubscriptionsCreatePayload[" + "deviceToken=<redacted>" + ", platform=" + platform
                + ", apnsEnvironment=" + apnsEnvironment + ", bundleId=" + bundleId + ", deviceName=" + deviceName
                + ", appVersion=" + appVersion + ", locale=" + locale + ", payloadMode=" + payloadMode + "]";
    }
}
