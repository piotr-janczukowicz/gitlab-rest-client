package io.github.piotr_janczukowicz.gitlab.api.resourcestateevents;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabResourceStateEventsApi {

    private final LazyValue<GitLabGroupResourceStateEventsApi> group;
    private final LazyValue<GitLabProjectResourceStateEventsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabResourceStateEventsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupResourceStateEventsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectResourceStateEventsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupResourceStateEventsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectResourceStateEventsApi project() {
        return project.get();
    }
}
