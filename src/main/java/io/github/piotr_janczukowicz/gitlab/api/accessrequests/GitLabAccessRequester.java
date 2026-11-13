package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab access requester.
 *
 * @param id the id
 * @param username the username
 * @param publicEmail the public email
 * @param name the name
 * @param state the state
 * @param locked the locked
 * @param avatarUrl the avatar url
 * @param avatarPath the avatar path
 * @param customAttributes the custom attributes
 * @param webUrl the web url
 * @param requestedAt the requested at
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesAccessRequester")
public record GitLabAccessRequester(
        @Nullable Long id,
        @Nullable String username,
        @Nullable String publicEmail,
        @Nullable String name,
        @Nullable String state,
        @Nullable Boolean locked,
        @Nullable String avatarUrl,
        @Nullable String avatarPath,
        @Nullable List<GitLabCustomAttribute> customAttributes,
        @Nullable String webUrl,
        @Nullable String requestedAt) {}
