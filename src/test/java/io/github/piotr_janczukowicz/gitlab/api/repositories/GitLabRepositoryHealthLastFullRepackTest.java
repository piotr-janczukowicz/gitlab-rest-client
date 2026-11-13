package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthLastFullRepackTest {

    @Test
    void constructor_shouldAcceptNull_whenSecondsIsNullable() {
        final GitLabRepositoryHealthLastFullRepackBuilder builder = GitLabRepositoryHealthLastFullRepackBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthLastFullRepack())
                .seconds(null);

        final GitLabRepositoryHealthLastFullRepack built = builder.build();

        assertThat(built.seconds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNanosIsNullable() {
        final GitLabRepositoryHealthLastFullRepackBuilder builder = GitLabRepositoryHealthLastFullRepackBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthLastFullRepack())
                .nanos(null);

        final GitLabRepositoryHealthLastFullRepack built = builder.build();

        assertThat(built.nanos()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthLastFullRepack value = RepositoriesCatalogFixtures.repositoryHealthLastFullRepack();

        assertSoftly(softly -> {
            softly.assertThat(value.seconds()).isEqualTo(1);
            softly.assertThat(value.nanos()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthLastFullRepack original =
                RepositoriesCatalogFixtures.repositoryHealthLastFullRepack();

        final GitLabRepositoryHealthLastFullRepack rebuilt =
                GitLabRepositoryHealthLastFullRepackBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthLastFullRepack.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("seconds", "nanos");
    }
}
