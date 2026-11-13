package io.github.piotr_janczukowicz.gitlab.api.epics;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupEpicsCreateAwardEmojiPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupEpicsCreateAwardEmojiPayloadBuilder builder =
                GitLabGroupEpicsCreateAwardEmojiPayloadBuilder.builder(
                                EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload())
                        .name(null);

        final GitLabGroupEpicsCreateAwardEmojiPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicsCreateAwardEmojiPayload value = EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload();

        assertThat(value.name()).isEqualTo("name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicsCreateAwardEmojiPayload original =
                EpicsCatalogFixtures.groupEpicsCreateAwardEmojiPayload();

        final GitLabGroupEpicsCreateAwardEmojiPayload rebuilt =
                GitLabGroupEpicsCreateAwardEmojiPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicsCreateAwardEmojiPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
