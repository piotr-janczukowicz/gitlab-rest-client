package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabFeatureFlagsApi {

    private final LazyValue<GitLabInstanceFeatureFlagsApi> instance;
    private final LazyValue<GitLabProjectFeatureFlagsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabFeatureFlagsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceFeatureFlagsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectFeatureFlagsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceFeatureFlagsApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectFeatureFlagsApi project() {
        return project.get();
    }
}
