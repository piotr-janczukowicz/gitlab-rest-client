package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCodeSuggestionsCreateCompletionContextTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCodeSuggestionsCreateCompletionContextType.values())
                .map(GitLabCodeSuggestionsCreateCompletionContextType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("file", "snippet");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabCodeSuggestionsCreateCompletionContextType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabCodeSuggestionsCreateCompletionContextType constant) {
        final GitLabCodeSuggestionsCreateCompletionContextType decoded =
                GitLabCodeSuggestionsCreateCompletionContextType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCodeSuggestionsCreateCompletionContextType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabCodeSuggestionsCreateCompletionContextType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
