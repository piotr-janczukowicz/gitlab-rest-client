package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabIssueBasicTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabIssueBasicType.values())
                .filter(constant -> constant != GitLabIssueBasicType.UNRECOGNIZED)
                .map(GitLabIssueBasicType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ISSUE", "INCIDENT", "TEST_CASE", "REQUIREMENT", "TASK", "TICKET");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabIssueBasicType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabIssueBasicType constant) {
        final GitLabIssueBasicType decoded = GitLabIssueBasicType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabIssueBasicType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabIssueBasicType decoded = GitLabIssueBasicType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabIssueBasicType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabIssueBasicType.values())
                .filter(constant -> constant.wireValue().equals(GitLabIssueBasicType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
