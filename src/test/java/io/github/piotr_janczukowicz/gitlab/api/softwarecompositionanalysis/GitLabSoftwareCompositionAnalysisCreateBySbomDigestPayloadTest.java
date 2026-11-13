package io.github.piotr_janczukowicz.gitlab.api.softwarecompositionanalysis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayloadTest {

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload original =
                SoftwarecompositionanalysisCatalogFixtures.softwareCompositionAnalysisCreateBySbomDigestPayload();

        final GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload rebuilt =
                GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSoftwareCompositionAnalysisCreateBySbomDigestPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly();
    }
}
