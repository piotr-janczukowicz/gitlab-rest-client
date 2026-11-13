package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssuableReferencesTest {

    @Test
    void constructor_shouldAcceptNull_whenShortValueIsNullable() {
        final GitLabIssuableReferencesBuilder builder = GitLabIssuableReferencesBuilder.builder(
                        CommonCatalogFixtures.issuableReferences())
                .shortValue(null);

        final GitLabIssuableReferences built = builder.build();

        assertThat(built.shortValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelativeIsNullable() {
        final GitLabIssuableReferencesBuilder builder = GitLabIssuableReferencesBuilder.builder(
                        CommonCatalogFixtures.issuableReferences())
                .relative(null);

        final GitLabIssuableReferences built = builder.build();

        assertThat(built.relative()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullIsNullable() {
        final GitLabIssuableReferencesBuilder builder = GitLabIssuableReferencesBuilder.builder(
                        CommonCatalogFixtures.issuableReferences())
                .full(null);

        final GitLabIssuableReferences built = builder.build();

        assertThat(built.full()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssuableReferences value = CommonCatalogFixtures.issuableReferences();

        assertSoftly(softly -> {
            softly.assertThat(value.shortValue()).isEqualTo("&6");
            softly.assertThat(value.relative()).isEqualTo("&6");
            softly.assertThat(value.full()).isEqualTo("test&6");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssuableReferences original = CommonCatalogFixtures.issuableReferences();

        final GitLabIssuableReferences rebuilt =
                GitLabIssuableReferencesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssuableReferences.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("shortValue", "relative", "full");
    }
}
