package io.github.piotr_janczukowicz.gitlab.api.projectmilestones;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectMilestonesListSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectMilestonesListSort.values())
                .map(GitLabProjectProjectMilestonesListSort::wireValue)
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
    @EnumSource(value = GitLabProjectProjectMilestonesListSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectMilestonesListSort constant) {
        final GitLabProjectProjectMilestonesListSort decoded =
                GitLabProjectProjectMilestonesListSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectMilestonesListSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectMilestonesListSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
