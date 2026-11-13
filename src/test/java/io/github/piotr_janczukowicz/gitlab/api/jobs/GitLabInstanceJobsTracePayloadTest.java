package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsTracePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsTracePayloadBuilder builder = GitLabInstanceJobsTracePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsTracePayload())
                .token(null);

        final GitLabInstanceJobsTracePayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDebugTraceIsNullable() {
        final GitLabInstanceJobsTracePayloadBuilder builder = GitLabInstanceJobsTracePayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsTracePayload())
                .debugTrace(null);

        final GitLabInstanceJobsTracePayload built = builder.build();

        assertThat(built.debugTrace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsTracePayload value = JobsCatalogFixtures.instanceJobsTracePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.debugTrace()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsTracePayload original = JobsCatalogFixtures.instanceJobsTracePayload();

        final GitLabInstanceJobsTracePayload rebuilt =
                GitLabInstanceJobsTracePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsTracePayload value = JobsCatalogFixtures.instanceJobsTracePayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsTracePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "debugTrace");
    }
}
