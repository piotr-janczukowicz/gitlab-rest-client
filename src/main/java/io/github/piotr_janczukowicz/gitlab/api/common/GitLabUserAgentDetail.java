package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user agent detail.
 *
 * @param userAgent the user agent
 * @param ipAddress the ip address
 * @param akismetSubmitted the akismet submitted
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserAgentDetail")
public record GitLabUserAgentDetail(
        @Nullable String userAgent,
        @Nullable String ipAddress,
        @Nullable Boolean akismetSubmitted) {}
