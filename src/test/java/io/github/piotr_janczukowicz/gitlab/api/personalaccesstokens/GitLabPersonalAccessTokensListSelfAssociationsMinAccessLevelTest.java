package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.values())
                .mapToInt(GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel::wireValue)
                .toArray();

        assertThat(wires).containsExactly(10, 15, 20, 25, 30, 40, 50);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel constant) {
        final GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel decoded =
                GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabPersonalAccessTokensListSelfAssociationsMinAccessLevel.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
