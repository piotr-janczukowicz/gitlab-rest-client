package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListBillableMembersSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsListBillableMembersSort.values())
                .map(GitLabGroupGroupsListBillableMembersSort::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "access_level_asc",
                        "access_level_desc",
                        "last_joined",
                        "name_asc",
                        "name_desc",
                        "oldest_joined",
                        "oldest_sign_in",
                        "recent_sign_in",
                        "last_activity_on_asc",
                        "last_activity_on_desc");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListBillableMembersSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsListBillableMembersSort constant) {
        final GitLabGroupGroupsListBillableMembersSort decoded =
                GitLabGroupGroupsListBillableMembersSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListBillableMembersSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsListBillableMembersSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
