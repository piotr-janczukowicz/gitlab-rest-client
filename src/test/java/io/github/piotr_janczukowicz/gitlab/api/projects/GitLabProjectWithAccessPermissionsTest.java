package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectWithAccessPermissionsTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectAccessIsNullable() {
        final GitLabProjectWithAccessPermissionsBuilder builder = GitLabProjectWithAccessPermissionsBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessPermissions())
                .projectAccess(null);

        final GitLabProjectWithAccessPermissions built = builder.build();

        assertThat(built.projectAccess()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupAccessIsNullable() {
        final GitLabProjectWithAccessPermissionsBuilder builder = GitLabProjectWithAccessPermissionsBuilder.builder(
                        ProjectsCatalogFixtures.projectWithAccessPermissions())
                .groupAccess(null);

        final GitLabProjectWithAccessPermissions built = builder.build();

        assertThat(built.groupAccess()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithAccessPermissions value = ProjectsCatalogFixtures.projectWithAccessPermissions();

        assertSoftly(softly -> {
            softly.assertThat(value.projectAccess()).isEqualTo(CommonCatalogFixtures.projectAccess());
            softly.assertThat(value.groupAccess()).isEqualTo(CommonCatalogFixtures.groupAccess());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectWithAccessPermissions original = ProjectsCatalogFixtures.projectWithAccessPermissions();

        final GitLabProjectWithAccessPermissions rebuilt =
                GitLabProjectWithAccessPermissionsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithAccessPermissions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectAccess", "groupAccess");
    }
}
