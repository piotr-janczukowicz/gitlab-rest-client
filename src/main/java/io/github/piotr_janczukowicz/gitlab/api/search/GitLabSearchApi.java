package io.github.piotr_janczukowicz.gitlab.api.search;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabSearchApi {

    private final LazyValue<GitLabInstanceSearchApi> instance;
    private final LazyValue<GitLabGroupSearchApi> group;
    private final LazyValue<GitLabProjectSearchApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabSearchApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceSearchApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupSearchApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectSearchApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceSearchApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupSearchApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectSearchApi project() {
        return project.get();
    }
}
