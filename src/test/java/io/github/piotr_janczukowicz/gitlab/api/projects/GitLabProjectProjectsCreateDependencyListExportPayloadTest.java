package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateDependencyListExportPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSendEmailIsNullable() {
        final GitLabProjectProjectsCreateDependencyListExportPayloadBuilder builder =
                GitLabProjectProjectsCreateDependencyListExportPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload())
                        .sendEmail(null);

        final GitLabProjectProjectsCreateDependencyListExportPayload built = builder.build();

        assertThat(built.sendEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportTypeIsNullable() {
        final GitLabProjectProjectsCreateDependencyListExportPayloadBuilder builder =
                GitLabProjectProjectsCreateDependencyListExportPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload())
                        .exportType(null);

        final GitLabProjectProjectsCreateDependencyListExportPayload built = builder.build();

        assertThat(built.exportType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateDependencyListExportPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sendEmail()).isEqualTo(true);
            softly.assertThat(value.exportType())
                    .isEqualTo(GitLabProjectProjectsCreateDependencyListExportType.DEPENDENCY_LIST);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateDependencyListExportPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateDependencyListExportPayload();

        final GitLabProjectProjectsCreateDependencyListExportPayload rebuilt =
                GitLabProjectProjectsCreateDependencyListExportPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateDependencyListExportPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sendEmail", "exportType");
    }
}
