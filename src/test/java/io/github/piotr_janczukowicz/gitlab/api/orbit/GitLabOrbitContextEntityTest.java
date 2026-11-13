package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabOrbitContextEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .token(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedTokenIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .resolvedToken(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.resolvedToken()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .type(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .id(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFoundIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .found(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.found()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSummaryIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .summary(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.summary()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .error(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.error()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpansionIsNullable() {
        final GitLabOrbitContextEntityBuilder builder = GitLabOrbitContextEntityBuilder.builder(
                        OrbitCatalogFixtures.orbitContextEntity())
                .expansion(null);

        final GitLabOrbitContextEntity built = builder.build();

        assertThat(built.expansion()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabOrbitContextEntity value = OrbitCatalogFixtures.orbitContextEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.token()).isEqualTo("MergeRequest[123]");
            softly.assertThat(value.resolvedToken()).isEqualTo("MergeRequest[123]");
            softly.assertThat(value.type()).isEqualTo("MergeRequest");
            softly.assertThat(value.id()).isEqualTo("123");
            softly.assertThat(value.found()).isEqualTo(true);
            softly.assertThat(value.summary()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.error()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.expansion()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabOrbitContextEntity original = OrbitCatalogFixtures.orbitContextEntity();

        final GitLabOrbitContextEntity rebuilt =
                GitLabOrbitContextEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabOrbitContextEntity value = OrbitCatalogFixtures.orbitContextEntity();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenResolvedTokenIsACredential() {
        final GitLabOrbitContextEntity value = OrbitCatalogFixtures.orbitContextEntity();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabOrbitContextEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("token", "resolvedToken", "type", "id", "found", "summary", "error", "expansion");
    }
}
