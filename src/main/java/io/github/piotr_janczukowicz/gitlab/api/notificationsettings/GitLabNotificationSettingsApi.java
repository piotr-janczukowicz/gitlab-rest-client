package io.github.piotr_janczukowicz.gitlab.api.notificationsettings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.util.LazyValue;

/** The APIs of every scope of one resource. */
public final class GitLabNotificationSettingsApi {

    private final LazyValue<GitLabInstanceNotificationSettingsApi> instance;
    private final LazyValue<GitLabGroupNotificationSettingsApi> group;
    private final LazyValue<GitLabProjectNotificationSettingsApi> project;

    /**
     * The APIs over {@code caller}; each is created when it is first asked for.
     *
     * @param caller sends the calls of every API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabNotificationSettingsApi(final GitLabCaller caller) {
        requireNonNull(caller, "caller");
        this.instance = new LazyValue<>(() -> new GitLabInstanceNotificationSettingsApi(caller));
        this.group = new LazyValue<>(() -> new GitLabGroupNotificationSettingsApi(caller));
        this.project = new LazyValue<>(() -> new GitLabProjectNotificationSettingsApi(caller));
    }

    /**
     * The instance API.
     *
     * @return the API
     */
    public GitLabInstanceNotificationSettingsApi instance() {
        return instance.get();
    }

    /**
     * The group API.
     *
     * @return the API
     */
    public GitLabGroupNotificationSettingsApi group() {
        return group.get();
    }

    /**
     * The project API.
     *
     * @return the API
     */
    public GitLabProjectNotificationSettingsApi project() {
        return project.get();
    }
}
