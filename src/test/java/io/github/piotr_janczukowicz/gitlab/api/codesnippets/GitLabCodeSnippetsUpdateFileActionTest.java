package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCodeSnippetsUpdateFileActionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCodeSnippetsUpdateFileAction.values())
                .map(GitLabCodeSnippetsUpdateFileAction::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("create", "update", "delete", "move");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabCodeSnippetsUpdateFileAction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabCodeSnippetsUpdateFileAction constant) {
        final GitLabCodeSnippetsUpdateFileAction decoded =
                GitLabCodeSnippetsUpdateFileAction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCodeSnippetsUpdateFileAction.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabCodeSnippetsUpdateFileAction.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
