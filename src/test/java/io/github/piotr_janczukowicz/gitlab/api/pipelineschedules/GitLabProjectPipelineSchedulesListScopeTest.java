package io.github.piotr_janczukowicz.gitlab.api.pipelineschedules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectPipelineSchedulesListScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectPipelineSchedulesListScope.values())
                .map(GitLabProjectPipelineSchedulesListScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("active", "inactive");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectPipelineSchedulesListScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectPipelineSchedulesListScope constant) {
        final GitLabProjectPipelineSchedulesListScope decoded =
                GitLabProjectPipelineSchedulesListScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectPipelineSchedulesListScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectPipelineSchedulesListScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
