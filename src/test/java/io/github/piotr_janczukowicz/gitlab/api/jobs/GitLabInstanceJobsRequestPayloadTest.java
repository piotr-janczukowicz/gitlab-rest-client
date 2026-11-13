package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceJobsRequestPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabInstanceJobsRequestPayloadBuilder builder = GitLabInstanceJobsRequestPayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestPayload())
                .token(null);

        final GitLabInstanceJobsRequestPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSystemIdIsNullable() {
        final GitLabInstanceJobsRequestPayloadBuilder builder = GitLabInstanceJobsRequestPayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestPayload())
                .systemId(null);

        final GitLabInstanceJobsRequestPayload built = builder.build();

        assertThat(built.systemId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastUpdateIsNullable() {
        final GitLabInstanceJobsRequestPayloadBuilder builder = GitLabInstanceJobsRequestPayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestPayload())
                .lastUpdate(null);

        final GitLabInstanceJobsRequestPayload built = builder.build();

        assertThat(built.lastUpdate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInfoIsNullable() {
        final GitLabInstanceJobsRequestPayloadBuilder builder = GitLabInstanceJobsRequestPayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestPayload())
                .info(null);

        final GitLabInstanceJobsRequestPayload built = builder.build();

        assertThat(built.info()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionIsNullable() {
        final GitLabInstanceJobsRequestPayloadBuilder builder = GitLabInstanceJobsRequestPayloadBuilder.builder(
                        JobsCatalogFixtures.instanceJobsRequestPayload())
                .session(null);

        final GitLabInstanceJobsRequestPayload built = builder.build();

        assertThat(built.session()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceJobsRequestPayload value = JobsCatalogFixtures.instanceJobsRequestPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.systemId()).isEqualTo("system_id");
            softly.assertThat(value.lastUpdate()).isEqualTo("last_update");
            softly.assertThat(value.info()).isEqualTo(JobsCatalogFixtures.instanceJobsRequestInfo());
            softly.assertThat(value.session()).isEqualTo(JobsCatalogFixtures.instanceJobsRequestSession());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceJobsRequestPayload original = JobsCatalogFixtures.instanceJobsRequestPayload();

        final GitLabInstanceJobsRequestPayload rebuilt =
                GitLabInstanceJobsRequestPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabInstanceJobsRequestPayload value = JobsCatalogFixtures.instanceJobsRequestPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceJobsRequestPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token", "systemId", "lastUpdate", "info", "session");
    }
}
