package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSearchZoektProjectIndexSuccessTest {

    @Test
    void constructor_shouldAcceptNull_whenJobIdIsNullable() {
        final GitLabSearchZoektProjectIndexSuccessBuilder builder = GitLabSearchZoektProjectIndexSuccessBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektProjectIndexSuccess())
                .jobId(null);

        final GitLabSearchZoektProjectIndexSuccess built = builder.build();

        assertThat(built.jobId()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSearchZoektProjectIndexSuccess value = CodesearchCatalogFixtures.searchZoektProjectIndexSuccess();

        assertThat(value.jobId()).isEqualTo("job_id");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSearchZoektProjectIndexSuccess original =
                CodesearchCatalogFixtures.searchZoektProjectIndexSuccess();

        final GitLabSearchZoektProjectIndexSuccess rebuilt =
                GitLabSearchZoektProjectIndexSuccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSearchZoektProjectIndexSuccess.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("jobId");
    }
}
