package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectCommitDiscussionCreatePositionTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectCommitDiscussionCreatePositionType.values())
                .map(GitLabProjectCommitDiscussionCreatePositionType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("text", "image", "file");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectCommitDiscussionCreatePositionType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectCommitDiscussionCreatePositionType constant) {
        final GitLabProjectCommitDiscussionCreatePositionType decoded =
                GitLabProjectCommitDiscussionCreatePositionType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectCommitDiscussionCreatePositionType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectCommitDiscussionCreatePositionType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
