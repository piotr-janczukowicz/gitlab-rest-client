package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectPipelinesListSourceTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectPipelinesListSource.values())
                .map(GitLabProjectPipelinesListSource::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "unknown",
                        "push",
                        "web",
                        "trigger",
                        "schedule",
                        "api",
                        "external",
                        "pipeline",
                        "chat",
                        "webide",
                        "merge_request_event",
                        "external_pull_request_event",
                        "parent_pipeline",
                        "ondemand_dast_scan",
                        "ondemand_dast_validation",
                        "security_orchestration_policy",
                        "container_registry_push",
                        "duo_workflow",
                        "pipeline_execution_policy_schedule",
                        "dependency_management_security_update");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectPipelinesListSource.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectPipelinesListSource constant) {
        final GitLabProjectPipelinesListSource decoded =
                GitLabProjectPipelinesListSource.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectPipelinesListSource.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectPipelinesListSource.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
