package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectTemplatesListTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectTemplatesListType.values())
                .map(GitLabProjectProjectTemplatesListType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("dockerfiles", "gitignores", "gitlab_ci_ymls", "licenses", "issues", "merge_requests");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectTemplatesListType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectTemplatesListType constant) {
        final GitLabProjectProjectTemplatesListType decoded =
                GitLabProjectProjectTemplatesListType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectTemplatesListType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectTemplatesListType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
