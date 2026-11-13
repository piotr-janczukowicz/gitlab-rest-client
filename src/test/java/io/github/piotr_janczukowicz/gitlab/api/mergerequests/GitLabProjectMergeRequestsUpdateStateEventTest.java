package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectMergeRequestsUpdateStateEventTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectMergeRequestsUpdateStateEvent.values())
                .map(GitLabProjectMergeRequestsUpdateStateEvent::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("close", "reopen");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectMergeRequestsUpdateStateEvent.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectMergeRequestsUpdateStateEvent constant) {
        final GitLabProjectMergeRequestsUpdateStateEvent decoded =
                GitLabProjectMergeRequestsUpdateStateEvent.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectMergeRequestsUpdateStateEvent.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectMergeRequestsUpdateStateEvent.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
