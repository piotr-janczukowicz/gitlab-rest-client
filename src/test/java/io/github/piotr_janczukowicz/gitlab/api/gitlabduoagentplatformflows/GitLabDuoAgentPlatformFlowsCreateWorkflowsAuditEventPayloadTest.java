package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload())
                        .events(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload();

        assertThat(value.events())
                .isEqualTo(List.of(
                        GitlabduoagentplatformflowsCatalogFixtures
                                .duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent()));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload();

        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload rebuilt =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEventsSourceChangesLater() {
        final List<GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent> source = new ArrayList<>(List.of(
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventEvent()));
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload built =
                GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload())
                        .events(source)
                        .build();
        source.clear();

        assertThat(built.events()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEventsIsRead() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload built =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowsAuditEventPayload();
        final List<GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventEvent> values = built.events();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateWorkflowsAuditEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("events");
    }
}
