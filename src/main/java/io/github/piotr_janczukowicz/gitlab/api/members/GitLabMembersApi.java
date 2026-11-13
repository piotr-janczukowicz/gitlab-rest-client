package io.github.piotr_janczukowicz.gitlab.api.members;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabMembersApi {

    private final LazyValue<GitLabGroupMembersApi> group;
    private final LazyValue<GitLabProjectMembersApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabMembersApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupMembersApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectMembersApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupMembersApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectMembersApi project() {
        return project.get();
    }
}
