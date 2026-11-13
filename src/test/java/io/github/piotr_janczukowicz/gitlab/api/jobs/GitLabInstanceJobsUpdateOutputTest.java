package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsUpdateOutputTest {

    @Test
    void constructor_shouldAcceptNull_whenChecksumIsNullable() {
        final GitLabInstanceJobsUpdateOutputBuilder builder = GitLabInstanceJobsUpdateOutputBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdateOutput())
                .checksum(null);

        final GitLabInstanceJobsUpdateOutput built = builder.build();

        assertThat(built.checksum()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBytesizeIsNullable() {
        final GitLabInstanceJobsUpdateOutputBuilder builder = GitLabInstanceJobsUpdateOutputBuilder.builder(
                        JobsCatalogFixtures.instanceJobsUpdateOutput())
                .bytesize(null);

        final GitLabInstanceJobsUpdateOutput built = builder.build();

        assertThat(built.bytesize()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsUpdateOutput value = JobsCatalogFixtures.instanceJobsUpdateOutput();

        assertSoftly(softly -> {
            softly.assertThat(value.checksum()).isEqualTo("checksum");
            softly.assertThat(value.bytesize()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsUpdateOutput original = JobsCatalogFixtures.instanceJobsUpdateOutput();

        final GitLabInstanceJobsUpdateOutput rebuilt =
                GitLabInstanceJobsUpdateOutputBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsUpdateOutput.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("checksum", "bytesize");
    }
}
