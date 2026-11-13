package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabCustomAttributesApi {

    private final LazyValue<GitLabInstanceCustomAttributesApi> instance;
    private final LazyValue<GitLabGroupCustomAttributesApi> group;
    private final LazyValue<GitLabProjectCustomAttributesApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabCustomAttributesApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceCustomAttributesApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupCustomAttributesApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectCustomAttributesApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceCustomAttributesApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupCustomAttributesApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectCustomAttributesApi project() {
        return project.get();
    }
}
