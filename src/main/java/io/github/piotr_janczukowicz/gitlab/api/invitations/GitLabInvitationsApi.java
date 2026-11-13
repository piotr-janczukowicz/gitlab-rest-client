package io.github.piotr_janczukowicz.gitlab.api.invitations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabInvitationsApi {

    private final LazyValue<GitLabGroupInvitationsApi> group;
    private final LazyValue<GitLabProjectInvitationsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabInvitationsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupInvitationsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectInvitationsApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupInvitationsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectInvitationsApi project() {
        return project.get();
    }
}
