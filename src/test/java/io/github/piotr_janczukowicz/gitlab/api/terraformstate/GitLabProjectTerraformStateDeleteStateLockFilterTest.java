package io.github.piotr_janczukowicz.gitlab.api.terraformstate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectTerraformStateDeleteStateLockFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenLockIdIsNullable() {
        final GitLabProjectTerraformStateDeleteStateLockFilterBuilder builder =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder(
                                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                                        .lockId("ID")
                                        .build())
                        .lockId(null);

        final GitLabProjectTerraformStateDeleteStateLockFilter built = builder.build();

        assertThat(built.lockId()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenLockIdIsTooLong() {
        final GitLabProjectTerraformStateDeleteStateLockFilterBuilder builder =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder(
                                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                                        .lockId("ID")
                                        .build())
                        .lockId("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenLockIdHasTheMaximumLength() {
        final GitLabProjectTerraformStateDeleteStateLockFilterBuilder builder =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder(
                                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                                        .lockId("ID")
                                        .build())
                        .lockId("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectTerraformStateDeleteStateLockFilter value =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                        .lockId("ID")
                        .build();

        assertThat(value.lockId()).isEqualTo("ID");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectTerraformStateDeleteStateLockFilter original =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                        .lockId("ID")
                        .build();

        final GitLabProjectTerraformStateDeleteStateLockFilter rebuilt =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectTerraformStateDeleteStateLockFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lockId");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectTerraformStateDeleteStateLockFilter empty =
                GitLabProjectTerraformStateDeleteStateLockFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectTerraformStateDeleteStateLockFilter filter =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                        .lockId("ID")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ID", "ID"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectTerraformStateDeleteStateLockFilter filter =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                        .lockId("ID")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ID", "ID"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectTerraformStateDeleteStateLockFilter filter =
                GitLabProjectTerraformStateDeleteStateLockFilterBuilder.builder()
                        .lockId("ID")
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
