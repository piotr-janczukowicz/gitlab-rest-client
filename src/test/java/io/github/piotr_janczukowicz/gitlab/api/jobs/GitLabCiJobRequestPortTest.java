package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestPortTest {

    @Test
    void constructor_shouldAcceptNull_whenNumberIsNullable() {
        final GitLabCiJobRequestPortBuilder builder = GitLabCiJobRequestPortBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestPort())
                .number(null);

        final GitLabCiJobRequestPort built = builder.build();

        assertThat(built.number()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProtocolIsNullable() {
        final GitLabCiJobRequestPortBuilder builder = GitLabCiJobRequestPortBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestPort())
                .protocol(null);

        final GitLabCiJobRequestPort built = builder.build();

        assertThat(built.protocol()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestPortBuilder builder = GitLabCiJobRequestPortBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestPort())
                .name(null);

        final GitLabCiJobRequestPort built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestPort value = JobsCatalogFixtures.ciJobRequestPort();

        assertSoftly(softly -> {
            softly.assertThat(value.number()).isEqualTo(1);
            softly.assertThat(value.protocol()).isEqualTo("protocol");
            softly.assertThat(value.name()).isEqualTo("name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestPort original = JobsCatalogFixtures.ciJobRequestPort();

        final GitLabCiJobRequestPort rebuilt =
                GitLabCiJobRequestPortBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestPort.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("number", "protocol", "name");
    }
}
