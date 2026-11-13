package io.github.piotr_janczukowicz.gitlab.api.dependencies;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDependencyTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .name(null);

        final GitLabDependency built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .version(null);

        final GitLabDependency built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackageManagerIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .packageManager(null);

        final GitLabDependency built = builder.build();

        assertThat(built.packageManager()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDependencyFilePathIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .dependencyFilePath(null);

        final GitLabDependency built = builder.build();

        assertThat(built.dependencyFilePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVulnerabilitiesIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .vulnerabilities(null);

        final GitLabDependency built = builder.build();

        assertThat(built.vulnerabilities()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLicensesIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .licenses(null);

        final GitLabDependency built = builder.build();

        assertThat(built.licenses()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMalwareIsNullable() {
        final GitLabDependencyBuilder builder = GitLabDependencyBuilder.builder(
                        DependenciesCatalogFixtures.dependency())
                .malware(null);

        final GitLabDependency built = builder.build();

        assertThat(built.malware()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDependency value = DependenciesCatalogFixtures.dependency();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.packageManager()).isEqualTo("package_manager");
            softly.assertThat(value.dependencyFilePath()).isEqualTo("dependency_file_path");
            softly.assertThat(value.vulnerabilities())
                    .isEqualTo(DependenciesCatalogFixtures.dependencyEntityVulnerabilityEntity());
            softly.assertThat(value.licenses()).isEqualTo(DependenciesCatalogFixtures.dependencyEntityLicenseEntity());
            softly.assertThat(value.malware()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDependency original = DependenciesCatalogFixtures.dependency();

        final GitLabDependency rebuilt =
                GitLabDependencyBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDependency.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "version",
                        "packageManager",
                        "dependencyFilePath",
                        "vulnerabilities",
                        "licenses",
                        "malware");
    }
}
