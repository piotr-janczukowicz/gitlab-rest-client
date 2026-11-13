package io.github.piotr_janczukowicz.gitlab.api.externalstatuschecks;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabProtectedBranch;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab external status check.
 *
 * @param id the id
 * @param name the name
 * @param projectId the project id
 * @param externalUrl the external url
 * @param protectedBranches the protected branches
 * @param hmac the hmac
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesExternalStatusCheck")
public record GitLabExternalStatusCheck(
        @Nullable Long id,
        @Nullable String name,
        @Nullable Long projectId,
        @Nullable String externalUrl,
        @Nullable List<GitLabProtectedBranch> protectedBranches,
        @Nullable Boolean hmac) {}
