package io.github.piotr_janczukowicz.gitlab.api.useremailaddresses;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabEmail;
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

/** The GitLab operations of user email addresses. */
public final class GitLabUserEmailAddressesApi extends GitLabResourceApi {
    private static final PathTemplate LIST = PathTemplate.of("/user/emails");
    private static final PathTemplate GET = PathTemplate.of("/user/emails/{email_id}");
    private static final JsonType<List<GitLabEmail>> EMAIL_LIST_TYPE = JsonTypes.listOf(GitLabEmail.class);
    private static final GitLabListSpec<GitLabEmail> EMAIL_SPEC = GitLabListSpec.offset(EMAIL_LIST_TYPE);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabUserEmailAddressesApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /user/emails}).
     *
     * @return the first page; the others are requested when they are asked for
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEmail> list() throws IOException {
        return list(GitLabPageRequest.byPage());
    }

    /**
     * List ({@code GET /user/emails}).
     *
     * @param request the page to start at
     * @return the first page; the others are requested when they are asked for
     * @throws NullPointerException if {@code request} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabPage<GitLabEmail> list(final GitLabPageRequest request) throws IOException {
        requireNonNull(request, "request");
        return pageList(LIST, Map.of(), request, EMAIL_SPEC);
    }

    /**
     * Create ({@code POST /user/emails}).
     *
     * @param payload the request body
     * @return the resource
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabEmail create(final GitLabUserEmailAddressesCreatePayload payload) throws IOException {
        requireNonNull(payload, "payload");
        return caller.fetch(caller.json(post(LIST), payload), GitLabEmail.class);
    }

    /**
     * Get ({@code GET /user/emails/{email_id}}).
     *
     * @param emailId the email id
     * @return the resource, or empty when GitLab answers 404
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabEmail> get(final long emailId) throws IOException {
        return caller.fetchOrEmpty(get(GET, emailId), GitLabEmail.class);
    }

    /**
     * Delete ({@code DELETE /user/emails/{email_id}}).
     *
     * @param emailId the email id
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final long emailId) throws IOException {
        caller.send(delete(GET, emailId));
    }
}
