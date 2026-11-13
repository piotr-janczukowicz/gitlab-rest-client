package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSoftwareCompositionAnalysisAuthorizePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFilesizeIsNullable() {
        final GitLabSoftwareCompositionAnalysisAuthorizePayloadBuilder builder =
                GitLabSoftwareCompositionAnalysisAuthorizePayloadBuilder.builder(
                                SoftwarecompositionanalysisCatalogFixtures
                                        .softwareCompositionAnalysisAuthorizePayload())
                        .filesize(null);

        final GitLabSoftwareCompositionAnalysisAuthorizePayload built = builder.build();

        assertThat(built.filesize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSoftwareCompositionAnalysisAuthorizePayload value =
                SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload();

        assertThat(value.filesize()).isEqualTo(1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSoftwareCompositionAnalysisAuthorizePayload original =
                SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisAuthorizePayload();

        final GitLabSoftwareCompositionAnalysisAuthorizePayload rebuilt =
                GitLabSoftwareCompositionAnalysisAuthorizePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSoftwareCompositionAnalysisAuthorizePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("filesize");
    }
}
