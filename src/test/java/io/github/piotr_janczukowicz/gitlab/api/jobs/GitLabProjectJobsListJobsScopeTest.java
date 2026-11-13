package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectJobsListJobsScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectJobsListJobsScope.values())
                .map(GitLabProjectJobsListJobsScope::wireValue)
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
    @EnumSource(value = GitLabProjectJobsListJobsScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectJobsListJobsScope constant) {
        final GitLabProjectJobsListJobsScope decoded = GitLabProjectJobsListJobsScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsListJobsScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsListJobsScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
