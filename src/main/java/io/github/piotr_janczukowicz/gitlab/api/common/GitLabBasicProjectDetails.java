package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab basic project details.
 *
 * @param id the id
 * @param description the description
 * @param name the name
 * @param nameWithNamespace the name with namespace
 * @param path the path
 * @param pathWithNamespace the path with namespace
 * @param createdAt the created at
 * @param defaultBranch the default branch
 * @param tagList the tag list
 * @param topics the topics
 * @param sshUrlToRepo the ssh url to repo
 * @param httpUrlToRepo the http url to repo
 * @param webUrl the web url
 * @param readmeUrl the readme url
 * @param forksCount the forks count
 * @param licenseUrl the license url
 * @param license the license
 * @param avatarUrl the avatar url
 * @param starCount the star count
 * @param lastActivityAt the last activity at
 * @param visibility the visibility
 * @param namespace the namespace
 * @param customAttributes the custom attributes
 * @param repositoryStorage the repository storage
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBasicProjectDetails")
public record GitLabBasicProjectDetails(
        @Nullable Long id,
        @Nullable String description,
        @Nullable String name,
        @Nullable String nameWithNamespace,
        @Nullable String path,
        @Nullable String pathWithNamespace,
        @Nullable Instant createdAt,
        @Nullable String defaultBranch,
        @Nullable List<String> tagList,
        @Nullable List<String> topics,
        @Nullable String sshUrlToRepo,
        @Nullable String httpUrlToRepo,
        @Nullable String webUrl,
        @Nullable String readmeUrl,
        @Nullable Integer forksCount,
        @Nullable String licenseUrl,
        @Nullable GitLabLicenseBasic license,
        @Nullable String avatarUrl,
        @Nullable Integer starCount,
        @Nullable Instant lastActivityAt,
        @Nullable String visibility,
        @Nullable GitLabNamespaceBasic namespace,
        @Nullable GitLabCustomAttribute customAttributes,
        @Nullable String repositoryStorage) {}
