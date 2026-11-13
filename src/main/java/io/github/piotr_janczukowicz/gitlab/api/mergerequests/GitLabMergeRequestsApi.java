package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabMergeRequestsApi {

    private final LazyValue<GitLabInstanceMergeRequestsApi> instance;
    private final LazyValue<GitLabGroupMergeRequestsApi> group;
    private final LazyValue<GitLabProjectMergeRequestsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabMergeRequestsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceMergeRequestsApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupMergeRequestsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectMergeRequestsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceMergeRequestsApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupMergeRequestsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectMergeRequestsApi project() {
        return project.get();
    }
}
