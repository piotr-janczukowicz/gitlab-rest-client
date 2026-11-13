package io.github.piotr_janczukowicz.gitlab.api.commits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectCommitsListStatusesOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectCommitsListStatusesOrderBy.values())
                .map(GitLabProjectCommitsListStatusesOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("id", "pipeline_id");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectCommitsListStatusesOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectCommitsListStatusesOrderBy constant) {
        final GitLabProjectCommitsListStatusesOrderBy decoded =
                GitLabProjectCommitsListStatusesOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectCommitsListStatusesOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectCommitsListStatusesOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
