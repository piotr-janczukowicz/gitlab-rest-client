package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSuggestionsDirectAccessPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenProjectPathIsNullable() {
        final GitLabCodeSuggestionsDirectAccessPayloadBuilder builder =
                GitLabCodeSuggestionsDirectAccessPayloadBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsDirectAccessPayload())
                        .projectPath(null);

        final GitLabCodeSuggestionsDirectAccessPayload built = builder.build();

        assertThat(built.projectPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSuggestionsDirectAccessPayload value =
                CodesuggestionsCatalogFixtures.codeSuggestionsDirectAccessPayload();

        assertThat(value.projectPath()).isEqualTo("namespace/project");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSuggestionsDirectAccessPayload original =
                CodesuggestionsCatalogFixtures.codeSuggestionsDirectAccessPayload();

        final GitLabCodeSuggestionsDirectAccessPayload rebuilt =
                GitLabCodeSuggestionsDirectAccessPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSuggestionsDirectAccessPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("projectPath");
    }
}
