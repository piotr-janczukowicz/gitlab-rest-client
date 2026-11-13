package io.github.piotr_janczukowicz.gitlab.api.issues;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabIssuesApi {

    private final LazyValue<GitLabInstanceIssuesApi> instance;
    private final LazyValue<GitLabGroupIssuesApi> group;
    private final LazyValue<GitLabProjectIssuesApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabIssuesApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceIssuesApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupIssuesApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectIssuesApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceIssuesApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupIssuesApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectIssuesApi project() {
        return project.get();
    }
}
