package io.github.piotr_janczukowicz.gitlab.api.groupmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupMilestonesListSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupMilestonesListSort.values())
                .map(GitLabGroupGroupMilestonesListSort::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "due_date_asc",
                        "due_date_desc",
                        "start_date_asc",
                        "start_date_desc",
                        "name_asc",
                        "name_desc",
                        "created_asc",
                        "created_desc",
                        "updated_asc",
                        "updated_desc");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupMilestonesListSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupGroupMilestonesListSort constant) {
        final GitLabGroupGroupMilestonesListSort decoded =
                GitLabGroupGroupMilestonesListSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupMilestonesListSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupMilestonesListSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
