package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectMilestonesUpdateStateEventTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectMilestonesUpdateStateEvent.values())
                .map(GitLabProjectProjectMilestonesUpdateStateEvent::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("close", "activate");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectMilestonesUpdateStateEvent.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectMilestonesUpdateStateEvent constant) {
        final GitLabProjectProjectMilestonesUpdateStateEvent decoded =
                GitLabProjectProjectMilestonesUpdateStateEvent.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectMilestonesUpdateStateEvent.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectMilestonesUpdateStateEvent.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
