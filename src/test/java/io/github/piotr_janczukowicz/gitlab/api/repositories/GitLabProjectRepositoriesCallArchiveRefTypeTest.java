package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectRepositoriesCallArchiveRefTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectRepositoriesCallArchiveRefType.values())
                .map(GitLabProjectRepositoriesCallArchiveRefType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("heads", "tags");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectRepositoriesCallArchiveRefType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectRepositoriesCallArchiveRefType constant) {
        final GitLabProjectRepositoriesCallArchiveRefType decoded =
                GitLabProjectRepositoriesCallArchiveRefType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectRepositoriesCallArchiveRefType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectRepositoriesCallArchiveRefType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
