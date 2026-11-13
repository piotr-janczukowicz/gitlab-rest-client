package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupWikisCreateFormatTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupWikisCreateFormat.values())
                .map(GitLabGroupGroupWikisCreateFormat::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("markdown", "rdoc", "asciidoc", "org");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupWikisCreateFormat.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupGroupWikisCreateFormat constant) {
        final GitLabGroupGroupWikisCreateFormat decoded =
                GitLabGroupGroupWikisCreateFormat.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupWikisCreateFormat.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupWikisCreateFormat.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
