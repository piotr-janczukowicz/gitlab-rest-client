package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDraftNotesUpdatePositionTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDraftNotesUpdatePositionType.values())
                .map(GitLabProjectDraftNotesUpdatePositionType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("text", "image", "file");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDraftNotesUpdatePositionType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDraftNotesUpdatePositionType constant) {
        final GitLabProjectDraftNotesUpdatePositionType decoded =
                GitLabProjectDraftNotesUpdatePositionType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDraftNotesUpdatePositionType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDraftNotesUpdatePositionType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
