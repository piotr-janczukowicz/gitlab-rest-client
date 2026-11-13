package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupMergeRequestsListWipTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupMergeRequestsListWip.values())
                .map(GitLabGroupMergeRequestsListWip::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("yes", "no");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupMergeRequestsListWip.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupMergeRequestsListWip constant) {
        final GitLabGroupMergeRequestsListWip decoded = GitLabGroupMergeRequestsListWip.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupMergeRequestsListWip.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupMergeRequestsListWip.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
