package io.github.piotr_janczukowicz.gitlab.api.rubygems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectRubyGemsGetFileNameTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectRubyGemsGetFileName.values())
                .map(GitLabProjectRubyGemsGetFileName::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("specs.4.8.gz", "latest_specs.4.8.gz", "prerelease_specs.4.8.gz");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectRubyGemsGetFileName.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectRubyGemsGetFileName constant) {
        final GitLabProjectRubyGemsGetFileName decoded =
                GitLabProjectRubyGemsGetFileName.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectRubyGemsGetFileName.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectRubyGemsGetFileName.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
