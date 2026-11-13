package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * The git lab rollouts create channel token of a GitLab resource.
 *
 * @param channelName the channel name
 * @param token the token
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4RolloutsId/requestBody/properties/channel_tokens/items")
public record GitLabRolloutsCreateChannelToken(
        @Nullable String channelName, @Nullable String token) {
    public GitLabRolloutsCreateChannelToken {
        requireMaxLengthIfPresent(channelName, 255, "channelName");
        requireMaxLengthIfPresent(token, 4096, "token");
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token} redacted
     */
    @Override
    public String toString() {
        return "GitLabRolloutsCreateChannelToken[" + "channelName=" + channelName + ", token=<redacted>" + "]";
    }
}
