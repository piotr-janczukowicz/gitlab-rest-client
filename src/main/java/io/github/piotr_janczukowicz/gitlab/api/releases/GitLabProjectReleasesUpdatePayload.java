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
 * Request body of the operation {@code putApiV4ProjectsIdReleasesTagName}.
 *
 * @param name the name
 * @param description the description
 * @param releasedAt the released at
 * @param milestones the milestones
 * @param milestoneIds the milestone ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ProjectsIdReleasesTagName/requestBody")
public record GitLabProjectReleasesUpdatePayload(
        @Nullable String name,
        @Nullable String description,
        @Nullable Instant releasedAt,
        @Nullable List<String> milestones,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String milestoneIds) {
    public GitLabProjectReleasesUpdatePayload {
        if (milestones != null) {
            milestones = List.copyOf(milestones);
        }
    }
}
