package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsAppleAppStore}.
 *
 * @param appStoreIssuerId the app store issuer id
 * @param appStoreKeyId the app store key id
 * @param appStorePrivateKeyFileName the app store private key file name
 * @param appStorePrivateKey the app store private key
 * @param appStoreProtectedRefs the app store protected refs
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsAppleAppStore/requestBody")
public record GitLabGroupGroupIntegrationsAppleAppStorePayload(
        @Nullable String appStoreIssuerId,
        @Nullable String appStoreKeyId,
        @Nullable String appStorePrivateKeyFileName,
        @Nullable String appStorePrivateKey,
        @Nullable Boolean appStoreProtectedRefs,
        @Nullable Boolean useInheritedSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code appStorePrivateKey} redacted
     */
    @Override
    public String toString() {
        return "GitLabGroupGroupIntegrationsAppleAppStorePayload[" + "appStoreIssuerId=" + appStoreIssuerId
                + ", appStoreKeyId=" + appStoreKeyId + ", appStorePrivateKeyFileName=" + appStorePrivateKeyFileName
                + ", appStorePrivateKey=<redacted>" + ", appStoreProtectedRefs=" + appStoreProtectedRefs
                + ", useInheritedSettings=" + useInheritedSettings + "]";
    }
}
