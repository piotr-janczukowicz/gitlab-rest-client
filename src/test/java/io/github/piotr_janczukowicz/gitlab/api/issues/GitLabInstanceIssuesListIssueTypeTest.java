package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceIssuesListIssueTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceIssuesListIssueType.values())
                .map(GitLabInstanceIssuesListIssueType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("issue", "incident", "test_case", "requirement", "task", "ticket");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceIssuesListIssueType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceIssuesListIssueType constant) {
        final GitLabInstanceIssuesListIssueType decoded =
                GitLabInstanceIssuesListIssueType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceIssuesListIssueType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceIssuesListIssueType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
