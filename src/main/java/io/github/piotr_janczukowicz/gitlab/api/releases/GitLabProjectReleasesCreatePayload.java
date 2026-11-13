package io.github.piotr_janczukowicz.gitlab.api.releases;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.time.Instant;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdReleases}.
 *
 * @param tagName the tag name
 * @param tagMessage the tag message
 * @param name the name
 * @param description the description
 * @param ref the ref
 * @param assets the assets
 * @param milestones the milestones
 * @param milestoneIds the milestone ids
 * @param releasedAt the released at
 * @param legacyCatalogPublish the legacy catalog publish
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdReleases/requestBody")
public record GitLabProjectReleasesCreatePayload(
        @Nullable String tagName,
        @Nullable String tagMessage,
        @Nullable String name,
        @Nullable String description,
        @Nullable String ref,
        @Nullable GitLabProjectReleasesCreateAssets assets,
        @Nullable List<String> milestones,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String milestoneIds,

        @Nullable Instant releasedAt,
        @Nullable Boolean legacyCatalogPublish) {
    public GitLabProjectReleasesCreatePayload {
        if (milestones != null) {
            milestones = List.copyOf(milestones);
        }
    }
}
