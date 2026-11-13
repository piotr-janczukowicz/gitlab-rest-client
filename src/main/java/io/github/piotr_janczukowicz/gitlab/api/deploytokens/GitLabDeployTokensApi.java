package io.github.piotr_janczukowicz.gitlab.api.deploytokens;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabDeployTokensApi {

    private final LazyValue<GitLabInstanceDeployTokensApi> instance;
    private final LazyValue<GitLabGroupDeployTokensApi> group;
    private final LazyValue<GitLabProjectDeployTokensApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDeployTokensApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceDeployTokensApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupDeployTokensApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectDeployTokensApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceDeployTokensApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupDeployTokensApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectDeployTokensApi project() {
        return project.get();
    }
}
