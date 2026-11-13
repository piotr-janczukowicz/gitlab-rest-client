package io.github.piotr_janczukowicz.gitlab.api.search;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectSearchCallScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectSearchCallScope.values())
                .map(GitLabProjectSearchCallScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "issues",
                        "work_items",
                        "merge_requests",
                        "milestones",
                        "notes",
                        "wiki_blobs",
                        "commits",
                        "blobs",
                        "users");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectSearchCallScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectSearchCallScope constant) {
        final GitLabProjectSearchCallScope decoded = GitLabProjectSearchCallScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectSearchCallScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectSearchCallScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
