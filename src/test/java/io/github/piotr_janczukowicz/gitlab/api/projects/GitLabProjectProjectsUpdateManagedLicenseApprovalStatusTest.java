package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsUpdateManagedLicenseApprovalStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.values())
                .map(GitLabProjectProjectsUpdateManagedLicenseApprovalStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("allowed", "denied");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsUpdateManagedLicenseApprovalStatus constant) {
        final GitLabProjectProjectsUpdateManagedLicenseApprovalStatus decoded =
                GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
