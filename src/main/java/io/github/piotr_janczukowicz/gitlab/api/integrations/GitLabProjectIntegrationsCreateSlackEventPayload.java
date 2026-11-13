package io.github.piotr_janczukowicz.gitlab.api.integrations;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4IntegrationsSlackEvents}.
 *
 * @param token the token
 * @param teamId the team id
 * @param apiAppId the api app id
 * @param event the event
 * @param type the type
 * @param eventId the event id
 * @param eventTime the event time
 * @param authedUsers the authed users
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4IntegrationsSlackEvents/requestBody")
public record GitLabProjectIntegrationsCreateSlackEventPayload(
        @Nullable String token,
        @Nullable String teamId,
        @Nullable String apiAppId,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> event,

        @Nullable String type,
        @Nullable String eventId,
        @Nullable Integer eventTime,
        @Nullable List<String> authedUsers) {
    public GitLabProjectIntegrationsCreateSlackEventPayload {
        if (event != null) {
            event = Map.copyOf(event);
        }
        if (authedUsers != null) {
            authedUsers = List.copyOf(authedUsers);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabProjectIntegrationsCreateSlackEventPayload[" + "token=<redacted>" + ", teamId=" + teamId
                + ", apiAppId=" + apiAppId + ", event=" + event + ", type=" + type + ", eventId=" + eventId
                + ", eventTime=" + eventTime + ", authedUsers=" + authedUsers + "]";
    }
}
