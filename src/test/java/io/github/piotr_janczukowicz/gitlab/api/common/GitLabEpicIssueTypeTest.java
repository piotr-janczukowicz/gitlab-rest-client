package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabEpicIssueTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabEpicIssueType.values())
                .filter(constant -> constant != GitLabEpicIssueType.UNRECOGNIZED)
                .map(GitLabEpicIssueType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ISSUE", "INCIDENT", "TEST_CASE", "REQUIREMENT", "TASK", "TICKET");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabEpicIssueType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabEpicIssueType constant) {
        final GitLabEpicIssueType decoded = GitLabEpicIssueType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabEpicIssueType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabEpicIssueType decoded = GitLabEpicIssueType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabEpicIssueType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabEpicIssueType.values())
                .filter(constant -> constant.wireValue().equals(GitLabEpicIssueType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
