package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironmentTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.values())
                .map(GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ide", "web", "chat_partial", "chat", "ambient");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment constant) {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment decoded =
                GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoAgentPlatformFlowsCreateWorkflowEnvironment.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
