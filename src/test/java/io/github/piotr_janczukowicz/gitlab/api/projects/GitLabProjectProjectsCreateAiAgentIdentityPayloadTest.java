package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateAiAgentIdentityPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenAgentTypeIsNull() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload())
                        .agentType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("agentType");
    }

    @Test
    void constructor_shouldAcceptNull_whenMachineFingerprintIsNullable() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload())
                        .machineFingerprint(null);

        final GitLabProjectProjectsCreateAiAgentIdentityPayload built = builder.build();

        assertThat(built.machineFingerprint()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenMachineFingerprintIsTooLong() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload())
                        .machineFingerprint("x".repeat(65));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenMachineFingerprintHasTheMaximumLength() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload())
                        .machineFingerprint("x".repeat(64));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.agentType())
                    .isEqualTo(GitLabProjectProjectsCreateAiAgentIdentityAgentType.CLAUDE_CODE);
            softly.assertThat(value.machineFingerprint()).isEqualTo("machine_fingerprint");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateAiAgentIdentityPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentIdentityPayload();

        final GitLabProjectProjectsCreateAiAgentIdentityPayload rebuilt =
                GitLabProjectProjectsCreateAiAgentIdentityPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateAiAgentIdentityPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("agentType", "machineFingerprint");
    }
}
