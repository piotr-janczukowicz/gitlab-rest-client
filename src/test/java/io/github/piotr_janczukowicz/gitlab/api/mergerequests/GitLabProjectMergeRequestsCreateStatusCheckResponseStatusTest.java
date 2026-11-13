package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectMergeRequestsCreateStatusCheckResponseStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.values())
                .map(GitLabProjectMergeRequestsCreateStatusCheckResponseStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("passed", "failed", "pending");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectMergeRequestsCreateStatusCheckResponseStatus constant) {
        final GitLabProjectMergeRequestsCreateStatusCheckResponseStatus decoded =
                GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectMergeRequestsCreateStatusCheckResponseStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
