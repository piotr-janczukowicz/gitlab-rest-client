package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupWebhooksCreateTestTriggerTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupWebhooksCreateTestTrigger.values())
                .map(GitLabGroupGroupWebhooksCreateTestTrigger::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "confidential_issues_events",
                        "confidential_note_events",
                        "deployment_events",
                        "emoji_events",
                        "feature_flag_events",
                        "issues_events",
                        "job_events",
                        "merge_requests_events",
                        "milestone_events",
                        "note_events",
                        "pipeline_events",
                        "push_events",
                        "releases_events",
                        "resource_access_token_events",
                        "resource_deploy_token_events",
                        "tag_push_events",
                        "wiki_page_events",
                        "vulnerability_events");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupWebhooksCreateTestTrigger.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupWebhooksCreateTestTrigger constant) {
        final GitLabGroupGroupWebhooksCreateTestTrigger decoded =
                GitLabGroupGroupWebhooksCreateTestTrigger.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupWebhooksCreateTestTrigger.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupWebhooksCreateTestTrigger.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
