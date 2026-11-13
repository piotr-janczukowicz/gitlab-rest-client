package io.github.piotr_janczukowicz.gitlab.api.protectedpackages;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDeleteTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.values())
                .map(GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("owner", "admin");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete constant) {
        final GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete decoded =
                GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectProtectedPackagesCreateMinimumAccessLevelForDelete.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
