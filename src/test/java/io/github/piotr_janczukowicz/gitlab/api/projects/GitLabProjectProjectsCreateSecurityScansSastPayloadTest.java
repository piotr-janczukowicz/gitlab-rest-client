package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateSecurityScansSastPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder builder =
                GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload())
                        .filePath(null);

        final GitLabProjectProjectsCreateSecurityScansSastPayload built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder builder =
                GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload())
                        .content(null);

        final GitLabProjectProjectsCreateSecurityScansSastPayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateSecurityScansSastPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.filePath()).isEqualTo("file_path");
            softly.assertThat(value.content()).isEqualTo("content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateSecurityScansSastPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateSecurityScansSastPayload();

        final GitLabProjectProjectsCreateSecurityScansSastPayload rebuilt =
                GitLabProjectProjectsCreateSecurityScansSastPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateSecurityScansSastPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filePath", "content");
    }
}
