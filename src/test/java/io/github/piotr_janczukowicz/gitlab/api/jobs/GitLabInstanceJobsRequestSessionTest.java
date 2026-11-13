package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsRequestSessionTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabInstanceJobsRequestSessionBuilder builder = GitLabInstanceJobsRequestSessionBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestSession())
                .url(null);

        final GitLabInstanceJobsRequestSession built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateIsNullable() {
        final GitLabInstanceJobsRequestSessionBuilder builder = GitLabInstanceJobsRequestSessionBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestSession())
                .certificate(null);

        final GitLabInstanceJobsRequestSession built = builder.build();

        assertThat(built.certificate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAuthorizationIsNullable() {
        final GitLabInstanceJobsRequestSessionBuilder builder = GitLabInstanceJobsRequestSessionBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestSession())
                .authorization(null);

        final GitLabInstanceJobsRequestSession built = builder.build();

        assertThat(built.authorization()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsRequestSession value = JobsCatalogFixtures.instanceJobsRequestSession();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.certificate()).isEqualTo("certificate");
            softly.assertThat(value.authorization()).isEqualTo("authorization");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsRequestSession original = JobsCatalogFixtures.instanceJobsRequestSession();

        final GitLabInstanceJobsRequestSession rebuilt =
                GitLabInstanceJobsRequestSessionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsRequestSession.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "certificate", "authorization");
    }
}
