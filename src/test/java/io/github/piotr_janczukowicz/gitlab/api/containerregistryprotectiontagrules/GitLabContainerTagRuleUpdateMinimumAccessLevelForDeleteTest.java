package io.github.piotr_janczukowicz.gitlab.api.containerregistryprotectiontagrules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabContainerTagRuleUpdateMinimumAccessLevelForDeleteTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.values())
                .map(GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("", "maintainer", "owner", "admin");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete constant) {
        final GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete decoded =
                GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabContainerTagRuleUpdateMinimumAccessLevelForDelete.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
