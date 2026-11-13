package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabResourceAccessTokenWithTokenAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabResourceAccessTokenWithTokenAccessLevel.values())
                .mapToInt(GitLabResourceAccessTokenWithTokenAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(10, 20, 30, 40, 50);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabResourceAccessTokenWithTokenAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabResourceAccessTokenWithTokenAccessLevel constant) {
        final GitLabResourceAccessTokenWithTokenAccessLevel decoded =
                GitLabResourceAccessTokenWithTokenAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabResourceAccessTokenWithTokenAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
