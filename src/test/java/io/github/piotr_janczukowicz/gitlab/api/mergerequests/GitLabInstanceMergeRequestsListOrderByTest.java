package io.github.piotr_janczukowicz.gitlab.api.mergerequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceMergeRequestsListOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceMergeRequestsListOrderBy.values())
                .map(GitLabInstanceMergeRequestsListOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "created_at",
                        "label_priority",
                        "milestone_due",
                        "popularity",
                        "priority",
                        "title",
                        "updated_at",
                        "merged_at");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceMergeRequestsListOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceMergeRequestsListOrderBy constant) {
        final GitLabInstanceMergeRequestsListOrderBy decoded =
                GitLabInstanceMergeRequestsListOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceMergeRequestsListOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceMergeRequestsListOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
