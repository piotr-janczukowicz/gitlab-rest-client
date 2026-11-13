package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

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

/** The GitLab operations of group group integrations. */
public final class GitLabGroupGroupIntegrationsApi extends GitLabResourceApi {
    private static final String PARAM_ID = "id";
    private static final String PARAM_PAYLOAD = "payload";
    private static final PathTemplate LIST = PathTemplate.of("/groups/{id}/integrations");
    private static final PathTemplate APPLE_APP_STORE = PathTemplate.of("/groups/{id}/integrations/apple-app-store");
    private static final PathTemplate ASANA = PathTemplate.of("/groups/{id}/integrations/asana");
    private static final PathTemplate ASSEMBLA = PathTemplate.of("/groups/{id}/integrations/assembla");
    private static final PathTemplate BAMBOO = PathTemplate.of("/groups/{id}/integrations/bamboo");
    private static final PathTemplate BUGZILLA = PathTemplate.of("/groups/{id}/integrations/bugzilla");
    private static final PathTemplate BUILDKITE = PathTemplate.of("/groups/{id}/integrations/buildkite");
    private static final PathTemplate CAMPFIRE = PathTemplate.of("/groups/{id}/integrations/campfire");
    private static final PathTemplate CONFLUENCE = PathTemplate.of("/groups/{id}/integrations/confluence");
    private static final PathTemplate CUSTOM_ISSUE_TRACKER =
            PathTemplate.of("/groups/{id}/integrations/custom-issue-tracker");
    private static final PathTemplate DATADOG = PathTemplate.of("/groups/{id}/integrations/datadog");
    private static final PathTemplate DIFFBLUE_COVER = PathTemplate.of("/groups/{id}/integrations/diffblue-cover");
    private static final PathTemplate DISCORD = PathTemplate.of("/groups/{id}/integrations/discord");
    private static final PathTemplate DRONE_CI = PathTemplate.of("/groups/{id}/integrations/drone-ci");
    private static final PathTemplate EMAILS_ON_PUSH = PathTemplate.of("/groups/{id}/integrations/emails-on-push");
    private static final PathTemplate EXTERNAL_WIKI = PathTemplate.of("/groups/{id}/integrations/external-wiki");
    private static final PathTemplate GITLAB_SLACK_APPLICATION =
            PathTemplate.of("/groups/{id}/integrations/gitlab-slack-application");
    private static final PathTemplate GOOGLE_PLAY = PathTemplate.of("/groups/{id}/integrations/google-play");
    private static final PathTemplate HANGOUTS_CHAT = PathTemplate.of("/groups/{id}/integrations/hangouts-chat");
    private static final PathTemplate HARBOR = PathTemplate.of("/groups/{id}/integrations/harbor");
    private static final PathTemplate IRKER = PathTemplate.of("/groups/{id}/integrations/irker");
    private static final PathTemplate UPDATE_JENKIN = PathTemplate.of("/groups/{id}/integrations/jenkins");
    private static final PathTemplate JIRA = PathTemplate.of("/groups/{id}/integrations/jira");
    private static final PathTemplate JIRA_CLOUD_APP = PathTemplate.of("/groups/{id}/integrations/jira-cloud-app");
    private static final PathTemplate LINEAR = PathTemplate.of("/groups/{id}/integrations/linear");
    private static final PathTemplate MATRIX = PathTemplate.of("/groups/{id}/integrations/matrix");
    private static final PathTemplate UPDATE_MATTERMOST_SLASH_COMMAND =
            PathTemplate.of("/groups/{id}/integrations/mattermost-slash-commands");
    private static final PathTemplate PACKAGIST = PathTemplate.of("/groups/{id}/integrations/packagist");
    private static final PathTemplate PHORGE = PathTemplate.of("/groups/{id}/integrations/phorge");
    private static final PathTemplate PIPELINES_EMAIL = PathTemplate.of("/groups/{id}/integrations/pipelines-email");
    private static final PathTemplate PIVOTALTRACKER = PathTemplate.of("/groups/{id}/integrations/pivotaltracker");
    private static final PathTemplate PUMBLE = PathTemplate.of("/groups/{id}/integrations/pumble");
    private static final PathTemplate PUSHOVER = PathTemplate.of("/groups/{id}/integrations/pushover");
    private static final PathTemplate REDMINE = PathTemplate.of("/groups/{id}/integrations/redmine");
    private static final PathTemplate EWM = PathTemplate.of("/groups/{id}/integrations/ewm");
    private static final PathTemplate YOUTRACK = PathTemplate.of("/groups/{id}/integrations/youtrack");
    private static final PathTemplate CLICKUP = PathTemplate.of("/groups/{id}/integrations/clickup");
    private static final PathTemplate SLACK = PathTemplate.of("/groups/{id}/integrations/slack");
    private static final PathTemplate UPDATE_MICROSOFT_TEAM =
            PathTemplate.of("/groups/{id}/integrations/microsoft-teams");
    private static final PathTemplate MATTERMOST = PathTemplate.of("/groups/{id}/integrations/mattermost");
    private static final PathTemplate TEAMCITY = PathTemplate.of("/groups/{id}/integrations/teamcity");
    private static final PathTemplate TELEGRAM = PathTemplate.of("/groups/{id}/integrations/telegram");
    private static final PathTemplate UNIFY_CIRCUIT = PathTemplate.of("/groups/{id}/integrations/unify-circuit");
    private static final PathTemplate UPDATE_WEBEX_TEAM = PathTemplate.of("/groups/{id}/integrations/webex-teams");
    private static final PathTemplate ZENTAO = PathTemplate.of("/groups/{id}/integrations/zentao");
    private static final PathTemplate SQUASH_TM = PathTemplate.of("/groups/{id}/integrations/squash-tm");
    private static final PathTemplate GITHUB = PathTemplate.of("/groups/{id}/integrations/github");
    private static final PathTemplate GIT_GUARDIAN = PathTemplate.of("/groups/{id}/integrations/git-guardian");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTRY =
            PathTemplate.of("/groups/{id}/integrations/google-cloud-platform-artifact-registry");
    private static final PathTemplate GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTITY =
            PathTemplate.of("/groups/{id}/integrations/google-cloud-platform-workload-identity-federation");
    private static final PathTemplate MOCK_CI = PathTemplate.of("/groups/{id}/integrations/mock-ci");
    private static final PathTemplate MOCK_MONITORING = PathTemplate.of("/groups/{id}/integrations/mock-monitoring");
    private static final PathTemplate GET = PathTemplate.of("/groups/{id}/integrations/{slug}");
    private static final JsonType<List<GitLabIntegrationBasic>> INTEGRATION_BASIC_LIST_TYPE =
            JsonTypes.listOf(GitLabIntegrationBasic.class);

