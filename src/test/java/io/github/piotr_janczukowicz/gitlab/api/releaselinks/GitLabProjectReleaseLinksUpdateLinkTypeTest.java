package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectReleaseLinksUpdateLinkTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectReleaseLinksUpdateLinkType.values())
                .map(GitLabProjectReleaseLinksUpdateLinkType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("other", "runbook", "image", "package");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectReleaseLinksUpdateLinkType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectReleaseLinksUpdateLinkType constant) {
        final GitLabProjectReleaseLinksUpdateLinkType decoded =
                GitLabProjectReleaseLinksUpdateLinkType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectReleaseLinksUpdateLinkType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectReleaseLinksUpdateLinkType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
