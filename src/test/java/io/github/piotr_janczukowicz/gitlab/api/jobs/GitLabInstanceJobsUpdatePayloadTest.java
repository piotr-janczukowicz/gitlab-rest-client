package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .token(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .state(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .checksum(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.checksum()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFailureReasonIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .failureReason(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.failureReason()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOutputIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .output(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.output()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExitCodeIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .exitCode(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.exitCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRuntimeEnvironmentKeyIsNullable() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .runtimeEnvironmentKey(null);

        final GitLabInstanceJobsUpdatePayload built = builder.build();

        assertThat(built.runtimeEnvironmentKey()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenRuntimeEnvironmentKeyIsTooLong() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .runtimeEnvironmentKey("x".repeat(513));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenRuntimeEnvironmentKeyHasTheMaximumLength() {
        final GitLabInstanceJobsUpdatePayloadBuilder builder = GitLabInstanceJobsUpdatePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdatePayload())
                .runtimeEnvironmentKey("x".repeat(512));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsUpdatePayload value = JobsCatalogFixtures.instanceJobsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.state()).isEqualTo("state");
            softly.assertThat(value.checksum()).isEqualTo("checksum");
            softly.assertThat(value.failureReason()).isEqualTo("failure_reason");
            softly.assertThat(value.output()).isEqualTo(JobsCatalogFixtures.instanceJobsUpdateOutput());
            softly.assertThat(value.exitCode()).isEqualTo(1);
            softly.assertThat(value.runtimeEnvironmentKey()).isEqualTo("runtime_environment_key");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsUpdatePayload original = JobsCatalogFixtures.instanceJobsUpdatePayload();

        final GitLabInstanceJobsUpdatePayload rebuilt =
                GitLabInstanceJobsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsUpdatePayload value = JobsCatalogFixtures.instanceJobsUpdatePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "token", "state", "checksum", "failureReason", "output", "exitCode", "runtimeEnvironmentKey");
    }
}
