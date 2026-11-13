package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSuggestionsEnabledPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabCodeSuggestionsEnabledPayloadBuilder builder = GitLabCodeSuggestionsEnabledPayloadBuilder.builder(
                        CodesuggestionsCatalogFixtures.codeSuggestionsEnabledPayload())
                .projectPath(null);

        final GitLabCodeSuggestionsEnabledPayload built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSuggestionsEnabledPayload value =
                CodesuggestionsCatalogFixtures.codeSuggestionsEnabledPayload();

        assertThat(value.projectPath()).isEqualTo("namespace/project");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSuggestionsEnabledPayload original =
                CodesuggestionsCatalogFixtures.codeSuggestionsEnabledPayload();

        final GitLabCodeSuggestionsEnabledPayload rebuilt =
                GitLabCodeSuggestionsEnabledPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSuggestionsEnabledPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectPath");
    }
}
