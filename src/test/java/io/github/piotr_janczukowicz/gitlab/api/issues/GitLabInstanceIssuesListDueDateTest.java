package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceIssuesListDueDateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceIssuesListDueDate.values())
                .map(GitLabInstanceIssuesListDueDate::wireValue)
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
    @EnumSource(value = GitLabInstanceIssuesListDueDate.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceIssuesListDueDate constant) {
        final GitLabInstanceIssuesListDueDate decoded = GitLabInstanceIssuesListDueDate.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceIssuesListDueDate.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceIssuesListDueDate.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
