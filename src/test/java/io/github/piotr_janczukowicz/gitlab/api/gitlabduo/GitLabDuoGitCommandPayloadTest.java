package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoGitCommandPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenPromptIsNullable() {
        final GitLabDuoGitCommandPayloadBuilder builder = GitLabDuoGitCommandPayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoGitCommandPayload())
                .prompt(null);

        final GitLabDuoGitCommandPayload built = builder.build();

        assertThat(built.prompt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoGitCommandPayload value = GitlabduoCatalogFixtures.duoGitCommandPayload();

        assertThat(value.prompt()).isEqualTo("prompt");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoGitCommandPayload original = GitlabduoCatalogFixtures.duoGitCommandPayload();

        final GitLabDuoGitCommandPayload rebuilt =
                GitLabDuoGitCommandPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoGitCommandPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("prompt");
    }
}
