package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsRequestInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .name(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVersionIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .version(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.version()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .revision(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.revision()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPlatformIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .platform(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.platform()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenArchitectureIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .architecture(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.architecture()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExecutorIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .executor(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.executor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeaturesIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .features(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.features()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .config(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.config()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabInstanceJobsRequestInfoBuilder builder = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .labels(null);

        final GitLabInstanceJobsRequestInfo built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsRequestInfo value = JobsCatalogFixtures.instanceJobsRequestInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.version()).isEqualTo("version");
            softly.assertThat(value.revision()).isEqualTo("revision");
            softly.assertThat(value.platform()).isEqualTo("platform");
            softly.assertThat(value.architecture()).isEqualTo("architecture");
            softly.assertThat(value.executor()).isEqualTo("executor");
            softly.assertThat(value.features()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.config()).isEqualTo(JobsCatalogFixtures.instanceJobsRequestInfoConfig());
            softly.assertThat(value.labels()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsRequestInfo original = JobsCatalogFixtures.instanceJobsRequestInfo();

        final GitLabInstanceJobsRequestInfo rebuilt =
                GitLabInstanceJobsRequestInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenFeaturesSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabInstanceJobsRequestInfo built = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .features(source)
                .build();
        source.clear();

        assertThat(built.features()).isNotEmpty();
    }

    @Test
    void constructor_shouldCopyTheMap_whenLabelsSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabInstanceJobsRequestInfo built = GitLabInstanceJobsRequestInfoBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestInfo())
                .labels(source)
                .build();
        source.clear();

        assertThat(built.labels()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsRequestInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "version",
                        "revision",
                        "platform",
                        "architecture",
                        "executor",
                        "features",
                        "config",
                        "labels");
    }
}
