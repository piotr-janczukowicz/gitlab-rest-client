package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabWorkItemsStatusCategoryTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabWorkItemsStatusCategory.values())
                .filter(constant -> constant != GitLabWorkItemsStatusCategory.UNRECOGNIZED)
                .map(GitLabWorkItemsStatusCategory::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("triage", "to_do", "in_progress", "done", "canceled");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabWorkItemsStatusCategory.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabWorkItemsStatusCategory constant) {
        final GitLabWorkItemsStatusCategory decoded = GitLabWorkItemsStatusCategory.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabWorkItemsStatusCategory.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabWorkItemsStatusCategory decoded = GitLabWorkItemsStatusCategory.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabWorkItemsStatusCategory.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabWorkItemsStatusCategory.values())
                .filter(constant -> constant.wireValue().equals(GitLabWorkItemsStatusCategory.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
