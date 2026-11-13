package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab group group integrations get slug. */
@CatalogSchema("operations/getApiV4GroupsIdIntegrationsSlug/parameters/slug/schema")
public enum GitLabGroupGroupIntegrationsGetSlug {
    APPLE_APP_STORE("apple-app-store"),
    ASANA("asana"),
    ASSEMBLA("assembla"),
    BAMBOO("bamboo"),
    BUGZILLA("bugzilla"),
    BUILDKITE("buildkite"),
    CAMPFIRE("campfire"),
    CONFLUENCE("confluence"),
    CUSTOM_ISSUE_TRACKER("custom-issue-tracker"),
    DATADOG("datadog"),
    DIFFBLUE_COVER("diffblue-cover"),
    DISCORD("discord"),
    DRONE_CI("drone-ci"),
    EMAILS_ON_PUSH("emails-on-push"),
    EXTERNAL_WIKI("external-wiki"),
    GITLAB_SLACK_APPLICATION("gitlab-slack-application"),
    GOOGLE_PLAY("google-play"),
    HANGOUTS_CHAT("hangouts-chat"),
    HARBOR("harbor"),
    IRKER("irker"),
    JENKINS("jenkins"),
    JIRA("jira"),
    JIRA_CLOUD_APP("jira-cloud-app"),
    LINEAR("linear"),
    MATRIX("matrix"),
    MATTERMOST_SLASH_COMMANDS("mattermost-slash-commands"),
    PACKAGIST("packagist"),
    PHORGE("phorge"),
    PIPELINES_EMAIL("pipelines-email"),
    PIVOTALTRACKER("pivotaltracker"),
    PUMBLE("pumble"),
    PUSHOVER("pushover"),
    REDMINE("redmine"),
    EWM("ewm"),
    YOUTRACK("youtrack"),
    CLICKUP("clickup"),
    SLACK("slack"),
    MICROSOFT_TEAMS("microsoft-teams"),
    MATTERMOST("mattermost"),
    TEAMCITY("teamcity"),
    TELEGRAM("telegram"),
    UNIFY_CIRCUIT("unify-circuit"),
    WEBEX_TEAMS("webex-teams"),
    ZENTAO("zentao"),
    SQUASH_TM("squash-tm"),
    GITHUB("github"),
    GIT_GUARDIAN("git-guardian"),
    GOOGLE_CLOUD_PLATFORM_ARTIFACT_REGISTRY("google-cloud-platform-artifact-registry"),
    GOOGLE_CLOUD_PLATFORM_WORKLOAD_IDENTITY_FEDERATION("google-cloud-platform-workload-identity-federation"),
    MOCK_CI("mock-ci"),
    MOCK_MONITORING("mock-monitoring");

    private static final EnumUtils.WireIndex<GitLabGroupGroupIntegrationsGetSlug> WIRE_INDEX =
            EnumUtils.index(GitLabGroupGroupIntegrationsGetSlug.class, GitLabGroupGroupIntegrationsGetSlug::wireValue);

    private final String wireValue;

    GitLabGroupGroupIntegrationsGetSlug(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabGroupGroupIntegrationsGetSlug fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
