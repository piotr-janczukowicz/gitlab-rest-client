package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupMilestonesUpdateStateEventTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupMilestonesUpdateStateEvent.values())
                .map(GitLabGroupGroupMilestonesUpdateStateEvent::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("close", "activate");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupMilestonesUpdateStateEvent.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupMilestonesUpdateStateEvent constant) {
        final GitLabGroupGroupMilestonesUpdateStateEvent decoded =
                GitLabGroupGroupMilestonesUpdateStateEvent.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupMilestonesUpdateStateEvent.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupMilestonesUpdateStateEvent.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
