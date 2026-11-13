package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCustomAttributeTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabCustomAttributeBuilder builder = GitLabCustomAttributeBuilder.builder(
                        CommonCatalogFixtures.customAttribute())
                .key(null);

        final GitLabCustomAttribute built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabCustomAttributeBuilder builder = GitLabCustomAttributeBuilder.builder(
                        CommonCatalogFixtures.customAttribute())
                .value(null);

        final GitLabCustomAttribute built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCustomAttribute value = CommonCatalogFixtures.customAttribute();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("foo");
            softly.assertThat(value.value()).isEqualTo("bar");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCustomAttribute original = CommonCatalogFixtures.customAttribute();

        final GitLabCustomAttribute rebuilt =
                GitLabCustomAttributeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCustomAttribute.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "value");
    }
}
