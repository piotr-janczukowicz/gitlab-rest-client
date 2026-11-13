package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectReleasesListSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectReleasesListSort.values())
                .map(GitLabProjectReleasesListSort::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("asc", "desc");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectReleasesListSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectReleasesListSort constant) {
        final GitLabProjectReleasesListSort decoded = GitLabProjectReleasesListSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectReleasesListSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectReleasesListSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
