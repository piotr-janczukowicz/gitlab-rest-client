package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsUpdateManagedLicensePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsUpdateManagedLicensePayloadBuilder builder =
                GitLabProjectProjectsUpdateManagedLicensePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload())
                        .name(null);

        final GitLabProjectProjectsUpdateManagedLicensePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalStatusIsNullable() {
        final GitLabProjectProjectsUpdateManagedLicensePayloadBuilder builder =
                GitLabProjectProjectsUpdateManagedLicensePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload())
                        .approvalStatus(null);

        final GitLabProjectProjectsUpdateManagedLicensePayload built = builder.build();

        assertThat(built.approvalStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateManagedLicensePayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("MIT");
            softly.assertThat(value.approvalStatus())
                    .isEqualTo(GitLabProjectProjectsUpdateManagedLicenseApprovalStatus.ALLOWED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateManagedLicensePayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateManagedLicensePayload();

        final GitLabProjectProjectsUpdateManagedLicensePayload rebuilt =
                GitLabProjectProjectsUpdateManagedLicensePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateManagedLicensePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "approvalStatus");
    }
}
