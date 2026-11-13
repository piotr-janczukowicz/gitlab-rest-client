package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupCustomAttributesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabGroupCustomAttributesUpdatePayloadBuilder builder =
                GitLabGroupCustomAttributesUpdatePayloadBuilder.builder(
                                CustomattributesCatalogFixtures.groupCustomAttributesUpdatePayload())
                        .value(null);

        final GitLabGroupCustomAttributesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupCustomAttributesUpdatePayload value =
                CustomattributesCatalogFixtures.groupCustomAttributesUpdatePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupCustomAttributesUpdatePayload original =
                CustomattributesCatalogFixtures.groupCustomAttributesUpdatePayload();

        final GitLabGroupCustomAttributesUpdatePayload rebuilt =
                GitLabGroupCustomAttributesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupCustomAttributesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
