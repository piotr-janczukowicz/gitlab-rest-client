package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateWorkflowSourceTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoAgentPlatformFlowsCreateWorkflowSource.values())
                .map(GitLabDuoAgentPlatformFlowsCreateWorkflowSource::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "merge_request_code_conflict",
                        "merge_request_dependency_bump",
                        "merge_request_fix_pipeline",
                        "merge_request_resolve_discussion",
                        "work_item_to_merge_request",
                        "fix_pipeline",
                        "convert_platform_ci_pipeline",
                        "duo_cli_interactive",
                        "duo_cli_run",
                        "duo_cli_acp",
                        "ide_extension",
                        "work_item_plan_to_merge_request",
                        "web_chat",
                        "vulnerability_leaked_token_rotation",
                        "mobile_chat");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoAgentPlatformFlowsCreateWorkflowSource.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoAgentPlatformFlowsCreateWorkflowSource constant) {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowSource decoded =
                GitLabDuoAgentPlatformFlowsCreateWorkflowSource.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabDuoAgentPlatformFlowsCreateWorkflowSource.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoAgentPlatformFlowsCreateWorkflowSource.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
