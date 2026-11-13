package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabManagedLicenseTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabManagedLicenseBuilder builder = GitLabManagedLicenseBuilder.builder(
                        ProjectsCatalogFixtures.managedLicense())
                .id(null);

        final GitLabManagedLicense built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabManagedLicenseBuilder builder = GitLabManagedLicenseBuilder.builder(
                        ProjectsCatalogFixtures.managedLicense())
                .name(null);

        final GitLabManagedLicense built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApprovalStatusIsNullable() {
        final GitLabManagedLicenseBuilder builder = GitLabManagedLicenseBuilder.builder(
                        ProjectsCatalogFixtures.managedLicense())
                .approvalStatus(null);

        final GitLabManagedLicense built = builder.build();

        assertThat(built.approvalStatus()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabManagedLicense value = ProjectsCatalogFixtures.managedLicense();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.approvalStatus()).isEqualTo("approval_status");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabManagedLicense original = ProjectsCatalogFixtures.managedLicense();

        final GitLabManagedLicense rebuilt =
                GitLabManagedLicenseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabManagedLicense.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "approvalStatus");
    }
}
