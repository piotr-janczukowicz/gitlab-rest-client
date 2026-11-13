package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabLicense;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabTemplateList;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
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

/** The GitLab operations of project project templates. */
public final class GitLabProjectProjectTemplatesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/templates/{type}");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/templates/{type}/{name}");
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
    public GitLabProjectProjectTemplatesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/templates/{type}}).
     *
     * @param id the id
     * @param type the type
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code type} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTemplateList> list(final String id, final GitLabProjectProjectTemplatesListType type)
            throws IOException {
        return list(id, type, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/templates/{type}}).
     *
     * @param id the id
     * @param type the type
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code type} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabTemplateList> list(
            final String id, final GitLabProjectProjectTemplatesListType type, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(type, "type");
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, TEMPLATE_LIST_SPEC, id, type.wireValue());
    }

    /**
     * Get ({@code GET /projects/{id}/templates/{type}/{name}}).
     *
     * @param id the id
     * @param type the type
     * @param name the name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code type} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabLicense> get(
            final String id, final GitLabProjectProjectTemplatesGetType type, final String name) throws IOException {
        return get(id, type, name, GitLabProjectProjectTemplatesGetFilter.empty());
    }

    /**
     * Get ({@code GET /projects/{id}/templates/{type}/{name}}).
     *
     * @param id the id
     * @param type the type
     * @param name the name
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code name} is blank
     * @throws NullPointerException if {@code type} or {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabLicense> get(
            final String id,
            final GitLabProjectProjectTemplatesGetType type,
            final String name,
            final GitLabProjectProjectTemplatesGetFilter filter)
            throws IOException {
        requireNotBlank(id, "id");
        requireNonNull(type, "type");
        requireNotBlank(name, "name");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(
                get(GET, id, type.wireValue(), name).withQuery(queryParameters), GitLabLicense.class);
    }
}
