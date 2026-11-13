package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectsCreateManagedLicenseApprovalStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectsCreateManagedLicenseApprovalStatus.values())
                .map(GitLabProjectProjectsCreateManagedLicenseApprovalStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("allowed", "denied");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectsCreateManagedLicenseApprovalStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectsCreateManagedLicenseApprovalStatus constant) {
        final GitLabProjectProjectsCreateManagedLicenseApprovalStatus decoded =
                GitLabProjectProjectsCreateManagedLicenseApprovalStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsCreateManagedLicenseApprovalStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectsCreateManagedLicenseApprovalStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
