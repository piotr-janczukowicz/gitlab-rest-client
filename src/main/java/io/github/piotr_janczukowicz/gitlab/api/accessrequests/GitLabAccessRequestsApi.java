package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabAccessRequestsApi {

    private final LazyValue<GitLabGroupAccessRequestsApi> group;
    private final LazyValue<GitLabProjectAccessRequestsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabAccessRequestsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupAccessRequestsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectAccessRequestsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupAccessRequestsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectAccessRequestsApi project() {
        return project.get();
    }
}
