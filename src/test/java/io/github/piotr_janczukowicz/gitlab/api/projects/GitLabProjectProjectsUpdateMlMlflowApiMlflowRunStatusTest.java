package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.values())
                .map(GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("RUNNING", "SCHEDULED", "FINISHED", "FAILED", "KILLED");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus constant) {
        final GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus decoded =
                GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsUpdateMlMlflowApiMlflowRunStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
