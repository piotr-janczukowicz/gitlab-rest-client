package io.github.piotr_janczukowicz.gitlab.api.agents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAgentsCreateTokenPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectAgentsCreateTokenPayloadBuilder builder =
                GitLabProjectAgentsCreateTokenPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateTokenPayload())
                        .name(null);

        final GitLabProjectAgentsCreateTokenPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectAgentsCreateTokenPayloadBuilder builder =
                GitLabProjectAgentsCreateTokenPayloadBuilder.builder(
                                AgentsCatalogFixtures.projectAgentsCreateTokenPayload())
                        .description(null);

        final GitLabProjectAgentsCreateTokenPayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAgentsCreateTokenPayload value = AgentsCatalogFixtures.projectAgentsCreateTokenPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.description()).isEqualTo("description");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAgentsCreateTokenPayload original = AgentsCatalogFixtures.projectAgentsCreateTokenPayload();

        final GitLabProjectAgentsCreateTokenPayload rebuilt =
                GitLabProjectAgentsCreateTokenPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAgentsCreateTokenPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "description");
    }
}
