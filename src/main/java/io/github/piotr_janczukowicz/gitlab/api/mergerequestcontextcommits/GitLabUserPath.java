package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCustomAttribute;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab user path.
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
 * @param statusTooltipHtml the status tooltip html
 * @param showStatus the show status
 * @param availability the availability
 * @param path the path
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesUserPath")
public record GitLabUserPath(
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
        @Nullable String statusTooltipHtml,
        @Nullable String showStatus,
        @Nullable String availability,
        @Nullable String path) {}
