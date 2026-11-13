package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformModulesCallByModuleVersionFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTerraformGetIsNullable() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder builder =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder(
                                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                                        .build())
                        .terraformGet(null);

        final GitLabProjectTerraformModulesCallByModuleVersionFilter built = builder.build();

        assertThat(built.terraformGet()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter value =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                        .build();

        assertThat(value.terraformGet()).isEqualTo(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter original =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                        .build();

        final GitLabProjectTerraformModulesCallByModuleVersionFilter rebuilt =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectTerraformModulesCallByModuleVersionFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("terraformGet");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter empty =
                GitLabProjectTerraformModulesCallByModuleVersionFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter filter =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("terraform-get", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter filter =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("terraform-get", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectTerraformModulesCallByModuleVersionFilter filter =
                GitLabProjectTerraformModulesCallByModuleVersionFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallByModuleVersionTerraformGet.N_1)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
