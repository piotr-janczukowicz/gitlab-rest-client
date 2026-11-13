package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTerraformModuleVersionsTest {

    @Test
    void constructor_shouldAcceptNull_whenModulesIsNullable() {
        final GitLabTerraformModuleVersionsBuilder builder = GitLabTerraformModuleVersionsBuilder.builder(
                        TerraformmodulesCatalogFixtures.terraformModuleVersions())
                .modules(null);

        final GitLabTerraformModuleVersions built = builder.build();

        assertThat(built.modules()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTerraformModuleVersions value = TerraformmodulesCatalogFixtures.terraformModuleVersions();

        assertThat(value.modules()).isEqualTo("modules");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTerraformModuleVersions original = TerraformmodulesCatalogFixtures.terraformModuleVersions();

        final GitLabTerraformModuleVersions rebuilt =
                GitLabTerraformModuleVersionsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTerraformModuleVersions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("modules");
    }
}
