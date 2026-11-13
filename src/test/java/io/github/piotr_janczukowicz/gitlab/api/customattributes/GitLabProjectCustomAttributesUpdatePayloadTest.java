package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCustomAttributesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabProjectCustomAttributesUpdatePayloadBuilder builder =
                GitLabProjectCustomAttributesUpdatePayloadBuilder.builder(
                                CustomattributesCatalogFixtures.projectCustomAttributesUpdatePayload())
                        .value(null);

        final GitLabProjectCustomAttributesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCustomAttributesUpdatePayload value =
                CustomattributesCatalogFixtures.projectCustomAttributesUpdatePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCustomAttributesUpdatePayload original =
                CustomattributesCatalogFixtures.projectCustomAttributesUpdatePayload();

        final GitLabProjectCustomAttributesUpdatePayload rebuilt =
                GitLabProjectCustomAttributesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCustomAttributesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
