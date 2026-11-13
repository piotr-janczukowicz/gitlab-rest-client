package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab license.
 *
 * @param key the key
 * @param name the name
 * @param nickname the nickname
 * @param htmlUrl the html url
 * @param sourceUrl the source url
 * @param popular the popular
 * @param description the description
 * @param conditions the conditions
 * @param permissions the permissions
 * @param limitations the limitations
 * @param content the content
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesLicense")
public record GitLabLicense(
        @Nullable String key,
        @Nullable String name,
        @Nullable String nickname,
        @Nullable String htmlUrl,
        @Nullable String sourceUrl,
        @Nullable Boolean popular,
        @Nullable String description,
        @Nullable List<String> conditions,
        @Nullable List<String> permissions,
        @Nullable List<String> limitations,
        @Nullable String content) {}
