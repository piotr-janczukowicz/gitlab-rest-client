package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabIssueTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabIssueType.values())
                .filter(constant -> constant != GitLabIssueType.UNRECOGNIZED)
                .map(GitLabIssueType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ISSUE", "INCIDENT", "TEST_CASE", "REQUIREMENT", "TASK", "TICKET");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabIssueType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabIssueType constant) {
        final GitLabIssueType decoded = GitLabIssueType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabIssueType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabIssueType decoded = GitLabIssueType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabIssueType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabIssueType.values())
                .filter(constant -> constant.wireValue().equals(GitLabIssueType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
