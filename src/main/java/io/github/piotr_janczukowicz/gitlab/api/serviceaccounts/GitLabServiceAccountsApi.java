package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabServiceAccountsApi {

    private final LazyValue<GitLabInstanceServiceAccountsApi> instance;
    private final LazyValue<GitLabGroupServiceAccountsApi> group;
    private final LazyValue<GitLabProjectServiceAccountsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabServiceAccountsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceServiceAccountsApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupServiceAccountsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectServiceAccountsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceServiceAccountsApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupServiceAccountsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectServiceAccountsApi project() {
        return project.get();
    }
}
