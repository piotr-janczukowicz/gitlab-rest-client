package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateManagedLicensePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectsCreateManagedLicensePayloadBuilder builder =
                GitLabProjectProjectsCreateManagedLicensePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload())
                        .name(null);

        final GitLabProjectProjectsCreateManagedLicensePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenApprovalStatusIsNull() {
        final GitLabProjectProjectsCreateManagedLicensePayloadBuilder builder =
                GitLabProjectProjectsCreateManagedLicensePayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload())
                        .approvalStatus(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("approvalStatus");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateManagedLicensePayload value =
                ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("MIT");
            softly.assertThat(value.approvalStatus())
                    .isEqualTo(GitLabProjectProjectsCreateManagedLicenseApprovalStatus.ALLOWED);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateManagedLicensePayload original =
                ProjectsCatalogFixtures.projectProjectsCreateManagedLicensePayload();

        final GitLabProjectProjectsCreateManagedLicensePayload rebuilt =
                GitLabProjectProjectsCreateManagedLicensePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateManagedLicensePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "approvalStatus");
    }
}
