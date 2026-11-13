package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Optional;

/** The GitLab operations of orbit. */
public final class GitLabOrbitApi extends GitLabResourceApi {
    private static final PathTemplate CONTEXT = PathTemplate.of("/orbit/context");
    private static final PathTemplate GET_SKILLS = PathTemplate.of("/orbit/skills");
    private static final PathTemplate GET_SKILL = PathTemplate.of("/orbit/skills/{name}");
    private static final PathTemplate GET_SKILL_BY_PATH = PathTemplate.of("/orbit/skills/{name}/{path}");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabOrbitApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Context ({@code POST /orbit/context}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabOrbitContext context(final GitLabOrbitContextPayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "postApiV4OrbitContext");
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(CONTEXT), payload), GitLabOrbitContext.class);
    }

    /**
     * Get skills ({@code GET /orbit/skills}).
     *
     * @return the resource
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabOrbitSkillCollection getSkills() throws IOException {
        return caller.fetch(get(GET_SKILLS), GitLabOrbitSkillCollection.class);
    }

    /**
     * Get skill ({@code GET /orbit/skills/{name}}).
     *
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabOrbitSkill> getSkill(final String name) throws IOException {
        requireNotBlank(name, "name");
        return caller.fetchOrEmpty(get(GET_SKILL, name), GitLabOrbitSkill.class);
    }

    /**
     * Get skill by path ({@code GET /orbit/skills/{name}/{path}}).
     *
     * @param name the name
     * @param path the path
     * @return the text of the body
     * @throws IllegalArgumentException if {@code name} or {@code path} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public String getSkillByPath(final String name, final String path) throws IOException {
        requireNotBlank(name, "name");
        requireNotBlank(path, "path");
        return fetchText(get(GET_SKILL_BY_PATH, name, path));
    }
}
