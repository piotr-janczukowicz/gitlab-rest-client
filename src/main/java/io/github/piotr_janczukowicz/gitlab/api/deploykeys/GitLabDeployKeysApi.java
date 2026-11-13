package io.github.piotr_janczukowicz.gitlab.api.deploykeys;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabDeployKeysApi {

    private final LazyValue<GitLabInstanceDeployKeysApi> instance;
    private final LazyValue<GitLabProjectDeployKeysApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDeployKeysApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceDeployKeysApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectDeployKeysApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceDeployKeysApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectDeployKeysApi project() {
        return project.get();
    }
}
