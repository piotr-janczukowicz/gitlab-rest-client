package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceRunnersCreateInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceRunnersCreateInfoBuilder builder = GitLabInstanceRunnersCreateInfoBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .name(null);

        final GitLabInstanceRunnersCreateInfo built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabInstanceRunnersCreateInfoBuilder builder = GitLabInstanceRunnersCreateInfoBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .version(null);

        final GitLabInstanceRunnersCreateInfo built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabInstanceRunnersCreateInfoBuilder builder = GitLabInstanceRunnersCreateInfoBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .revision(null);

        final GitLabInstanceRunnersCreateInfo built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformIsNullable() {
        final GitLabInstanceRunnersCreateInfoBuilder builder = GitLabInstanceRunnersCreateInfoBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .platform(null);

        final GitLabInstanceRunnersCreateInfo built = builder.build();

        assertThat(built.platform()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitectureIsNullable() {
        final GitLabInstanceRunnersCreateInfoBuilder builder = GitLabInstanceRunnersCreateInfoBuilder.builder(
                        RunnersCatalogFixtures.instanceRunnersCreateInfo())
                .architecture(null);

        final GitLabInstanceRunnersCreateInfo built = builder.build();

        assertThat(built.architecture()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceRunnersCreateInfo value = RunnersCatalogFixtures.instanceRunnersCreateInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.revision()).isEqualTo("revision");
            softly.assertThat(value.platform()).isEqualTo("platform");
            softly.assertThat(value.architecture()).isEqualTo("architecture");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceRunnersCreateInfo original = RunnersCatalogFixtures.instanceRunnersCreateInfo();

        final GitLabInstanceRunnersCreateInfo rebuilt =
                GitLabInstanceRunnersCreateInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceRunnersCreateInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "version", "revision", "platform", "architecture");
    }
}
