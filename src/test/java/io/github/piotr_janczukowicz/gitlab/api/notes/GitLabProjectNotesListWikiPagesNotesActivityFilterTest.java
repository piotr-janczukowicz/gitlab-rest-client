package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectNotesListWikiPagesNotesActivityFilterTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectNotesListWikiPagesNotesActivityFilter.values())
                .map(GitLabProjectNotesListWikiPagesNotesActivityFilter::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all_notes", "only_comments", "only_activity");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectNotesListWikiPagesNotesActivityFilter.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectNotesListWikiPagesNotesActivityFilter constant) {
        final GitLabProjectNotesListWikiPagesNotesActivityFilter decoded =
                GitLabProjectNotesListWikiPagesNotesActivityFilter.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectNotesListWikiPagesNotesActivityFilter.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectNotesListWikiPagesNotesActivityFilter.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
