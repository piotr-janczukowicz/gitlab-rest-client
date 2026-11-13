package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsListPackagesOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsListPackagesOrderBy.values())
                .map(GitLabGroupGroupsListPackagesOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created_at", "name", "version", "type", "project_path");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsListPackagesOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupGroupsListPackagesOrderBy constant) {
        final GitLabGroupGroupsListPackagesOrderBy decoded =
                GitLabGroupGroupsListPackagesOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListPackagesOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupGroupsListPackagesOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
