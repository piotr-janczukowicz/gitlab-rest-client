package io.github.piotr_janczukowicz.gitlab.api.resourcelabelevents;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabResourceLabelEventsApi {

    private final LazyValue<GitLabGroupResourceLabelEventsApi> group;
    private final LazyValue<GitLabProjectResourceLabelEventsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabResourceLabelEventsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupResourceLabelEventsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectResourceLabelEventsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupResourceLabelEventsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectResourceLabelEventsApi project() {
        return project.get();
    }
}
