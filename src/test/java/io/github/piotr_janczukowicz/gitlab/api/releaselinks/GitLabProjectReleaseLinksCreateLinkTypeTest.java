package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectReleaseLinksCreateLinkTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectReleaseLinksCreateLinkType.values())
                .map(GitLabProjectReleaseLinksCreateLinkType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("other", "runbook", "image", "package");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectReleaseLinksCreateLinkType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectReleaseLinksCreateLinkType constant) {
        final GitLabProjectReleaseLinksCreateLinkType decoded =
                GitLabProjectReleaseLinksCreateLinkType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectReleaseLinksCreateLinkType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectReleaseLinksCreateLinkType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
