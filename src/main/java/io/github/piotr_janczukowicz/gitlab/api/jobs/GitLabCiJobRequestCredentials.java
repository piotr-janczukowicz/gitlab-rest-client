package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request credentials.
 *
 * @param type the type
 * @param url the url
 * @param username the username
 * @param password the password
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestCredentials")
public record GitLabCiJobRequestCredentials(
        @Nullable String type,
        @Nullable String url,
        @Nullable String username,
        @Nullable String password) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code password} redacted
     */
    @Override
    public String toString() {
        return "GitLabCiJobRequestCredentials[" + "type=" + type + ", url=" + url + ", username=" + username
                + ", password=<redacted>" + "]";
    }
}
