package io.github.piotr_janczukowicz.gitlab.api.projectvulnerabilities;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectVulnerabilitiesCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFindingIdIsNullable() {
        final GitLabProjectProjectVulnerabilitiesCreatePayloadBuilder builder =
                GitLabProjectProjectVulnerabilitiesCreatePayloadBuilder.builder(
                                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload())
                        .findingId(null);

        final GitLabProjectProjectVulnerabilitiesCreatePayload built = builder.build();

        assertThat(built.findingId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectVulnerabilitiesCreatePayload value =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload();

        assertThat(value.findingId()).isEqualTo(1L);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectVulnerabilitiesCreatePayload original =
                ProjectvulnerabilitiesCatalogFixtures.projectProjectVulnerabilitiesCreatePayload();

        final GitLabProjectProjectVulnerabilitiesCreatePayload rebuilt =
                GitLabProjectProjectVulnerabilitiesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectVulnerabilitiesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("findingId");
    }
}
