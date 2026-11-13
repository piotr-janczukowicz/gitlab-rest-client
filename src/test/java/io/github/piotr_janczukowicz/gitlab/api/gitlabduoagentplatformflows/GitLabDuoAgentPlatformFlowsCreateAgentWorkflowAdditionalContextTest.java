package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextTest {

    @Test
    void constructor_shouldAcceptNull_whenCategoryIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext())
                        .category(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext built = builder.build();

        assertThat(built.category()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext())
                        .content(null);

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext();

        assertSoftly(softly -> {
            softly.assertThat(value.category()).isEqualTo("Category");
            softly.assertThat(value.content()).isEqualTo("Content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext();

        final GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext rebuilt =
                GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContextBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateAgentWorkflowAdditionalContext.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("category", "content");
    }
}
