package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsAuthorizeArtifactPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsAuthorizeArtifactPayloadBuilder builder =
                GitLabInstanceJobsAuthorizeArtifactPayloadBuilder.builder(
                                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload())
                        .token(null);

        final GitLabInstanceJobsAuthorizeArtifactPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesizeIsNullable() {
        final GitLabInstanceJobsAuthorizeArtifactPayloadBuilder builder =
                GitLabInstanceJobsAuthorizeArtifactPayloadBuilder.builder(
                                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload())
                        .filesize(null);

        final GitLabInstanceJobsAuthorizeArtifactPayload built = builder.build();

        assertThat(built.filesize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArtifactTypeIsNullable() {
        final GitLabInstanceJobsAuthorizeArtifactPayloadBuilder builder =
                GitLabInstanceJobsAuthorizeArtifactPayloadBuilder.builder(
                                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload())
                        .artifactType(null);

        final GitLabInstanceJobsAuthorizeArtifactPayload built = builder.build();

        assertThat(built.artifactType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsAuthorizeArtifactPayload value =
                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.filesize()).isEqualTo(1);
            softly.assertThat(value.artifactType()).isEqualTo(GitLabInstanceJobsAuthorizeArtifactType.ARCHIVE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsAuthorizeArtifactPayload original =
                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload();

        final GitLabInstanceJobsAuthorizeArtifactPayload rebuilt =
                GitLabInstanceJobsAuthorizeArtifactPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsAuthorizeArtifactPayload value =
                JobsCatalogFixtures.instanceJobsAuthorizeArtifactPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsAuthorizeArtifactPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "filesize", "artifactType");
    }
}
