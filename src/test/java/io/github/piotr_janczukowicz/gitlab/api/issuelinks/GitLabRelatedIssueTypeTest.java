package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabRelatedIssueTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabRelatedIssueType.values())
                .filter(constant -> constant != GitLabRelatedIssueType.UNRECOGNIZED)
                .map(GitLabRelatedIssueType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("ISSUE", "INCIDENT", "TEST_CASE", "REQUIREMENT", "TASK", "TICKET");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabRelatedIssueType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabRelatedIssueType constant) {
        final GitLabRelatedIssueType decoded = GitLabRelatedIssueType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabRelatedIssueType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabRelatedIssueType decoded = GitLabRelatedIssueType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabRelatedIssueType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabRelatedIssueType.values())
                .filter(constant -> constant.wireValue().equals(GitLabRelatedIssueType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
