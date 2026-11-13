package io.github.piotr_janczukowicz.gitlab.api.containerregistry;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryRepository;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabContainerRegistryTag;
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

/** The GitLab operations of project container registry. */
public final class GitLabProjectContainerRegistryApi extends GitLabResourceApi {
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_ID = "id";
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/registry/repositories");
    private static final PathTemplate DELETE = PathTemplate.of("/projects/{id}/registry/repositories/{repository_id}");
    private static final PathTemplate LIST_TAGS =
            PathTemplate.of("/projects/{id}/registry/repositories/{repository_id}/tags");
    private static final PathTemplate GET_TAG =
            PathTemplate.of("/projects/{id}/registry/repositories/{repository_id}/tags/{tag_name}");
    private static final PathTemplate GET = PathTemplate.of("/registry/repositories/{id}");
    private static final PathTemplate CREATE_CONTAINER_REGISTRY_EVENT_EVENT =
            PathTemplate.of("/container_registry_event/events");
    private static final JsonType<List<GitLabContainerRegistryRepository>> CONTAINER_REGISTRY_REPOSITORY_LIST_TYPE =
            JsonTypes.listOf(GitLabContainerRegistryRepository.class);
    private static final JsonType<List<GitLabContainerRegistryTag>> CONTAINER_REGISTRY_TAG_LIST_TYPE =
            JsonTypes.listOf(GitLabContainerRegistryTag.class);
    private static final GitLabListSpec<GitLabContainerRegistryRepository> CONTAINER_REGISTRY_REPOSITORY_SPEC =
            GitLabListSpec.offset(CONTAINER_REGISTRY_REPOSITORY_LIST_TYPE);
    private static final GitLabListSpec<GitLabContainerRegistryTag> CONTAINER_REGISTRY_TAG_KEYSET_SPEC =
            GitLabListSpec.offsetOrKeyset(CONTAINER_REGISTRY_TAG_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectContainerRegistryApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /projects/{id}/registry/repositories}).
     *
     * @param id the id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> list(final String id) throws IOException {
        return list(id, GitLabProjectContainerRegistryListFilter.empty(), GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/registry/repositories}).
     *
     * @param id the id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> list(final String id, final GitLabPageRequest request)
            throws IOException {
        return list(id, GitLabProjectContainerRegistryListFilter.empty(), request);
    }

    /**
     * List ({@code GET /projects/{id}/registry/repositories}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> list(
            final String id, final GitLabProjectContainerRegistryListFilter filter) throws IOException {
        return list(id, filter, GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /projects/{id}/registry/repositories}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} or {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryRepository> list(
            final String id, final GitLabProjectContainerRegistryListFilter filter, final GitLabPageRequest request)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        requireNonNull(request, "request");
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return pageList(LIST, queryParameters, request, CONTAINER_REGISTRY_REPOSITORY_SPEC, id);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/registry/repositories/{repository_id}}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final long repositoryId) throws IOException {
        requireNotBlank(id, PARAM_ID);
        caller.send(delete(DELETE, id, repositoryId));
    }

    /**
     * List tags ({@code GET /projects/{id}/registry/repositories/{repository_id}/tags}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryTag> listTags(final String id, final long repositoryId)
            throws IOException {
        return listTags(id, repositoryId, GitLabPageRequest.byPage());
    }

    /**
     * List tags ({@code GET /projects/{id}/registry/repositories/{repository_id}/tags}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabContainerRegistryTag> listTags(
            final String id, final long repositoryId, final GitLabPageRequest request) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(request, "request");
        return pageList(LIST_TAGS, Map.of(), request, CONTAINER_REGISTRY_TAG_KEYSET_SPEC, id, repositoryId);
    }

    /**
     * Delete tag ({@code DELETE /projects/{id}/registry/repositories/{repository_id}/tags}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteTag(final String id, final long repositoryId) throws IOException {
        deleteTag(id, repositoryId, GitLabProjectContainerRegistryDeleteTagFilter.empty());
    }

    /**
     * Delete tag ({@code DELETE /projects/{id}/registry/repositories/{repository_id}/tags}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @param filter the optional query parameters
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteTag(
            final String id, final long repositoryId, final GitLabProjectContainerRegistryDeleteTagFilter filter)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        caller.send(delete(LIST_TAGS, id, repositoryId).withQuery(queryParameters));
    }

    /**
     * Get tag ({@code GET /projects/{id}/registry/repositories/{repository_id}/tags/{tag_name}}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @param tagName the tag name
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabContainerRegistryTagDetails> getTag(
            final String id, final long repositoryId, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, "tagName");
        return caller.fetchOrEmpty(get(GET_TAG, id, repositoryId, tagName), GitLabContainerRegistryTagDetails.class);
    }

    /**
     * Delete tag by tag name ({@code DELETE /projects/{id}/registry/repositories/{repository_id}/tags/{tag_name}}).
     *
     * @param id the id
     * @param repositoryId the repository id
     * @param tagName the tag name
     * @throws IllegalArgumentException if {@code id} or {@code tagName} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteTagByTagName(final String id, final long repositoryId, final String tagName) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNotBlank(tagName, "tagName");
        caller.send(delete(GET_TAG, id, repositoryId, tagName));
    }

    /**
     * Get ({@code GET /registry/repositories/{id}}).
     *
     * @param id the id
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabContainerRegistryRepository> get(final String id) throws IOException {
        return get(id, GitLabProjectContainerRegistryGetFilter.empty());
    }

    /**
     * Get ({@code GET /registry/repositories/{id}}).
     *
     * @param id the id
     * @param filter the optional query parameters
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabContainerRegistryRepository> get(
            final String id, final GitLabProjectContainerRegistryGetFilter filter) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(filter, PARAM_FILTER);
        final Map<String, String> queryParameters =
                GitLabQueryParameters.builder().all(filter.toQueryParameters()).build();
        return caller.fetchOrEmpty(get(GET, id).withQuery(queryParameters), GitLabContainerRegistryRepository.class);
    }

    /**
     * Create container registry event event ({@code POST /container_registry_event/events}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createContainerRegistryEventEvent() throws IOException {
        caller.send(post(CREATE_CONTAINER_REGISTRY_EVENT_EVENT));
    }
}
