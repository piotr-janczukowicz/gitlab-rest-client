package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectPipelineSchedulesListPipelinesScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectPipelineSchedulesListPipelinesScope.values())
                .map(GitLabProjectPipelineSchedulesListPipelinesScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("running", "pending", "finished", "branches", "tags");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectPipelineSchedulesListPipelinesScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectPipelineSchedulesListPipelinesScope constant) {
        final GitLabProjectPipelineSchedulesListPipelinesScope decoded =
                GitLabProjectPipelineSchedulesListPipelinesScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectPipelineSchedulesListPipelinesScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectPipelineSchedulesListPipelinesScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
