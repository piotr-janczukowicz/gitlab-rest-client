package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupIssuesListOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupIssuesListOrderBy.values())
                .map(GitLabGroupIssuesListOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "created_at",
                        "due_date",
                        "label_priority",
                        "milestone_due",
                        "popularity",
                        "priority",
                        "relative_position",
                        "title",
                        "updated_at",
                        "weight");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupIssuesListOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupIssuesListOrderBy constant) {
        final GitLabGroupIssuesListOrderBy decoded = GitLabGroupIssuesListOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesListOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesListOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
