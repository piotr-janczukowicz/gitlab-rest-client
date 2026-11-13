package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextTest {

    @Test
    void constructor_shouldAcceptNull_whenCategoryIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowAdditionalContext())
                        .category(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext built = builder.build();

        assertThat(built.category()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder builder =
                GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures
                                        .duoAgentPlatformFlowsCreateWorkflowAdditionalContext())
                        .content(null);

        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowAdditionalContext();

        assertSoftly(softly -> {
            softly.assertThat(value.category()).isEqualTo("Category");
            softly.assertThat(value.content()).isEqualTo("Content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsCreateWorkflowAdditionalContext();

        final GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext rebuilt =
                GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContextBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabDuoAgentPlatformFlowsCreateWorkflowAdditionalContext.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("category", "content");
    }
}
