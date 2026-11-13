package io.github.piotr_janczukowicz.gitlab.api.repositoryfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryFilesGetRawFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectRepositoryFilesGetRawFilterBuilder builder =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder(
                                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                                        .ref("ref")
                                        .lfs(true)
                                        .build())
                        .ref(null);

        final GitLabProjectRepositoryFilesGetRawFilter built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLfsIsNullable() {
        final GitLabProjectRepositoryFilesGetRawFilterBuilder builder =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder(
                                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                                        .ref("ref")
                                        .lfs(true)
                                        .build())
                        .lfs(null);

        final GitLabProjectRepositoryFilesGetRawFilter built = builder.build();

        assertThat(built.lfs()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryFilesGetRawFilter value = GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                .ref("ref")
                .lfs(true)
                .build();

        assertSoftly(softly -> {
            softly.assertThat(value.ref()).isEqualTo("ref");
            softly.assertThat(value.lfs()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryFilesGetRawFilter original =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                        .ref("ref")
                        .lfs(true)
                        .build();

        final GitLabProjectRepositoryFilesGetRawFilter rebuilt =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryFilesGetRawFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("ref", "lfs");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabProjectRepositoryFilesGetRawFilter empty = GitLabProjectRepositoryFilesGetRawFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabProjectRepositoryFilesGetRawFilter filter =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                        .ref("ref")
                        .lfs(true)
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"), Map.entry("lfs", "true"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabProjectRepositoryFilesGetRawFilter filter =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                        .ref("ref")
                        .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("ref", "ref"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabProjectRepositoryFilesGetRawFilter filter =
                GitLabProjectRepositoryFilesGetRawFilterBuilder.builder()
                        .ref("ref")
                        .lfs(true)
                        .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
