package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupIssuesListDueDateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupIssuesListDueDate.values())
                .map(GitLabGroupIssuesListDueDate::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "",
                        "0",
                        "any",
                        "today",
                        "tomorrow",
                        "overdue",
                        "week",
                        "month",
                        "next_month_and_previous_two_weeks");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupIssuesListDueDate.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupIssuesListDueDate constant) {
        final GitLabGroupIssuesListDueDate decoded = GitLabGroupIssuesListDueDate.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesListDueDate.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesListDueDate.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
