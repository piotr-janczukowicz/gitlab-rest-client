package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectNotesListSnippetsNotesActivityFilterTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectNotesListSnippetsNotesActivityFilter.values())
                .map(GitLabProjectNotesListSnippetsNotesActivityFilter::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all_notes", "only_comments", "only_activity");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectNotesListSnippetsNotesActivityFilter.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectNotesListSnippetsNotesActivityFilter constant) {
        final GitLabProjectNotesListSnippetsNotesActivityFilter decoded =
                GitLabProjectNotesListSnippetsNotesActivityFilter.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectNotesListSnippetsNotesActivityFilter.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectNotesListSnippetsNotesActivityFilter.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
