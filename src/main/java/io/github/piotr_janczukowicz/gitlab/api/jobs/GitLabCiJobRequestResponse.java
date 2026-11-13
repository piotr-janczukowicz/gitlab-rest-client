package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request response.
 *
 * @param id the id
 * @param token the token
 * @param allowGitFetch the allow git fetch
 * @param jobInfo the job info
 * @param gitInfo the git info
 * @param runnerInfo the runner info
 * @param inputs the inputs
 * @param variables the variables
 * @param steps the steps
 * @param hooks the hooks
 * @param image the image
 * @param services the services
 * @param artifacts the artifacts
 * @param cache the cache
 * @param credentials the credentials
 * @param features the features
 * @param dependencies the dependencies
 * @param run the run
 * @param suspendOptions the suspend options
 * @param secrets the secrets
 * @param policyOptions the policy options
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestResponse")
public record GitLabCiJobRequestResponse(
        @Nullable String id,
        @Nullable String token,
        @Nullable String allowGitFetch,
        @Nullable GitLabCiJobRequestJobInfo jobInfo,
        @Nullable GitLabCiJobRequestGitInfo gitInfo,
        @Nullable GitLabCiJobRequestRunnerInfo runnerInfo,
        @Nullable String inputs,
        @Nullable String variables,
        @Nullable List<GitLabCiJobRequestStep> steps,
        @Nullable List<GitLabCiJobRequestHook> hooks,
        @Nullable GitLabCiJobRequestImage image,
        @Nullable List<GitLabCiJobRequestService> services,
        @Nullable List<GitLabCiJobRequestArtifacts> artifacts,
        @Nullable List<GitLabCiJobRequestCache> cache,
        @Nullable List<GitLabCiJobRequestCredentials> credentials,
        @Nullable String features,
        @Nullable String dependencies,
        @Nullable String run,
        @Nullable String suspendOptions,
        @Nullable String secrets,
        @Nullable String policyOptions) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code token}, {@code secrets} redacted
     */
    @Override
    public String toString() {
        return "GitLabCiJobRequestResponse[" + "id=" + id + ", token=<redacted>" + ", allowGitFetch=" + allowGitFetch
                + ", jobInfo=" + jobInfo + ", gitInfo=" + gitInfo + ", runnerInfo=" + runnerInfo + ", inputs=" + inputs
                + ", variables=" + variables + ", steps=" + steps + ", hooks=" + hooks + ", image=" + image
                + ", services=" + services + ", artifacts=" + artifacts + ", cache=" + cache + ", credentials="
                + credentials + ", features=" + features + ", dependencies=" + dependencies + ", run=" + run
                + ", suspendOptions=" + suspendOptions + ", secrets=<redacted>" + ", policyOptions=" + policyOptions
                + "]";
    }
}
