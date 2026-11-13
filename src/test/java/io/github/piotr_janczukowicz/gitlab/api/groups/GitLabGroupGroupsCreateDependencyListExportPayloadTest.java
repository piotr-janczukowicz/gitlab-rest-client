package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupsCreateDependencyListExportPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSendEmailIsNullable() {
        final GitLabGroupGroupsCreateDependencyListExportPayloadBuilder builder =
                GitLabGroupGroupsCreateDependencyListExportPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload())
                        .sendEmail(null);

        final GitLabGroupGroupsCreateDependencyListExportPayload built = builder.build();

        assertThat(built.sendEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExportTypeIsNullable() {
        final GitLabGroupGroupsCreateDependencyListExportPayloadBuilder builder =
                GitLabGroupGroupsCreateDependencyListExportPayloadBuilder.builder(
                                GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload())
                        .exportType(null);

        final GitLabGroupGroupsCreateDependencyListExportPayload built = builder.build();

        assertThat(built.exportType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupsCreateDependencyListExportPayload value =
                GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sendEmail()).isEqualTo(true);
            softly.assertThat(value.exportType()).isEqualTo(GitLabGroupGroupsCreateDependencyListExportType.JSON_ARRAY);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupsCreateDependencyListExportPayload original =
                GroupsCatalogFixtures.groupGroupsCreateDependencyListExportPayload();

        final GitLabGroupGroupsCreateDependencyListExportPayload rebuilt =
                GitLabGroupGroupsCreateDependencyListExportPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupGroupsCreateDependencyListExportPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sendEmail", "exportType");
    }
}
