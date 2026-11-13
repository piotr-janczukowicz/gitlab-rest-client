package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4GroupsIdIntegrationsIrker}.
 *
 * @param serverHost the server host
 * @param serverPort the server port
 * @param defaultIrcUri the default irc uri
 * @param recipients the recipients
 * @param colorizeMessages the colorize messages
 * @param pushEvents the push events
 * @param useInheritedSettings the use inherited settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4GroupsIdIntegrationsIrker/requestBody")
public record GitLabGroupGroupIntegrationsIrkerPayload(
        @Nullable String serverHost,
        @Nullable Integer serverPort,
        @Nullable String defaultIrcUri,
        @Nullable String recipients,
        @Nullable Boolean colorizeMessages,
        @Nullable Boolean pushEvents,
        @Nullable Boolean useInheritedSettings) {}
