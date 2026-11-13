package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceProjectsListUsersStarredProjectsOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceProjectsListUsersStarredProjectsOrderBy.values())
                .map(GitLabInstanceProjectsListUsersStarredProjectsOrderBy::wireValue)
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
                        "star_count",
                        "storage_size",
                        "repository_size",
                        "wiki_size",
                        "packages_size");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceProjectsListUsersStarredProjectsOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceProjectsListUsersStarredProjectsOrderBy constant) {
        final GitLabInstanceProjectsListUsersStarredProjectsOrderBy decoded =
                GitLabInstanceProjectsListUsersStarredProjectsOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceProjectsListUsersStarredProjectsOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceProjectsListUsersStarredProjectsOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
