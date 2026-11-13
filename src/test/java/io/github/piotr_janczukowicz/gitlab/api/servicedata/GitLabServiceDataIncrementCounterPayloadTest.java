package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataIncrementCounterPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEventIsNullable() {
        final GitLabServiceDataIncrementCounterPayloadBuilder builder =
                GitLabServiceDataIncrementCounterPayloadBuilder.builder(
                                ServicedataCatalogFixtures.serviceDataIncrementCounterPayload())
                        .event(null);

        final GitLabServiceDataIncrementCounterPayload built = builder.build();

        assertThat(built.event()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceDataIncrementCounterPayload value =
                ServicedataCatalogFixtures.serviceDataIncrementCounterPayload();

        assertThat(value.event()).isEqualTo("i_quickactions_page");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceDataIncrementCounterPayload original =
                ServicedataCatalogFixtures.serviceDataIncrementCounterPayload();

        final GitLabServiceDataIncrementCounterPayload rebuilt =
                GitLabServiceDataIncrementCounterPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabServiceDataIncrementCounterPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("event");
    }
}
