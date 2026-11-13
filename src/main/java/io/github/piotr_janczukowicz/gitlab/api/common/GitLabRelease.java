package io.github.piotr_janczukowicz.gitlab.api.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab release.
 *
 * @param name the name
 * @param tagName the tag name
 * @param description the description
 * @param createdAt the created at
 * @param releasedAt the released at
 * @param upcomingRelease the upcoming release
 * @param descriptionHtml the description html
 * @param author the author
 * @param commit the commit
 * @param milestones the milestones
 * @param commitPath the commit path
 * @param tagPath the tag path
 * @param assets the assets
 * @param evidences the evidences
 * @param links the links
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesRelease")
public record GitLabRelease(
        @Nullable String name,
        @Nullable String tagName,
        @Nullable String description,
        @Nullable Instant createdAt,
        @Nullable Instant releasedAt,
        @Nullable Boolean upcomingRelease,
        @Nullable String descriptionHtml,
        @Nullable GitLabUserBasic author,
        @Nullable GitLabCommit commit,
        @Nullable List<GitLabMilestoneWithStats> milestones,
        @Nullable String commitPath,
        @Nullable String tagPath,
        @Nullable GitLabReleaseAssets assets,
        @Nullable List<GitLabReleaseEvidence> evidences,
        @Nullable @JsonProperty("_links") GitLabReleaseLinks links) {}
