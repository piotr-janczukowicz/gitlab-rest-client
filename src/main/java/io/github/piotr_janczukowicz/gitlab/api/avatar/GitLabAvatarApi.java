package io.github.piotr_janczukowicz.gitlab.api.avatar;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabQueryParameters;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.http.MultipartFormData;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.Map;

/** The GitLab operations of avatar. */
public final class GitLabAvatarApi extends GitLabResourceApi {
    private static final PathTemplate AVATAR_USER = PathTemplate.of("/user/avatar");
    private static final PathTemplate GET = PathTemplate.of("/avatar");

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAvatarApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Avatar user ({@code PUT /user/avatar}).
     *
     * @param form the form to send
     * @return the resource
     * @throws NullPointerException if {@code form} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAvatar avatarUser(final MultipartFormData form) throws IOException {
        requireNonNull(form, "form");
        return caller.fetch(caller.multipart(put(AVATAR_USER), form), GitLabAvatar.class);
    }

    /**
     * Get ({@code GET /avatar}).
     *
     * @param email the email
     * @return the resource
     * @throws IllegalArgumentException if {@code email} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAvatar get(final String email) throws IOException {
        return get(email, GitLabAvatarGetFilter.empty());
    }

    /**
     * Get ({@code GET /avatar}).
     *
     * @param email the email
     * @param filter the optional query parameters
     * @return the resource
     * @throws IllegalArgumentException if {@code email} is blank
     * @throws NullPointerException if {@code filter} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabAvatar get(final String email, final GitLabAvatarGetFilter filter) throws IOException {
        requireNotBlank(email, "email");
        requireNonNull(filter, "filter");
        final Map<String, String> queryParameters = GitLabQueryParameters.builder()
                .all(filter.toQueryParameters())
                .text("email", email)
                .build();
        return caller.fetch(get(GET).withQuery(queryParameters), GitLabAvatar.class);
    }
}
