package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectWithAccessAndCatalogPermissionsTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectAccessIsNullable() {
        final GitLabProjectWithAccessAndCatalogPermissionsBuilder builder =
                GitLabProjectWithAccessAndCatalogPermissionsBuilder.builder(
                                ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions())
                        .projectAccess(null);

        final GitLabProjectWithAccessAndCatalogPermissions built = builder.build();

        assertThat(built.projectAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAccessIsNullable() {
        final GitLabProjectWithAccessAndCatalogPermissionsBuilder builder =
                GitLabProjectWithAccessAndCatalogPermissionsBuilder.builder(
                                ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions())
                        .groupAccess(null);

        final GitLabProjectWithAccessAndCatalogPermissions built = builder.build();

        assertThat(built.groupAccess()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithAccessAndCatalogPermissions value =
                ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions();

        assertSoftly(softly -> {
            softly.assertThat(value.projectAccess()).isEqualTo(CommonCatalogFixtures.projectAccess());
            softly.assertThat(value.groupAccess()).isEqualTo(CommonCatalogFixtures.groupAccess());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectWithAccessAndCatalogPermissions original =
                ProjectsCatalogFixtures.projectWithAccessAndCatalogPermissions();

        final GitLabProjectWithAccessAndCatalogPermissions rebuilt =
                GitLabProjectWithAccessAndCatalogPermissionsBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithAccessAndCatalogPermissions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectAccess", "groupAccess");
    }
}
