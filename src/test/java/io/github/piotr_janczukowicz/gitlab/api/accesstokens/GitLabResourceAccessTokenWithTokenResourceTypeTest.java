package io.github.piotr_janczukowicz.gitlab.api.accesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabResourceAccessTokenWithTokenResourceTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabResourceAccessTokenWithTokenResourceType.values())
                .filter(constant -> constant != GitLabResourceAccessTokenWithTokenResourceType.UNRECOGNIZED)
                .map(GitLabResourceAccessTokenWithTokenResourceType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("project", "group");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabResourceAccessTokenWithTokenResourceType.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabResourceAccessTokenWithTokenResourceType constant) {
        final GitLabResourceAccessTokenWithTokenResourceType decoded =
                GitLabResourceAccessTokenWithTokenResourceType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabResourceAccessTokenWithTokenResourceType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabResourceAccessTokenWithTokenResourceType decoded =
                GitLabResourceAccessTokenWithTokenResourceType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabResourceAccessTokenWithTokenResourceType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabResourceAccessTokenWithTokenResourceType.values())
                .filter(constant -> constant.wireValue()
                        .equals(GitLabResourceAccessTokenWithTokenResourceType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
