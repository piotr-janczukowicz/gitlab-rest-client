package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAgentsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectAgentsCreatePayloadBuilder builder = GitLabProjectAgentsCreatePayloadBuilder.builder(
                        AgentsCatalogFixtures.projectAgentsCreatePayload())
                .name(null);

        final GitLabProjectAgentsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAgentsCreatePayload value = AgentsCatalogFixtures.projectAgentsCreatePayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAgentsCreatePayload original = AgentsCatalogFixtures.projectAgentsCreatePayload();

        final GitLabProjectAgentsCreatePayload rebuilt =
                GitLabProjectAgentsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAgentsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
