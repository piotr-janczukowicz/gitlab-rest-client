package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsListAiAgentSessionsAgentTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsListAiAgentSessionsAgentType.values())
                .map(GitLabProjectProjectsListAiAgentSessionsAgentType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("claude-code", "opencode", "cursor", "codex");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsListAiAgentSessionsAgentType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsListAiAgentSessionsAgentType constant) {
        final GitLabProjectProjectsListAiAgentSessionsAgentType decoded =
                GitLabProjectProjectsListAiAgentSessionsAgentType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectsListAiAgentSessionsAgentType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsListAiAgentSessionsAgentType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
