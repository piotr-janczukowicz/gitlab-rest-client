package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListDescendantGroupsOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsListDescendantGroupsOrderBy.values())
                .map(GitLabGroupGroupsListDescendantGroupsOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("name", "path", "id", "similarity");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListDescendantGroupsOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsListDescendantGroupsOrderBy constant) {
        final GitLabGroupGroupsListDescendantGroupsOrderBy decoded =
                GitLabGroupGroupsListDescendantGroupsOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListDescendantGroupsOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsListDescendantGroupsOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
