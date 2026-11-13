package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTerraformModuleVersionTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .name(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .provider(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.provider()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProvidersIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .providers(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.providers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRootIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .root(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.root()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .source(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSubmodulesIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .submodules(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.submodules()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .version(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionsIsNullable() {
        final GitLabTerraformModuleVersionBuilder builder = GitLabTerraformModuleVersionBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersion())
                .versions(null);

        final GitLabTerraformModuleVersion built = builder.build();

        assertThat(built.versions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTerraformModuleVersion value = TerraformmodulesCatalogFixtures.terraformModuleVersion();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.provider()).isEqualTo("provider");
            softly.assertThat(value.providers()).isEqualTo("providers");
            softly.assertThat(value.root()).isEqualTo("root");
            softly.assertThat(value.source()).isEqualTo("source");
            softly.assertThat(value.submodules()).isEqualTo("submodules");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.versions()).isEqualTo("versions");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTerraformModuleVersion original = TerraformmodulesCatalogFixtures.terraformModuleVersion();

        final GitLabTerraformModuleVersion rebuilt =
                GitLabTerraformModuleVersionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTerraformModuleVersion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "provider", "providers", "root", "source", "submodules", "version", "versions");
    }
}
