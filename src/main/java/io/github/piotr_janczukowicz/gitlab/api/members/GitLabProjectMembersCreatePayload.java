package io.github.piotr_janczukowicz.gitlab.api.members;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdMembers}.
 *
 * @param accessLevel the access level
 * @param userId the user id
 * @param username the username
 * @param expiresAt the expires at
 * @param inviteSource the invite source
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdMembers/requestBody")
public record GitLabProjectMembersCreatePayload(
        @Nullable Integer accessLevel,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_INTEGER_STRING)
        String userId,

        @Nullable String username,
        @Nullable Instant expiresAt,
        @Nullable String inviteSource) {}
