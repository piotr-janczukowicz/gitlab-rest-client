package io.github.piotr_janczukowicz.gitlab.api.todos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabToDosListActionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabToDosListAction.values())
                .map(GitLabToDosListAction::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "assigned",
                        "review_requested",
                        "mentioned",
                        "build_failed",
                        "marked",
                        "approval_required",
                        "unmergeable",
                        "directly_addressed",
                        "member_access_requested",
                        "review_submitted",
                        "review_approved",
                        "review_changes_requested",
                        "ssh_key_expired",
                        "ssh_key_expiring_soon",
                        "transfer_failed",
                        "merge_train_removed",
                        "okr_checkin_requested",
                        "added_approver",
                        "duo_pro_access_granted",
                        "duo_enterprise_access_granted",
                        "duo_core_access_granted",
                        "duo_workflow_input_required",
                        "orbit_access_granted");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabToDosListAction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabToDosListAction constant) {
        final GitLabToDosListAction decoded = GitLabToDosListAction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabToDosListAction.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabToDosListAction.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
