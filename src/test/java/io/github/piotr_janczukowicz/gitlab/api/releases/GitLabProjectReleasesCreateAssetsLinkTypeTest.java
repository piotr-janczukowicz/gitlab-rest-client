package io.github.piotr_janczukowicz.gitlab.api.releases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectReleasesCreateAssetsLinkTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectReleasesCreateAssetsLinkType.values())
                .map(GitLabProjectReleasesCreateAssetsLinkType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("other", "runbook", "package", "image");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectReleasesCreateAssetsLinkType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectReleasesCreateAssetsLinkType constant) {
        final GitLabProjectReleasesCreateAssetsLinkType decoded =
                GitLabProjectReleasesCreateAssetsLinkType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectReleasesCreateAssetsLinkType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectReleasesCreateAssetsLinkType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
