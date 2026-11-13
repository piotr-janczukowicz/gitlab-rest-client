package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabDiscussionsApi {

    private final LazyValue<GitLabGroupDiscussionsApi> group;
    private final LazyValue<GitLabProjectDiscussionsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabDiscussionsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupDiscussionsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectDiscussionsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupDiscussionsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectDiscussionsApi project() {
        return project.get();
    }
}
