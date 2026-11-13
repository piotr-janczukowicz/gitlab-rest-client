package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDraftNotesCreatePositionTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDraftNotesCreatePositionType.values())
                .map(GitLabProjectDraftNotesCreatePositionType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("text", "image", "file");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDraftNotesCreatePositionType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDraftNotesCreatePositionType constant) {
        final GitLabProjectDraftNotesCreatePositionType decoded =
                GitLabProjectDraftNotesCreatePositionType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDraftNotesCreatePositionType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDraftNotesCreatePositionType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
