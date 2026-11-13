package io.github.piotr_janczukowicz.gitlab.api.tags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTagSignatureTest {

    @Test
    void constructor_shouldAcceptNull_whenSignatureTypeIsNullable() {
        final GitLabTagSignatureBuilder builder = GitLabTagSignatureBuilder.builder(TagsCatalogFixtures.tagSignature())
                .signatureType(null);

        final GitLabTagSignature built = builder.build();

        assertThat(built.signatureType()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSignatureIsNullable() {
        final GitLabTagSignatureBuilder builder = GitLabTagSignatureBuilder.builder(TagsCatalogFixtures.tagSignature())
                .signature(null);

        final GitLabTagSignature built = builder.build();

        assertThat(built.signature()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTagSignature value = TagsCatalogFixtures.tagSignature();

        assertSoftly(softly -> {
            softly.assertThat(value.signatureType()).isEqualTo("PGP");
            softly.assertThat(value.signature()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTagSignature original = TagsCatalogFixtures.tagSignature();

        final GitLabTagSignature rebuilt =
                GitLabTagSignatureBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTagSignature.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("signatureType", "signature");
    }
}
