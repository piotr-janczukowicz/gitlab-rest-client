package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload())
                        .body(null);

        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload())
                        .createdAt(null);

        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload();

        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload rebuilt =
                GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateIssuesDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateIssuesDiscussionsPayload())
                        .createdAt(instant);

        final GitLabProjectDiscussionsCreateIssuesDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateIssuesDiscussionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt");
    }
}
