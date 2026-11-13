package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.values())
                .map(GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("queued", "delivered");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus constant) {
        final GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus decoded =
                GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoAgentPlatformFlowsUpdateWorkflowsEventStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
