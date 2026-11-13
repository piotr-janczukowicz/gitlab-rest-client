package io.github.piotr_janczukowicz.gitlab.api.branches;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab branch.
 *
 * @param name the name
 * @param commit the commit
 * @param merged the merged
 * @param protectedValue the protected
 * @param developersCanPush the developers can push
 * @param developersCanMerge the developers can merge
 * @param canPush the can push
 * @param defaultValue the default
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesBranch")
public record GitLabBranch(
        @Nullable String name,
        @Nullable GitLabCommit commit,
        @Nullable Boolean merged,
        @Nullable @JsonProperty("protected") Boolean protectedValue,
        @Nullable Boolean developersCanPush,
        @Nullable Boolean developersCanMerge,
        @Nullable Boolean canPush,
        @Nullable @JsonProperty("default") Boolean defaultValue,
        @Nullable String webUrl) {}
