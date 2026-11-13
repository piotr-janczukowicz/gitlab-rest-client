package io.github.piotr_janczukowicz.gitlab.api.runners;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabRunnersApi {

    private final LazyValue<GitLabInstanceRunnersApi> instance;
    private final LazyValue<GitLabProjectRunnersApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabRunnersApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceRunnersApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectRunnersApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceRunnersApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectRunnersApi project() {
        return project.get();
    }
}
