package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4RolloutsId}.
 *
 * @param topic the topic
 * @param type the type
 * @param data the data
 * @param value the value
 * @param channelTokens the channel tokens
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4RolloutsId/requestBody")
public record GitLabRolloutsCreatePayload(
        @Nullable String topic,
        @Nullable String type,
        @Nullable GitLabRolloutsCreateData data,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> value,

        @Nullable List<GitLabRolloutsCreateChannelToken> channelTokens) {
    public GitLabRolloutsCreatePayload {
        requireMaxLengthIfPresent(type, 255, "type");
        if (value != null) {
            value = Map.copyOf(value);
        }
        if (channelTokens != null) {
            channelTokens = List.copyOf(channelTokens);
        }
    }
}
