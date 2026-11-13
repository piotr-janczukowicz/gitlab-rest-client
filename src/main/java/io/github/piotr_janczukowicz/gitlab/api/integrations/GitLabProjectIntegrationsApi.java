package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;
import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNotBlank;

import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegration;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabIntegrationBasic;
import io.github.piotr_janczukowicz.gitlab.client.GitLabCaller;
import io.github.piotr_janczukowicz.gitlab.client.GitLabResourceApi;
import io.github.piotr_janczukowicz.gitlab.client.GitLabTier;
import io.github.piotr_janczukowicz.gitlab.client.RequiresTier;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabApiException;
import io.github.piotr_janczukowicz.gitlab.client.exception.GitLabTierException;
import io.github.piotr_janczukowicz.json.JsonType;
import io.github.piotr_janczukowicz.json.JsonTypes;
import io.github.piotr_janczukowicz.uri.PathTemplate;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/** The GitLab operations of project integrations. */
public final class GitLabProjectIntegrationsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final String PARAM_SLUG = "slug";
    private static final PathTemplate CREATE_SLACK_OPTION = PathTemplate.of("/integrations/slack/options");
    private static final PathTemplate CREATE_SLACK_INTERACTION = PathTemplate.of("/integrations/slack/interactions");
    private static final PathTemplate CREATE_SLACK_EVENT = PathTemplate.of("/integrations/slack/events");
    private static final PathTemplate LIST_SERVICES = PathTemplate.of("/projects/{id}/services");
    private static final PathTemplate APPLE_APP_STORE_SERVICE =
            PathTemplate.of("/projects/{id}/services/apple-app-store");
    private static final PathTemplate ASANA_SERVICE = PathTemplate.of("/projects/{id}/services/asana");
    private static final PathTemplate ASSEMBLA_SERVICE = PathTemplate.of("/projects/{id}/services/assembla");
    private static final PathTemplate BAMBOO_SERVICE = PathTemplate.of("/projects/{id}/services/bamboo");
    private static final PathTemplate BUGZILLA_SERVICE = PathTemplate.of("/projects/{id}/services/bugzilla");
    private static final PathTemplate BUILDKITE_SERVICE = PathTemplate.of("/projects/{id}/services/buildkite");
    private static final PathTemplate CAMPFIRE_SERVICE = PathTemplate.of("/projects/{id}/services/campfire");
    private static final PathTemplate CONFLUENCE_SERVICE = PathTemplate.of("/projects/{id}/services/confluence");
    private static final PathTemplate CUSTOM_ISSUE_TRACKER_SERVICE =
            PathTemplate.of("/projects/{id}/services/custom-issue-tracker");
    private static final PathTemplate DATADOG_SERVICE = PathTemplate.of("/projects/{id}/services/datadog");
    private static final PathTemplate DIFFBLUE_COVER_SERVICE =
            PathTemplate.of("/projects/{id}/services/diffblue-cover");
    private static final PathTemplate DISCORD_SERVICE = PathTemplate.of("/projects/{id}/services/discord");
    private static final PathTemplate DRONE_CI_SERVICE = PathTemplate.of("/projects/{id}/services/drone-ci");
    private static final PathTemplate EMAILS_ON_PUSH_SERVICE =
            PathTemplate.of("/projects/{id}/services/emails-on-push");
    private static final PathTemplate EXTERNAL_WIKI_SERVICE = PathTemplate.of("/projects/{id}/services/external-wiki");
    private static final PathTemplate GITLAB_SLACK_APPLICATION_SERVICE =
            PathTemplate.of("/projects/{id}/services/gitlab-slack-application");
    private static final PathTemplate GOOGLE_PLAY_SERVICE = PathTemplate.of("/projects/{id}/services/google-play");
    private static final PathTemplate HANGOUTS_CHAT_SERVICE = PathTemplate.of("/projects/{id}/services/hangouts-chat");
    private static final PathTemplate HARBOR_SERVICE = PathTemplate.of("/projects/{id}/services/harbor");
    private static final PathTemplate IRKER_SERVICE = PathTemplate.of("/projects/{id}/services/irker");
    private static final PathTemplate UPDATE_SERVICES_JENKIN = PathTemplate.of("/projects/{id}/services/jenkins");
    private static final PathTemplate JIRA_SERVICE = PathTemplate.of("/projects/{id}/services/jira");
    private static final PathTemplate JIRA_CLOUD_APP_SERVICE =
            PathTemplate.of("/projects/{id}/services/jira-cloud-app");
    private static final PathTemplate LINEAR_SERVICE = PathTemplate.of("/projects/{id}/services/linear");
    private static final PathTemplate MATRIX_SERVICE = PathTemplate.of("/projects/{id}/services/matrix");
    private static final PathTemplate UPDATE_SERVICES_MATTERMOST_SLASH_COMMAND =
            PathTemplate.of("/projects/{id}/services/mattermost-slash-commands");
    private static final PathTemplate PACKAGIST_SERVICE = PathTemplate.of("/projects/{id}/services/packagist");
    private static final PathTemplate PHORGE_SERVICE = PathTemplate.of("/projects/{id}/services/phorge");
    private static final PathTemplate PIPELINES_EMAIL_SERVICE =
            PathTemplate.of("/projects/{id}/services/pipelines-email");
    private static final PathTemplate PIVOTALTRACKER_SERVICE =
            PathTemplate.of("/projects/{id}/services/pivotaltracker");
    private static final PathTemplate PUMBLE_SERVICE = PathTemplate.of("/projects/{id}/services/pumble");
    private static final PathTemplate PUSHOVER_SERVICE = PathTemplate.of("/projects/{id}/services/pushover");
    private static final PathTemplate REDMINE_SERVICE = PathTemplate.of("/projects/{id}/services/redmine");
    private static final PathTemplate EWM_SERVICE = PathTemplate.of("/projects/{id}/services/ewm");
    private static final PathTemplate YOUTRACK_SERVICE = PathTemplate.of("/projects/{id}/services/youtrack");
    private static final PathTemplate CLICKUP_SERVICE = PathTemplate.of("/projects/{id}/services/clickup");
    private static final PathTemplate SLACK_SERVICE = PathTemplate.of("/projects/{id}/services/slack");
    private static final PathTemplate UPDATE_SERVICES_MICROSOFT_TEAM =
            PathTemplate.of("/projects/{id}/services/microsoft-teams");
    private static final PathTemplate MATTERMOST_SERVICE = PathTemplate.of("/projects/{id}/services/mattermost");
    private static final PathTemplate TEAMCITY_SERVICE = PathTemplate.of("/projects/{id}/services/teamcity");
    private static final PathTemplate TELEGRAM_SERVICE = PathTemplate.of("/projects/{id}/services/telegram");
    private static final PathTemplate UNIFY_CIRCUIT_SERVICE = PathTemplate.of("/projects/{id}/services/unify-circuit");
    private static final PathTemplate UPDATE_SERVICES_WEBEX_TEAM =
            PathTemplate.of("/projects/{id}/services/webex-teams");
    private static final PathTemplate ZENTAO_SERVICE = PathTemplate.of("/projects/{id}/services/zentao");
    private static final PathTemplate SQUASH_TM_SERVICE = PathTemplate.of("/projects/{id}/services/squash-tm");
    private static final PathTemplate GITHUB_SERVICE = PathTemplate.of("/projects/{id}/services/github");
    private static final PathTemplate GIT_GUARDIAN_SERVICE = PathTemplate.of("/projects/{id}/services/git-guardian");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTRY =
            PathTemplate.of("/projects/{id}/services/google-cloud-platform-artifact-registry");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTITY =
            PathTemplate.of("/projects/{id}/services/google-cloud-platform-workload-identity-federation");
    private static final PathTemplate MOCK_CI_SERVICE = PathTemplate.of("/projects/{id}/services/mock-ci");
    private static final PathTemplate MOCK_MONITORING_SERVICE =
            PathTemplate.of("/projects/{id}/services/mock-monitoring");
    private static final PathTemplate GET_SERVICE = PathTemplate.of("/projects/{id}/services/{slug}");
    private static final PathTemplate TRIGGER_SERVICES_MATTERMOST_SLASH_COMMAN =
            PathTemplate.of("/projects/{id}/services/mattermost_slash_commands/trigger");
    private static final PathTemplate LIST = PathTemplate.of("/projects/{id}/integrations");
    private static final PathTemplate APPLE_APP_STORE = PathTemplate.of("/projects/{id}/integrations/apple-app-store");
    private static final PathTemplate ASANA = PathTemplate.of("/projects/{id}/integrations/asana");
    private static final PathTemplate ASSEMBLA = PathTemplate.of("/projects/{id}/integrations/assembla");
    private static final PathTemplate BAMBOO = PathTemplate.of("/projects/{id}/integrations/bamboo");
    private static final PathTemplate BUGZILLA = PathTemplate.of("/projects/{id}/integrations/bugzilla");
    private static final PathTemplate BUILDKITE = PathTemplate.of("/projects/{id}/integrations/buildkite");
    private static final PathTemplate CAMPFIRE = PathTemplate.of("/projects/{id}/integrations/campfire");
    private static final PathTemplate CONFLUENCE = PathTemplate.of("/projects/{id}/integrations/confluence");
    private static final PathTemplate CUSTOM_ISSUE_TRACKER =
            PathTemplate.of("/projects/{id}/integrations/custom-issue-tracker");
    private static final PathTemplate DATADOG = PathTemplate.of("/projects/{id}/integrations/datadog");
    private static final PathTemplate DIFFBLUE_COVER = PathTemplate.of("/projects/{id}/integrations/diffblue-cover");
    private static final PathTemplate DISCORD = PathTemplate.of("/projects/{id}/integrations/discord");
    private static final PathTemplate DRONE_CI = PathTemplate.of("/projects/{id}/integrations/drone-ci");
    private static final PathTemplate EMAILS_ON_PUSH = PathTemplate.of("/projects/{id}/integrations/emails-on-push");
    private static final PathTemplate EXTERNAL_WIKI = PathTemplate.of("/projects/{id}/integrations/external-wiki");
    private static final PathTemplate GITLAB_SLACK_APPLICATION =
            PathTemplate.of("/projects/{id}/integrations/gitlab-slack-application");
    private static final PathTemplate GOOGLE_PLAY = PathTemplate.of("/projects/{id}/integrations/google-play");
    private static final PathTemplate HANGOUTS_CHAT = PathTemplate.of("/projects/{id}/integrations/hangouts-chat");
    private static final PathTemplate HARBOR = PathTemplate.of("/projects/{id}/integrations/harbor");
    private static final PathTemplate IRKER = PathTemplate.of("/projects/{id}/integrations/irker");
    private static final PathTemplate UPDATE_JENKIN = PathTemplate.of("/projects/{id}/integrations/jenkins");
    private static final PathTemplate JIRA = PathTemplate.of("/projects/{id}/integrations/jira");
    private static final PathTemplate JIRA_CLOUD_APP = PathTemplate.of("/projects/{id}/integrations/jira-cloud-app");
    private static final PathTemplate LINEAR = PathTemplate.of("/projects/{id}/integrations/linear");
    private static final PathTemplate MATRIX = PathTemplate.of("/projects/{id}/integrations/matrix");
    private static final PathTemplate UPDATE_MATTERMOST_SLASH_COMMAND =
            PathTemplate.of("/projects/{id}/integrations/mattermost-slash-commands");
    private static final PathTemplate PACKAGIST = PathTemplate.of("/projects/{id}/integrations/packagist");
    private static final PathTemplate PHORGE = PathTemplate.of("/projects/{id}/integrations/phorge");
    private static final PathTemplate PIPELINES_EMAIL = PathTemplate.of("/projects/{id}/integrations/pipelines-email");
    private static final PathTemplate PIVOTALTRACKER = PathTemplate.of("/projects/{id}/integrations/pivotaltracker");
    private static final PathTemplate PUMBLE = PathTemplate.of("/projects/{id}/integrations/pumble");
    private static final PathTemplate PUSHOVER = PathTemplate.of("/projects/{id}/integrations/pushover");
    private static final PathTemplate REDMINE = PathTemplate.of("/projects/{id}/integrations/redmine");
    private static final PathTemplate EWM = PathTemplate.of("/projects/{id}/integrations/ewm");
    private static final PathTemplate YOUTRACK = PathTemplate.of("/projects/{id}/integrations/youtrack");
    private static final PathTemplate CLICKUP = PathTemplate.of("/projects/{id}/integrations/clickup");
    private static final PathTemplate SLACK = PathTemplate.of("/projects/{id}/integrations/slack");
    private static final PathTemplate UPDATE_MICROSOFT_TEAM =
            PathTemplate.of("/projects/{id}/integrations/microsoft-teams");
    private static final PathTemplate MATTERMOST = PathTemplate.of("/projects/{id}/integrations/mattermost");
    private static final PathTemplate TEAMCITY = PathTemplate.of("/projects/{id}/integrations/teamcity");
    private static final PathTemplate TELEGRAM = PathTemplate.of("/projects/{id}/integrations/telegram");
    private static final PathTemplate UNIFY_CIRCUIT = PathTemplate.of("/projects/{id}/integrations/unify-circuit");
    private static final PathTemplate UPDATE_WEBEX_TEAM = PathTemplate.of("/projects/{id}/integrations/webex-teams");
    private static final PathTemplate ZENTAO = PathTemplate.of("/projects/{id}/integrations/zentao");
    private static final PathTemplate SQUASH_TM = PathTemplate.of("/projects/{id}/integrations/squash-tm");
    private static final PathTemplate GITHUB = PathTemplate.of("/projects/{id}/integrations/github");
    private static final PathTemplate GIT_GUARDIAN = PathTemplate.of("/projects/{id}/integrations/git-guardian");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTR_2 =
            PathTemplate.of("/projects/{id}/integrations/google-cloud-platform-artifact-registry");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTIT_2 =
            PathTemplate.of("/projects/{id}/integrations/google-cloud-platform-workload-identity-federation");
    private static final PathTemplate MOCK_CI = PathTemplate.of("/projects/{id}/integrations/mock-ci");
    private static final PathTemplate MOCK_MONITORING = PathTemplate.of("/projects/{id}/integrations/mock-monitoring");
    private static final PathTemplate GET = PathTemplate.of("/projects/{id}/integrations/{slug}");
    private static final PathTemplate TRIGGER_MATTERMOST_SLASH_COMMAND =
            PathTemplate.of("/projects/{id}/integrations/mattermost_slash_commands/trigger");
    private static final PathTemplate TRIGGER_SLACK = PathTemplate.of("/slack/trigger");
    private static final JsonType<List<GitLabIntegrationBasic>> INTEGRATION_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabIntegrationBasic.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabProjectIntegrationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * Create slack option ({@code POST /integrations/slack/options}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createSlackOption() throws IOException {
        caller.send(post(CREATE_SLACK_OPTION));
    }

    /**
     * Create slack interaction ({@code POST /integrations/slack/interactions}).
     *
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createSlackInteraction() throws IOException {
        caller.send(post(CREATE_SLACK_INTERACTION));
    }

    /**
     * Create slack event ({@code POST /integrations/slack/events}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void createSlackEvent(final GitLabProjectIntegrationsCreateSlackEventPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(CREATE_SLACK_EVENT), payload));
    }

    /**
     * List services ({@code GET /projects/{id}/services}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabIntegrationBasic> listServices(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST_SERVICES, id), INTEGRATION_BASIC_LIST_TYPE);
    }

    /**
     * Apple app store service ({@code PUT /projects/{id}/services/apple-app-store}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic appleAppStoreService(
            final String id, final GitLabProjectIntegrationsAppleAppStoreServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(APPLE_APP_STORE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Asana service ({@code PUT /projects/{id}/services/asana}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic asanaService(
            final String id, final GitLabProjectIntegrationsAsanaServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASANA_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Assembla service ({@code PUT /projects/{id}/services/assembla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic assemblaService(
            final String id, final GitLabProjectIntegrationsAssemblaServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASSEMBLA_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bamboo service ({@code PUT /projects/{id}/services/bamboo}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bambooService(
            final String id, final GitLabProjectIntegrationsBambooServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BAMBOO_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bugzilla service ({@code PUT /projects/{id}/services/bugzilla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bugzillaService(
            final String id, final GitLabProjectIntegrationsBugzillaServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUGZILLA_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Buildkite service ({@code PUT /projects/{id}/services/buildkite}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic buildkiteService(
            final String id, final GitLabProjectIntegrationsBuildkiteServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUILDKITE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Campfire service ({@code PUT /projects/{id}/services/campfire}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic campfireService(
            final String id, final GitLabProjectIntegrationsCampfireServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CAMPFIRE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Confluence service ({@code PUT /projects/{id}/services/confluence}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic confluenceService(
            final String id, final GitLabProjectIntegrationsConfluenceServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CONFLUENCE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Custom issue tracker service ({@code PUT /projects/{id}/services/custom-issue-tracker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic customIssueTrackerService(
            final String id, final GitLabProjectIntegrationsCustomIssueTrackerServicePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CUSTOM_ISSUE_TRACKER_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Datadog service ({@code PUT /projects/{id}/services/datadog}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic datadogService(
            final String id, final GitLabProjectIntegrationsDatadogServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DATADOG_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Diffblue cover service ({@code PUT /projects/{id}/services/diffblue-cover}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic diffblueCoverService(
            final String id, final GitLabProjectIntegrationsDiffblueCoverServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DIFFBLUE_COVER_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Discord service ({@code PUT /projects/{id}/services/discord}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic discordService(
            final String id, final GitLabProjectIntegrationsDiscordServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DISCORD_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Drone ci service ({@code PUT /projects/{id}/services/drone-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic droneCiService(
            final String id, final GitLabProjectIntegrationsDroneCiServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DRONE_CI_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Emails on push service ({@code PUT /projects/{id}/services/emails-on-push}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic emailsOnPushService(
            final String id, final GitLabProjectIntegrationsEmailsOnPushServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EMAILS_ON_PUSH_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * External wiki service ({@code PUT /projects/{id}/services/external-wiki}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic externalWikiService(
            final String id, final GitLabProjectIntegrationsExternalWikiServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EXTERNAL_WIKI_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Gitlab slack application service ({@code PUT /projects/{id}/services/gitlab-slack-application}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic gitlabSlackApplicationService(
            final String id, final GitLabProjectIntegrationsGitlabSlackApplicationServicePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GITLAB_SLACK_APPLICATION_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google play service ({@code PUT /projects/{id}/services/google-play}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googlePlayService(
            final String id, final GitLabProjectIntegrationsGooglePlayServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GOOGLE_PLAY_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Hangouts chat service ({@code PUT /projects/{id}/services/hangouts-chat}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic hangoutsChatService(
            final String id, final GitLabProjectIntegrationsHangoutsChatServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HANGOUTS_CHAT_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Harbor service ({@code PUT /projects/{id}/services/harbor}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic harborService(
            final String id, final GitLabProjectIntegrationsHarborServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HARBOR_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Irker service ({@code PUT /projects/{id}/services/irker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic irkerService(
            final String id, final GitLabProjectIntegrationsIrkerServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(IRKER_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update services jenkin ({@code PUT /projects/{id}/services/jenkins}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateServicesJenkin(
            final String id, final GitLabProjectIntegrationsUpdateServicesJenkinPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_SERVICES_JENKIN, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira service ({@code PUT /projects/{id}/services/jira}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic jiraService(
            final String id, final GitLabProjectIntegrationsJiraServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira cloud app service ({@code PUT /projects/{id}/services/jira-cloud-app}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic jiraCloudAppService(
            final String id, final GitLabProjectIntegrationsJiraCloudAppServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA_CLOUD_APP_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Linear service ({@code PUT /projects/{id}/services/linear}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic linearService(
            final String id, final GitLabProjectIntegrationsLinearServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(LINEAR_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Matrix service ({@code PUT /projects/{id}/services/matrix}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic matrixService(
            final String id, final GitLabProjectIntegrationsMatrixServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATRIX_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update services mattermost slash command ({@code PUT /projects/{id}/services/mattermost-slash-commands}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateServicesMattermostSlashCommand(
            final String id, final GitLabProjectIntegrationsUpdateServicesMattermostSlashCommandPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_SERVICES_MATTERMOST_SLASH_COMMAND, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Packagist service ({@code PUT /projects/{id}/services/packagist}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic packagistService(
            final String id, final GitLabProjectIntegrationsPackagistServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PACKAGIST_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Phorge service ({@code PUT /projects/{id}/services/phorge}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic phorgeService(
            final String id, final GitLabProjectIntegrationsPhorgeServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PHORGE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pipelines email service ({@code PUT /projects/{id}/services/pipelines-email}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pipelinesEmailService(
            final String id, final GitLabProjectIntegrationsPipelinesEmailServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIPELINES_EMAIL_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pivotaltracker service ({@code PUT /projects/{id}/services/pivotaltracker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pivotaltrackerService(
            final String id, final GitLabProjectIntegrationsPivotaltrackerServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIVOTALTRACKER_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pumble service ({@code PUT /projects/{id}/services/pumble}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pumbleService(
            final String id, final GitLabProjectIntegrationsPumbleServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUMBLE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pushover service ({@code PUT /projects/{id}/services/pushover}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pushoverService(
            final String id, final GitLabProjectIntegrationsPushoverServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUSHOVER_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Redmine service ({@code PUT /projects/{id}/services/redmine}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic redmineService(
            final String id, final GitLabProjectIntegrationsRedmineServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(REDMINE_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Ewm service ({@code PUT /projects/{id}/services/ewm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic ewmService(final String id, final GitLabProjectIntegrationsEwmServicePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EWM_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Youtrack service ({@code PUT /projects/{id}/services/youtrack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic youtrackService(
            final String id, final GitLabProjectIntegrationsYoutrackServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(YOUTRACK_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Clickup service ({@code PUT /projects/{id}/services/clickup}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic clickupService(
            final String id, final GitLabProjectIntegrationsClickupServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CLICKUP_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Slack service ({@code PUT /projects/{id}/services/slack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic slackService(
            final String id, final GitLabProjectIntegrationsSlackServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SLACK_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update services microsoft team ({@code PUT /projects/{id}/services/microsoft-teams}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateServicesMicrosoftTeam(
            final String id, final GitLabProjectIntegrationsUpdateServicesMicrosoftTeamPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_SERVICES_MICROSOFT_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mattermost service ({@code PUT /projects/{id}/services/mattermost}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mattermostService(
            final String id, final GitLabProjectIntegrationsMattermostServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATTERMOST_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Teamcity service ({@code PUT /projects/{id}/services/teamcity}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic teamcityService(
            final String id, final GitLabProjectIntegrationsTeamcityServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TEAMCITY_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Telegram service ({@code PUT /projects/{id}/services/telegram}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic telegramService(
            final String id, final GitLabProjectIntegrationsTelegramServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TELEGRAM_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Unify circuit service ({@code PUT /projects/{id}/services/unify-circuit}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic unifyCircuitService(
            final String id, final GitLabProjectIntegrationsUnifyCircuitServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UNIFY_CIRCUIT_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update services webex team ({@code PUT /projects/{id}/services/webex-teams}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateServicesWebexTeam(
            final String id, final GitLabProjectIntegrationsUpdateServicesWebexTeamPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_SERVICES_WEBEX_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Zentao service ({@code PUT /projects/{id}/services/zentao}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic zentaoService(
            final String id, final GitLabProjectIntegrationsZentaoServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ZENTAO_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Squash tm service ({@code PUT /projects/{id}/services/squash-tm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic squashTmService(
            final String id, final GitLabProjectIntegrationsSquashTmServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SQUASH_TM_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Github service ({@code PUT /projects/{id}/services/github}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIntegrationBasic githubService(
            final String id, final GitLabProjectIntegrationsGithubServicePayload payload) throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdServicesGithub");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GITHUB_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Git guardian service ({@code PUT /projects/{id}/services/git-guardian}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic gitGuardianService(
            final String id, final GitLabProjectIntegrationsGitGuardianServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GIT_GUARDIAN_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform artifact registry service ({@code PUT
     * /projects/{id}/services/google-cloud-platform-artifact-registry}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googleCloudPlatformArtifactRegistryService(
            final String id, final GitLabProjectServiceGoogleCloudArtifactRegistryPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTRY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform workload identity federation service ({@code PUT
     * /projects/{id}/services/google-cloud-platform-workload-identity-federation}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googleCloudPlatformWorkloadIdentityFederationService(
            final String id, final GitLabProjectServiceGoogleCloudWorkloadIdentityFederationPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTITY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock ci service ({@code PUT /projects/{id}/services/mock-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mockCiService(
            final String id, final GitLabProjectIntegrationsMockCiServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_CI_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock monitoring service ({@code PUT /projects/{id}/services/mock-monitoring}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mockMonitoringService(
            final String id, final GitLabProjectIntegrationsMockMonitoringServicePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_MONITORING_SERVICE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Get service ({@code GET /projects/{id}/services/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIntegration> getService(final String id, final GitLabProjectIntegrationsGetServiceSlug slug)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, PARAM_SLUG);
        return caller.fetchOrEmpty(get(GET_SERVICE, id, slug.wireValue()), GitLabIntegration.class);
    }

    /**
     * Delete service ({@code DELETE /projects/{id}/services/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void deleteService(final String id, final GitLabProjectIntegrationsDeleteServiceSlug slug)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, PARAM_SLUG);
        caller.send(delete(GET_SERVICE, id, slug.wireValue()));
    }

    /**
     * Trigger services mattermost slash command ({@code POST
     * /projects/{id}/services/mattermost_slash_commands/trigger}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void triggerServicesMattermostSlashCommand(
            final String id, final GitLabProjectIntegrationsTriggerServicesMattermostSlashCommandPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(TRIGGER_SERVICES_MATTERMOST_SLASH_COMMAN, id), payload));
    }

    /**
     * List ({@code GET /projects/{id}/integrations}).
     *
     * @param id the id
     * @return the items
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public List<GitLabIntegrationBasic> list(final String id) throws IOException {
        requireNotBlank(id, PARAM_ID);
        return caller.fetch(get(LIST, id), INTEGRATION_BASIC_LIST_TYPE);
    }

    /**
     * Apple app store ({@code PUT /projects/{id}/integrations/apple-app-store}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic appleAppStore(
            final String id, final GitLabProjectIntegrationsAppleAppStorePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(APPLE_APP_STORE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Asana ({@code PUT /projects/{id}/integrations/asana}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic asana(final String id, final GitLabProjectIntegrationsAsanaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASANA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Assembla ({@code PUT /projects/{id}/integrations/assembla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic assembla(final String id, final GitLabProjectIntegrationsAssemblaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASSEMBLA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bamboo ({@code PUT /projects/{id}/integrations/bamboo}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bamboo(final String id, final GitLabProjectIntegrationsBambooPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BAMBOO, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bugzilla ({@code PUT /projects/{id}/integrations/bugzilla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bugzilla(final String id, final GitLabProjectIntegrationsBugzillaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUGZILLA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Buildkite ({@code PUT /projects/{id}/integrations/buildkite}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic buildkite(final String id, final GitLabProjectIntegrationsBuildkitePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUILDKITE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Campfire ({@code PUT /projects/{id}/integrations/campfire}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic campfire(final String id, final GitLabProjectIntegrationsCampfirePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CAMPFIRE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Confluence ({@code PUT /projects/{id}/integrations/confluence}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic confluence(final String id, final GitLabProjectIntegrationsConfluencePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CONFLUENCE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Custom issue tracker ({@code PUT /projects/{id}/integrations/custom-issue-tracker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic customIssueTracker(
            final String id, final GitLabProjectIntegrationsCustomIssueTrackerPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CUSTOM_ISSUE_TRACKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Datadog ({@code PUT /projects/{id}/integrations/datadog}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic datadog(final String id, final GitLabProjectIntegrationsDatadogPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DATADOG, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Diffblue cover ({@code PUT /projects/{id}/integrations/diffblue-cover}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic diffblueCover(
            final String id, final GitLabProjectIntegrationsDiffblueCoverPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DIFFBLUE_COVER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Discord ({@code PUT /projects/{id}/integrations/discord}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic discord(final String id, final GitLabProjectIntegrationsDiscordPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DISCORD, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Drone ci ({@code PUT /projects/{id}/integrations/drone-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic droneCi(final String id, final GitLabProjectIntegrationsDroneCiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DRONE_CI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Emails on push ({@code PUT /projects/{id}/integrations/emails-on-push}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic emailsOnPush(
            final String id, final GitLabProjectIntegrationsEmailsOnPushPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EMAILS_ON_PUSH, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * External wiki ({@code PUT /projects/{id}/integrations/external-wiki}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic externalWiki(
            final String id, final GitLabProjectIntegrationsExternalWikiPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EXTERNAL_WIKI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Gitlab slack application ({@code PUT /projects/{id}/integrations/gitlab-slack-application}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic gitlabSlackApplication(
            final String id, final GitLabProjectIntegrationsGitlabSlackApplicationPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GITLAB_SLACK_APPLICATION, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google play ({@code PUT /projects/{id}/integrations/google-play}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googlePlay(final String id, final GitLabProjectIntegrationsGooglePlayPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GOOGLE_PLAY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Hangouts chat ({@code PUT /projects/{id}/integrations/hangouts-chat}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic hangoutsChat(
            final String id, final GitLabProjectIntegrationsHangoutsChatPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HANGOUTS_CHAT, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Harbor ({@code PUT /projects/{id}/integrations/harbor}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic harbor(final String id, final GitLabProjectIntegrationsHarborPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HARBOR, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Irker ({@code PUT /projects/{id}/integrations/irker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic irker(final String id, final GitLabProjectIntegrationsIrkerPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(IRKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update jenkin ({@code PUT /projects/{id}/integrations/jenkins}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateJenkin(
            final String id, final GitLabProjectIntegrationsUpdateJenkinPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_JENKIN, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira ({@code PUT /projects/{id}/integrations/jira}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic jira(final String id, final GitLabProjectIntegrationsJiraPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira cloud app ({@code PUT /projects/{id}/integrations/jira-cloud-app}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic jiraCloudApp(
            final String id, final GitLabProjectIntegrationsJiraCloudAppPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA_CLOUD_APP, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Linear ({@code PUT /projects/{id}/integrations/linear}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic linear(final String id, final GitLabProjectIntegrationsLinearPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(LINEAR, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Matrix ({@code PUT /projects/{id}/integrations/matrix}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic matrix(final String id, final GitLabProjectIntegrationsMatrixPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATRIX, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update mattermost slash command ({@code PUT /projects/{id}/integrations/mattermost-slash-commands}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateMattermostSlashCommand(
            final String id, final GitLabProjectIntegrationsUpdateMattermostSlashCommandPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_MATTERMOST_SLASH_COMMAND, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Packagist ({@code PUT /projects/{id}/integrations/packagist}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic packagist(final String id, final GitLabProjectIntegrationsPackagistPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PACKAGIST, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Phorge ({@code PUT /projects/{id}/integrations/phorge}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic phorge(final String id, final GitLabProjectIntegrationsPhorgePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PHORGE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pipelines email ({@code PUT /projects/{id}/integrations/pipelines-email}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pipelinesEmail(
            final String id, final GitLabProjectIntegrationsPipelinesEmailPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIPELINES_EMAIL, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pivotaltracker ({@code PUT /projects/{id}/integrations/pivotaltracker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pivotaltracker(
            final String id, final GitLabProjectIntegrationsPivotaltrackerPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIVOTALTRACKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pumble ({@code PUT /projects/{id}/integrations/pumble}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pumble(final String id, final GitLabProjectIntegrationsPumblePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUMBLE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pushover ({@code PUT /projects/{id}/integrations/pushover}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pushover(final String id, final GitLabProjectIntegrationsPushoverPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUSHOVER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Redmine ({@code PUT /projects/{id}/integrations/redmine}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic redmine(final String id, final GitLabProjectIntegrationsRedminePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(REDMINE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Ewm ({@code PUT /projects/{id}/integrations/ewm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic ewm(final String id, final GitLabProjectIntegrationsEwmPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EWM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Youtrack ({@code PUT /projects/{id}/integrations/youtrack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic youtrack(final String id, final GitLabProjectIntegrationsYoutrackPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(YOUTRACK, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Clickup ({@code PUT /projects/{id}/integrations/clickup}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic clickup(final String id, final GitLabProjectIntegrationsClickupPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CLICKUP, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Slack ({@code PUT /projects/{id}/integrations/slack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic slack(final String id, final GitLabProjectIntegrationsSlackPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SLACK, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update microsoft team ({@code PUT /projects/{id}/integrations/microsoft-teams}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateMicrosoftTeam(
            final String id, final GitLabProjectIntegrationsUpdateMicrosoftTeamPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_MICROSOFT_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mattermost ({@code PUT /projects/{id}/integrations/mattermost}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mattermost(final String id, final GitLabProjectIntegrationsMattermostPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATTERMOST, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Teamcity ({@code PUT /projects/{id}/integrations/teamcity}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic teamcity(final String id, final GitLabProjectIntegrationsTeamcityPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TEAMCITY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Telegram ({@code PUT /projects/{id}/integrations/telegram}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic telegram(final String id, final GitLabProjectIntegrationsTelegramPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TELEGRAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Unify circuit ({@code PUT /projects/{id}/integrations/unify-circuit}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic unifyCircuit(
            final String id, final GitLabProjectIntegrationsUnifyCircuitPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UNIFY_CIRCUIT, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update webex team ({@code PUT /projects/{id}/integrations/webex-teams}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic updateWebexTeam(
            final String id, final GitLabProjectIntegrationsUpdateWebexTeamPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_WEBEX_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Zentao ({@code PUT /projects/{id}/integrations/zentao}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic zentao(final String id, final GitLabProjectIntegrationsZentaoPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ZENTAO, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Squash tm ({@code PUT /projects/{id}/integrations/squash-tm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic squashTm(final String id, final GitLabProjectIntegrationsSquashTmPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SQUASH_TM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Github ({@code PUT /projects/{id}/integrations/github}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     * @throws GitLabTierException if the configured tier is lower than premium
     */
    @RequiresTier(GitLabTier.PREMIUM)
    public GitLabIntegrationBasic github(final String id, final GitLabProjectIntegrationsGithubPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4ProjectsIdIntegrationsGithub");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GITHUB, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Git guardian ({@code PUT /projects/{id}/integrations/git-guardian}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic gitGuardian(
            final String id, final GitLabProjectIntegrationsGitGuardianPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GIT_GUARDIAN, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform artifact registry ({@code PUT
     * /projects/{id}/integrations/google-cloud-platform-artifact-registry}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googleCloudPlatformArtifactRegistry(
            final String id, final GitLabProjectGoogleCloudArtifactRegistryPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTR_2, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform workload identity federation ({@code PUT
     * /projects/{id}/integrations/google-cloud-platform-workload-identity-federation}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googleCloudPlatformWorkloadIdentityFederation(
            final String id, final GitLabProjectGoogleCloudWorkloadIdentityFederationPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTIT_2, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock ci ({@code PUT /projects/{id}/integrations/mock-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mockCi(final String id, final GitLabProjectIntegrationsMockCiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_CI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock monitoring ({@code PUT /projects/{id}/integrations/mock-monitoring}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mockMonitoring(
            final String id, final GitLabProjectIntegrationsMockMonitoringPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_MONITORING, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Get ({@code GET /projects/{id}/integrations/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIntegration> get(final String id, final GitLabProjectIntegrationsGetSlug slug)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, PARAM_SLUG);
        return caller.fetchOrEmpty(get(GET, id, slug.wireValue()), GitLabIntegration.class);
    }

    /**
     * Delete ({@code DELETE /projects/{id}/integrations/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final GitLabProjectIntegrationsDeleteSlug slug) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, PARAM_SLUG);
        caller.send(delete(GET, id, slug.wireValue()));
    }

    /**
     * Trigger mattermost slash command ({@code POST /projects/{id}/integrations/mattermost_slash_commands/trigger}).
     *
     * @param id the id
     * @param payload the request body
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void triggerMattermostSlashCommand(
            final String id, final GitLabProjectIntegrationsTriggerMattermostSlashCommandPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(TRIGGER_MATTERMOST_SLASH_COMMAND, id), payload));
    }

    /**
     * Trigger slack ({@code POST /slack/trigger}).
     *
     * @param payload the request body
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void triggerSlack(final GitLabProjectIntegrationsTriggerSlackPayload payload) throws IOException {
        requireNonNull(payload, PARAM_PAYLOAD);
        caller.send(caller.json(post(TRIGGER_SLACK), payload));
    }
}
