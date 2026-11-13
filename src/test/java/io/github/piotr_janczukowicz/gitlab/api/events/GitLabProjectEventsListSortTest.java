package io.github.piotr_janczukowicz.gitlab.api.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectEventsListSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectEventsListSort.values())
                .map(GitLabProjectEventsListSort::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("asc", "desc");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectEventsListSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectEventsListSort constant) {
        final GitLabProjectEventsListSort decoded = GitLabProjectEventsListSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEventsListSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEventsListSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
