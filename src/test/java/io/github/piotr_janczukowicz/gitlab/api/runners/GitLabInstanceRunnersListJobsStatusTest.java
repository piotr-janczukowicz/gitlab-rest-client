package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceRunnersListJobsStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceRunnersListJobsStatus.values())
                .map(GitLabInstanceRunnersListJobsStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "created",
                        "waiting_for_resource",
                        "preparing",
                        "waiting_for_callback",
                        "pending",
                        "running",
                        "success",
                        "failed",
                        "canceling",
                        "canceled",
                        "skipped",
                        "manual",
                        "scheduled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceRunnersListJobsStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceRunnersListJobsStatus constant) {
        final GitLabInstanceRunnersListJobsStatus decoded =
                GitLabInstanceRunnersListJobsStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceRunnersListJobsStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceRunnersListJobsStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
