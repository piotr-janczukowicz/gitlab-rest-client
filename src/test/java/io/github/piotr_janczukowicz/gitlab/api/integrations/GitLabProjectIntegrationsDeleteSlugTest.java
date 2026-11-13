package io.github.piotr_janczukowicz.gitlab.api.integrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectIntegrationsDeleteSlugTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectIntegrationsDeleteSlug.values())
                .map(GitLabProjectIntegrationsDeleteSlug::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "apple-app-store",
                        "asana",
                        "assembla",
                        "bamboo",
                        "bugzilla",
                        "buildkite",
                        "campfire",
                        "confluence",
                        "custom-issue-tracker",
                        "datadog",
                        "diffblue-cover",
                        "discord",
                        "drone-ci",
                        "emails-on-push",
                        "external-wiki",
                        "gitlab-slack-application",
                        "google-play",
                        "hangouts-chat",
                        "harbor",
                        "irker",
                        "jenkins",
                        "jira",
                        "jira-cloud-app",
                        "linear",
                        "matrix",
                        "mattermost-slash-commands",
                        "packagist",
                        "phorge",
                        "pipelines-email",
                        "pivotaltracker",
                        "pumble",
                        "pushover",
                        "redmine",
                        "ewm",
                        "youtrack",
                        "clickup",
                        "slack",
                        "microsoft-teams",
                        "mattermost",
                        "teamcity",
                        "telegram",
                        "unify-circuit",
                        "webex-teams",
                        "zentao",
                        "squash-tm",
                        "github",
                        "git-guardian",
                        "google-cloud-platform-artifact-registry",
                        "google-cloud-platform-workload-identity-federation",
                        "mock-ci",
                        "mock-monitoring");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectIntegrationsDeleteSlug.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectIntegrationsDeleteSlug constant) {
        final GitLabProjectIntegrationsDeleteSlug decoded =
                GitLabProjectIntegrationsDeleteSlug.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectIntegrationsDeleteSlug.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectIntegrationsDeleteSlug.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
