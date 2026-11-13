package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabPagesDomainsApi {

    private final LazyValue<GitLabInstancePagesDomainsApi> instance;
    private final LazyValue<GitLabProjectPagesDomainsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabPagesDomainsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstancePagesDomainsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectPagesDomainsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstancePagesDomainsApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectPagesDomainsApi project() {
        return project.get();
    }
}
