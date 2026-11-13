package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectNotesListWikiPagesNotesOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectNotesListWikiPagesNotesOrderBy.values())
                .map(GitLabProjectNotesListWikiPagesNotesOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created_at", "updated_at");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectNotesListWikiPagesNotesOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectNotesListWikiPagesNotesOrderBy constant) {
        final GitLabProjectNotesListWikiPagesNotesOrderBy decoded =
                GitLabProjectNotesListWikiPagesNotesOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectNotesListWikiPagesNotesOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectNotesListWikiPagesNotesOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
