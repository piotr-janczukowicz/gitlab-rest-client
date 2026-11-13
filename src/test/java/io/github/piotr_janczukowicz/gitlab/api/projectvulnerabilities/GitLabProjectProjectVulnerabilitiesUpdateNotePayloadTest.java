package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectVulnerabilitiesUpdateNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload())
                        .body(null);

        final GitLabProjectProjectVulnerabilitiesUpdateNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload())
                        .confidential(null);

        final GitLabProjectProjectVulnerabilitiesUpdateNotePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectVulnerabilitiesUpdateNotePayload value =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectVulnerabilitiesUpdateNotePayload original =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesUpdateNotePayload();

        final GitLabProjectProjectVulnerabilitiesUpdateNotePayload rebuilt =
                GitLabProjectProjectVulnerabilitiesUpdateNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectVulnerabilitiesUpdateNotePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential");
    }
}
