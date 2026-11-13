package io.github.piotr_janczukowicz.gitlab.api.notes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabNotesApi {

    private final LazyValue<GitLabGroupNotesApi> group;
    private final LazyValue<GitLabProjectNotesApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabNotesApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.group = new LazyValue<>(() -> new GitLabGroupNotesApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectNotesApi(caller));
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupNotesApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectNotesApi project() {
        return project.get();
    }
}