    /**
     * The API over {@code caller}.
     *
     * @param caller sends the calls of this API
     * @throws NullPointerException if {@code caller} is {@code null}
     */
    public GitLabGroupGroupIntegrationsApi(final GitLabCaller caller) {
        super(caller);
    }

    /**
     * List ({@code GET /groups/{id}/integrations}).
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
     * Apple app store ({@code PUT /groups/{id}/integrations/apple-app-store}).
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
            final String id, final GitLabGroupGroupIntegrationsAppleAppStorePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(APPLE_APP_STORE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Asana ({@code PUT /groups/{id}/integrations/asana}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic asana(final String id, final GitLabGroupGroupIntegrationsAsanaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASANA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Assembla ({@code PUT /groups/{id}/integrations/assembla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic assembla(final String id, final GitLabGroupGroupIntegrationsAssemblaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ASSEMBLA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bamboo ({@code PUT /groups/{id}/integrations/bamboo}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bamboo(final String id, final GitLabGroupGroupIntegrationsBambooPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BAMBOO, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Bugzilla ({@code PUT /groups/{id}/integrations/bugzilla}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic bugzilla(final String id, final GitLabGroupGroupIntegrationsBugzillaPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUGZILLA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Buildkite ({@code PUT /groups/{id}/integrations/buildkite}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic buildkite(final String id, final GitLabGroupGroupIntegrationsBuildkitePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(BUILDKITE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Campfire ({@code PUT /groups/{id}/integrations/campfire}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic campfire(final String id, final GitLabGroupGroupIntegrationsCampfirePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CAMPFIRE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Confluence ({@code PUT /groups/{id}/integrations/confluence}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic confluence(
            final String id, final GitLabGroupGroupIntegrationsConfluencePayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CONFLUENCE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Custom issue tracker ({@code PUT /groups/{id}/integrations/custom-issue-tracker}).
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
            final String id, final GitLabGroupGroupIntegrationsCustomIssueTrackerPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CUSTOM_ISSUE_TRACKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Datadog ({@code PUT /groups/{id}/integrations/datadog}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic datadog(final String id, final GitLabGroupGroupIntegrationsDatadogPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DATADOG, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Diffblue cover ({@code PUT /groups/{id}/integrations/diffblue-cover}).
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
            final String id, final GitLabGroupGroupIntegrationsDiffblueCoverPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DIFFBLUE_COVER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Discord ({@code PUT /groups/{id}/integrations/discord}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic discord(final String id, final GitLabGroupGroupIntegrationsDiscordPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DISCORD, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Drone ci ({@code PUT /groups/{id}/integrations/drone-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic droneCi(final String id, final GitLabGroupGroupIntegrationsDroneCiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(DRONE_CI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Emails on push ({@code PUT /groups/{id}/integrations/emails-on-push}).
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
            final String id, final GitLabGroupGroupIntegrationsEmailsOnPushPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EMAILS_ON_PUSH, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * External wiki ({@code PUT /groups/{id}/integrations/external-wiki}).
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
            final String id, final GitLabGroupGroupIntegrationsExternalWikiPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EXTERNAL_WIKI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Gitlab slack application ({@code PUT /groups/{id}/integrations/gitlab-slack-application}).
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
            final String id, final GitLabGroupGroupIntegrationsGitlabSlackApplicationPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GITLAB_SLACK_APPLICATION, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google play ({@code PUT /groups/{id}/integrations/google-play}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic googlePlay(
            final String id, final GitLabGroupGroupIntegrationsGooglePlayPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GOOGLE_PLAY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Hangouts chat ({@code PUT /groups/{id}/integrations/hangouts-chat}).
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
            final String id, final GitLabGroupGroupIntegrationsHangoutsChatPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HANGOUTS_CHAT, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Harbor ({@code PUT /groups/{id}/integrations/harbor}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic harbor(final String id, final GitLabGroupGroupIntegrationsHarborPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(HARBOR, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Irker ({@code PUT /groups/{id}/integrations/irker}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic irker(final String id, final GitLabGroupGroupIntegrationsIrkerPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(IRKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update jenkin ({@code PUT /groups/{id}/integrations/jenkins}).
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
            final String id, final GitLabGroupGroupIntegrationsUpdateJenkinPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_JENKIN, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira ({@code PUT /groups/{id}/integrations/jira}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic jira(final String id, final GitLabGroupGroupIntegrationsJiraPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Jira cloud app ({@code PUT /groups/{id}/integrations/jira-cloud-app}).
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
            final String id, final GitLabGroupGroupIntegrationsJiraCloudAppPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(JIRA_CLOUD_APP, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Linear ({@code PUT /groups/{id}/integrations/linear}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic linear(final String id, final GitLabGroupGroupIntegrationsLinearPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(LINEAR, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Matrix ({@code PUT /groups/{id}/integrations/matrix}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic matrix(final String id, final GitLabGroupGroupIntegrationsMatrixPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATRIX, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update mattermost slash command ({@code PUT /groups/{id}/integrations/mattermost-slash-commands}).
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
            final String id, final GitLabGroupGroupIntegrationsUpdateMattermostSlashCommandPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(UPDATE_MATTERMOST_SLASH_COMMAND, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Packagist ({@code PUT /groups/{id}/integrations/packagist}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic packagist(final String id, final GitLabGroupGroupIntegrationsPackagistPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PACKAGIST, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Phorge ({@code PUT /groups/{id}/integrations/phorge}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic phorge(final String id, final GitLabGroupGroupIntegrationsPhorgePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PHORGE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pipelines email ({@code PUT /groups/{id}/integrations/pipelines-email}).
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
            final String id, final GitLabGroupGroupIntegrationsPipelinesEmailPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIPELINES_EMAIL, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pivotaltracker ({@code PUT /groups/{id}/integrations/pivotaltracker}).
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
            final String id, final GitLabGroupGroupIntegrationsPivotaltrackerPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PIVOTALTRACKER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pumble ({@code PUT /groups/{id}/integrations/pumble}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pumble(final String id, final GitLabGroupGroupIntegrationsPumblePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUMBLE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Pushover ({@code PUT /groups/{id}/integrations/pushover}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic pushover(final String id, final GitLabGroupGroupIntegrationsPushoverPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(PUSHOVER, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Redmine ({@code PUT /groups/{id}/integrations/redmine}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic redmine(final String id, final GitLabGroupGroupIntegrationsRedminePayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(REDMINE, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Ewm ({@code PUT /groups/{id}/integrations/ewm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic ewm(final String id, final GitLabGroupGroupIntegrationsEwmPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(EWM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Youtrack ({@code PUT /groups/{id}/integrations/youtrack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic youtrack(final String id, final GitLabGroupGroupIntegrationsYoutrackPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(YOUTRACK, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Clickup ({@code PUT /groups/{id}/integrations/clickup}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic clickup(final String id, final GitLabGroupGroupIntegrationsClickupPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(CLICKUP, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Slack ({@code PUT /groups/{id}/integrations/slack}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic slack(final String id, final GitLabGroupGroupIntegrationsSlackPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SLACK, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update microsoft team ({@code PUT /groups/{id}/integrations/microsoft-teams}).
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
            final String id, final GitLabGroupGroupIntegrationsUpdateMicrosoftTeamPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_MICROSOFT_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mattermost ({@code PUT /groups/{id}/integrations/mattermost}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mattermost(
            final String id, final GitLabGroupGroupIntegrationsMattermostPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MATTERMOST, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Teamcity ({@code PUT /groups/{id}/integrations/teamcity}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic teamcity(final String id, final GitLabGroupGroupIntegrationsTeamcityPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TEAMCITY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Telegram ({@code PUT /groups/{id}/integrations/telegram}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic telegram(final String id, final GitLabGroupGroupIntegrationsTelegramPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(TELEGRAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Unify circuit ({@code PUT /groups/{id}/integrations/unify-circuit}).
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
            final String id, final GitLabGroupGroupIntegrationsUnifyCircuitPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UNIFY_CIRCUIT, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Update webex team ({@code PUT /groups/{id}/integrations/webex-teams}).
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
            final String id, final GitLabGroupGroupIntegrationsUpdateWebexTeamPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(UPDATE_WEBEX_TEAM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Zentao ({@code PUT /groups/{id}/integrations/zentao}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic zentao(final String id, final GitLabGroupGroupIntegrationsZentaoPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(ZENTAO, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Squash tm ({@code PUT /groups/{id}/integrations/squash-tm}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic squashTm(final String id, final GitLabGroupGroupIntegrationsSquashTmPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(SQUASH_TM, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Github ({@code PUT /groups/{id}/integrations/github}).
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
    public GitLabIntegrationBasic github(final String id, final GitLabGroupGroupIntegrationsGithubPayload payload)
            throws IOException {
        caller.requireTier(GitLabTier.PREMIUM, "putApiV4GroupsIdIntegrationsGithub");
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GITHUB, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Git guardian ({@code PUT /groups/{id}/integrations/git-guardian}).
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
            final String id, final GitLabGroupGroupIntegrationsGitGuardianPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(GIT_GUARDIAN, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform artifact registry ({@code PUT
     * /groups/{id}/integrations/google-cloud-platform-artifact-registry}).
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
            final String id, final GitLabGroupGoogleCloudArtifactRegistryPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTRY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Google cloud platform workload identity federation ({@code PUT
     * /groups/{id}/integrations/google-cloud-platform-workload-identity-federation}).
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
            final String id, final GitLabGroupGoogleCloudWorkloadIdentityFederationPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(
                caller.json(put(GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTITY, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock ci ({@code PUT /groups/{id}/integrations/mock-ci}).
     *
     * @param id the id
     * @param payload the request body
     * @return the resource
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code payload} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public GitLabIntegrationBasic mockCi(final String id, final GitLabGroupGroupIntegrationsMockCiPayload payload)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_CI, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Mock monitoring ({@code PUT /groups/{id}/integrations/mock-monitoring}).
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
            final String id, final GitLabGroupGroupIntegrationsMockMonitoringPayload payload) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(payload, PARAM_PAYLOAD);
        return caller.fetch(caller.json(put(MOCK_MONITORING, id), payload), GitLabIntegrationBasic.class);
    }

    /**
     * Get ({@code GET /groups/{id}/integrations/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @return the resource, or empty when GitLab answers 404
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public Optional<GitLabIntegration> get(final String id, final GitLabGroupGroupIntegrationsGetSlug slug)
            throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, "slug");
        return caller.fetchOrEmpty(get(GET, id, slug.wireValue()), GitLabIntegration.class);
    }

    /**
     * Delete ({@code DELETE /groups/{id}/integrations/{slug}}).
     *
     * @param id the id
     * @param slug the slug
     * @throws IllegalArgumentException if {@code id} is blank
     * @throws NullPointerException if {@code slug} is {@code null}
     * @throws IOException if the transport fails
     * @throws GitLabApiException if the response is unsuccessful
     */
    public void delete(final String id, final GitLabGroupGroupIntegrationsDeleteSlug slug) throws IOException {
        requireNotBlank(id, PARAM_ID);
        requireNonNull(slug, "slug");
        caller.send(delete(GET, id, slug.wireValue()));
    }
}
