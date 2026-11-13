package io.github.piotr_janczukowicz.gitlab.api.customattributes;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceCustomAttributesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenValueIsNullable() {
        final GitLabInstanceCustomAttributesUpdatePayloadBuilder builder =
                GitLabInstanceCustomAttributesUpdatePayloadBuilder.builder(
                                CustomattributesCatalogFixtures.instanceCustomAttributesUpdatePayload())
                        .value(null);

        final GitLabInstanceCustomAttributesUpdatePayload built = builder.build();

        assertThat(built.value()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceCustomAttributesUpdatePayload value =
                CustomattributesCatalogFixtures.instanceCustomAttributesUpdatePayload();

        assertThat(value.value()).isEqualTo("value");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceCustomAttributesUpdatePayload original =
                CustomattributesCatalogFixtures.instanceCustomAttributesUpdatePayload();

        final GitLabInstanceCustomAttributesUpdatePayload rebuilt =
                GitLabInstanceCustomAttributesUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceCustomAttributesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("value");
    }
}
