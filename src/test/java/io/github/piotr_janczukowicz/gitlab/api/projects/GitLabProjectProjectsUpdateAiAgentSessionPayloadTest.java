package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsUpdateAiAgentSessionPayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenStatusIsNull() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload())
                        .status(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("status");
    }

    @Test
    void constructor_shouldAcceptNull_whenJsonlSha256IsNullable() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload())
                        .jsonlSha256(null);

        final GitLabProjectProjectsUpdateAiAgentSessionPayload built = builder.build();

        assertThat(built.jsonlSha256()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenJsonlSha256IsTooLong() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload())
                        .jsonlSha256("x".repeat(65));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenJsonlSha256HasTheMaximumLength() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder builder =
                GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload())
                        .jsonlSha256("x".repeat(64));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayload value =
                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.status()).isEqualTo(GitLabProjectProjectsUpdateAiAgentSessionStatus.COMPLETED);
            softly.assertThat(value.jsonlSha256())
                    .isEqualTo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsUpdateAiAgentSessionPayload original =
                ProjectsCatalogFixtures.projectProjectsUpdateAiAgentSessionPayload();

        final GitLabProjectProjectsUpdateAiAgentSessionPayload rebuilt =
                GitLabProjectProjectsUpdateAiAgentSessionPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsUpdateAiAgentSessionPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status", "jsonlSha256");
    }
}
