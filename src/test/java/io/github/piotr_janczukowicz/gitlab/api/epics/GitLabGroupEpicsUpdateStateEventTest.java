package io.github.piotr_janczukowicz.gitlab.api.epics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupEpicsUpdateStateEventTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupEpicsUpdateStateEvent.values())
                .map(GitLabGroupEpicsUpdateStateEvent::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("reopen", "close");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupEpicsUpdateStateEvent.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupEpicsUpdateStateEvent constant) {
        final GitLabGroupEpicsUpdateStateEvent decoded =
                GitLabGroupEpicsUpdateStateEvent.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupEpicsUpdateStateEvent.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupEpicsUpdateStateEvent.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
