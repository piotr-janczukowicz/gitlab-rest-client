package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabDuoWorkflowCheckpointCreateChannelBlobStepActionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.values())
                .map(GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("conversation", "compaction");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction constant) {
        final GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction decoded =
                GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabDuoWorkflowCheckpointCreateChannelBlobStepAction.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
