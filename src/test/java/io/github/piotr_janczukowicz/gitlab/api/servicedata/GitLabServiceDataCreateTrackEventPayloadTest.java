package io.github.piotr_janczukowicz.gitlab.api.servicedata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceDataCreateTrackEventPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabServiceDataCreateTrackEventPayloadBuilder builder =
                GitLabServiceDataCreateTrackEventPayloadBuilder.builder(
                                ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload())
                        .events(null);

        final GitLabServiceDataCreateTrackEventPayload built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceDataCreateTrackEventPayload value =
                ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload();

        assertThat(value.events()).isEqualTo(List.of(Map.of("key", "value")));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceDataCreateTrackEventPayload original =
                ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload();

        final GitLabServiceDataCreateTrackEventPayload rebuilt =
                GitLabServiceDataCreateTrackEventPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEventsSourceChangesLater() {
        final List<Map<String, Object>> source = new ArrayList<>(List.of(Map.of("key", "value")));
        final GitLabServiceDataCreateTrackEventPayload built = GitLabServiceDataCreateTrackEventPayloadBuilder.builder(
                        ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload())
                .events(source)
                .build();
        source.clear();

        assertThat(built.events()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEventsIsRead() {
        final GitLabServiceDataCreateTrackEventPayload built =
                ServicedataCatalogFixtures.serviceDataCreateTrackEventPayload();
        final List<Map<String, Object>> values = built.events();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabServiceDataCreateTrackEventPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("events");
    }
}
