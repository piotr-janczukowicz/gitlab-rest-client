package io.github.piotr_janczukowicz.gitlab.api.codesuggestions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSuggestionsCreateCompletionContextTest {

    @Test
    void constructor_shouldRefuseNull_whenTypeIsNull() {
        final GitLabCodeSuggestionsCreateCompletionContextBuilder builder =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext())
                        .type(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("type");
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionContextBuilder builder =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext())
                        .name(null);

        final GitLabCodeSuggestionsCreateCompletionContext built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenNameIsTooLong() {
        final GitLabCodeSuggestionsCreateCompletionContextBuilder builder =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext())
                        .name("x".repeat(256));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenNameHasTheMaximumLength() {
        final GitLabCodeSuggestionsCreateCompletionContextBuilder builder =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext())
                        .name("x".repeat(255));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabCodeSuggestionsCreateCompletionContextBuilder builder =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(
                                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext())
                        .content(null);

        final GitLabCodeSuggestionsCreateCompletionContext built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSuggestionsCreateCompletionContext value =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext();

        assertSoftly(softly -> {
            softly.assertThat(value.type()).isEqualTo(GitLabCodeSuggestionsCreateCompletionContextType.FILE);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.content()).isEqualTo("content");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSuggestionsCreateCompletionContext original =
                CodesuggestionsCatalogFixtures.codeSuggestionsCreateCompletionContext();

        final GitLabCodeSuggestionsCreateCompletionContext rebuilt =
                GitLabCodeSuggestionsCreateCompletionContextBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCodeSuggestionsCreateCompletionContext.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type", "name", "content");
    }
}
