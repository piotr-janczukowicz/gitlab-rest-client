package io.github.piotr_janczukowicz.gitlab.api.terraformmodules;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformModulesCallFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenTerraformGetIsNullable() {
        final GitLabProjectTerraformModulesCallFilterBuilder builder =
                GitLabProjectTerraformModulesCallFilterBuilder.builder(
                                GitLabProjectTerraformModulesCallFilterBuilder.builder()
                                        .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                                        .build())
                        .terraformGet(null);

        final GitLabProjectTerraformModulesCallFilter built = builder.build();

        assertThat(built.terraformGet()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformModulesCallFilter value = GitLabProjectTerraformModulesCallFilterBuilder.builder()
                .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                .build();

        assertThat(value.terraformGet()).isEqualTo(GitLabProjectTerraformModulesCallTerraformGet.N_1);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformModulesCallFilter original =
                GitLabProjectTerraformModulesCallFilterBuilder.builder()
                        .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                        .build();

        final GitLabProjectTerraformModulesCallFilter rebuilt =
                GitLabProjectTerraformModulesCallFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectTerraformModulesCallFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("terraformGet");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectTerraformModulesCallFilter empty = GitLabProjectTerraformModulesCallFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectTerraformModulesCallFilter filter = GitLabProjectTerraformModulesCallFilterBuilder.builder()
                .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("terraform-get", "1"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectTerraformModulesCallFilter filter = GitLabProjectTerraformModulesCallFilterBuilder.builder()
                .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("terraform-get", "1"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectTerraformModulesCallFilter filter = GitLabProjectTerraformModulesCallFilterBuilder.builder()
                .terraformGet(GitLabProjectTerraformModulesCallTerraformGet.N_1)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
