package io.github.piotr_janczukowicz.gitlab.api.gitlabcicdyamltemplates;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTemplate;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTemplateList;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.pagination.GitLabListSpec;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPage;
import io.github.piotr_janczukowicz.gitlab.pagination.GitLabPageRequest;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** The GitLab operations of cicdyamltemplates. */
public final class GitLabCICDYAMLTemplatesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/templates/gitlab_ci_ymls");
    private static final PathTemplate GET = PathTemplate.of("/templates/gitlab_ci_ymls/{name}");
    private static final JsonType<List<GitLabTemplateList>> TEMPLATE_LIST_LIST_TYPE =
            JsonTypes.listOf(GitLabTemplateList.class);
    private static final GitLabListSpec<GitLabTemplateList> TEMPLATE_LIST_SPEC =
            GitLabListSpec.offset(TEMPLATE_LIST_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCICDYAMLTemplatesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /templates/gitlab_ci_ymls}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTemplateList> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /templates/gitlab_ci_ymls}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTemplateList> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, TEMPLATE_LIST_SPEC);
    }

    /**
     * Get ({@code GET /templates/gitlab_ci_ymls/{name}}).
     *
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code name} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabTemplate> get(final String name) throws IOException {
        requireNotBlank(name, "name");
        return caller.fetchOrEmpty(get(GET, name), GitLabTemplate.class);
    }
}
