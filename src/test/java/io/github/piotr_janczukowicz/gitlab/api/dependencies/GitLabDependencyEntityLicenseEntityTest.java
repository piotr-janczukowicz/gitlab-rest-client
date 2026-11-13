package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDependencyEntityLicenseEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenSpdxIdentifierIsNullable() {
        final GitLabDependencyEntityLicenseEntityBuilder builder = GitLabDependencyEntityLicenseEntityBuilder.builder(
                        DependenciesCatalogFixtures.dependencyEntityLicenseEntity())
                .spdxIdentifier(null);

        final GitLabDependencyEntityLicenseEntity built = builder.build();

        assertThat(built.spdxIdentifier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabDependencyEntityLicenseEntityBuilder builder = GitLabDependencyEntityLicenseEntityBuilder.builder(
                        DependenciesCatalogFixtures.dependencyEntityLicenseEntity())
                .name(null);

        final GitLabDependencyEntityLicenseEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabDependencyEntityLicenseEntityBuilder builder = GitLabDependencyEntityLicenseEntityBuilder.builder(
                        DependenciesCatalogFixtures.dependencyEntityLicenseEntity())
                .url(null);

        final GitLabDependencyEntityLicenseEntity built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDependencyEntityLicenseEntity value = DependenciesCatalogFixtures.dependencyEntityLicenseEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.spdxIdentifier()).isEqualTo("spdx_identifier");
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDependencyEntityLicenseEntity original =
                DependenciesCatalogFixtures.dependencyEntityLicenseEntity();

        final GitLabDependencyEntityLicenseEntity rebuilt =
                GitLabDependencyEntityLicenseEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDependencyEntityLicenseEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("spdxIdentifier", "name", "url");
    }
}
