package io.github.piotr_janczukowicz.gitlab.api.linkedepics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupLinkedEpicsCreateLinkTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupLinkedEpicsCreateLinkType.values())
                .map(GitLabGroupLinkedEpicsCreateLinkType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("relates_to", "blocks", "is_blocked_by");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupLinkedEpicsCreateLinkType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupLinkedEpicsCreateLinkType constant) {
        final GitLabGroupLinkedEpicsCreateLinkType decoded =
                GitLabGroupLinkedEpicsCreateLinkType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupLinkedEpicsCreateLinkType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupLinkedEpicsCreateLinkType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
