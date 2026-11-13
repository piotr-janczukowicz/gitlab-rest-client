package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsCreateAiAgentAuditEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenSessionIdIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload())
                        .sessionId(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventPayload built = builder.build();

        assertThat(built.sessionId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder builder =
                GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload())
                        .events(null);

        final GitLabProjectProjectsCreateAiAgentAuditEventPayload built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsCreateAiAgentAuditEventPayload value =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sessionId()).isEqualTo(1L);
            softly.assertThat(value.events())
                    .isEqualTo(List.of(ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsCreateAiAgentAuditEventPayload original =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload();

        final GitLabProjectProjectsCreateAiAgentAuditEventPayload rebuilt =
                GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEventsSourceChangesLater() {
        final List<GitLabProjectProjectsCreateAiAgentAuditEventEvent> source =
                new ArrayList<>(List.of(ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventEvent()));
        final GitLabProjectProjectsCreateAiAgentAuditEventPayload built =
                GitLabProjectProjectsCreateAiAgentAuditEventPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload())
                        .events(source)
                        .build();
        source.clear();

        assertThat(built.events()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEventsIsRead() {
        final GitLabProjectProjectsCreateAiAgentAuditEventPayload built =
                ProjectsCatalogFixtures.projectProjectsCreateAiAgentAuditEventPayload();
        final List<GitLabProjectProjectsCreateAiAgentAuditEventEvent> values = built.events();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectProjectsCreateAiAgentAuditEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sessionId", "events");
    }
}
