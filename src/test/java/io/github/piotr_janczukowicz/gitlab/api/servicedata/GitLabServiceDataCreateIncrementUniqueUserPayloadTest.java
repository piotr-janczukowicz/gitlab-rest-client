package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataCreateIncrementUniqueUserPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEventIsNullable() {
        final GitLabServiceDataCreateIncrementUniqueUserPayloadBuilder builder =
                GitLabServiceDataCreateIncrementUniqueUserPayloadBuilder.builder(
                                ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload())
                        .event(null);

        final GitLabServiceDataCreateIncrementUniqueUserPayload built = builder.build();

        assertThat(built.event()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceDataCreateIncrementUniqueUserPayload value =
                ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload();

        assertThat(value.event()).isEqualTo("i_quickactions_page");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceDataCreateIncrementUniqueUserPayload original =
                ServicedataCatalogFixtures.serviceDataCreateIncrementUniqueUserPayload();

        final GitLabServiceDataCreateIncrementUniqueUserPayload rebuilt =
                GitLabServiceDataCreateIncrementUniqueUserPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabServiceDataCreateIncrementUniqueUserPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("event");
    }
}
