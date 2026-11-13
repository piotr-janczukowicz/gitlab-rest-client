package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitContextPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTokensIsNullable() {
        final GitLabOrbitContextPayloadBuilder builder = GitLabOrbitContextPayloadBuilder.builder(
                        OrbitCatalogFixtures.orbitContextPayload())
                .tokens(null);

        final GitLabOrbitContextPayload built = builder.build();

        assertThat(built.tokens()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpandIsNullable() {
        final GitLabOrbitContextPayloadBuilder builder = GitLabOrbitContextPayloadBuilder.builder(
                        OrbitCatalogFixtures.orbitContextPayload())
                .expand(null);

        final GitLabOrbitContextPayload built = builder.build();

        assertThat(built.expand()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResponseFormatIsNullable() {
        final GitLabOrbitContextPayloadBuilder builder = GitLabOrbitContextPayloadBuilder.builder(
                        OrbitCatalogFixtures.orbitContextPayload())
                .responseFormat(null);

        final GitLabOrbitContextPayload built = builder.build();

        assertThat(built.responseFormat()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitContextPayload value = OrbitCatalogFixtures.orbitContextPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.tokens()).isEqualTo(List.of("tokens"));
            softly.assertThat(value.expand()).isEqualTo(true);
            softly.assertThat(value.responseFormat()).isEqualTo(GitLabOrbitContextResponseFormat.RAW);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitContextPayload original = OrbitCatalogFixtures.orbitContextPayload();

        final GitLabOrbitContextPayload rebuilt =
                GitLabOrbitContextPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenTokensSourceChangesLater() {
        final List<String> source = new ArrayList<>(List.of("tokens"));
        final GitLabOrbitContextPayload built = GitLabOrbitContextPayloadBuilder.builder(
                        OrbitCatalogFixtures.orbitContextPayload())
                .tokens(source)
                .build();
        source.clear();

        assertThat(built.tokens()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenTokensIsRead() {
        final GitLabOrbitContextPayload built = OrbitCatalogFixtures.orbitContextPayload();
        final List<String> values = built.tokens();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitContextPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tokens", "expand", "responseFormat");
    }
}
