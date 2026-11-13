package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCodeSuggestionsCreateCompletionIntentTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCodeSuggestionsCreateCompletionIntent.values())
                .map(GitLabCodeSuggestionsCreateCompletionIntent::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("completion", "generation");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabCodeSuggestionsCreateCompletionIntent.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabCodeSuggestionsCreateCompletionIntent constant) {
        final GitLabCodeSuggestionsCreateCompletionIntent decoded =
                GitLabCodeSuggestionsCreateCompletionIntent.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCodeSuggestionsCreateCompletionIntent.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabCodeSuggestionsCreateCompletionIntent.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
