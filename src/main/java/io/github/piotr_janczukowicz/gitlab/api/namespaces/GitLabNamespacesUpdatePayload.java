package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.LocalDate;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4NamespacesId}.
 *
 * @param sharedRunnersMinutesLimit the shared runners minutes limit
 * @param extraSharedRunnersMinutesLimit the extra shared runners minutes limit
 * @param additionalPurchasedStorageSize the additional purchased storage size
 * @param additionalPurchasedStorageEndsOn the additional purchased storage ends on
 * @param gitlabSubscriptionAttributes the gitlab subscription attributes
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4NamespacesId/requestBody")
public record GitLabNamespacesUpdatePayload(
        @Nullable Integer sharedRunnersMinutesLimit,
        @Nullable Integer extraSharedRunnersMinutesLimit,
        @Nullable Long additionalPurchasedStorageSize,
        @Nullable LocalDate additionalPurchasedStorageEndsOn,
        @Nullable GitLabNamespacesUpdateGitlabSubscriptionAttributes gitlabSubscriptionAttributes) {}
