package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab member.
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
 * @param accessLevel the access level
 * @param createdAt the created at
 * @param createdBy the created by
 * @param expiresAt the expires at
 * @param twoFactorEnabled the two factor enabled
 * @param groupSamlIdentity the group saml identity
 * @param groupScimIdentity the group scim identity
 * @param email the email
 * @param isUsingSeat the is using seat
 * @param override the override
 * @param membershipState the membership state
 * @param memberRole the member role
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMember")
public record GitLabMember(
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
        @Nullable Integer accessLevel,

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable GitLabUserBasic createdBy,
        @Nullable String expiresAt,
        @Nullable Boolean twoFactorEnabled,
        @Nullable GitLabIdentity groupSamlIdentity,
        @Nullable GitLabScimIdentity groupScimIdentity,
        @Nullable String email,
        @Nullable String isUsingSeat,
        @Nullable String override,
        @Nullable String membershipState,
        @Nullable GitLabMemberRole memberRole) {}
