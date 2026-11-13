package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDraftNotesBulkPublishReviewerStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDraftNotesBulkPublishReviewerState.values())
                .map(GitLabProjectDraftNotesBulkPublishReviewerState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("requested_changes", "reviewed");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDraftNotesBulkPublishReviewerState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDraftNotesBulkPublishReviewerState constant) {
        final GitLabProjectDraftNotesBulkPublishReviewerState decoded =
                GitLabProjectDraftNotesBulkPublishReviewerState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDraftNotesBulkPublishReviewerState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDraftNotesBulkPublishReviewerState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
