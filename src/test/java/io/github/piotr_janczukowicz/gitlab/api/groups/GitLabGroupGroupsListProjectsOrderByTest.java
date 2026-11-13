package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListProjectsOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsListProjectsOrderBy.values())
                .map(GitLabGroupGroupsListProjectsOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "id",
                        "name",
                        "path",
                        "created_at",
                        "updated_at",
                        "last_activity_at",
                        "similarity",
                        "star_count");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListProjectsOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupGroupsListProjectsOrderBy constant) {
        final GitLabGroupGroupsListProjectsOrderBy decoded =
                GitLabGroupGroupsListProjectsOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListProjectsOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListProjectsOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
