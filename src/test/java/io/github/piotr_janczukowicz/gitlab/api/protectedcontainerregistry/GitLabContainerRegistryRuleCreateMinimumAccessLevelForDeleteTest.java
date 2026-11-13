package io.github.piotr_janczukowicz.gitlab.api.protectedcontainerregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabContainerRegistryRuleCreateMinimumAccessLevelForDeleteTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.values())
                .map(GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("maintainer", "owner", "admin");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete constant) {
        final GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete decoded =
                GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabContainerRegistryRuleCreateMinimumAccessLevelForDelete.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
