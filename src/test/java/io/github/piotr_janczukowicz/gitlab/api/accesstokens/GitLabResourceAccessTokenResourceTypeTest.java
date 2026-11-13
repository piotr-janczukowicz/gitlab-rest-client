package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabResourceAccessTokenResourceTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabResourceAccessTokenResourceType.values())
                .filter(constant -> constant != GitLabResourceAccessTokenResourceType.UNRECOGNIZED)
                .map(GitLabResourceAccessTokenResourceType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("project", "group");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabResourceAccessTokenResourceType.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabResourceAccessTokenResourceType constant) {
        final GitLabResourceAccessTokenResourceType decoded =
                GitLabResourceAccessTokenResourceType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabResourceAccessTokenResourceType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabResourceAccessTokenResourceType decoded =
                GitLabResourceAccessTokenResourceType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabResourceAccessTokenResourceType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabResourceAccessTokenResourceType.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabResourceAccessTokenResourceType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
