package io.github.piotr_janczukowicz.gitlab.api.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user profile.
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
 * @param createdAt the created at
 * @param bio the bio
 * @param location the location
 * @param linkedin the linkedin
 * @param twitter the twitter
 * @param discord the discord
 * @param websiteUrl the website url
 * @param github the github
 * @param jobTitle the job title
 * @param pronouns the pronouns
 * @param organization the organization
 * @param bot the bot
 * @param workInformation the work information
 * @param followers the followers
 * @param following the following
 * @param isFollowed the is followed
 * @param localTime the local time
 * @param bioHtml the bio html
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserProfile")
public record GitLabUserProfile(
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

        @Nullable @SuppressSchemaTypeMismatch("type rule: date-time (created_at)")
        Instant createdAt,

        @Nullable String bio,
        @Nullable String location,
        @Nullable String linkedin,
        @Nullable String twitter,
        @Nullable String discord,
        @Nullable String websiteUrl,
        @Nullable String github,
        @Nullable String jobTitle,
        @Nullable String pronouns,
        @Nullable String organization,
        @Nullable Boolean bot,
        @Nullable String workInformation,
        @Nullable String followers,
        @Nullable String following,
        @Nullable String isFollowed,
        @Nullable String localTime,
        @Nullable String bioHtml) {}
