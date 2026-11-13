package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabJobsApi {

    private final LazyValue<GitLabInstanceJobsApi> instance;
    private final LazyValue<GitLabProjectJobsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabJobsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceJobsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectJobsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceJobsApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectJobsApi project() {
        return project.get();
    }
}
