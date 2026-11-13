package io.github.piotr_janczukowicz.gitlab.api.gitlabduoagentplatformflows;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoAgentPlatformFlowsRevokeTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabDuoAgentPlatformFlowsRevokeTokenPayloadBuilder builder =
                GitLabDuoAgentPlatformFlowsRevokeTokenPayloadBuilder.builder(
                                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload())
                        .token(null);

        final GitLabDuoAgentPlatformFlowsRevokeTokenPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoAgentPlatformFlowsRevokeTokenPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload();

        assertThat(value.token()).isEqualTo("token");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoAgentPlatformFlowsRevokeTokenPayload original =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload();

        final GitLabDuoAgentPlatformFlowsRevokeTokenPayload rebuilt =
                GitLabDuoAgentPlatformFlowsRevokeTokenPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabDuoAgentPlatformFlowsRevokeTokenPayload value =
                GitlabduoagentplatformflowsCatalogFixtures.duoAgentPlatformFlowsRevokeTokenPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoAgentPlatformFlowsRevokeTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("token");
    }
}
