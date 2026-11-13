package io.github.piotr_janczukowicz.gitlab.api.dependencylistexports;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDependencyListExportsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSendEmailIsNullable() {
        final GitLabDependencyListExportsCreatePayloadBuilder builder =
                GitLabDependencyListExportsCreatePayloadBuilder.builder(
                                DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload())
                        .sendEmail(null);

        final GitLabDependencyListExportsCreatePayload built = builder.build();

        assertThat(built.sendEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportTypeIsNullable() {
        final GitLabDependencyListExportsCreatePayloadBuilder builder =
                GitLabDependencyListExportsCreatePayloadBuilder.builder(
                                DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload())
                        .exportType(null);

        final GitLabDependencyListExportsCreatePayload built = builder.build();

        assertThat(built.exportType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDependencyListExportsCreatePayload value =
                DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sendEmail()).isEqualTo(true);
            softly.assertThat(value.exportType()).isEqualTo(GitLabDependencyListExportsCreateExportType.SBOM);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDependencyListExportsCreatePayload original =
                DependencylistexportsCatalogFixtures.dependencyListExportsCreatePayload();

        final GitLabDependencyListExportsCreatePayload rebuilt =
                GitLabDependencyListExportsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDependencyListExportsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sendEmail", "exportType");
    }
}
