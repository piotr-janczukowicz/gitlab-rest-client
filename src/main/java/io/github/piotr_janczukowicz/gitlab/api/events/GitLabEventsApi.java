package io.github.piotr_janczukowicz.gitlab.api.events;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabEventsApi {

    private final LazyValue<GitLabInstanceEventsApi> instance;
    private final LazyValue<GitLabProjectEventsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabEventsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceEventsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectEventsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceEventsApi instance() {
        return instance.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectEventsApi project() {
        return project.get();
    }
}
