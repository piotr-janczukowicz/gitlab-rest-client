package io.github.piotr_janczukowicz.gitlab.api.mobilepushsubscriptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab mobile push subscription.
 *
 * @param id the id
 * @param createdAt the created at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMobilePushSubscription")
public record GitLabMobilePushSubscription(
        @Nullable Long id, @Nullable Instant createdAt) {}
