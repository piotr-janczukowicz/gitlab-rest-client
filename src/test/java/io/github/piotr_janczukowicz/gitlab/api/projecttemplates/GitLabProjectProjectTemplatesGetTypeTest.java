package io.github.piotr_janczukowicz.gitlab.api.projecttemplates;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectTemplatesGetTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectTemplatesGetType.values())
                .map(GitLabProjectProjectTemplatesGetType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("dockerfiles", "gitignores", "gitlab_ci_ymls", "licenses", "issues", "merge_requests");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectTemplatesGetType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectProjectTemplatesGetType constant) {
        final GitLabProjectProjectTemplatesGetType decoded =
                GitLabProjectProjectTemplatesGetType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectTemplatesGetType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectProjectTemplatesGetType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
